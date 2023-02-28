package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zkb.bot.warframe.domain.market.WarframeMarketItems;
import com.zkb.bot.warframe.domain.market.WarframeMarketItemsRegular;
import com.zkb.bot.warframe.mapper.WarframeMarketItemsMapper;
import com.zkb.bot.warframe.service.IWarframeMarketItemsService;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.zero.ZeroConfig;
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
public class WarframeMarketItemsServiceImpl implements IWarframeMarketItemsService, CommandLineRunner {
    Logger log = LoggerFactory.getLogger(WarframeMarketItemsServiceImpl.class);
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
     * 根据Id获取物品详情
     *
     * @param id ID
     * @return 详细信息
     */
    @Override
    public WarframeMarketItems selectWarframeMarketItemsById(String id) {
        WarframeMarketItems items = itemsMapper.selectWarframeMarketItemsById(id);
        if (items == null) {
            items = new WarframeMarketItems();
            items.setItemName("未知物品");
        }
        return items;
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
     * 根据名称模糊查询数据
     *
     * @param itemName 名称
     * @return 结果
     */
    @Override
    public WarframeMarketItems selectWarframeMarketItemsByItemNameSet(String itemName) {
        WarframeMarketItems warframeMarketItems = itemsMapper.selectWarframeMarketItemsByItemNameSet(itemName);
        if (warframeMarketItems == null) {
            warframeMarketItems = itemsMapper.selectWarframeMarketItemsByItemName(itemName);
        }
        return warframeMarketItems;
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

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化MarketItems表数据……");
                    List<WarframeMarketItems> items;
                    String json = HttpUtils.sendGetOkHttp(
                            "https://api.warframe.market/v1/items",
                            "",
                            new Headers.Builder()
                                    .add("language", "zh-hans"));
                    if (json.equals("timeout")) {
                        log.error("未获取到Warframe.MarketItems数据……");
                        return;
                    }
                    items = JSONObject.parseObject(
                                    json)
                            .getJSONObject("payload")
                            .getJSONArray("items")
                            .toJavaList(WarframeMarketItems.class);

                    if (itemsMapper.selectWarframeMarketItemsList(null).size() != items.size()) {
                        List<List<WarframeMarketItems>> lists = Lists.partition(items, 500);
                        int i = 0;
                        for (List<WarframeMarketItems> mrs : lists) {
                            i += itemsMapper.insertWarframeMarketItems(mrs);
                        }
                        log.info("共更新MarketItems {} 条数据！", i);
                    } else {
                        log.info("MarketItems表数据未做更改！");
                    }
                }
            }
        });


    }
}
