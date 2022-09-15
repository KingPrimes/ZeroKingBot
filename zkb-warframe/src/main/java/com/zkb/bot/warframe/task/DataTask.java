package com.zkb.bot.warframe.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zkb.bot.warframe.dao.DataHash;
import com.zkb.bot.warframe.domain.WarframeRelics;
import com.zkb.bot.warframe.domain.WarframeTranslation;
import com.zkb.bot.warframe.domain.WfAllTranslNo;
import com.zkb.bot.warframe.service.impl.WarframeRelicsServiceImpl;
import com.zkb.bot.warframe.service.impl.WarframeTranslationServiceImpl;
import com.zkb.bot.warframe.service.impl.WfAllTranslNoImpl;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataTask {

    private static final Logger log = LoggerFactory.getLogger(DataTask.class);

    //每天请求一下判断Hash值是否相同
    @Async("taskExecutor")
    @Scheduled(cron = "${task.cron.dataTask}")
    public void getDataHash() {
        DataHash d = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://drops.warframestat.us//data/info.json"), DataHash.class);
        DataHash dh;
        try {
            dh = SpringUtils.getBean(RedisCache.class).getCacheObject("datahash");
            if (dh == null) {
                SpringUtils.getBean(RedisCache.class).setCacheObject("datahash", d);
                return;
            }
            if (!d.equals(dh)) {
                getRelics();
                updateTra();
                SpringUtils.getBean(RedisCache.class).setCacheObject("datahash", d);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取遗物Hash出错，错误信息：{}", e.getMessage());
            SpringUtils.getBean(RedisCache.class).setCacheObject("datahash", d);
        }


    }

    public void getRelics() {
        String json = HttpUtils.sendGetOkHttp("https://drops.warframestat.us/data/relics.json");
        JSONObject object = JSON.parseObject(json);
        JSONArray array = object.getJSONArray("relics");
        List<WarframeRelics> relics = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject jrelic = array.getJSONObject(i);
            if (!jrelic.getString("state").contains("Intact")) {
                continue;
            }
            JSONArray rewards = jrelic.getJSONArray("rewards");
            for (int j = 0; j < rewards.size(); j++) {
                JSONObject r = rewards.getJSONObject(j);
                relics.add(new WarframeRelics(
                        0,
                        jrelic.getString("_id"),
                        jrelic.getString("tier"),
                        jrelic.getString("relicName"),
                        jrelic.getString("state"),
                        r.getString("_id"),
                        r.getString("itemName"),
                        r.getString("rarity"),
                        r.getString("chance"),
                        ""
                ));
            }
        }
        SpringUtils.getBean(WarframeRelicsServiceImpl.class).deleteWarframeRelics();
        for (WarframeRelics relic : relics) {
            SpringUtils.getBean(WarframeRelicsServiceImpl.class).insertWarframeRelics(relic);
        }
    }

    public void updateTra() {
        List<WfAllTranslNo> atNos = SpringUtils.getBean(WfAllTranslNoImpl.class).selectAllNoRelics(null);

        for (WfAllTranslNo atNo : atNos) {
            StringBuilder str = new StringBuilder();
            //根据空格分隔字符串
            String[] s = atNo.getRelicsItemName().split(" ");

            for (int i = 0; i < s.length; i++) {
                //获取Prime的字符串内容
                if (s[i].equals("Prime")) {
                    StringBuilder j = new StringBuilder();
                    for (int x = 0; x <= i; x++) {
                        if (x != i) {
                            j.append(s[x]).append(" ");
                        }
                        if (x == i) {
                            j.append(s[x]);
                        }
                    }
                    str.append(SpringUtils.getBean(WarframeTranslationServiceImpl.class).enToZh(j.toString()));
                }
                if (i == s.length - 1) {
                    str.append(" ").append(SpringUtils.getBean(WarframeTranslationServiceImpl.class).enToZh(s[i]));
                }
            }
            SpringUtils.getBean(WarframeTranslationServiceImpl.class).insertWarframeTranslation(new WarframeTranslation(
                    atNo.getRelicsItemName(),
                    str.toString(),
                    0L,
                    0L
            ));
        }
    }

}
