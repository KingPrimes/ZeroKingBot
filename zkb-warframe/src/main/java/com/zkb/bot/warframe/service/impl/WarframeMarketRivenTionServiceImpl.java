package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTion;
import com.zkb.bot.warframe.mapper.WarframeMarketRivenTionMapper;
import com.zkb.bot.warframe.service.IWarframeMarketRivenTionService;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.zero.ZeroConfig;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TimerTask;

@Service
public class WarframeMarketRivenTionServiceImpl implements IWarframeMarketRivenTionService, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(WarframeMarketRivenTionServiceImpl.class);

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

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe.MarketRivenTion表数据……");
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_market_riven_tion.json");
                    if (aliasJson.trim().isEmpty()) {
                        log.error("未获取到MarketRivenTion数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<WarframeMarketRivenTion> records = alias.getJSONArray("RECORDS").toJavaList(WarframeMarketRivenTion.class);
                    if (records.size() != tionMapper.selectWarframeMarketRivenTionList(null).size()) {
                        int x = 0;
                        List<List<WarframeMarketRivenTion>> lists = Lists.partition(records, 500);
                        for (List<WarframeMarketRivenTion> record : lists) {
                            x += tionMapper.insertWarframeMarketRivenTion(record);
                        }
                        log.info("共更新Warframe.MarketRivenTion表 {} 条数据！", x);
                    } else {
                        log.info("Warframe.MarketRivenTion表数据未做更改！");
                    }
                }
            }
        });

    }
}
