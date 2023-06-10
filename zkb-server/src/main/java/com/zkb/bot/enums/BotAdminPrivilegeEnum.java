package com.zkb.bot.enums;

import com.zkb.framework.config.EnumValue;


public enum BotAdminPrivilegeEnum implements EnumValue {
    //普通等级
    OWNER((short) 0, "普通等级"),
    //普通管理员
    ADMIN((short) 1, "普通管理员"),
    //顶级管理员
    TOP_ADMIN((short) 2, "顶级管理员");
    private final Short value;

    private final String desc;

    BotAdminPrivilegeEnum(short value, String desc) {
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
