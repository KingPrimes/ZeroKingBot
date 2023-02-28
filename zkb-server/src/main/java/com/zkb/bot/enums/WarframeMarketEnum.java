package com.zkb.bot.enums;

public enum WarframeMarketEnum {
    WM_BY("买家"),
    WM_SET("卖家"),
    WM_MAX("满级"),
    ;
    private final String type;

    WarframeMarketEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
