package com.zkb.bot.group.plugin;


import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotContainer;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.mikuac.shiro.dto.event.notice.GroupDecreaseNoticeEvent;
import com.mikuac.shiro.dto.event.notice.GroupIncreaseNoticeEvent;
import com.mikuac.shiro.dto.event.request.GroupAddRequestEvent;
import com.zkb.bot.group.doa.GroupVerify;
import com.zkb.bot.utils.GroupAddApi;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.PrivateAddApi;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.StaticFinal;
import com.zkb.common.utils.VerifyCodeUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Component
public class JoinGroupVerifyCodePlugin extends BotPlugin {

    private static final Logger log = LoggerFactory.getLogger(JoinGroupVerifyCodePlugin.class);
 @Resource
    private RedisCache redisCache;
 @Resource
    private BotContainer botContainer;

    @Override
    public int onGroupDecreaseNotice(@NotNull Bot bot, @NotNull GroupDecreaseNoticeEvent event) {
        bot.sendGroupMsg(
                event.getGroupId(),
                Msg.builder()
                        .text(
                                event.getUserId()
                                        + "\n"
                                        + PrivateAddApi.getPrivateNick(event.getUserId())
                                        + "退群了").build(),
                false);
        return super.onGroupDecreaseNotice(bot, event);
    }

    /**
     * 给新入群的人员提示验证码消息
     */
    @Override
    public int onGroupIncreaseNotice(@NotNull Bot bot, @NotNull GroupIncreaseNoticeEvent event) {
        if (GroupAddApi.isAdmin(bot, event.getGroupId())) {
            for (Long bottle : botContainer.robots.keySet()) {
                if (bottle == event.getUserId()) {
                    return MESSAGE_IGNORE;
                }
            }
            //生成验证码
            String code = VerifyCodeUtils.generateVerifyCode(8);
            //创建实体类
            GroupVerify gv = new GroupVerify();
            //赋值 触发方法的用户账号
            gv.setUserId(event.getUserId());
            //赋值 当前验证码
            gv.setCode(code);
            //赋值 当前群账号
            gv.setGroupId(event.getGroupId());
            //赋值 当前链接的ID
            gv.setSelfId(bot.getSelfId());
            //赋值 当前Bot的账号
            gv.setBotId(bot.getSelfId());
            //发送消息
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("欢迎！").at(event.getUserId()).text("\n请在10分钟内输入一下验证码!\n否则将会移出该群\n").text(code).build(), false);
            //把指存到Redis当中并设置10分钟的倒计时
            redisCache.setCacheObject("code:" + event.getUserId() + "-", "", 10, TimeUnit.MINUTES);
            redisCache.setCacheObject("v-code:" + event.getUserId(), gv);
            //触发方法的 群组 与 用户账号暂存到HashMap集合中
            StaticFinal.JOINGROUPVERIFYCODE.put(event.getUserId(), event.getGroupId());
            //返回 拦截消息
            return MESSAGE_BLOCK;
        } else {
            return MESSAGE_IGNORE;
        }
    }

    /**
     * 核查验证码是否正确
     */

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        try {
            //如果是当前群组则取出待验证用户
            Long groupId = StaticFinal.JOINGROUPVERIFYCODE.get(event.getUserId());
            //若是待验证用户则匹配验证码
            if (groupId.equals(event.getGroupId())) {
                GroupVerify gv = redisCache.getCacheObject("v-code:" + event.getUserId());
                //匹配用户发送的验证码是否正确
                if (event.getRawMessage().toUpperCase(Locale.ROOT).equals(gv.getCode())) {
                    StaticFinal.JOINGROUPVERIFYCODE.remove(event.getUserId());
                    redisCache.deleteObject("v-code:" + event.getUserId());
                    redisCache.deleteObject("code:" + event.getUserId() + "-");
                    bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("恭喜！").at(event.getUserId()).text("验证码正确！\n尽情的在群内玩耍吧！").build(), false);
                    //返回 继续消息
                    return MESSAGE_IGNORE;
                } else {
                    bot.deleteMsg(event.getMessageId());
                    bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("在你未验证时不可以发送其它无关的消息！").build(), false);
                    bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("验证码有误！\n提示验证码是:" + gv.getCode()).build(), false);
                    bot.setGroupBan(event.getGroupId(), event.getUserId(), 15);
                    //不正确
                    return MESSAGE_BLOCK;
                }
            }
        } catch (Exception e) {
            //未验证
            return MESSAGE_IGNORE;
        }
        return MESSAGE_IGNORE;
    }

    /**
     * 自动批准用户入群
     */
    @Override
    public int onGroupAddRequest(@NotNull Bot bot, @NotNull GroupAddRequestEvent event) {
        bot.setGroupAddRequest(event.getFlag(), event.getSubType(), true, "");
        return MESSAGE_IGNORE;
    }
}
