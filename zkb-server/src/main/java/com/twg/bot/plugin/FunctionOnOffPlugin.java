package com.twg.bot.plugin;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.twg.bot.domain.GroupFunctionOnOff;
import com.twg.bot.server.GroupFunctionOnOffServer;
import com.twg.bot.utils.GroupAddApi;
import com.twg.bot.utils.Msg;
import com.twg.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.twg.bot.enums.FunctionEnums.*;


/**
 * @author KingPrimes
 */
@Component
public class FunctionOnOffPlugin extends BotPlugin {


    @Override

    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        //开启WF
        if (ON_WARFRAME.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {
                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_WARFRAME.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "开启Warframe功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "已开启过了", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        //关闭WF
        if (OFF_WARFRAME.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {
                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_WARFRAME.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "已关闭Warframe功能", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }

        //开启AI
        if (ON_AI.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {
                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_AI.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "开启AI功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "已开启过了", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        //关闭AI
        if (OFF_AI.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {
                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_AI.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "关闭AI功能", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }

        if (ON_GIF.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {

                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_GIF.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "开启GIF功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "已开启过了", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        if (OFF_GIF.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {

                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_GIF.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "关闭GIF功能", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }

        }

        if ("help".equals(event.getRawMessage().toLowerCase(Locale.ROOT))) {

            Msg.builder()
                    .text("语雀文档:\nhttps://www.yuque.com/kingprimes/twgbot\n")
                    .text("B站视频:\nhttps://www.bilibili.com/video/BV1cF411F7w5/\n")
                    .text("百度贴吧:\nhttps://tieba.baidu.com/p/7770150887?pid=143554944348&cid=0&red_tag=1843223236#143554944348\n")
                    .text("GitHub:\nhttps://github.com/KingPrimes")
                    .sendToGroup(bot, event);
            return MESSAGE_BLOCK;
        }

        return MESSAGE_IGNORE;
    }

}
