package com.twg.bot.warframe.service.impl;


import com.twg.bot.warframe.domain.market.WarframeMarketLichOrSister;
import com.twg.bot.warframe.mapper.WarframeMarketSisterMapper;
import com.twg.bot.warframe.service.IWarframeMarketSisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeMarketSisterServiceImpl implements IWarframeMarketSisterService {

    @Autowired
    WarframeMarketSisterMapper sisterMapper;

    @Override
    public List<WarframeMarketLichOrSister> selectWarframeMarketSisterList(WarframeMarketLichOrSister sister) {
        return sisterMapper.selectWarframeMarketSisterList(sister);
    }

    @Override
    public WarframeMarketLichOrSister selectWarframeMarketSisterByItemName(String name) {
        return sisterMapper.selectWarframeMarketSisterByItemName(name);
    }

    @Override
    public WarframeMarketLichOrSister selectWarframeMarketSisterById(String id) {
        return sisterMapper.selectWarframeMarketSisterById(id);
    }

    @Override
    public WarframeMarketLichOrSister selectWarframeMarketSisterByElement(String element) {
        return sisterMapper.selectWarframeMarketSisterByElement(element);
    }

    @Override
    public WarframeMarketLichOrSister selectWarframeMarketSisterByUrlName(String urlName) {
        return sisterMapper.selectWarframeMarketSisterByUrlName(urlName);
    }

    @Override
    public int insertWarframeMarketSister(WarframeMarketLichOrSister sister) {
        return sisterMapper.insertWarframeMarketSister(sister);
    }

    @Override
    public int updateWarframeMarketSister(WarframeMarketLichOrSister sister) {
        return sisterMapper.updateWarframeMarketSister(sister);
    }

    @Override
    public int deleteWarframeMarketSisterById(String id) {
        return sisterMapper.deleteWarframeMarketSisterById(id);
    }

    @Override
    public int deleteWarframeMarketSisterByIds(String[] id) {
        return sisterMapper.deleteWarframeMarketSisterByIds(id);
    }
}
