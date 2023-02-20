package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.WarframeRivenTrend;
import com.zkb.bot.warframe.domain.market.WarframeMarketSister;
import com.zkb.bot.warframe.mapper.WarframeRivenTrendMapper;
import com.zkb.bot.warframe.service.IWarframeRivenTrendService;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TimerTask;

/**
 * WarframeRivenTrendService业务层处理
 * 紫卡倾向
 *
 * @author KingPrimes
 * @date 2021-06-02
 */
@Service
public class WarframeRivenTrendServiceImpl implements IWarframeRivenTrendService, CommandLineRunner {
    Logger log = LoggerFactory.getLogger(WarframeRivenTrendServiceImpl.class);

    @Autowired
    private WarframeRivenTrendMapper trendMapper;

    /**
     * 查询
     *
     * @param rivenTrendId ID
     * @return 结果
     */
    @Override
    public WarframeRivenTrend selectWarframeRivenTrendById(Long rivenTrendId) {
        return trendMapper.selectWarframeRivenTrendById(rivenTrendId);
    }

    /**
     * 查询列表
     *
     * @param warframeRivenTrend 条件
     * @return 集合
     */
    @Override
    public List<WarframeRivenTrend> selectWarframeRivenTrendList(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.selectWarframeRivenTrendList(warframeRivenTrend);
    }

    /**
     * 新增
     *
     * @param warframeRivenTrend 数据
     * @return 结果
     */
    @Override
    public int insertWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.insertWarframeRivenTrend(warframeRivenTrend);
    }

    /**
     * 新增与修改
     *
     * @param warframeRivenTrend
     * @return 结果
     */
    @Override
    public int insertAndUpDateWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.insertAndUpDateWarframeRivenTrend(warframeRivenTrend);
    }

    /**
     * 修改
     *
     * @param warframeRivenTrend 数据
     * @return 结果
     */
    @Override
    public int updateWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.updateWarframeRivenTrend(warframeRivenTrend);
    }

    /**
     * 删除
     *
     * @param rivenTrendId ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRivenTrendById(Long rivenTrendId) {
        return trendMapper.deleteWarframeRivenTrendById(rivenTrendId);
    }

    /**
     * 批量删除
     *
     * @param rivenTrendIds 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRivenTrendByIds(Long[] rivenTrendIds) {
        return trendMapper.deleteWarframeRivenTrendByIds(rivenTrendIds);
    }


    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                log.info("开始初始化Warframe.RivenTrend紫卡倾向数据……");
                String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc()+"warframe_riven_trend.json");
                if (aliasJson.trim().length() == 0) {
                    log.error("未获取到Warframe.RivenTrend紫卡倾向数据……");
                    return;
                }
                JSONObject alias = JSON.parseObject(aliasJson);
                List<WarframeRivenTrend> records = alias.getJSONArray("RECORDS").toJavaList(WarframeRivenTrend.class);
                if(records.size() != trendMapper.selectWarframeRivenTrendList(null).size()){
                    int x = 0;
                    for (WarframeRivenTrend record : records) {
                        trendMapper.insertAndUpDateWarframeRivenTrend(record);
                        x++;
                    }
                    log.info("共更新Warframe.RivenTrend紫卡倾向 {} 条数据！",x);
                }else{
                    log.info("Warframe.RivenTrend紫卡倾向数据未做更改！");
                }
            }
        });

    }
}
