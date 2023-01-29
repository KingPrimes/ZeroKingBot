package com.zkb.bot.enums;

public enum BotAdminPrivilegeEnum {
    //普通等级
    OWNER("普通等级"),
    //普通管理员
    ADMIN("普通管理员"),
    //顶级管理员
    TOP_ADMIN("顶级管理员")
    ;

    private final String S;

    BotAdminPrivilegeEnum(String s) {
        this.S = s;
    }

    public String getType(){
        return S;
    }
}
