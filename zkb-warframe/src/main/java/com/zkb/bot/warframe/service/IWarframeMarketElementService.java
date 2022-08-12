package com.zkb.bot.warframe.service;


import com.zkb.bot.warframe.domain.market.WarframeMarketElement;

import java.util.List;

/**
 * WarframeMarketElementService 接口
 * Market 赤毒/信条武器 元素字典
 *
 * @author KingPrimes
 * @date 2021-11-29
 */
public interface IWarframeMarketElementService {

    /**
     * 查询赤毒元素字典
     *
     * @param elementEn 赤毒元素字典主键
     * @return 赤毒元素字典
     */
    WarframeMarketElement selectWarframeMarketElementByElementEn(String elementEn);

    /**
     * 查询赤毒元素字典列表
     *
     * @param warframeMarketElement 赤毒元素字典
     * @return 赤毒元素字典集合
     */
    List<WarframeMarketElement> selectWarframeMarketElementList(WarframeMarketElement warframeMarketElement);

    /**
     * 模糊查询英文
     *
     * @param en 条件-英文
     * @return 结果
     */
    WarframeMarketElement selectWarframeMarketElementLikeEn(String en);

    /**
     * 模糊查询中文
     *
     * @param ch 条件-中文
     * @return 结果
     */
    WarframeMarketElement selectWarframeMarketElementLikeCh(String ch);

    /**
     * 新增元素字典
     *
     * @param warframeMarketElement 元素字典
     * @return 结果
     */
    int insertWarframeMarketElement(WarframeMarketElement warframeMarketElement);

    /**
     * 修改元素字典
     *
     * @param warframeMarketElement 元素字典
     * @return 结果
     */
    int updateWarframeMarketElement(WarframeMarketElement warframeMarketElement);

    /**
     * 删除元素字典
     *
     * @param elementEn 赤毒字典主键
     * @return 结果
     */
    int deleteWarframeMarketElementByElementEn(String elementEn);

    /**
     * 批量删除元素字典
     *
     * @param elementEns 需要删除的数据主键集合
     * @return 结果
     */
    int deleteWarframeMarketElementByElementEns(String[] elementEns);
}
