package com.twg.bot.warframe.service;


import com.twg.bot.warframe.domain.market.WarframeMarketRivenTion;

import java.util.List;

public interface IWarframeMarketRivenTionService {

    List<WarframeMarketRivenTion> selectWarframeMarketRivenTionList(WarframeMarketRivenTion warframeMarketRivenTion);

    List<WarframeMarketRivenTion> selectWarframeMarketRivenTionByEffect(String eff);

    WarframeMarketRivenTion selectWarframeMarketRivenTionByEffectToTion(String eff);

    WarframeMarketRivenTion selectWarframeMarketRivenTionByUrlName(String urlName);

    int insertWarframeMarketRivenTion(List<WarframeMarketRivenTion> tionList);
}
