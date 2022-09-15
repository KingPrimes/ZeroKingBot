package com.zkb.bot.warframe.mapper;


import com.zkb.bot.warframe.domain.market.WarframeMarketItems;
import com.zkb.bot.warframe.domain.market.WarframeMarketItemsRegular;

import java.util.List;

//@Mapper
public interface WarframeMarketItemsMapper {
    /**
     * 查询所有数据
     *
     * @param items 条件
     * @return 结果集
     */
    List<WarframeMarketItems> selectWarframeMarketItemsList(WarframeMarketItems items);

    /**
     * 模糊查询数据
     *
     * @param itemName 名称
     * @return 结果集
     */
    List<WarframeMarketItems> selectWarframeMarketItemsLikeList(String itemName);

    /**
     * 根据名称模糊查询数据
     *
     * @param itemName 名称
     * @return 结果集
     */
    List<WarframeMarketItems> selectWarframeMarketItemsByItemNameList(String itemName);


    /**
     * 根据名称模糊查询数据
     *
     * @param itemName 名称
     * @return 结果
     */
    WarframeMarketItems selectWarframeMarketItemsByItemName(String itemName);

    /**
     * 根据Id获取物品详情
     *
     * @param id ID
     * @return 详细信息
     */
    WarframeMarketItems selectWarframeMarketItemsById(String id);


    /**
     * 根据名称正则查询数据
     *
     * @param regular 正则
     * @return 结果
     */
    //@Select("select * from wf_market_items where upper(replace(item_name,' ','')) like UPPER(replace('%'||#{}||'%',' ',''))")
    WarframeMarketItems selectWarframeMarketItemByItemNameToRegular(WarframeMarketItemsRegular regular);


    /**
     * 新增
     *
     * @param items 数据集
     * @return 新增条数
     */
    int insertWarframeMarketItems(List<WarframeMarketItems> items);

}
