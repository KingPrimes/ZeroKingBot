package com.zkb.bot.warframe.service;


import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTionNick;

import java.util.List;

public interface IWarframeMarketRivenTionNickService {

    List<WarframeMarketRivenTionNick> selectWarframeMarketRivenTionNickByNickCh(WarframeMarketRivenTionNick nick);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickByNickCh(String nick);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickEn(String en);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickCh(String ch);
}
