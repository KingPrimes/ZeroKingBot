package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTionNick;
import com.zkb.bot.warframe.mapper.WarframeMarketRivenTionNickMapper;
import com.zkb.bot.warframe.service.IWarframeMarketRivenTionNickService;
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
public class WarframeMarketRivenTionNickServiceImpl implements IWarframeMarketRivenTionNickService, CommandLineRunner {
    Logger log = LoggerFactory.getLogger(WarframeMarketRivenTionNickServiceImpl.class);
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

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe.MarketRiven别名表数据……");
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_market_riven_tion_nick.json");
                    if (aliasJson.trim().isEmpty()) {
                        log.error("未获取到MarketRiven别名数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<WarframeMarketRivenTionNick> records = alias.getJSONArray("RECORDS").toJavaList(WarframeMarketRivenTionNick.class);
                    if (records.size() != tionNickMapper.selectWarframeMarketRivenTionNickList().size()) {
                        int x = 0;
                        for (WarframeMarketRivenTionNick record : records) {
                            x += tionNickMapper.insertWarframeMarketRivenTionNickLikeNickCh(record);
                        }
                        log.info("共更新Warframe.MarketRiven别名表 {} 条数据！", x);
                    } else {
                        log.info("Warframe.MarketRiven别名表数据未做更改！");
                    }
                }
            }
        });

    }
}
