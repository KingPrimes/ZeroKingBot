package com.zkb.bot.warframe.service.impl;


import com.zkb.bot.warframe.domain.WarframeRelics;
import com.zkb.bot.warframe.mapper.WarframeRelicsMapper;
import com.zkb.bot.warframe.service.IWarframeRelicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author KingPrimes
 * @date 2021-05-26
 */
@Service
public class WarframeRelicsServiceImpl implements IWarframeRelicsService {
    @Autowired
    private WarframeRelicsMapper WarframeRelicsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param relicsKeyId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public WarframeRelics selectWarframeRelicsById(Integer relicsKeyId) {
        return WarframeRelicsMapper.selectWarframeRelicsById(relicsKeyId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WarframeRelics> selectWarframeRelicsList(WarframeRelics WarframeRelics) {
        return WarframeRelicsMapper.selectWarframeRelicsList(WarframeRelics);
    }

    /**
     * 根据key查询物品
     */
    @Override
    public List<WarframeRelics> selectWarframeRelicsByAll(String key) {
        return WarframeRelicsMapper.selectWarframeRelicsByAll(key);
    }

    /**
     * 根据遗物Id获取遗物信息
     *
     * @param relicsId ID
     * @return 信息
     */
    @Override
    public List<WarframeRelics> selectWarframeRelicsByRelicsId(String relicsId) {
        return WarframeRelicsMapper.selectWarframeRelicsByRelicsId(relicsId);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWarframeRelics(WarframeRelics WarframeRelics) {
        return WarframeRelicsMapper.insertWarframeRelics(WarframeRelics);
    }

    /**
     * 查最大ID
     */
    @Override
    public WarframeRelics selectWarframeRelicsMaxId() {
        return WarframeRelicsMapper.selectWarframeRelicsMaxId();
    }

    /**
     * 根据ID查询 翻译之后的物品
     */
    @Override
    public WarframeRelics selectWarframeRelicsToTraById(Integer relicsKeyId) {
        return WarframeRelicsMapper.selectWarframeRelicsToTraById(relicsKeyId);
    }

    @Override
    public int insertWarframeRelicsList(List<WarframeRelics> WarframeRelics) {
        return WarframeRelicsMapper.insertWarframeRelicsList(WarframeRelics);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWarframeRelics(WarframeRelics WarframeRelics) {
        return WarframeRelicsMapper.updateWarframeRelics(WarframeRelics);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param relicsKeyIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRelicsByIds(Integer[] relicsKeyIds) {
        return WarframeRelicsMapper.deleteWarframeRelicsByIds(relicsKeyIds);
    }

    /**
     * 清空表格
     *
     * @return 影响行数
     */
    @Override
    public int deleteWarframeRelics() {
        return WarframeRelicsMapper.deleteWarframeRelics();
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param relicsKeyId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRelicsById(Integer relicsKeyId) {
        return WarframeRelicsMapper.deleteWarframeRelicsById(relicsKeyId);
    }
}
