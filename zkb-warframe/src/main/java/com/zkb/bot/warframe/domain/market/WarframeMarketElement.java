package com.zkb.bot.warframe.domain.market;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Warframe.Market 赤毒/信条武器 元素字典对象
 *
 * @author KingPrimes
 * @date 2021-11-29
 */
@Entity
@Table(name = "warframe_market_element")
public class WarframeMarketElement {
    private static final long serialVersionUID = 1L;

    @GeneratedValue
    @Id
    Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("elementEn", getElementEn())
                .append("elementCh", getElementCh())
                .toString();
    }
}
