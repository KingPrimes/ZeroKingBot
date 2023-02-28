package com.zkb.bot.enums;

import com.zkb.framework.config.EnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GitHubUrlEnum implements EnumValue {

    ZeroKingBotDataSource((short) 0, "https://ghproxy.com/https://raw.githubusercontent.com/KingPrimes/ZeroKingBotDataSource/main/"),

    ;


    private final Short value;

    private final String desc;


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
