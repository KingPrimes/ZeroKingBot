package com.zkb;

import com.zkb.bot.warframe.socket.OkHttpListener;
import com.zkb.common.load.LoadConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ZeroKingBotApplication {
    private static final Logger log = LoggerFactory.getLogger(ZeroKingBotApplication.class);

    public static void main(String[] args) {
        LoadConfig.initSqliteFile();
        SpringApplication.run(ZeroKingBotApplication.class, args);
        OkHttpListener.socket().connectServer();
        log.info("启动成功！");

    }

}
