package com.zkb.bot.warframe.service.impl;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.bot.warframe.domain.WarframeAlias;
import com.zkb.bot.warframe.mapper.WarframeAliasMapper;
import com.zkb.bot.warframe.service.IWarframeAliasService;
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
 * Warframe Alias Service业务层处理
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
@Service
public class WarframeAliasServiceImpl implements IWarframeAliasService, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(WarframeAliasServiceImpl.class);

    @Autowired
    private WarframeAliasMapper aliasMapper;


    @Override
    public WarframeAlias selectWarframeAliasById(Integer aliasId) {
        return aliasMapper.selectWarframeAliasById(aliasId);
    }

    @Override
    public List<WarframeAlias> selectWarframeAliasList(WarframeAlias warframeAlias) {
        return aliasMapper.selectWarframeAliasList(warframeAlias);
    }

    @Override
    public int insertWarframeAlias(WarframeAlias warframeAlias) {
        return aliasMapper.insertWarframeAlias(warframeAlias);
    }

    @Override
    public int updateWarframeAlias(WarframeAlias warframeAlias) {
        return aliasMapper.updateWarframeAlias(warframeAlias);
    }

    @Override
    public int deleteWarframeAliasById(Integer aliasId) {
        return aliasMapper.deleteWarframeAliasById(aliasId);
    }

    @Override
    public int deleteWarframeAliasByIds(Integer[] aliasIds) {
        return aliasMapper.deleteWarframeAliasByIds(aliasIds);
    }

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                if (!ZeroConfig.getTest()) {
                    log.info("开始初始化Warframe别名表数据……");
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "warframe_alias.json");
                    if (aliasJson.trim().length() == 0) {
                        log.error("未获取到别名数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<WarframeAlias> records = alias.getJSONArray("RECORDS").toJavaList(WarframeAlias.class);
                    if (records.size() != aliasMapper.selectWarframeAliasList(null).size()) {
                        int x = 0;
                        for (WarframeAlias record : records) {
                            aliasMapper.insertWarframeAlias(record);
                            x++;
                        }
                        log.info("共更新Warframe别名表 {} 条数据！", x);
                    } else {
                        log.info("Warframe别名表数据未做更改！");
                    }
                }

            }
        });
    }
}
