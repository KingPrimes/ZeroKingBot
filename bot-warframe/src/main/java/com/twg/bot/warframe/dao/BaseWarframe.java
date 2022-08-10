package com.twg.bot.warframe.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BaseWarframe {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date activation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiry;

    /**
     * 开始时间
     */
    public Date getActivation() {
        return activation;
    }

    /**
     * 开始时间
     */
    public void setActivation(Date activation) {
        this.activation = activation;
    }

    /**
     * 结束时间
     */
    public Date getExpiry() {
        return expiry;
    }

    /**
     * 结束时间
     */
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
