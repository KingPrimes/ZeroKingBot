package com.zkb.bot.enums;

public enum WarframeEnum {
    /**
     * Market 赤毒武器搜索
     */
    TYPE_MARKET_CD(""),
    /**
     * Market 信条武器搜索
     */
    TYPE_MARKET_XT(""),
    REDIS_MISSION_KEY("warframe-data-the-provided-plat"),
    ;
    private String type;

    WarframeEnum(String s) {
        type = s;
    }


    public String getType() {
        return type;
    }

    public WarframeEnum setType(String type) {
        this.type = type;
        return this;
    }
}
