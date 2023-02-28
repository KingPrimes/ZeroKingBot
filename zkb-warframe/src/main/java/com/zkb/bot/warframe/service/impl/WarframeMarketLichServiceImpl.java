package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.market.WarframeMarketLich;
import com.zkb.bot.warframe.mapper.WarframeMarketLichMapper;
import com.zkb.bot.warframe.service.IWarframeMarketLichService;
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

/**
 * lichService业务层处理
 * 赤毒武器拍卖
 *
 * @author KingPrimes
 * @date 2021-11-24
 */
@Service
public class WarframeMarketLichServiceImpl implements IWarframeMarketLichService, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(WarframeMarketLichServiceImpl.class);

    @Autowired
    private WarframeMarketLichMapper warframeMarketLich;

    /**
     * 查询lich
     *
     * @param id lich主键
     * @return lich
     */
    @Override
    public WarframeMarketLich selectWarframeMarketLichById(String id) {
        return warframeMarketLich.selectWarframeMarketLichById(id);
    }


    /**
     * 查询lich列表
     *
     * @param warframeMarketLichOrSister lich
     * @return lich
     */
    @Override
    public List<WarframeMarketLich> selectWarframeMarketLichList(WarframeMarketLich warframeMarketLichOrSister) {
        return warframeMarketLich.selectWarframeMarketLichList(warframeMarketLichOrSister);
    }

    /**
     * 根据物品名称模糊查询结果
     *
     * @param itemName 物品名称
     * @return WarframeMarketLich
     */
    @Override
    public WarframeMarketLich selectWarframeMarketLichByItemName(String itemName) {
        return warframeMarketLich.selectWarframeMarketLichByItemName(itemName);
    }

    /**
     * 根据元素查询幻纹
     *
     * @param element 元素
     * @return 实体类
     */
    @Override
    public WarframeMarketLich selectWarframeMarketLichByElement(String element) {
        return warframeMarketLich.selectWarframeMarketLichByElement(element);
    }

    @Override
    public WarframeMarketLich selectWarframeMarketLichByUrlName(String urlName) {
        return warframeMarketLich.selectWarframeMarketLichByUrlName(urlName);
    }

    /**
     * 新增lich
     *
     * @param warframeMarketLichOrSister lich
     * @return 结果
     */
    @Override
    public int insertWarframeMarketLich(WarframeMarketLich warframeMarketLichOrSister) {
        return warframeMarketLich.insertWarframeMarketLich(warframeMarketLichOrSister);
    }

    /**
     * 修改lich
     *
     * @param warframeMarketLichOrSister lich
     * @return 结果
     */
    @Override
    public int updateWarframeMarketLich(WarframeMarketLich warframeMarketLichOrSister) {
        return warframeMarketLich.updateWarframeMarketLich(warframeMarketLichOrSister);
    }

    /**
     * 批量删除lich
     *
     * @param ids 需要删除的lich主键
     * @return 结果
     */
    @Override
    public int deleteWarframeMarketLichByIds(String[] ids) {
        return warframeMarketLich.deleteWarframeMarketLichByIds(ids);
    }

    /**
     * 删除lich信息
     *
     * @param id lich主键
     * @return 结果
     */
    @Override
    public int deleteWarframeMarketLichById(String id) {
        return warframeMarketLich.deleteWarframeMarketLichById(id);
    }

    @Override
    public void run(String... args) throws Exception {

        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe.Market赤毒武器数据……");
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_market_lich.json");
                    if (aliasJson.trim().length() == 0) {
                        log.error("未获取到赤毒武器数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<WarframeMarketLich> records = alias.getJSONArray("RECORDS").toJavaList(WarframeMarketLich.class);
                    if (records.size() != warframeMarketLich.selectWarframeMarketLichList(null).size()) {
                        int x = 0;
                        for (WarframeMarketLich record : records) {
                            warframeMarketLich.insertWarframeMarketLich(record);
                            x++;
                        }
                        log.info("共更新Warframe.Market赤毒武器 {} 条数据！", x);
                    } else {
                        log.info("Warframe.Market赤毒武器数据未做更改！");
                    }
                }
            }
        });


    }
}
