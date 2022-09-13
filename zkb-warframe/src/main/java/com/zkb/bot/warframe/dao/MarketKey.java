package com.zkb.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class MarketKey {
    private String key;
    private String itemName;
    private List<ErrorWM> errorWM;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<ErrorWM> getErrorWM() {
        return errorWM;
    }

    public void setErrorWM(List<ErrorWM> errorWM) {
        this.errorWM = errorWM;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("key", getKey())
                .append("itme_name", getItemName())
                .append("wm", getErrorWM())
                .toString();
    }
}
