package com.zkb.bot.enums;

import com.zkb.framework.config.EnumValue;


public enum WarframeRivenTrendTypeEnum implements EnumValue {

    //步枪 - 狙击枪
    RIFLE((short) 0, "步枪-狙击枪"),
    //霰弹枪
    SHOTGUN((short) 1, "霰弹枪"),
    //手枪
    PISTOL((short) 2, "手枪"),
    //Archwing枪械
    ARCHGUN((short) 3, "Archwing枪械"),
    //近战
    MELEE((short) 4, "近战");

    final short value;

    final String desc;


    public Short value() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    WarframeRivenTrendTypeEnum(short value, String desc) {
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
