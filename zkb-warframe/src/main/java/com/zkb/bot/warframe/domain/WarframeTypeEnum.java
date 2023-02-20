package com.zkb.bot.warframe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "warframe_type_enum",uniqueConstraints = @UniqueConstraint(name = "enum",columnNames = "key"))
public class WarframeTypeEnum {

    @GeneratedValue
    @Id
    Long id;

    //Key
    String key;
    //Value
    String value;

    public WarframeTypeEnum() {
    }

    public WarframeTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public WarframeTypeEnum(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("key", key)
                .append("value", value)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
