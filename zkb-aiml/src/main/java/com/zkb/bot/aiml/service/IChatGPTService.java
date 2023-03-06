package com.zkb.bot.aiml.service;

import com.zkb.bot.aiml.domain.ChatGPTConfig;
import com.zkb.bot.aiml.req.ChatGPTReq;
import com.zkb.bot.aiml.res.ChatGPTRes;
import com.zkb.common.vo.Proxy;

public interface IChatGPTService {

    /**
     * 发送请求
     * @param req 请求体
     * @return 返回的消息
     */
    ChatGPTRes sendChatGPT(ChatGPTReq req);

    /**
     * 配置ChatGPT
     * @param config 配置
     * @return 是否配置成功
     */
    boolean setChatGPTConfig(ChatGPTConfig config);
}
