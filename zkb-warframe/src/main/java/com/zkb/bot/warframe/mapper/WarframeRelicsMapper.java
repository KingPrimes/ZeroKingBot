package com.zkb.bot.warframe.mapper;


import com.zkb.bot.warframe.domain.WarframeRelics;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author KingPrimes
 * @date 2021-05-26
 */
public interface WarframeRelicsMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param relicsKeyId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    WarframeRelics selectWarframeRelicsById(Integer relicsKeyId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<WarframeRelics> selectWarframeRelicsList(WarframeRelics WarframeRelics);

    /**
     * 根据key查询物品
     */
    List<WarframeRelics> selectWarframeRelicsByAll(String key);

    /**
     * 查最大ID
     */
    WarframeRelics selectWarframeRelicsMaxId();

    /**
     * 根据ID查询 翻译之后的物品
     */
    WarframeRelics selectWarframeRelicsToTraById(Integer relicsKeyId);

    /**
     * 根据遗物Id获取遗物信息
     *
     * @param relicsId ID
     * @return 信息
     */
    List<WarframeRelics> selectWarframeRelicsByRelicsId(String relicsId);

    /**
     * 新增【请填写功能名称】
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 结果
     */
    int insertWarframeRelics(WarframeRelics WarframeRelics);

    /**
     * 批量插入数据
     *
     * @param WarframeRelics
     * @return
     */
    int insertWarframeRelicsList(List<WarframeRelics> WarframeRelics);

    /**
     * 修改【请填写功能名称】
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 结果
     */
    int updateWarframeRelics(WarframeRelics WarframeRelics);

    /**
     * 删除【请填写功能名称】
     *
     * @param relicsKeyId 【请填写功能名称】ID
     * @return 结果
     */
    int deleteWarframeRelicsById(Integer relicsKeyId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param relicsKeyIds 需要删除的数据ID
     * @return 结果
     */
    int deleteWarframeRelicsByIds(Integer[] relicsKeyIds);

    /**
     * 清空表格
     *
     * @return 影响行数
     */
    int deleteWarframeRelics();
}
