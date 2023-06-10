package com.zkb.bot.enums;

import com.zkb.framework.config.EnumValue;


public enum MusicEnum implements EnumValue {
    SONG((short) 0, "点歌"),
    QQ((short) 1, "点歌QQ"),
    W163((short) 2, "点歌WY"),
    KUWO((short) 3, "点歌KW"),
    QAN((short) 4, "点歌QAN"),
    YT((short) 5, "点歌YT"),
    ;

    private final Short value;

    private final String desc;


    public Short value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    MusicEnum(short value, String desc) {
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
