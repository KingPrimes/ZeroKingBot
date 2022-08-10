package com.twg.bot.warframe.service;


import com.twg.bot.warframe.domain.market.WarframeMarketLichOrSister;

import java.util.List;

public interface IWarframeMarketSisterService {
    /**
     * 查询信条武器与幻纹
     *
     * @param sister 条件
     * @return 结果集
     */
    List<WarframeMarketLichOrSister> selectWarframeMarketSisterList(WarframeMarketLichOrSister sister);


    /**
     * 根据物品名称查出详细内容
     *
     * @param name 物品名称
     * @return 实体类
     */
    WarframeMarketLichOrSister selectWarframeMarketSisterByItemName(String name);

    /**
     * 根据ID查询详细内容
     *
     * @param id id
     * @return 结果
     */
    WarframeMarketLichOrSister selectWarframeMarketSisterById(String id);

    /**
     * 根据元素查出详细内容
     *
     * @param element 元素名称
     * @return 实体类
     */
    WarframeMarketLichOrSister selectWarframeMarketSisterByElement(String element);

    /**
     * 根据Url地址查询详细内容
     *
     * @param urlName Url地址
     * @return 实体类
     */
    WarframeMarketLichOrSister selectWarframeMarketSisterByUrlName(String urlName);

    /**
     * 新增
     *
     * @param sister 数据
     * @return 影响行数
     */
    int insertWarframeMarketSister(WarframeMarketLichOrSister sister);

    /**
     * 修改
     *
     * @param sister 数据
     * @return 影响行数
     */
    int updateWarframeMarketSister(WarframeMarketLichOrSister sister);

    int deleteWarframeMarketSisterById(String id);

    int deleteWarframeMarketSisterByIds(String[] id);
}
