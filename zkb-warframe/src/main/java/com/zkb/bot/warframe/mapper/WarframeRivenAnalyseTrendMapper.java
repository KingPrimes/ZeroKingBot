package com.zkb.bot.warframe.mapper;

import com.zkb.bot.warframe.domain.WarframeRivenAnalyseTrend;

import java.util.List;

public interface WarframeRivenAnalyseTrendMapper {

    List<WarframeRivenAnalyseTrend> selectWarframeRivenAnalyseTrendList(WarframeRivenAnalyseTrend trend);

    WarframeRivenAnalyseTrend selectWarframeRivenAnalyseTrendById(Long id);

    int insertWarframeRivenAnalyseTrend(WarframeRivenAnalyseTrend trend);

    int updateWarframeRivenAnalyseTrend(WarframeRivenAnalyseTrend trend);
}
