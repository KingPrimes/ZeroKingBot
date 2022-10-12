package com.zkb.bot.aiml.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.bot.utils.CqMatcher;
import com.zkb.bot.utils.CqParse;
import com.zkb.bot.utils.Msg;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.DateUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.html.EscapeUtil;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_REPLY;
import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_TEACHING;
import static com.zkb.common.utils.StringUtils.isHttpUrl;
import static com.zkb.common.utils.StringUtils.isNumberAndDouble;

/**
 * @author KingPrimes
 */
@Component
public class TeachingUtils {

    @Autowired
    RedisCache redisCache;

    /**
     * 教学
     *
     * @param bot   机器人实体类
     * @param event 消息实体类
     * @return 是否执行
     */
    public int teaching(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        String str = StringUtils.substring(event.getRawMessage(), ORDER_TEACHING.length(), event.getRawMessage().length());
        if (str.trim().length() == 0) {
            bot.sendGroupMsg(event.getGroupId(), "请在教学后面写上问题", false);
            return 1;
        }
        if (CqParse.build(str).reovmCq().trim().length() > 80) {
            Msg.builder().text("你教的问题太长了！").sendToGroup(bot, event);
            return 1;
        }
        if (isNumberAndDouble(str.trim())) {
            Msg.builder().text("不可以纯数字问题！").sendToGroup(bot, event);
            return 1;
        }

        if (isHttpUrl(CqParse.build(str).reovmCq())) {
            Msg.builder().text("不可以包含链接").at(event.getUserId()).sendToGroup(bot, event);
            return 1;
        }

        IssueReply issueReply = new IssueReply();


        if (CqMatcher.isCqImage(str)) {
            issueReply.setMsgIssueImage(CqParse.build(str).getCqImageMD5().toString());
        }

        if (CqMatcher.isCqFace(str)) {
            issueReply.setMsgIssueFace(CqParse.build(str).getCqFace().toString());
        }

        issueReply.setMsgIssue(EscapeUtil.escape(CqParse.build(str).reovmCq()));
        issueReply.setMsgCreateTime(DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD_HH_MM_SS));
        issueReply.setMsgCreateGroup(String.valueOf(event.getGroupId()));
        issueReply.setMsgCreateMember(String.valueOf(event.getUserId()));
        String key = event.getGroupId() + "-" + event.getUserId();
        redisCache.setCacheObject(key, issueReply, 2, TimeUnit.MINUTES);
        Msg.builder().text("请发送 答+回答内容").at(event.getUserId()).sendToGroup(bot, event);
        return 0;
    }

    /**
     * 回答
     */
    public int reply(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        String key = event.getGroupId() + "-" + event.getUserId();
        String str = StringUtils.substring(event.getRawMessage(), ORDER_REPLY.length(), event.getRawMessage().length());
        IssueReply issueReply = redisCache.getCacheObject(key);
        if (issueReply != null) {

            if (isHttpUrl(CqParse.build(str).reovmCq())) {
                Msg.builder().text("不可以包含链接").at(event.getUserId()).sendToGroup(bot, event);
                return 1;
            }
            if (CqParse.build(str).reovmCq().trim().length() > 180) {
                Msg.builder().text("你教的答太长了！").at(event.getUserId()).sendToGroup(bot, event);
                return 1;
            }

            if (CqMatcher.isCqImage(str)) {
                issueReply.setMsgReplyImage(CqParse.build(str).getCqImageUrl().toString());
            }

            if (CqMatcher.isCqFace(str)) {
                issueReply.setMsgReplyFace(CqParse.build(str).getCqFace().toString());
            }


            issueReply.setMsgReply(CqParse.build(str).reovmCq());
            if (SpringUtils.getBean(IssueReplyService.class).insertIssueReply(issueReply) > 0) {
                redisCache.deleteObject(key);
                Msg.builder().text("教学完成！").at(event.getUserId()).sendToGroup(bot, event);
            } else {
                Msg.builder().text("请勿重复教学！").at(event.getUserId()).sendToGroup(bot, event);
            }
        } else {
            Msg.builder().text("未查询到您的教学！\n教学内容可能已经过期！").at(event.getUserId()).sendToGroup(bot, event);
        }
        return 0;
    }


    /**
     * 构建Issue实体类
     *
     * @param str 字符串
     * @return 实体类
     */
    public IssueReply getIssue(String str) {
        IssueReply issueReply = new IssueReply();
        if (CqMatcher.isCqFace(str)) {
            issueReply.setMsgIssueFace(CqParse.build(str).getCqFace().toString());
        }
        if (CqMatcher.isCqImage(str)) {
            issueReply.setMsgIssueImage(CqParse.build(str).getCqImageMD5().toString());
        }
        String issue = CqParse.build(str).reovmCq();
        if(issue.length()!=0){
            issueReply.setMsgIssue(EscapeUtil.escape(issue));
        }
        return issueReply.getMsgIssueImage() == null && issueReply.getMsgIssueFace() ==null && issueReply.getMsgIssue() ==null?null:issueReply;
    }


}
