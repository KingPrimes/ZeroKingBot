package com.zkb.bot.warframe.mapper;


import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTionNick;

import java.util.List;

public interface WarframeMarketRivenTionNickMapper {
    List<WarframeMarketRivenTionNick> selectWarframeMarketRivenTionNickByNickCh(WarframeMarketRivenTionNick nick);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickByNickCh(String nick);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickEn(String en);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickCh(String ch);

    List<WarframeMarketRivenTionNick> selectWarframeMarketRivenTionNickList();

    int insertWarframeMarketRivenTionNickLikeNickCh(WarframeMarketRivenTionNick nick);
}
