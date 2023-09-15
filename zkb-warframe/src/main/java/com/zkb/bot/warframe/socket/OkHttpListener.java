package com.zkb.bot.warframe.socket;

import com.alibaba.fastjson.JSONObject;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.utils.WarframeMissionUtils;
import com.zkb.framework.manager.AsyncManager;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class OkHttpListener extends WebSocketListener {


    private static final OkHttpListener socket = new OkHttpListener();

    public static OkHttpListener socket() {
        return socket;
    }

    WebSocket webSocket;


    public void connectServer(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .pingInterval(45,TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder().url("ws://api.warframestat.us/socket").build();
        webSocket = client.newWebSocket(request,this);
    }

    public void close() {
        if (webSocket != null) {
            webSocket.close(1000, "service close");
        }
    }

    @Override
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        super.onOpen(webSocket, response);
        log.info("成功连接服务器...");
    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        SocketGlobalStates states = JSONObject.parseObject(text).toJavaObject(SocketGlobalStates.class);
        if (states != null) {
            if (!states.getEvent().equals("connected") && states.getEvent().equals("ws:update")) {
                if (states.getPacket().getLanguage().equals("en") && states.getPacket().getPlatform().equals("pc")) {
                    AsyncManager.me().execute(new TimerTask() {
                        @Override
                        public void run() {
                            WarframeMissionUtils.isUpdated(states);
                        }
                    });

                }
            }
        }
    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
        super.onMessage(webSocket, bytes);
    }

    @Override
    public void onClosing(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        super.onClosing(webSocket, code, reason);
        log.warn("onClosing:链接被关闭,尝试重新连接...Code:{}---Reason:{}", code, reason);
        if (code == 1002) {
            this.connectServer();
        }


    }

    @Override
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        super.onFailure(webSocket, t, response);
        log.warn("链接出错,尝试重新连接...\nError:{}", t.getMessage());
        this.connectServer();
    }
}
