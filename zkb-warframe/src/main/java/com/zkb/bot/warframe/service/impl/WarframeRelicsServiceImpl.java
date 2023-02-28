package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.warframe.dao.DataHash;
import com.zkb.bot.warframe.domain.WarframeRelics;
import com.zkb.bot.warframe.mapper.WarframeRelicsMapper;
import com.zkb.bot.warframe.service.IWarframeRelicsService;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.zero.ZeroConfig;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author KingPrimes
 * @date 2021-05-26
 */
@Service
public class WarframeRelicsServiceImpl implements IWarframeRelicsService, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(WarframeRelicsServiceImpl.class);

    @Autowired
    private WarframeRelicsMapper WarframeRelicsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param relicsKeyId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public WarframeRelics selectWarframeRelicsById(Integer relicsKeyId) {
        return WarframeRelicsMapper.selectWarframeRelicsById(relicsKeyId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WarframeRelics> selectWarframeRelicsList(WarframeRelics WarframeRelics) {
        return WarframeRelicsMapper.selectWarframeRelicsList(WarframeRelics);
    }

    /**
     * 根据key查询物品
     */
    @Override
    public List<WarframeRelics> selectWarframeRelicsByAll(String key) {
        return WarframeRelicsMapper.selectWarframeRelicsByAll(key);
    }

    /**
     * 根据遗物Id获取遗物信息
     *
     * @param relicsId ID
     * @return 信息
     */
    @Override
    public List<WarframeRelics> selectWarframeRelicsByRelicsId(String relicsId) {
        return WarframeRelicsMapper.selectWarframeRelicsByRelicsId(relicsId);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWarframeRelics(WarframeRelics WarframeRelics) {
        return WarframeRelicsMapper.insertWarframeRelics(WarframeRelics);
    }

    /**
     * 查最大ID
     */
    @Override
    public WarframeRelics selectWarframeRelicsMaxId() {
        return WarframeRelicsMapper.selectWarframeRelicsMaxId();
    }

    /**
     * 根据ID查询 翻译之后的物品
     */
    @Override
    public WarframeRelics selectWarframeRelicsToTraById(Integer relicsKeyId) {
        return WarframeRelicsMapper.selectWarframeRelicsToTraById(relicsKeyId);
    }

    @Override
    public int insertWarframeRelicsList(List<WarframeRelics> WarframeRelics) {
        return WarframeRelicsMapper.insertWarframeRelicsList(WarframeRelics);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param WarframeRelics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWarframeRelics(WarframeRelics WarframeRelics) {
        return WarframeRelicsMapper.updateWarframeRelics(WarframeRelics);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param relicsKeyIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRelicsByIds(Integer[] relicsKeyIds) {
        return WarframeRelicsMapper.deleteWarframeRelicsByIds(relicsKeyIds);
    }

    /**
     * 清空表格
     *
     * @return 影响行数
     */
    @Override
    public int deleteWarframeRelics() {
        return WarframeRelicsMapper.deleteWarframeRelics();
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param relicsKeyId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteWarframeRelicsById(Integer relicsKeyId) {
        return WarframeRelicsMapper.deleteWarframeRelicsById(relicsKeyId);
    }

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe遗物表数据……");
                    if (WarframeRelicsMapper.selectWarframeRelicsList(null).size() == 0) {
                        upInit();
                        DataHash d = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://drops.warframestat.us//data/info.json"), DataHash.class);
                        SpringUtils.getBean(RedisCache.class).setCacheObject("datahash", d);
                        log.info("Warframe遗物表数据更新完毕！");
                        return;
                    }
                    DataHash d = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://drops.warframestat.us//data/info.json"), DataHash.class);
                    DataHash dh;
                    try {
                        dh = SpringUtils.getBean(RedisCache.class).getCacheObject("datahash");
                        if (dh == null) {
                            SpringUtils.getBean(RedisCache.class).setCacheObject("datahash", d);
                            return;
                        }
                        if (!d.equals(dh)) {
                            upInit();
                            SpringUtils.getBean(RedisCache.class).setCacheObject("datahash", d);
                            log.info("Warframe遗物表数据更新完毕！");
                        } else {
                            log.info("Warframe遗物表数据未做更改！");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("获取遗物Hash出错，错误信息：{}", e.getMessage());
                        SpringUtils.getBean(RedisCache.class).setCacheObject("datahash", d);
                    }
                }
            }
        });
    }

    private void upInit() {
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
                        jrelic.getString("_id"),
                        jrelic.getString("tier"),
                        jrelic.getString("relicName"),
                        jrelic.getString("state"),
                        r.getString("_id"),
                        r.getString("itemName"),
                        r.getString("rarity"),
                        r.getString("chance")
                ));
            }
        }
        WarframeRelicsMapper.deleteWarframeRelics();
        for (WarframeRelics relic : relics) {
            WarframeRelicsMapper.insertWarframeRelics(relic);
        }
    }
}
