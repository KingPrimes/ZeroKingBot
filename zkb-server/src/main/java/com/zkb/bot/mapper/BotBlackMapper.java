package com.zkb.bot.mapper;

import com.zkb.bot.domain.BotBlack;

import java.util.List;

public interface BotBlackMapper {

    List<BotBlack> selectBotBlackList(BotBlack black);

    BotBlack selectBotBlackById(Long id);

    BotBlack selectBotBlackByUserId(Long userId);

    BotBlack selectBotBlackByGroupId(Long groupId);

    int insertBotBlack(BotBlack black);

    int deleteBotBlackById(Long id);

    int updateBotBlack(BotBlack black);

}
