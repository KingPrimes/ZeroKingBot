package com.zkb.bot.warframe.service.impl;

import com.zkb.bot.warframe.domain.WarframeTypeEnum;
import com.zkb.bot.warframe.mapper.WarframeTypeEnumMapper;
import com.zkb.bot.warframe.service.IWarframeTypeEnumService;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

@Service
public class WarframeTypeEnumServiceImpl implements IWarframeTypeEnumService, CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(WarframeTypeEnumServiceImpl.class);

    @Autowired
    WarframeTypeEnumMapper typeEnumMapper;

    //初始化
    public void init() {
        log.info("开始初始化Warframe指令……");
        List<WarframeTypeEnum> tes = typeEnumMapper.selectWarframeTypeEnumList(null);

        if (tes == null || tes.isEmpty() || tes.size() != com.zkb.bot.enums.WarframeTypeEnum.values().length) {
            if (tes != null) {
                Map<String, String> initMap = new HashMap<>();
                Map<String, String> sqlMap = new HashMap<>();

                for (com.zkb.bot.enums.WarframeTypeEnum value : com.zkb.bot.enums.WarframeTypeEnum.values()) {
                    initMap.put(value.name(), value.getType());
                }
                for (WarframeTypeEnum te : tes) {
                    sqlMap.put(te.getKey(), te.getValue());
                }

                Map<String, String> kMap = new HashMap<>(sqlMap);

                sqlMap.forEach((qk, qv) -> {
                    initMap.forEach((k, v) -> {
                        if (k.equals(qk)) {
                            kMap.remove(qk);
                        }
                    });
                });

                kMap.forEach((k, v) -> {
                    typeEnumMapper.daleteWarframeTypeEnum(k);
                });
            }

            for (com.zkb.bot.enums.WarframeTypeEnum key : com.zkb.bot.enums.WarframeTypeEnum.values()) {
                if (com.zkb.bot.enums.WarframeTypeEnum.valueOf(key.name()).getType() != null && !com.zkb.bot.enums.WarframeTypeEnum.valueOf(key.name()).getType().trim().isEmpty() && !key.name().equals("REDIS_MISSION_KEY")) {
                    WarframeTypeEnum typeEnum = new WarframeTypeEnum();
                    typeEnum.setKey(key.name());
                    typeEnum.setValue(key.getType());
                    typeEnumMapper.insertWarframeTypeEnum(typeEnum);
                }
            }
        } else {
            for (com.zkb.bot.enums.WarframeTypeEnum keyEnum : com.zkb.bot.enums.WarframeTypeEnum.values()) {
                for (WarframeTypeEnum warframeTypeEnum : tes) {
                    if (keyEnum.name().equals(warframeTypeEnum.getKey())) {
                        keyEnum.setType(warframeTypeEnum.getValue());
                        break;
                    }
                }
            }
        }
        log.info("Warframe指令初始化完成……");
    }

    /**
     * 修改
     *
     * @param warframeTypeEnum 数据
     * @return 条数
     */
    @Override
    public int updateWarframeTypeEnum(WarframeTypeEnum warframeTypeEnum) {

        for (com.zkb.bot.enums.WarframeTypeEnum value : com.zkb.bot.enums.WarframeTypeEnum.values()) {
            if (value.name().equals(warframeTypeEnum.getKey())) {
                value.setType(warframeTypeEnum.getValue());
            }
        }
        return typeEnumMapper.updateWarframeTypeEnum(warframeTypeEnum);
    }

    /**
     * 条件查询
     *
     * @param warframeTypeEnum 条件
     * @return 具体数据
     */
    @Override
    public List<WarframeTypeEnum> selectWarframeTypeEnumList(WarframeTypeEnum warframeTypeEnum) {
        return typeEnumMapper.selectWarframeTypeEnumList(warframeTypeEnum);
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    @Override
    public int daleteWarframeTypeEnum(String key) {
        return typeEnumMapper.daleteWarframeTypeEnum(key);
    }

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                init();
            }
        });
    }
}
