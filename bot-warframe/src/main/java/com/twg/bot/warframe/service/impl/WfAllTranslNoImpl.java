package com.twg.bot.warframe.service.impl;


import com.twg.bot.warframe.domain.WfAllTranslNo;
import com.twg.bot.warframe.mapper.WfAllTranslNoMapper;
import com.twg.bot.warframe.service.IWfAllTranslNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WfAllTranslNoImpl implements IWfAllTranslNoService {


    @Autowired
    private WfAllTranslNoMapper wfAllTranslNoMapper;

    /**
     * 查询所有没有翻译的任务列表
     */
    @Override
    public List<WfAllTranslNo> selectAllNoMission(WfAllTranslNo w) {
        return wfAllTranslNoMapper.selectAllNoMission(w);
    }

    /**
     * 查询所有没有翻译的遗物列表
     */
    @Override
    public List<WfAllTranslNo> selectAllNoRelics(WfAllTranslNo w) {
        return wfAllTranslNoMapper.selectAllNoRelics(w);
    }

    /**
     * 查询所有没有翻译的市场列表
     */
    @Override
    public List<WfAllTranslNo> selectAllNoMarket(WfAllTranslNo w) {
        return wfAllTranslNoMapper.selectAllNoMarket(w);
    }

    /**
     * 查询所有没有翻译的紫卡倾向列表
     */
    @Override
    public List<WfAllTranslNo> selectAllNoTrend(WfAllTranslNo w) {
        return wfAllTranslNoMapper.selectAllNoTrend(w);
    }
}
