package com.twg.bot.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotContainer;
import com.mikuac.shiro.dto.action.response.GroupInfoResp;
import com.twg.bot.enums.FunctionEnums;
import com.twg.common.utils.spring.SpringUtils;

import java.util.Map;

public class SendAllGroup {
    /**
     * 像所有开启某项功能的群组发送消息
     *
     * @param msg      Msg
     * @param function FunctionEnums
     */
    public static void sendAllGroup(Msg msg, FunctionEnums function) throws InterruptedException {
        Map<Long, Bot> bots = SpringUtils.getBean(BotContainer.class).robots;
        for (long botId : bots.keySet()) {
            for (GroupInfoResp group : bots.get(botId).getGroupList().getData()) {
                Thread.sleep(3000L);
                if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group.getGroupId(), function)) {
                    msg.sendToGroup(bots.get(botId), group.getGroupId());
                }

            }
        }

    }
}
