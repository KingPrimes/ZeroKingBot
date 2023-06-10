package com.zkb.bot.enums;

import com.zkb.framework.config.EnumValue;


public enum MusicTypeEnum implements EnumValue {
    SONG((short) 0, ""),
    QQ((short) 1, "qq"),
    WY((short) 2, "163"),
    KW((short) 3, "kuwo"),
    QAN((short) 4, "taihe"),
    YT((short) 5, "1ting"),
    ;

    private final Short value;

    private final String desc;


    public Short value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    MusicTypeEnum(short value, String desc) {
        this.desc = desc;
        this.value = value;
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
