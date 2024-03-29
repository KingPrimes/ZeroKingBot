package com.zkb.bot.plugin.server;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.common.utils.OneBotMedia;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.domain.GroupFunctionOnOff;
import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.server.IBotGroupFunctionOnOffServer;
import com.zkb.bot.utils.GroupAddApi;
import com.zkb.bot.utils.Msg;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_BLOCK;
import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;
import static com.zkb.bot.enums.FunctionEnums.*;
import static com.zkb.bot.enums.WarframeTypeEnum.values;


/**
 * @author KingPrimes
 */
@Shiro
@Component
public class FunctionOnOffPlugin {
    @GroupMessageHandler
    public int groupMessageHandler(Bot bot, GroupMessageEvent event) {
        if (event.getRawMessage().trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        //开启WF
        if (ON_WARFRAME.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {
                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_WARFRAME.ordinal())));
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
                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_WARFRAME.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "已关闭Warframe功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "没有开启过Warframe功能", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }

        //开启涩图
        if (ON_IMAGE.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isSuperAdmin(bot, event.getUserId())) {
                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_IMAGE.ordinal())));
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
        if (OFF_IMAGE.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isSuperAdmin(bot, event.getUserId())) {
                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_IMAGE.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "已关闭涩图功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "没有开启过涩图功能", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }

        //开启AI
        if (ON_AI.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isSuperAdmin(bot, event.getUserId())) {
                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_AI.ordinal())));
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
            if (GroupAddApi.isSuperAdmin(bot, event.getUserId())) {
                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_AI.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "关闭AI功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "没有开启过AI功能", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }

        if (ON_GIF.getType().equals(event.getRawMessage().toUpperCase(Locale.ROOT))) {
            if (GroupAddApi.isAdmin(bot, event)) {

                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).updateGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_GIF.ordinal())));
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
                int i = SpringUtils.getBean(IBotGroupFunctionOnOffServer.class).deleteGroupFunctionOnOff(new GroupFunctionOnOff(event.getGroupId(), String.valueOf(FUNCTION_GIF.ordinal())));
                if (i > 0) {
                    bot.sendGroupMsg(event.getGroupId(), "关闭GIF功能", false);
                } else {
                    bot.sendGroupMsg(event.getGroupId(), "没有开启过GIF功能", false);
                }
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("没有权限！").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }

        }

        if ("运行状态".equals(event.getRawMessage())) {
            OneBotMedia builder = OneBotMedia.builder().
                    proxy(false).
                    cache(false).
                    timeout(30).
                    file("http://localhost:" + GetServerPort.getPort() + "/server");
            Msg.builder().img(builder).sendToGroup(bot, event);
            return MESSAGE_BLOCK;
        }

        if ("help".equals(event.getRawMessage().toLowerCase(Locale.ROOT))) {
            Msg.builder()
                    .text("语雀文档:\nhttps://www.yuque.com/kingprimes/zerokingbot\n")
                    .text("B站主页:\nhttps://space.bilibili.com/16131052\n")
                    .text("GitHub:\nhttps://github.com/KingPrimes")
                    .sendToGroup(bot, event);
            return MESSAGE_BLOCK;
        }

        if ("wf指令".equals(event.getRawMessage().toLowerCase(Locale.ROOT))) {
            Msg msg = new Msg();
            msg.text("以下是Warframe指令表：\n");
            for (WarframeTypeEnum value : values()) {
                msg.text(value.getType() + "\n");
            }
            msg.sendToGroup(bot, event);
        }

        return MESSAGE_IGNORE;
    }

}
