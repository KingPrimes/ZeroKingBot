package com.twg.bot.warframe.service.impl;


import com.twg.bot.warframe.domain.WarframeRivenTrend;
import com.twg.bot.warframe.mapper.WarframeRivenTrendMapper;
import com.twg.bot.warframe.service.IWarframeRivenTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * WarframeRivenTrendService业务层处理
 * 紫卡倾向
 *
 * @author KingPrimes
 * @date 2021-06-02
 */
@Service
public class WarframeRivenTrendServiceImpl implements IWarframeRivenTrendService {
    @Autowired
    private WarframeRivenTrendMapper trendMapper;

    /**
     * 查询
     *
     * @param rivenTrendId ID
     * @return 结果
     */
    @Override
    public WarframeRivenTrend selectWarframeRivenTrendById(Long rivenTrendId) {
        return trendMapper.selectWarframeRivenTrendById(rivenTrendId);
    }

    /**
     * 查询列表
     *
     * @param warframeRivenTrend 条件
     * @return 集合
     */
    @Override
    public List<WarframeRivenTrend> selectWarframeRivenTrendList(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.selectWarframeRivenTrendList(warframeRivenTrend);
    }

    /**
     * 新增
     *
     * @param warframeRivenTrend 数据
     * @return 结果
     */
    @Override
    public int insertWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.insertWarframeRivenTrend(warframeRivenTrend);
    }

    /**
     * 新增与修改
     *
     * @param warframeRivenTrend
     * @return 结果
     */
    @Override
    public int insertAndUpDateWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.insertAndUpDateWarframeRivenTrend(warframeRivenTrend);
    }

    /**
     * 修改
     *
     * @param warframeRivenTrend 数据
     * @return 结果
     */
    @Override
    public int updateWarframeRivenTrend(WarframeRivenTrend warframeRivenTrend) {
        return trendMapper.updateWarframeRivenTrend(warframeRivenTrend);
    }

    /**
     * 删除
     *
     * @param rivenTrendId ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRivenTrendById(Long rivenTrendId) {
        return trendMapper.deleteWarframeRivenTrendById(rivenTrendId);
    }

    /**
     * 批量删除
     *
     * @param rivenTrendIds 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRivenTrendByIds(Long[] rivenTrendIds) {
        return trendMapper.deleteWarframeRivenTrendByIds(rivenTrendIds);
    }
}
