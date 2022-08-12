package com.zkb.bot.warframe.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WarframeMarketItemsRegular {
    String regulaHeader;
    String regulaEnd;

    public WarframeMarketItemsRegular() {

    }

    public WarframeMarketItemsRegular(String header, String end) {
        this.regulaHeader = header;
        this.regulaEnd = end;
    }

    public String getRegulaHeader() {
        return regulaHeader;
    }

    public void setRegulaHeader(String regulaHeader) {
        this.regulaHeader = regulaHeader;
    }

    public String getRegulaEnd() {
        return regulaEnd;
    }

    public void setRegulaEnd(String regulaEnd) {
        this.regulaEnd = regulaEnd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("header", getRegulaHeader())
                .append("end", getRegulaEnd())
                .toString();
    }
}
