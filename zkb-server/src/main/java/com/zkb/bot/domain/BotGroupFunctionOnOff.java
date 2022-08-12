package com.zkb.bot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author KingPrimes
 */
public class BotGroupFunctionOnOff {
    Integer functionId;
    long group;
    String functionName;
    String functionIntroduction;


    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionIntroduction() {
        return functionIntroduction;
    }

    public void setFunctionIntroduction(String functionIntroduction) {
        this.functionIntroduction = functionIntroduction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("functionId", getFunctionId())
                .append("group", getGroup())
                .append("functionName", getFunctionName())
                .append("functionIntroduction", getFunctionIntroduction())
                .toString();
    }
}
