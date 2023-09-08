package com.zkb.bot.enums;

import com.zkb.framework.config.EnumValue;

public enum GitHubUrlEnum implements EnumValue {

    ZeroKingBotDataSource((short) 0, "https://raw.gitmirror.com/KingPrimes/ZeroKingBotDataSource/main/"),

    ;


    private final Short value;

    private final String desc;

    GitHubUrlEnum(short value, String desc) {
        this.desc = desc;
        this.value = value;
    }


    public Short value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    /**
     * 序列化
     *
     * @return 不允许返回 null
     */
    @Override
    public Object toValue() {
        return value;
    }
}
