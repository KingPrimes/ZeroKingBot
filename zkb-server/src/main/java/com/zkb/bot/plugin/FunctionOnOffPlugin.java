package com.zkb.bot.plugin;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.mikuac.shiro.dto.event.message.PrivateMessageEvent;
import com.zkb.bot.domain.GroupFunctionOnOff;
import com.zkb.bot.server.GroupFunctionOnOffServer;
import com.zkb.bot.utils.GroupAddApi;
import com.zkb.bot.utils.Msg;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.zkb.bot.enums.FunctionEnums.*;


/**
 * @author KingPrimes
 */
@Component
public class FunctionOnOffPlugin extends BotPlugin {


    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        if(event.getRawMessage().trim().length()==0){
            return MESSAGE_IGNORE;
        }

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

        //开启涩图
        if (ON_IMAGE.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {
                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_IMAGE.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "开启涩图功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "已开启过了", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        //关闭涩图
        if (ON_IMAGE.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {
                int i = SpringUtils.getBean(GroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_IMAGE.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "已关闭涩图功能", false);
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
                    .text("语雀文档:\nhttps://www.yuque.com/kingprimes/zerokingbot\n")
                    .text("B站主页:\nhttps://space.bilibili.com/16131052\n")
                    .text("GitHub:\nhttps://github.com/KingPrimes")
                    .sendToGroup(bot, event);
            return MESSAGE_BLOCK;
        }

        return MESSAGE_IGNORE;
    }


}
