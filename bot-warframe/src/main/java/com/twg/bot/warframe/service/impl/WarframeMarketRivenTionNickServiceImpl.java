package com.twg.bot.warframe.service.impl;


import com.twg.bot.warframe.domain.market.WarframeMarketRivenTionNick;
import com.twg.bot.warframe.mapper.WarframeMarketRivenTionNickMapper;
import com.twg.bot.warframe.service.IWarframeMarketRivenTionNickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeMarketRivenTionNickServiceImpl implements IWarframeMarketRivenTionNickService {

    @Autowired
    WarframeMarketRivenTionNickMapper tionNickMapper;

    @Override
    public List<WarframeMarketRivenTionNick> selectWarframeMarketRivenTionNickByNickCh(WarframeMarketRivenTionNick nick) {
        return tionNickMapper.selectWarframeMarketRivenTionNickByNickCh(nick);
    }

    @Override
    public WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickByNickCh(String nick) {
        try {
            return tionNickMapper.selectWarframeMarketRivenTionNickByNickCh(new WarframeMarketRivenTionNick("", nick)).get(0);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickEn(String en) {
        return tionNickMapper.selectWarframeMarketRivenTionNickLikeNickEn(en);
    }

    @Override
    public WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickCh(String ch) {
        return tionNickMapper.selectWarframeMarketRivenTionNickLikeNickCh(ch);
    }
}
