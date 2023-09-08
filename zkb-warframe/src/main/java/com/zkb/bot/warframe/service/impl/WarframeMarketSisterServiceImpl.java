package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.market.WarframeMarketSister;
import com.zkb.bot.warframe.mapper.WarframeMarketSisterMapper;
import com.zkb.bot.warframe.service.IWarframeMarketSisterService;
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
public class WarframeMarketSisterServiceImpl implements IWarframeMarketSisterService, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(WarframeMarketSisterServiceImpl.class);

    @Autowired
    WarframeMarketSisterMapper sisterMapper;

    @Override
    public List<WarframeMarketSister> selectWarframeMarketSisterList(WarframeMarketSister sister) {
        return sisterMapper.selectWarframeMarketSisterList(sister);
    }

    @Override
    public WarframeMarketSister selectWarframeMarketSisterByItemName(String name) {
        return sisterMapper.selectWarframeMarketSisterByItemName(name);
    }

    @Override
    public WarframeMarketSister selectWarframeMarketSisterById(String id) {
        return sisterMapper.selectWarframeMarketSisterById(id);
    }

    @Override
    public WarframeMarketSister selectWarframeMarketSisterByElement(String element) {
        return sisterMapper.selectWarframeMarketSisterByElement(element);
    }

    @Override
    public WarframeMarketSister selectWarframeMarketSisterByUrlName(String urlName) {
        return sisterMapper.selectWarframeMarketSisterByUrlName(urlName);
    }

    @Override
    public int insertWarframeMarketSister(WarframeMarketSister sister) {
        return sisterMapper.insertWarframeMarketSister(sister);
    }

    @Override
    public int updateWarframeMarketSister(WarframeMarketSister sister) {
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

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe.Market信条武器数据……");
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_market_sister.json");
                    if (aliasJson.trim().isEmpty()) {
                        log.error("未获取到信条武器数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<WarframeMarketSister> records = alias.getJSONArray("RECORDS").toJavaList(WarframeMarketSister.class);
                    if (records.size() != sisterMapper.selectWarframeMarketSisterList(null).size()) {
                        int x = 0;
                        for (WarframeMarketSister record : records) {
                            sisterMapper.insertWarframeMarketSister(record);
                            x++;
                        }
                        log.info("共更新Warframe.Market信条武器 {} 条数据！", x);
                    } else {
                        log.info("Warframe.Market信条武器数据未做更改！");
                    }
                }
            }
        });

    }
}
