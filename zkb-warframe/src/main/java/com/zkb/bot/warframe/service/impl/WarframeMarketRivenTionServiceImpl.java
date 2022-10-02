package com.zkb.bot.warframe.service.impl;


import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTion;
import com.zkb.bot.warframe.mapper.WarframeMarketRivenTionMapper;
import com.zkb.bot.warframe.service.IWarframeMarketRivenTionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeMarketRivenTionServiceImpl implements IWarframeMarketRivenTionService {

    @Autowired
    WarframeMarketRivenTionMapper tionMapper;

    @Override
    public List<WarframeMarketRivenTion> selectWarframeMarketRivenTionList(WarframeMarketRivenTion warframeMarketRivenTion) {
        return tionMapper.selectWarframeMarketRivenTionList(warframeMarketRivenTion);
    }

    @Override
    public List<WarframeMarketRivenTion> selectWarframeMarketRivenTionByEffect(String eff) {
        return tionMapper.selectWarframeMarketRivenTionByEffect(eff);
    }

    @Override
    public WarframeMarketRivenTion selectWarframeMarketRivenTionByEffectToTion(String eff) {
        try {
            return tionMapper.selectWarframeMarketRivenTionByEffect(eff).get(0);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public WarframeMarketRivenTion selectWarframeMarketRivenTionByUrlName(String urlName) {
        return tionMapper.selectWarframeMarketRivenTionByUrlName(urlName);
    }

    @Override
    public int insertWarframeMarketRivenTion(List<WarframeMarketRivenTion> tionList) {
        return tionMapper.insertWarframeMarketRivenTion(tionList);
    }
}
