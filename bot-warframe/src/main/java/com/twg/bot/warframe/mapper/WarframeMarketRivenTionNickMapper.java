package com.twg.bot.warframe.mapper;


import com.twg.bot.warframe.domain.market.WarframeMarketRivenTionNick;

import java.util.List;

public interface WarframeMarketRivenTionNickMapper {
    List<WarframeMarketRivenTionNick> selectWarframeMarketRivenTionNickByNickCh(WarframeMarketRivenTionNick nick);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickByNickCh(String nick);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickEn(String en);

    WarframeMarketRivenTionNick selectWarframeMarketRivenTionNickLikeNickCh(String ch);
}
