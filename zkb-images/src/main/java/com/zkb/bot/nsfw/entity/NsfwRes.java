package com.zkb.bot.nsfw.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class NsfwRes {
    Double drawings;
    Double hentai;
    Double neutral;
    Double porn;
    Double sexy;

    public Double getDrawings() {
        return drawings;
    }

    public void setDrawings(Double drawings) {
        this.drawings = drawings;
    }

    public Double getHentai() {
        return hentai;
    }

    public void setHentai(Double hentai) {
        this.hentai = hentai;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

    public Double getPorn() {
        return porn;
    }

    public void setPorn(Double porn) {
        this.porn = porn;
    }

    public Double getSexy() {
        return sexy;
    }

    public void setSexy(Double sexy) {
        this.sexy = sexy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("drawings", drawings)
                .append("hentai", hentai)
                .append("neutral", neutral)
                .append("porn", porn)
                .append("sexy", sexy)
                .toString();
    }
}
