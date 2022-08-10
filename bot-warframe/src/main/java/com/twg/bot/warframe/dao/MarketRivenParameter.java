package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class MarketRivenParameter {
    String urlName;
    String itemName;
    List<MarketRivenKey.ErrMarketRiven> errMarketRiven;
    String positiveStats;
    String negativeStats;
    String polarity;
    String modRank;
    String masteryRankMin;
    String masteryRankMax;
    String buyoutPolicy;
    String sortBy;

    public MarketRivenParameter() {

    }

    public MarketRivenParameter(MarketRivenParameter parameter) {
        this.urlName = parameter.getUrlName();
        this.itemName = parameter.getItemName();
        this.errMarketRiven = parameter.getErrMarketRiven();
        this.positiveStats = parameter.getPositiveStats();
        this.negativeStats = parameter.getNegativeStats();
        this.polarity = parameter.getPolarity();
        this.modRank = parameter.getModRank();
        this.masteryRankMin = parameter.getMasteryRankMin();
        this.masteryRankMax = parameter.getMasteryRankMax();
        this.buyoutPolicy = parameter.getBuyoutPolicy();
        this.sortBy = parameter.getSortBy();
    }


    /**
     * Url Name
     */
    public String getUrlName() {
        return urlName;
    }

    /**
     * Url Name
     */
    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    /**
     * 正面词条 以,分割
     */
    public String getPositiveStats() {
        return positiveStats;
    }

    /**
     * 正面词条 以,分割
     */
    public void setPositiveStats(String positiveStats) {
        this.positiveStats = positiveStats;
    }

    /**
     * 负面词条 none 无  has 有
     */
    public String getNegativeStats() {
        return negativeStats;
    }

    /**
     * 负面词条 none 无  has 有
     */
    public void setNegativeStats(String negativeStats) {
        this.negativeStats = negativeStats;
    }

    /**
     * 极性
     */
    public String getPolarity() {
        return polarity;
    }

    /**
     * 极性
     */
    public void setPolarity(String polarity) {
        this.polarity = polarity;
    }

    /**
     * Mod等级
     */
    public String getModRank() {
        return modRank;
    }

    /**
     * Mod等级
     */
    public void setModRank(String modRank) {
        this.modRank = modRank;
    }

    /**
     * 最低段位
     */
    public String getMasteryRankMin() {
        return masteryRankMin;
    }

    /**
     * 最低段位
     */
    public void setMasteryRankMin(String masteryRankMin) {
        this.masteryRankMin = masteryRankMin;
    }

    /**
     * 最高段位
     */
    public String getMasteryRankMax() {
        return masteryRankMax;
    }

    /**
     * 最高段位
     */
    public void setMasteryRankMax(String masteryRankMax) {
        this.masteryRankMax = masteryRankMax;
    }

    /**
     * 类别 direct 售卖  auction 拍卖 默认全部
     */
    public String getBuyoutPolicy() {
        return buyoutPolicy;
    }

    /**
     * 类别 direct 售卖  auction 拍卖 默认全部
     */
    public void setBuyoutPolicy(String buyoutPolicy) {
        this.buyoutPolicy = buyoutPolicy;
    }

    /**
     * 排序方式  price_asc 价格正序, price_desc 价格倒序, damage_asc 伤害正序, damage_desc 伤害倒序
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * 排序方式  price_asc 价格正序, price_desc 价格倒序, damage_asc 伤害正序, damage_desc 伤害倒序
     */
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<MarketRivenKey.ErrMarketRiven> getErrMarketRiven() {
        return errMarketRiven;
    }

    public void setErrMarketRiven(List<MarketRivenKey.ErrMarketRiven> errMarketRiven) {
        this.errMarketRiven = errMarketRiven;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("urlName", getUrlName())
                .append("itemName", getItemName())
                .append("errMarketRiven", getErrMarketRiven())
                .append("positiveStats", getPositiveStats())
                .append("negativeStats", getNegativeStats())
                .append("polarity", getPolarity())
                .append("modRank", getModRank())
                .append("masteryRankMin", getMasteryRankMax())
                .append("masteryRankMax", getMasteryRankMax())
                .append("buyoutPolicy", getBuyoutPolicy())
                .append("sortBy", getSortBy())
                .toString();
    }
}
