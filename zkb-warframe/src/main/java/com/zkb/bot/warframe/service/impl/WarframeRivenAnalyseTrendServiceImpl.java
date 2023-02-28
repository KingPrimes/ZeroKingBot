package com.zkb.bot.warframe.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.WarframeRivenAnalyseTrend;
import com.zkb.bot.warframe.mapper.WarframeRivenAnalyseTrendMapper;
import com.zkb.bot.warframe.service.IWarframeRivenAnalyseTrendService;
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
public class WarframeRivenAnalyseTrendServiceImpl implements IWarframeRivenAnalyseTrendService, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(WarframeRivenAnalyseTrendServiceImpl.class);

    @Autowired
    WarframeRivenAnalyseTrendMapper trendMapper;

    @Override
    public List<WarframeRivenAnalyseTrend> selectWarframeRivenAnalyseTrendList(WarframeRivenAnalyseTrend trend) {
        return trendMapper.selectWarframeRivenAnalyseTrendList(trend);
    }

    @Override
    public WarframeRivenAnalyseTrend selectWarframeRivenAnalyseTrendById(Long id) {
        return trendMapper.selectWarframeRivenAnalyseTrendById(id);
    }

    @Override
    public WarframeRivenAnalyseTrend selectWarframeRivenAnalyseByPrefix(String prefix) {
        WarframeRivenAnalyseTrend trend = new WarframeRivenAnalyseTrend();
        trend.setPrefix(prefix);
        List<WarframeRivenAnalyseTrend> warframeRivenAnalyseTrends = trendMapper.selectWarframeRivenAnalyseTrendList(trend);
        if (warframeRivenAnalyseTrends.isEmpty()) {
            return new WarframeRivenAnalyseTrend();
        }
        return warframeRivenAnalyseTrends.get(0);
    }

    @Override
    public WarframeRivenAnalyseTrend selectWarframeRivenAnalyseBySuffix(String suffix) {
        WarframeRivenAnalyseTrend trend = new WarframeRivenAnalyseTrend();
        trend.setSuffix(suffix);
        List<WarframeRivenAnalyseTrend> warframeRivenAnalyseTrends = trendMapper.selectWarframeRivenAnalyseTrendList(trend);
        if (warframeRivenAnalyseTrends.isEmpty()) {
            return new WarframeRivenAnalyseTrend();
        }
        return warframeRivenAnalyseTrends.get(0);
    }

    @Override
    public WarframeRivenAnalyseTrend selectWarframeRivenAnalyseByName(String name) {
        WarframeRivenAnalyseTrend trend = new WarframeRivenAnalyseTrend();
        trend.setName(name);
        List<WarframeRivenAnalyseTrend> warframeRivenAnalyseTrends = trendMapper.selectWarframeRivenAnalyseTrendList(trend);
        if (warframeRivenAnalyseTrends.isEmpty()) {
            return new WarframeRivenAnalyseTrend();
        }
        return warframeRivenAnalyseTrends.get(0);
    }

    @Override
    public int insertWarframeRivenAnalyseTrend(WarframeRivenAnalyseTrend trend) {
        return trendMapper.insertWarframeRivenAnalyseTrend(trend);
    }

    @Override
    public int updateWarframeRivenAnalyseTrend(WarframeRivenAnalyseTrend trend) {
        return trendMapper.updateWarframeRivenAnalyseTrend(trend);
    }

    @Override
    public void run(String... args) throws Exception {

        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe-Riven-Analyse-Trend数据……");
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_riven_analyse_trend.json");
                    if (aliasJson.trim().length() == 0) {
                        log.error("未获取到Warframe-Riven-Analyse-Trend数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<WarframeRivenAnalyseTrend> records = alias.getJSONArray("RECORDS").toJavaList(WarframeRivenAnalyseTrend.class);
                    if (records.size() != trendMapper.selectWarframeRivenAnalyseTrendList(null).size()) {
                        int x = 0;
                        for (WarframeRivenAnalyseTrend record : records) {
                            trendMapper.insertWarframeRivenAnalyseTrend(record);
                            x++;
                        }
                        log.info("共更新Warframe-Riven-Analyse-Trend {} 条数据！", x);
                    } else {
                        log.info("Warframe-Riven-Analyse-Trend数据未做更改！");
                    }
                }
            }
        });
    }
}
