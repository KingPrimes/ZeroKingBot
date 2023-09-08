package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.market.WarframeMarketElement;
import com.zkb.bot.warframe.mapper.WarframeMarketElementMapper;
import com.zkb.bot.warframe.service.IWarframeMarketElementService;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.zero.ZeroConfig;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TimerTask;

/**
 * WarframeMarketElementService 业务层处理
 * Market 赤毒/信条武器 元素字典
 *
 * @author KingPrimes
 * @date 2021-11-29
 */
@Service
public class WarframeMarketElementServiceImpl implements IWarframeMarketElementService, CommandLineRunner {


    Logger log = LoggerFactory.getLogger(WarframeMarketElementServiceImpl.class);

    @Autowired
    private WarframeMarketElementMapper elementMapper;

    /**
     * 查询赤毒元素字典
     *
     * @param elementEn 赤毒元素字典主键
     * @return 赤毒元素字典
     */
    @Override
    public WarframeMarketElement selectWarframeMarketElementByElementEn(String elementEn) {
        return elementMapper.selectWarframeMarketElementByElementEn(elementEn);
    }

    /**
     * 查询赤毒元素字典列表
     *
     * @param warframeMarketElement 赤毒元素字典
     * @return 赤毒元素字典
     */
    @Override
    public List<WarframeMarketElement> selectWarframeMarketElementList(WarframeMarketElement warframeMarketElement) {
        return elementMapper.selectWarframeMarketElementList(warframeMarketElement);
    }

    @Override
    public WarframeMarketElement selectWarframeMarketElementLikeEn(String en) {
        return elementMapper.selectWarframeMarketElementLikeEn(en);
    }

    @Override
    public WarframeMarketElement selectWarframeMarketElementLikeCh(String ch) {
        return elementMapper.selectWarframeMarketElementLikeCh(ch);
    }

    /**
     * 新增赤毒元素字典
     *
     * @param warframeMarketElement 赤毒元素字典
     * @return 结果
     */
    @Override
    public int insertWarframeMarketElement(WarframeMarketElement warframeMarketElement) {
        return elementMapper.insertWarframeMarketElement(warframeMarketElement);
    }

    /**
     * 修改赤毒元素字典
     *
     * @param warframeMarketElement 赤毒元素字典
     * @return 结果
     */
    @Override
    public int updateWarframeMarketElement(WarframeMarketElement warframeMarketElement) {
        return elementMapper.updateWarframeMarketElement(warframeMarketElement);
    }

    /**
     * 批量删除赤毒元素字典
     *
     * @param elementEns 需要删除的赤毒元素字典主键
     * @return 结果
     */
    @Override
    public int deleteWarframeMarketElementByElementEns(String[] elementEns) {
        return elementMapper.deleteWarframeMarketElementByElementEns(elementEns);
    }

    /**
     * 删除赤毒元素字典信息
     *
     * @param elementEn 赤毒元素字典主键
     * @return 结果
     */
    @Override
    public int deleteWarframeMarketElementByElementEn(String elementEn) {
        return elementMapper.deleteWarframeMarketElementByElementEn(elementEn);
    }

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe赤毒元素字典数据……");
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_market_element.json");
                    if (aliasJson.trim().isEmpty()) {
                        log.error("未获取到赤毒元素字典数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<WarframeMarketElement> records = alias.getJSONArray("RECORDS").toJavaList(WarframeMarketElement.class);
                    if (records.size() != elementMapper.selectWarframeMarketElementList(null).size()) {
                        int x = 0;
                        for (WarframeMarketElement record : records) {
                            elementMapper.insertWarframeMarketElement(record);
                            x++;
                        }
                        log.info("共更新Warframe赤毒元素字典 {} 条数据！", x);
                    } else {
                        log.info("Warframe赤毒元素字典数据未做更改！");
                    }
                }
            }
        });

    }
}
