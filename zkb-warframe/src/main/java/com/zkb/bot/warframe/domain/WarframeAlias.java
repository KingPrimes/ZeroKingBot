package com.zkb.bot.warframe.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Warframe Alias
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
public class WarframeAlias {
    private static final long serialVersionUID = 1L;

    private Integer aliasId;

    private String aliasEn;

    private String aliasCh;

    public Integer getAliasId() {
        return aliasId;
    }

    public void setAliasId(Integer aliasId) {
        this.aliasId = aliasId;
    }

    public String getAliasEn() {
        return aliasEn;
    }

    public void setAliasEn(String aliasEn) {
        this.aliasEn = aliasEn;
    }

    public String getAliasCh() {
        return aliasCh;
    }

    public void setAliasCh(String aliasCh) {
        this.aliasCh = aliasCh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("aliasId", getAliasCh())
                .append("aliasEn", getAliasEn())
                .append("aliasCh", getAliasCh())
                .toString();
    }
}
