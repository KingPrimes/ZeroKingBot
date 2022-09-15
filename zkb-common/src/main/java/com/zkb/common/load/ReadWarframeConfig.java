package com.zkb.common.load;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Component
public class ReadWarframeConfig {

    public static final Properties WARFRAME = new Properties();
    private static final Logger log = LoggerFactory.getLogger(ReadAdminConfig.class);

    @PostConstruct
    public static void initWarframeConfig() {
        try {
            WARFRAME.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/config/warframeConfig.ini")));
        } catch (Exception e) {
            log.error("读取 WarframeConfig.ini文件出错，错误信息：{}", e.getMessage());
        }

    }
}
