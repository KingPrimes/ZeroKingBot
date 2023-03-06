package com.zkb.bot.aiml.enums;

import com.zkb.framework.config.EnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ChatRoleEnum implements EnumValue {
    //用户消息
    USER((short)0,"user"),
    //系统消息,用于给ChatGPT做前置消息
    SYSTEM((short)1,"system"),
    //助理消息
    ASSISTANT((short)2,"assistant")
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
