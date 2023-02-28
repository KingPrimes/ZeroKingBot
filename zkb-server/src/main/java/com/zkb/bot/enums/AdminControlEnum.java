package com.zkb.bot.enums;

public enum AdminControlEnum {
    UPDATE_HTML("更新html"),
    UPDATE_RES_MARKET_ITEMS("更新WM物品"),
    UPDATE_RES_MARKET_RIVEN("更新WM紫卡"),

    UPDATE_RES_RM("更新RM紫卡"),
    TYPE_CODE("指令"),

    UPDATE_RIVEN_CHANGES("更新紫卡倾向变动"),

    UPDATE_SISTER("更新信条"),

    UPDATE_TAR("更新翻译");

    private final String STR;

    AdminControlEnum(String str) {
        this.STR = str;
    }

    public String getType() {
        return this.STR;
    }

}
