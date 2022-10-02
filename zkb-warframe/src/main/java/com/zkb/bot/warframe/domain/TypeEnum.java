package com.zkb.bot.warframe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TypeEnum {
    //Key
    String key;
    //Value
    String value;

    public TypeEnum() {
    }

    public TypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("key", key)
                .append("value", value)
                .toString();
    }

    /**
     * 获取 Key
     *
     * @return key Key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * 设置 Key
     *
     * @param key Key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取 Value
     *
     * @return value Value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * 设置 Value
     *
     * @param value Value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
