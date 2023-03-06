package com.zkb.bot.aiml.enums;

import com.zkb.framework.config.EnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ChatModelEnum implements EnumValue {

    GPT35TURBO((short)0,"gpt-3.5-turbo"),

    GPT36TURBO301((short)1,"gpt-3.5-turbo-0301"),

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
