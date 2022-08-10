package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ErrorWM {
    private String En;
    private String Ch;

    public String getCh() {
        return Ch;
    }

    public void setCh(String ch) {
        Ch = ch;
    }

    public String getEn() {
        return En;
    }

    public void setEn(String en) {
        En = en;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("en", getEn())
                .append("ch", getCh())
                .toString();
    }
}
