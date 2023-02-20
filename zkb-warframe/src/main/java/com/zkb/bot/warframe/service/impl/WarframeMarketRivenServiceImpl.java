package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zkb.bot.warframe.domain.market.WarframeMarketRiven;
import com.zkb.bot.warframe.mapper.WarframeMarketRivenMapper;
import com.zkb.bot.warframe.service.IWarframeMarketRivenService;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.framework.manager.AsyncManager;
import okhttp3.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TimerTask;

@Service
public class WarframeMarketRivenServiceImpl implements IWarframeMarketRivenService, CommandLineRunner {
    Logger log = LoggerFactory.getLogger(WarframeMarketRivenServiceImpl.class);
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

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                log.info("开始初始化Warframe.Riven数据……");
                List<WarframeMarketRiven> marketRiven;
                String json = HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/riven/items", "", new Headers.Builder().add("language", "zh-hans"));
                if (json.equals("timeout")){
                    log.error("未获取到赤毒武器数据……");
                    return;
                }
                marketRiven = JSONObject.parseObject(json).getJSONObject("payload").getJSONArray("items").toJavaList(WarframeMarketRiven.class);

                if (marketRiven.size() != marketRivenMapper.selectWarframeMarketRivenList(null).size()) {
                    List<List<WarframeMarketRiven>> lists = Lists.partition(marketRiven, 500);
                    for (List<WarframeMarketRiven> mrs : lists) {
                        marketRivenMapper.insertWarframeMarketRiven(mrs);
                    }
                    log.info("Warframe.Riven数据更新完毕！");
                } else {
                    log.info("Warframe.Market赤毒武器数据未做更改！");
                }
            }
        });

    }
}
