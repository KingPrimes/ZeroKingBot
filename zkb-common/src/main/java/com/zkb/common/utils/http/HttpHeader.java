package com.zkb.common.utils.http;

public enum HttpHeader {
    /**
     * 请求头 user-agent
     */
    USER_AGENT("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36 Edg/98.0.1108.56"),
    ACCEPT("accept", "*/*"),
    CONNECTION("connection", "Keep-Alive"),
    PLAT_FROM("platform", "pc"),
    ;
    private final String name;
    private final String value;

    HttpHeader(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
