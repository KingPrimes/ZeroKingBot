package com.zkb.bot.warframe.service;

import com.zkb.bot.warframe.domain.WarframeRivenAnalyseTrend;

import java.util.List;

public interface IWarframeRivenAnalyseTrendService {
    /**
     * 查询列表
     */
    List<WarframeRivenAnalyseTrend> selectWarframeRivenAnalyseTrendList(WarframeRivenAnalyseTrend trend);

    /**
     * 根据ID查询
     */
    WarframeRivenAnalyseTrend selectWarframeRivenAnalyseTrendById(Long id);

    /**
     * 根据前缀查询
     */
    WarframeRivenAnalyseTrend selectWarframeRivenAnalyseByPrefix(String prefix);

    /**
     * 根据后缀查询
     */
    WarframeRivenAnalyseTrend selectWarframeRivenAnalyseBySuffix(String suffix);

    /**
     * 根据词条名称查询
     */
    WarframeRivenAnalyseTrend selectWarframeRivenAnalyseByName(String name);


    /**
     * 添加
     */
    int insertWarframeRivenAnalyseTrend(WarframeRivenAnalyseTrend trend);

    /**
     * 修改
     */
    int updateWarframeRivenAnalyseTrend(WarframeRivenAnalyseTrend trend);


}
