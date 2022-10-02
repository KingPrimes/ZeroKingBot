package com.zkb.bot.warframe.service.impl;


import com.zkb.bot.warframe.domain.market.WarframeMarketRiven;
import com.zkb.bot.warframe.mapper.WarframeMarketRivenMapper;
import com.zkb.bot.warframe.service.IWarframeMarketRivenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeMarketRivenServiceImpl implements IWarframeMarketRivenService {

    @Autowired
    WarframeMarketRivenMapper marketRivenMapper;

    @Override
    public List<WarframeMarketRiven> selectWarframeMarketRivenList(WarframeMarketRiven marketRiven) {
        return marketRivenMapper.selectWarframeMarketRivenList(marketRiven);
    }

    @Override
    public List<WarframeMarketRiven> selectWarframeMarketRivenByItemName(String itemName) {
        return marketRivenMapper.selectWarframeMarketRivenByItemName(itemName);
    }

    @Override
    public int insertWarframeMarketRiven(List<WarframeMarketRiven> marketRivenList) {
        return marketRivenMapper.insertWarframeMarketRiven(marketRivenList);
    }
}
