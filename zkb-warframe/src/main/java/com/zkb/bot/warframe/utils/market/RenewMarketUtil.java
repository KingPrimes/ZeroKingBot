package com.zkb.bot.warframe.utils.market;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zkb.bot.warframe.domain.market.WarframeMarketItems;
import com.zkb.bot.warframe.domain.market.WarframeMarketLichOrSister;
import com.zkb.bot.warframe.domain.market.WarframeMarketRiven;
import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTion;
import com.zkb.bot.warframe.service.IWarframeMarketItemsService;
import com.zkb.bot.warframe.service.IWarframeMarketRivenService;
import com.zkb.bot.warframe.service.IWarframeMarketRivenTionService;
import com.zkb.bot.warframe.service.IWarframeMarketSisterService;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.spring.SpringUtils;
import okhttp3.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RenewMarketUtil {

    private static final Logger log = LoggerFactory.getLogger(RenewMarketUtil.class);
    /**
     * 更新Market紫卡词典
     *
     * @return 更新条数
     */
    public static int resMarketRiven() {
        try {
            List<WarframeMarketRiven> marketRiven;
            marketRiven = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/riven/items", "", new Headers.Builder().add("language", "zh-hans"))).getJSONObject("payload").getJSONArray("items").toJavaList(WarframeMarketRiven.class);
            List<List<WarframeMarketRiven>> lists = Lists.partition(marketRiven, 500);
            int i = 0;
            for (List<WarframeMarketRiven> mrs : lists) {
                i += SpringUtils.getBean(IWarframeMarketRivenService.class).insertWarframeMarketRiven(mrs);
            }
            return i;
        } catch (Exception e) {
            log.error("更新Market紫卡词典：{}",e.getMessage());
            return 0;
        }
    }

    /**
     * 更新Market紫卡词条词典
     *
     * @return 更新条数
     */
    public static int resMarketRivenTion() {
        try {
            List<WarframeMarketRivenTion> tionList;

            tionList = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/riven/attributes", "", new Headers.Builder().add("language", "zh-hans"))).getJSONObject("payload").getJSONArray("attributes").toJavaList(WarframeMarketRivenTion.class);

            List<List<WarframeMarketRivenTion>> lists = Lists.partition(tionList, 500);
            int i = 0;
            for (List<WarframeMarketRivenTion> mrs : lists) {
                i += SpringUtils.getBean(IWarframeMarketRivenTionService.class).insertWarframeMarketRivenTion(mrs);
            }
            return i;
        } catch (Exception e) {
            log.error("更新Market紫卡词条词典：{}",e.getMessage());
            return 0;
        }
    }

    /**
     * 更新Market物品词典
     *
     * @return 更新条数
     */
    public static int resMarketItems() {
        List<WarframeMarketItems> items;

        items = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/items", "", new Headers.Builder().add("language", "zh-hans"))).getJSONObject("payload").getJSONArray("items").toJavaList(WarframeMarketItems.class);

        List<List<WarframeMarketItems>> lists = Lists.partition(items, 500);
        int i = 0;
        for (List<WarframeMarketItems> mrs : lists) {
            i += SpringUtils.getBean(IWarframeMarketItemsService.class).insertWarframeMarketItems(mrs);
        }
        log.info("更新Market物品词典 条{}数据",i);
        return i;
    }


    /**
     * 更新 Market 信条 武器与幻纹
     *
     * @return int[0] = Weapons; int[1] = Ephemera 更新条数
     */
    public static int[] resMarketSister() {
        return new int[]{resMarketSisterWeapons(), resMarketSisterEphemera()};
    }

    /**
     * 更新Market 信条 武器
     */
    private static int resMarketSisterWeapons() {
        List<WarframeMarketLichOrSister> sisters = JSONObject.parseObject(
                        HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/sister/weapons", "", new Headers.Builder().add("language", "zh-hans")))
                .getJSONObject("payload")
                .getJSONArray("weapons")
                .toJavaList(WarframeMarketLichOrSister.class);
        int i = 0;
        for (WarframeMarketLichOrSister sister : sisters) {
            i += SpringUtils.getBean(IWarframeMarketSisterService.class).insertWarframeMarketSister(sister);
        }
        log.info("更新Market 信条 武器 共更新条{}数据",i);
        return i;
    }

    /**
     * 更新Market 信条 幻纹
     */
    private static int resMarketSisterEphemera() {
        List<WarframeMarketLichOrSister> sisters = JSONObject.parseObject(
                        HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/sister/ephemeras", "", new Headers.Builder().add("language", "zh-hans")))
                .getJSONObject("payload")
                .getJSONArray("ephemeras")
                .toJavaList(WarframeMarketLichOrSister.class);
        int i = 0;
        for (WarframeMarketLichOrSister sister : sisters) {
            i += SpringUtils.getBean(IWarframeMarketSisterService.class).insertWarframeMarketSister(sister);
        }
        log.info("更新Market 信条 幻纹 共更新条{}数据",i);
        return i;
    }


}
