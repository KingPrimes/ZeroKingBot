package com.zkb.bot.enums;

/**
 * @author KingPrimes
 */

public enum FunctionEnums {

    ERROR("error"),

    FUNCTION_WARFRAME("warframe"),

    FUNCTION_AI("ai"),

    FUNCTION_GIF("gif"),

    FUNCTION_IMAGE("image"),

    /**
     * 开启WF
     */
    ON_WARFRAME("开启WF"),
    /**
     * 开启AI
     */
    ON_AI("开启AI"),

    /**
     * 开启Gif图片生成
     */
    ON_GIF("开启GIF"),

    ON_IMAGE("开启涩图"),

    ON_CHAT_GPT("开启chat"),

    /**
     * 关闭WF
     */
    OFF_WARFRAME("关闭WF"),
    /**
     * 关闭AI
     */
    OFF_AI("关闭AI"),
    /**
     * 关闭Gif图片生成
     */
    OFF_GIF("关闭GIF"),

    OFF_IMAGE("关闭涩图"),

    OFF_CHAT_GPT("关闭chat")


    ;
    private final String type;

    FunctionEnums(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
