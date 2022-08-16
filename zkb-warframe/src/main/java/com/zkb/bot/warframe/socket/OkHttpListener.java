package com.zkb.bot.warframe.socket;

import com.alibaba.fastjson.JSONObject;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.utils.WarframeMissionUtils;
import com.zkb.framework.manager.AsyncManager;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.TimerTask;

@Slf4j
public class OkHttpListener extends WebSocketListener {


    public OkHttpListener() {
        super();
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
        log.error("onClosing:链接被关闭,尝试重新连接...Code:{}---Reason:{}", code, reason);
        if (code == 1002) {
            OkHttpWebSocket.init();
        }


    }

    @Override
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        super.onFailure(webSocket, t, response);
        log.error("链接出错,尝试重新连接...\nError:{}", t.getMessage());
        OkHttpWebSocket.init();
    }
}
