package com.twg.bot.warframe.mapper;


import com.twg.bot.warframe.domain.market.WarframeMarketRivenTion;

import java.util.List;

public interface WarframeMarketRivenTionMapper {
    /**
     * 查询
     *
     * @param warframeMarketRivenTion 数据
     * @return 结果
     */
    List<WarframeMarketRivenTion> selectWarframeMarketRivenTionList(WarframeMarketRivenTion warframeMarketRivenTion);

    List<WarframeMarketRivenTion> selectWarframeMarketRivenTionByEffect(String eff);

    /**
     * 根据Url查询
     *
     * @param urlName 数据
     * @return 结果
     */
    WarframeMarketRivenTion selectWarframeMarketRivenTionByUrlName(String urlName);

    /**
     * 批量添加
     *
     * @param tionList 数据
     * @return 结果
     */
    int insertWarframeMarketRivenTion(List<WarframeMarketRivenTion> tionList);
}
