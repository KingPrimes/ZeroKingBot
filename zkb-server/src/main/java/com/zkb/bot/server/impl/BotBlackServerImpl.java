package com.zkb.bot.server.impl;

import com.zkb.bot.domain.BotBlack;
import com.zkb.bot.mapper.BotBlackMapper;
import com.zkb.bot.server.IBotBlackServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotBlackServerImpl implements IBotBlackServer {

    @Autowired
    BotBlackMapper blackMapper;


    @Override
    public List<BotBlack> selectBotBlackList(BotBlack black) {
        return blackMapper.selectBotBlackList(black);
    }

    @Override
    public BotBlack selectBotBlackById(Long id) {
        return blackMapper.selectBotBlackById(id);
    }

    @Override
    public BotBlack selectBotBlackByUserId(Long userId) {
        return blackMapper.selectBotBlackByUserId(userId);
    }

    @Override
    public BotBlack selectBotBlackByGroupId(Long groupId) {
        return blackMapper.selectBotBlackByGroupId(groupId);
    }

    @Override
    public int insertBotBlack(BotBlack black) {
        return blackMapper.insertBotBlack(black);
    }

    @Override
    public int deleteBotBlackById(Long id) {
        return blackMapper.deleteBotBlackById(id);
    }

    @Override
    public int updateBotBlack(BotBlack black) {
        return blackMapper.updateBotBlack(black);
    }
}
