package com.twg.bot.interceptor;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Primary
@Component
public class BotWsInterceptor {

    @SneakyThrows
    public boolean checkSession(@NotNull WebSocketSession session) {
        HttpHeaders headers = session.getHandshakeHeaders();
        String botId = headers.getFirst("x-self-id");
        System.out.println("新的连接:" + botId + "---" + session.getId());
        return true; // 正常连接
    }
}
