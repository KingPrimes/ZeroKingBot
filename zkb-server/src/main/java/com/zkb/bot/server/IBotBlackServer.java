package com.zkb.bot.server;

import com.zkb.bot.domain.BotBlack;

import java.util.List;

public interface IBotBlackServer {
    List<BotBlack> selectBotBlackList(BotBlack black);

    BotBlack selectBotBlackById(Long id);
    BotBlack selectBotBlackByUserId(Long userId);

    BotBlack selectBotBlackByGroupId(Long groupId);

    int insertBotBlack(BotBlack black);

    int deleteBotBlackById(Long id);

    int updateBotBlack(BotBlack black);
}
