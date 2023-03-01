package com.zkb.bot.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotContainer;
import com.zkb.bot.domain.BotAdmins;
import com.zkb.bot.server.BotAdminsServer;
import com.zkb.common.utils.spring.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class SendAdminMessage {

    static Logger log = LoggerFactory.getLogger(SendAdminMessage.class);

    /**
     * 向所有管理员用户发送通知消息
     * @param msg 消息体
     */
    public static void sendAllAdminMsg(Msg msg){
        Map<Long, Bot> bots = SpringUtils.getBean(BotContainer.class).robots;
        List<BotAdmins> botAdmins = SpringUtils.getBean(BotAdminsServer.class).selectBotAdminsList(null);
        if(botAdmins==null){
            log.info("未设置管理员！无法发送通知消息！");
            return;
        }
        for (Long botId : bots.keySet()) {
            for (BotAdmins botAdmin : botAdmins) {
                if(botAdmin.getBotUid().equals(botId)){
                    bots.get(botId).sendPrivateMsg(botAdmin.getBotAdminUid(),msg.build(),false);
                }
            }
        }
    }

}
