package com.twg.bot.warframe.mapper;


import com.twg.bot.warframe.domain.WarframeAlias;

import java.util.List;

/**
 * Warframe Alias Mapper接口
 *
 * @author KingPrimes
 * @Date 2021-05-24
 */
public interface WarframeAliasMapper {
    /**
     * 查询
     *
     * @param aliasId ID
     */
    WarframeAlias selectWarframeAliasById(Integer aliasId);

    /**
     * 查询列表
     *
     * @param warframeAlias 条件
     */
    List<WarframeAlias> selectWarframeAliasList(WarframeAlias warframeAlias);

    /**
     * 新增
     *
     * @param warframeAlias 数据
     * @return 结果
     */
    int insertWarframeAlias(WarframeAlias warframeAlias);

    /**
     * 修改
     *
     * @param warframeAlias 数据
     * @return 结果
     */
    int updateWarframeAlias(WarframeAlias warframeAlias);

    /**
     * 删除
     *
     * @param aliasId ID
     * @return 结果
     */
    int deleteWarframeAliasById(Integer aliasId);

    /**
     * 批量删除
     *
     * @param aliasIds 需要删除的数据ID
     * @return 结果
     */
    int deleteWarframeAliasByIds(Integer[] aliasIds);
}
