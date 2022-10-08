package com.zkb.bot.utils;

import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.common.load.ReadWarframeConfig;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class InitConfigs {

    public static void initWarframeConfig() {
        for (WarframeTypeEnum key : WarframeTypeEnum.values()) {
            //转码
            String value = ReadWarframeConfig.WARFRAME.getProperty(key.name(), new String(key.getType().getBytes(), StandardCharsets.ISO_8859_1));
            key.setType(new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        }
    }
}
