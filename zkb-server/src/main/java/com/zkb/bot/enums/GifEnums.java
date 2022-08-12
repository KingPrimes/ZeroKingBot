package com.zkb.bot.enums;


public enum GifEnums {
    //Capoo动图表情包
    GIF_CAPOO("capoo"),
    //EmailFunny滑稽果表情
    GIF_EMAIL_FUNNY("funny"),
    //精神支柱
    PNG_EMO_SUPT("精神支柱"),
    ;

    private final String type;

    GifEnums(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
