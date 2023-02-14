package com.zkb.bot.enums;

import com.zkb.framework.config.EnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MusicTypeEnum implements EnumValue {
    QQ((short)0,"qq"),
    WY((short)1,"163"),
    XM((short)2,"xm"),
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
