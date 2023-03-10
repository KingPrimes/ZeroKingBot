package com.zkb.common.vo;

import com.zkb.common.utils.RegularMatch;

public class Proxy {
    String host;
    Integer port;

    public String getHost() {
        return host;
    }

    public Proxy() {
        this.host = "127.0.0.1";
        this.port = 0;
    }

    /**
     * 设置代理地址
     * @param host IPV4地址
     * @return true 成功设置
     */
    public boolean setHost(String host) {
        if(RegularMatch.isIPV4(host)){
            this.host = host;
            return true;
        }
        return false;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
