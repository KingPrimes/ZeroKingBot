package com.zkb.bot.warframe.socket;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.time.Duration;

@Slf4j
public class OkHttpWebSocket {

    public static WebSocket socket;

    public static void init() {
        String url = "ws://api.warframestat.us/socket";
        OkHttpClient client = new OkHttpClient.Builder()
                .pingInterval(Duration.ofMinutes(1L))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        log.info("正在初始化Socket连接...");
        socket = client.newWebSocket(request, new OkHttpListener());
    }


}
