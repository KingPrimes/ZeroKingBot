package com.twg.bot.warframe.mapper;


import com.twg.bot.warframe.domain.market.WarframeMarketLichOrSister;

import java.util.List;


/**
 * lichMapper接口
 *
 * @author ruoyi
 * @Date 2021-11-24
 */
public interface WarframeMarketLichOrSisterMapper {
    /**
     * 查询lich
     *
     * @param id lich主键
     * @return lich
     */
    WarframeMarketLichOrSister selectWarframeMarketLichById(String id);

    /**
     * 查询lich列表
     *
     * @param warframeMarketLichOrSister lich
     * @return lich集合
     */
    List<WarframeMarketLichOrSister> selectWarframeMarketLichList(WarframeMarketLichOrSister warframeMarketLichOrSister);

    /**
     * 根据物品名称模糊查询结果
     *
     * @param itemName 名称
     * @return 实体类
     */
    WarframeMarketLichOrSister selectWarframeMarketLichByItemName(String itemName);

    /**
     * 根据元素查询幻纹
     *
     * @param element 元素
     * @return 实体类
     */
    WarframeMarketLichOrSister selectWarframeMarketLichByElement(String element);

    WarframeMarketLichOrSister selectWarframeMarketLichByUrlName(String urlName);

    /**
     * 新增lich
     *
     * @param warframeMarketLichOrSister lich
     * @return 结果
     */
    int insertWarframeMarketLich(WarframeMarketLichOrSister warframeMarketLichOrSister);

    /**
     * 修改lich
     *
     * @param warframeMarketLichOrSister lich
     * @return 结果
     */
    int updateWarframeMarketLich(WarframeMarketLichOrSister warframeMarketLichOrSister);

    /**
     * 删除lich
     *
     * @param id lich主键
     * @return 结果
     */
    int deleteWarframeMarketLichById(String id);

    /**
     * 批量删除lich
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteWarframeMarketLichByIds(String[] ids);
}
