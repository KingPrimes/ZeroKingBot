package com.zkb.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class DucatDumps {
    /**
     * 银垃圾
     */
    private List<Ducats.Ducat> silver;
    /**
     * 金垃圾
     */
    private List<Ducats.Ducat> god;


    /**
     * get 银垃圾
     *
     * @return silver 银垃圾
     */
    public List<Ducats.Ducat> getSilver() {
        return this.silver;
    }

    /**
     * set 银垃圾
     *
     * @param silver 银垃圾
     */
    public void setSilver(List<Ducats.Ducat> silver) {
        this.silver = silver;
    }

    /**
     * get 金垃圾
     *
     * @return god 金垃圾
     */
    public List<Ducats.Ducat> getGod() {
        return this.god;
    }

    /**
     * set 金垃圾
     *
     * @param god 金垃圾
     */
    public void setGod(List<Ducats.Ducat> god) {
        this.god = god;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("silver", silver)
                .append("god", god)
                .toString();
    }
}
