package com.zkb.bot.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import org.jetbrains.annotations.NotNull;

import static com.zkb.bot.enums.FunctionEnums.*;

public class ErroSendMessage {
    public static int getFunctionOff(@NotNull Bot bot, @NotNull GroupMessageEvent event, FunctionEnums enumTypeName) {
        if (enumTypeName.equals(FUNCTION_WARFRAME)) {
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("该群未开启Warframe功能！\n请发送 \"开启wf\" 开启功能\n具体功能请发送 \"help\" 查看").build(), false);
        }
        if (enumTypeName.equals(FUNCTION_GIF)) {
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("该群未开启GIF图片功能！\n 请发送 \"开启GIF\" 开启功能\n具体功能请发送 \"help\" 查看").build(), false);
        }
        if (enumTypeName.equals(FUNCTION_IMAGE)) {
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("该群未开启涩图功能！\n 请发送 \"开启涩图\" 开启功能\n具体功能请发送 \"help\" 查看").build(), false);
        }

        return 1;
    }

}
