package com.zkb.bot.enums;

public enum ImageEnum {
    ORDER_IMAGE("涩图"),
    ORDER_NSFW("鉴图"),
    ;

    private final String str;

    ImageEnum(String str) {
        this.str = str;
    }

    public String getType() {
        return str;
    }
}
