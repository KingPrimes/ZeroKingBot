package com.zkb.bot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * @author KingPrimes
 */
@Entity
@Table(name = "bot_function", uniqueConstraints = @UniqueConstraint(name = "function", columnNames = "functionName"))
public class BotFunction {
    @GeneratedValue
    @Id
    long functionId;
    String functionName;
    String functionIntroduction;

    public BotFunction() {
    }

    public BotFunction(long functionId, String functionName, String functionIntroduction) {
        this.functionId = functionId;
        this.functionName = functionName;
        this.functionIntroduction = functionIntroduction;
    }

    public long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(long functionId) {
        this.functionId = functionId;
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
                .append("functionName", getFunctionName())
                .append("functionIntroduction", getFunctionIntroduction())
                .toString();
    }
}
