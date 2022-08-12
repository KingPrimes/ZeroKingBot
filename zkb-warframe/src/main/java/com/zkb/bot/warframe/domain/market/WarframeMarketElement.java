package com.zkb.bot.warframe.domain.market;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Warframe.Market 赤毒/信条武器 元素字典对象
 *
 * @author KingPrimes
 * @date 2021-11-29
 */
public class WarframeMarketElement {
    private static final long serialVersionUID = 1L;

    private String elementEn;

    private String elementCh;

    public String getElementEn() {
        return elementEn;
    }

    public void setElementEn(String elementEn) {
        this.elementEn = elementEn;
    }

    public String getElementCh() {
        return elementCh;
    }

    public void setElementCh(String elementCh) {
        this.elementCh = elementCh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("elementEn", getElementEn())
                .append("elementCh", getElementCh())
                .toString();
    }
}
