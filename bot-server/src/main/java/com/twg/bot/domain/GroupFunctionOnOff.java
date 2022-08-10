package com.twg.bot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author KingPrimes
 */
public class GroupFunctionOnOff {
    long group;
    String functionId;

    public GroupFunctionOnOff() {

    }

    public GroupFunctionOnOff(long group, String functionId) {
        this.group = group;
        this.functionId = functionId;
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
