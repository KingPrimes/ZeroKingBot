package com.twg.bot.warframe.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Warframe.Market紫卡词条
 *
 * @author KingPrimes
 * @className WarframeMarketRivenTion
 */
public class WarframeMarketRivenTion {
    String effect;
    String exclusiveTo;
    String group;
    Boolean negativeOnly;
    Boolean positiveIsNegative;
    String prefix;
    Boolean searchOnly;
    String suffix;
    String units;
    String urlName;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getExclusiveTo() {
        return exclusiveTo;
    }

    public void setExclusiveTo(String exclusiveTo) {
        this.exclusiveTo = exclusiveTo;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getNegativeOnly() {
        return negativeOnly;
    }

    public void setNegativeOnly(Boolean negativeOnly) {
        this.negativeOnly = negativeOnly;
    }

    public Boolean getPositiveIsNegative() {
        return positiveIsNegative;
    }

    public void setPositiveIsNegative(Boolean positiveIsNegative) {
        this.positiveIsNegative = positiveIsNegative;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Boolean getSearchOnly() {
        return searchOnly;
    }

    public void setSearchOnly(Boolean searchOnly) {
        this.searchOnly = searchOnly;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("effect", getEffect())
                .append("exclusive_to", getExclusiveTo())
                .append("group", getGroup())
                .append("negative_only", getNegativeOnly())
                .append("positive_is_negative", getPositiveIsNegative())
                .append("prefix", getPrefix())
                .append("search_only", getSearchOnly())
                .append("suffix", getSuffix())
                .append("units", getUnits())
                .append("url_name", getUrlName())
                .toString();
    }
}
