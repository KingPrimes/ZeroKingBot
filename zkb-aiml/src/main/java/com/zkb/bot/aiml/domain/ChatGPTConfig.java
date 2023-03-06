package com.zkb.bot.aiml.domain;

import com.zkb.common.vo.Proxy;

public class ChatGPTConfig {
    String key;
    String msg;
    Proxy proxy;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }
}
