package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.WarframeTranslation;
import com.zkb.bot.warframe.mapper.WarframeTranslationMapper;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.zero.ZeroConfig;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;

/**
 * WarframeTranslationService业务层处理
 * Warframe 中英文翻译
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
@Service
public class WarframeTranslationServiceImpl implements IWarframeTranslationService, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(WarframeRivenTrendServiceImpl.class);

    @Autowired
    private WarframeTranslationMapper warframeTranslationMapper;

    /**
     * 查询
     *
     * @param traId ID
     * @return 结果
     */
    @Override
    public WarframeTranslation selectWarframeTranslationById(Long traId) {
        return warframeTranslationMapper.selectWarframeTranslationById(traId);
    }

    /**
     * 英文 ->> 中文
     * 未找到返回原文
     *
     * @param us_en 英文
     */
    @Override
    public String enToZh(String us_en) {
        try {
            String traCh = warframeTranslationMapper.enToZh(us_en);
            if (traCh == null || traCh.trim().length() == 0) {
                return us_en;
            }
            return traCh;
        } catch (Exception e) {
            e.printStackTrace();
            return us_en;
        }

    }

    /**
     * 中文 ->> 英文
     * 未找到返回原文
     *
     * @param cn_zh 中文
     */
    @Override
    public String zhToEn(String cn_zh) {
        try {
            String tra = warframeTranslationMapper.zhToEn(cn_zh);
            if (!tra.isEmpty()) {
                return tra;
            } else {
                return cn_zh;
            }
        } catch (Exception ignored) {
            return cn_zh;
        }
    }

    @Override
    public String zhToEnTrim(String zh_cn) {
        try {
            String tra = warframeTranslationMapper.zhToEnTrim(zh_cn);
            if (!tra.isEmpty()) {
                return tra;
            } else {
                return zh_cn;
            }
        } catch (Exception ignored) {
            return zh_cn;
        }
    }

    /**
     * 模糊查询英文->中 中->英
     * 双条件
     *
     * @param enOrzh 数据
     * @return 结果
     */
    @Override
    public String enOrzh(String enOrzh) {
        try {
            WarframeTranslation tra = warframeTranslationMapper.enOrzh(enOrzh);
            if (tra != null) {
                return "中文:" + tra.getTraCh() + "\n英文:" + tra.getTraEn();
            }
        } catch (Exception e) {
            return enOrzh;
        }
        return null;
    }

    /**
     * 中文 ->> 英文 列表 模糊匹配
     * 未找到返回原文
     *
     * @param cn_zh 中文
     */
    @Override
    public List<String> zhToEnList(String cn_zh) {
        try {
            List<String> trays = new ArrayList<>();
            List<WarframeTranslation> translations = warframeTranslationMapper.zhToEnList(cn_zh);
            for (WarframeTranslation warframeTranslation : translations) {
                trays.add(warframeTranslation.getTraEn());
            }
            return trays;
        } catch (Exception e) {
            return Collections.singletonList(cn_zh);
        }
    }

    /**
     * 英文 ->> 中文 列表 模糊匹配
     * 未找到返回原文
     *
     * @param us_en 英文
     */
    @Override
    public List<String> enToZhList(String us_en) {
        try {
            List<String> trays = new ArrayList<>();
            List<WarframeTranslation> translations = warframeTranslationMapper.enToZhList(us_en);
            for (WarframeTranslation warframeTranslation : translations) {
                trays.add(warframeTranslation.getTraCh());
            }
            return trays;
        } catch (Exception e) {
            return Collections.singletonList(us_en);
        }
    }

    /**
     * 模糊搜索中英文匹配值
     *
     * @param key 值
     */
    @Override
    public List<WarframeTranslation> enAndZhToList(String key) {
        return warframeTranslationMapper.enAndZhToList(key);
    }

    /**
     * 查询列表
     *
     * @param warframeTranslation 条件
     * @return 结果
     */
    @Override
    public List<WarframeTranslation> selectWarframeTranslationList(WarframeTranslation warframeTranslation) {
        return warframeTranslationMapper.selectWarframeTranslationList(warframeTranslation);
    }

    /**
     * 新增
     *
     * @param warframeTranslation 数据
     * @return 结果
     */
    @Override
    public int insertWarframeTranslation(WarframeTranslation warframeTranslation) {
        return warframeTranslationMapper.insertWarframeTranslation(warframeTranslation);
    }

    /**
     * 批量插入
     * 去除相同数据
     *
     * @param warframeTranslation 数据
     * @return 结果
     */
    @Override
    public int insertWarframeTranslationList(List<WarframeTranslation> warframeTranslation) {
        return warframeTranslationMapper.insertWarframeTranslationList(warframeTranslation);
    }

    /**
     * 修改
     *
     * @param warframeTranslation 数据
     * @return 结果
     */
    @Override
    public int updateWarframeTranslation(WarframeTranslation warframeTranslation) {
        return warframeTranslationMapper.updateWarframeTranslation(warframeTranslation);
    }

    /**
     * 批量删除
     *
     * @param traIds 需要删除的ID
     * @return 结果
     */
    @Override
    public int deleteWarframeTranslationByIds(Long[] traIds) {
        return warframeTranslationMapper.deleteWarframeTranslationByIds(traIds);
    }

    /**
     * 删除信息
     *
     * @param traId ID
     * @return 结果
     */
    @Override
    public int deleteWarframeTranslationById(Long traId) {
        return warframeTranslationMapper.deleteWarframeTranslationById(traId);
    }

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe中英翻译表数据……");
                    String tarJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_translation.json");
                    if (tarJson.trim().length() == 0) {
                        log.error("未获取到中英翻译数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(tarJson);
                    List<WarframeTranslation> trasList = alias.getJSONArray("RECORDS").toJavaList(WarframeTranslation.class);
                    if (trasList.size() != warframeTranslationMapper.selectWarframeTranslationList(null).size()) {
                        warframeTranslationMapper.deleteWarframeTranslation();
                        List<List<WarframeTranslation>> partition = Lists.partition(trasList, 500);
                        int x = 0;
                        for (List<WarframeTranslation> tar : partition) {
                            x = warframeTranslationMapper.insertWarframeTranslationList(tar);
                        }
                        log.info("Warframe中英翻译表数据初始化完毕！共更新 {} 条数据！", x);
                    }
                }
            }
        });

    }
}
