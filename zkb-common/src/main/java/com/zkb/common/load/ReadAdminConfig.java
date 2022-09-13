package com.zkb.common.load;

import com.zkb.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Component
public class ReadAdminConfig {
    private static final Logger log = LoggerFactory.getLogger(ReadAdminConfig.class);

    private static final Properties CFG = new Properties();

    @PostConstruct
    public static void initConfig() {
        try {
            CFG.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/config/config.ini")));
        } catch (Exception e) {
            log.error("读取config.ini文件出错，错误信息：{}", e.getMessage());
        }

    }

    /**
     * 获取 管理员账号
     * @return 管理员账号
     */

    public static long getAdmin() {
        initConfig();
        String admin = CFG.getProperty("admin");
        if (StringUtils.isNumber(admin)) return Long.parseLong(admin);
        return 0;
    }
}
