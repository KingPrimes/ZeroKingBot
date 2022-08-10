package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class MarketRivenKey {
    String urlName;
    String itemName;
    List<ErrMarketRiven> errMarketRiven;

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<ErrMarketRiven> getErrMarketRiven() {
        return errMarketRiven;
    }

    public void setErrMarketRiven(List<ErrMarketRiven> errMarketRiven) {
        this.errMarketRiven = errMarketRiven;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("url_name", getUrlName())
                .append("item_name", getItemName())
                .append("err_market_riven", getErrMarketRiven())
                .toString();
    }

    public static class ErrMarketRiven {
        String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("key", getKey())
                    .toString();
        }
    }
}
