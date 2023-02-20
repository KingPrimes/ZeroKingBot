package com.zkb.bot.warframe.mapper;


import com.zkb.bot.warframe.domain.market.WarframeMarketSister;

import java.util.List;

public interface WarframeMarketSisterMapper {
    /**
     * 查询信条武器与幻纹
     *
     * @param sister 条件
     * @return 结果集
     */
    List<WarframeMarketSister> selectWarframeMarketSisterList(WarframeMarketSister sister);


    /**
     * 根据物品名称查出详细内容
     *
     * @param name 物品名称
     * @return 实体类
     */
    WarframeMarketSister selectWarframeMarketSisterByItemName(String name);


    /**
     * 根据ID查询详细内容
     *
     * @param id id
     * @return 结果
     */
    WarframeMarketSister selectWarframeMarketSisterById(String id);

    /**
     * 根据元素查出详细内容
     *
     * @param element 元素名称
     * @return 实体类
     */
    WarframeMarketSister selectWarframeMarketSisterByElement(String element);

    /**
     * 根据Url地址查询详细内容
     *
     * @param urlName Url地址
     * @return 实体类
     */
    WarframeMarketSister selectWarframeMarketSisterByUrlName(String urlName);

    /**
     * 新增
     *
     * @param sister 数据
     * @return 影响行数
     */
    int insertWarframeMarketSister(WarframeMarketSister sister);

    /**
     * 修改
     *
     * @param sister 数据
     * @return 影响行数
     */
    int updateWarframeMarketSister(WarframeMarketSister sister);

    int deleteWarframeMarketSisterById(String id);

    int deleteWarframeMarketSisterByIds(String[] id);
}
