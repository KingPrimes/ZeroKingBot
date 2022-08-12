package com.zkb.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class VallisCycle extends BaseWarframe {
    private String id;
    private Boolean isWarm;
    private String state;
    private String timeLeft;
    private String shortString;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getWarm() {
        return isWarm;
    }

    public void setWarm(Boolean warm) {
        isWarm = warm;
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
                .append("isWarm", getWarm())
                .append("state", getState())
                .append("timeLeft", getTimeLeft())
                .append("shortString", getShortString())
                .toString();
    }
}
