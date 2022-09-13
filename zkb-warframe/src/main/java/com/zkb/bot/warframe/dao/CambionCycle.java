package com.zkb.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CambionCycle extends BaseWarframe {
    private String id;
    private String active;
    private String timeLeft;

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .append("active", getActive())
                .append("timeLeft", getTimeLeft())
                .toString();
    }

}
