package com.twg.bot.warframe.mapper;


import com.twg.bot.warframe.domain.WarframeRivenTrend;

import java.util.List;

/**
 * WarframeRivenTrendMapper接口
 * 紫卡倾向
 *
 * @author KingPrimes
 * @Date 2021-06-02
 */
public interface WarframeRivenTrendMapper {
    /**
     * 查询
     *
     * @param rivenTrendId ID
     * @return 结果
     */
    WarframeRivenTrend selectWarframeRivenTrendById(Long rivenTrendId);

    /**
     * 查询列表
     *
     * @param warframeRivenTrend 条件
     * @return 集合
     */
    List<WarframeRivenTrend> selectWarframeRivenTrendList(WarframeRivenTrend warframeRivenTrend);

    /**
     * 新增
     *
     * @param warframeRivenTrend 数据
     * @return 结果
     */
    int insertWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend);

    /**
     * 新增与修改
     *
     * @return 结果
     */
    int insertAndUpDateWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend);

    /**
     * 修改
     *
     * @param warframeRivenTrend 数据
     * @return 结果
     */
    int updateWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend);

    /**
     * 删除
     *
     * @param rivenTrendId ID
     * @return 结果
     */
    int deleteWarframeRivenTrendById(Long rivenTrendId);

    /**
     * 批量删除
     *
     * @param rivenTrendIds 需要删除的数据ID
     * @return 结果
     */
    int deleteWarframeRivenTrendByIds(Long[] rivenTrendIds);
}
