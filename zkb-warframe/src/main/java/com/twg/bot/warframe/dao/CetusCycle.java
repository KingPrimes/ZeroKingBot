package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CetusCycle extends BaseWarframe {
    private String id;
    private Boolean isDay;
    private String state;
    private String timeLeft;
    private Boolean isCetus;
    private String shortString;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDay() {
        return isDay;
    }

    public void setDay(Boolean day) {
        isDay = day;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Boolean getCetus() {
        return isCetus;
    }

    public void setCetus(Boolean cetus) {
        isCetus = cetus;
    }

    public String getShortString() {
        return shortString;
    }

    public void setShortString(String shortString) {
        this.shortString = shortString;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .append("isDay", getDay())
                .append("state", getState())
                .append("timeLeft", getTimeLeft())
                .append("isCetus", getCetus())
                .append("shortString", getShortString())
                .toString();
    }
}
