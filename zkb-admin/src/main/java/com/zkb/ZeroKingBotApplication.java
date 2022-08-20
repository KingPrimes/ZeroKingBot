package com.zkb;


import com.zkb.bot.utils.GetProxyOnClons;
import com.zkb.bot.warframe.socket.OkHttpWebSocket;
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
        SpringApplication.run(ZeroKingBotApplication.class, args);
        GetProxyOnClons.isHttpProxy();
        GetProxyOnClons.isSocketProxy();
        OkHttpWebSocket.init();
        log.info("启动成功！");
    }
    //测试是否同步 Releases
}
