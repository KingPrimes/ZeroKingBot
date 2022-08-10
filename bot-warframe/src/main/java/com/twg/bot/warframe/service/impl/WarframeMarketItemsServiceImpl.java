package com.twg.bot.warframe.service.impl;


import com.twg.bot.warframe.domain.market.WarframeMarketItems;
import com.twg.bot.warframe.domain.market.WarframeMarketItemsRegular;
import com.twg.bot.warframe.mapper.WarframeMarketItemsMapper;
import com.twg.bot.warframe.service.IWarframeMarketItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeMarketItemsServiceImpl implements IWarframeMarketItemsService {

    @Autowired
    WarframeMarketItemsMapper itemsMapper;


    /**
     * 查询所有数据
     *
     * @param items 条件
     * @return 结果集
     */
    @Override
    public List<WarframeMarketItems> selectWarframeMarketItemsList(WarframeMarketItems items) {
        return itemsMapper.selectWarframeMarketItemsList(items);
    }

    /**
     * 模糊查询数据
     *
     * @param itemName 名称
     * @return 结果集
     */
    @Override
    public List<WarframeMarketItems> selectWarframeMarketItemsLikeList(String itemName) {
        return itemsMapper.selectWarframeMarketItemsLikeList(itemName);
    }

    /**
     * 根据名称模糊查询数据
     *
     * @param itemName 名称
     * @return 结果集
     */
    @Override
    public List<WarframeMarketItems> selectWarframeMarketItemsByItemNameList(String itemName) {
        return itemsMapper.selectWarframeMarketItemsByItemNameList(itemName);
    }

    /**
     * 根据名称模糊查询数据
     *
     * @param itemName 名称
     * @return 结果
     */
    @Override
    public WarframeMarketItems selectWarframeMarketItemsByItemName(String itemName) {
        return itemsMapper.selectWarframeMarketItemsByItemName(itemName);
    }

    /**
     * 根据名称正则查询数据
     *
     * @param regular 正则
     * @return 结果
     */
    @Override
    public WarframeMarketItems selectWarframeMarketItemByItemNameToRegular(WarframeMarketItemsRegular regular) {
        try {
            return itemsMapper.selectWarframeMarketItemByItemNameToRegular(regular);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 新增
     *
     * @param items 数据集
     * @return 新增条数
     */
    @Override
    public int insertWarframeMarketItems(List<WarframeMarketItems> items) {
        return itemsMapper.insertWarframeMarketItems(items);
    }
}
