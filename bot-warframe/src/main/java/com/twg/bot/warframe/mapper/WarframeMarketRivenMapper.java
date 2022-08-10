package com.twg.bot.warframe.mapper;


import com.twg.bot.warframe.domain.market.WarframeMarketRiven;

import java.util.List;

public interface WarframeMarketRivenMapper {
    /**
     * 查询Warframe.Market紫卡拍卖
     *
     * @param marketRiven 数据
     * @return 结果
     */
    List<WarframeMarketRiven> selectWarframeMarketRivenList(WarframeMarketRiven marketRiven);

    List<WarframeMarketRiven> selectWarframeMarketRivenByItemName(String itemName);

    /**
     * 批量添加
     *
     * @param marketRivenList 数据
     * @return 结果
     */
    int insertWarframeMarketRiven(List<WarframeMarketRiven> marketRivenList);
}
