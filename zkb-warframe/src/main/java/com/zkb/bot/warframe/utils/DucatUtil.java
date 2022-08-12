package com.zkb.bot.warframe.utils;

import com.alibaba.fastjson.JSON;
import com.zkb.bot.warframe.dao.DucatDumps;
import com.zkb.bot.warframe.dao.Ducats;
import com.zkb.bot.warframe.service.impl.WarframeMarketItemsServiceImpl;
import com.zkb.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DucatUtil {

    @Autowired
    WarframeMarketItemsServiceImpl mis;

    public DucatDumps getDucats() {
        DucatDumps dd = new DucatDumps();
        Ducats ducats = new Ducats();
        ducats.setDucats(JSON.parseObject(HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/tools/ducats")).getJSONObject("payload").getJSONArray("previous_hour").toJavaList(Ducats.Ducat.class));
        dd.setSilver(formatDucats(ducats.getSilverDump()));
        dd.setGod(formatDucats(ducats.getGodDump()));
        return dd;
    }

    /**
     * 格式化并限制 数量
     * @param ducats 数据
     * @return 格式化之后的数据
     */
    private List<Ducats.Ducat> formatDucats(List<Ducats.Ducat> ducats) {
        List<Ducats.Ducat> ducatList = new ArrayList<>();
        int i = 0;
        for (Ducats.Ducat ducat : ducats) {
            if (i >= 5) {
                break;
            }
            ducat.setItem_name(mis.selectWarframeMarketItemsById(ducat.getItem()).getItemName());
            ducatList.add(ducat);
            i++;
        }
        return ducatList;
    }
}
