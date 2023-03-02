package com.zkb.bot.utils;

import com.zkb.bot.domain.BotBlack;
import com.zkb.bot.server.IBotBlackServer;
import com.zkb.common.utils.spring.SpringUtils;

public class CheckUtils {
    public static boolean checkUserBlackList(Long userId) {
        BotBlack botBlack = SpringUtils.getBean(IBotBlackServer.class).selectBotBlackByUserId(userId);
        return botBlack != null && botBlack.getUserId() != null;
    }

    public static boolean checkGroupBlackList(Long groupId) {
        BotBlack botBlack = SpringUtils.getBean(IBotBlackServer.class).selectBotBlackByGroupId(groupId);
        return botBlack != null && botBlack.getGroupId() != null;
    }
}
