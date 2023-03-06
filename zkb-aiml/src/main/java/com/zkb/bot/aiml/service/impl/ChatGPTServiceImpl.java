package com.zkb.bot.aiml.service.impl;

import com.alibaba.fastjson.JSON;
import com.zkb.bot.aiml.domain.ChatGPTConfig;
import com.zkb.bot.aiml.enums.ChatRoleEnum;
import com.zkb.bot.aiml.req.ChatGPTReq;
import com.zkb.bot.aiml.res.ChatGPTRes;
import com.zkb.bot.aiml.service.IChatGPTService;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.vo.Proxy;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTServiceImpl implements IChatGPTService {

    private static final String URL = "https://api.openai.com/v1/chat/completions";
    @Autowired
    RedisCache redis;

    /**
     * 发送请求
     *
     * @param req 请求体
     * @return 返回的消息
     */
    @Override
    public ChatGPTRes sendChatGPT(ChatGPTReq req) {
        ChatGPTConfig config =  redis.getCacheObject("chat-config");

        String key = config.getKey();
        if (key == null || key.isEmpty()) {
            return ChatGPTRes.error("您未正常设置API，请设置API后使用!");
        }
        Proxy proxy = config.getProxy();
        if (proxy == null) {
            return ChatGPTRes.error("您未正常设置代理，请通过Web页面设置代理");
        }

        //构建请求头
        HttpUtils.initOkHttpClient(proxy.getHost(), proxy.getPort());
        Headers.Builder head = new Headers.Builder();
        head.add("Authorization", "Bearer "+key);
        head.add("Content-Type", "application/json");
        //添加暗示
        String msg = config.getMsg();
        if (msg != null && !msg.isEmpty() && !msg.trim().equals("")) {
            req.add(ChatRoleEnum.SYSTEM, msg);
        }

        //发送请求
        String resJson = HttpUtils.sendPostOkHttpToJson(URL, req.toString(), head.build());
        if (resJson != null && !resJson.isEmpty() &&!resJson.equals("timeout")) {
            return JSON.parseObject(resJson, ChatGPTRes.class);
        }
        return ChatGPTRes.error("网络请求失败！");
    }

    @Override
    public boolean setChatGPTConfig(ChatGPTConfig config) {
        redis.setCacheObject("chat-config",config);
        HttpUtils.initOkHttpClient(config.getProxy().getHost(), config.getProxy().getPort());
        String res = HttpUtils.sendGetOkHttpProxy("https://www.google.com/");
        return !res.isEmpty() && !res.equals("timeout");
    }
}
