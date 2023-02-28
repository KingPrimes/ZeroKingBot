package com.zkb.bot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * @author KingPrimes
 */
@Entity
@Table(name = "bot_group_function_onoff", uniqueConstraints = @UniqueConstraint(name = "functionOFF", columnNames = "`group`"))
public class GroupFunctionOnOff {

    @GeneratedValue
    @Id
    Long id;
    @Column(name = "`group`")
    long group;
    String functionId;

    public GroupFunctionOnOff() {

    }

    public GroupFunctionOnOff(long group, String functionId) {
        this.group = group;
        this.functionId = functionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("group", getGroup())
                .append("functionId", getFunctionId())
                .toString();
    }
}
