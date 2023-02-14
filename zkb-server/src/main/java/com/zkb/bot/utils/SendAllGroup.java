package com.zkb.bot.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotContainer;
import com.mikuac.shiro.dto.action.response.GroupInfoResp;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.common.utils.spring.SpringUtils;

import java.util.Map;

public class SendAllGroup {
    /**
     * 像所有开启某项功能的群组发送消息
     *
     * @param msg      Msg
     * @param function FunctionEnums
     */
    public static void sendAllGroup(Msg msg, FunctionEnums function) {
        Map<Long, Bot> bots = SpringUtils.getBean(BotContainer.class).robots;
        try {
            for (long botId : bots.keySet()) {
                for (GroupInfoResp group : bots.get(botId).getGroupList().getData()) {
                    Thread.sleep(3000L);
                    if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group.getGroupId(), function)) {
                        msg.sendToGroup(bots.get(botId), group.getGroupId());
                    }

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向所有群组发送消息
     * @param msg      Msg
     */
    public static void sendAllGroup(Msg msg) {
        Map<Long, Bot> bots = SpringUtils.getBean(BotContainer.class).robots;
        try {
            for (long botId : bots.keySet()) {
                for (GroupInfoResp group : bots.get(botId).getGroupList().getData()) {
                    Thread.sleep(3000L);
                    msg.sendToGroup(bots.get(botId), group.getGroupId());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
