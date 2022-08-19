package com.zkb.bot.warframe.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author KingPrimes
 * @date 2021-05-26
 */
public class WarframeRelics {

    private Long relicsKeyId;
    /**
     * 遗物ID
     */
    private String relicsId;

    /**
     * 纪元
     */
    private String relicsTier;

    /**
     * 纪元
     */
    private String relicsTierD;

    /**
     * 遗物名称
     */
    private String relicsName;

    /**
     * 遗物状态
     */
    private String relicsState;

    /**
     * 遗物内物品ID
     */
    private String relicsItemId;

    /**
     * 物品名称
     */
    private String relicsItemName;

    /**
     * 概率
     */
    private String relicsItemRarity;

    /**
     * 详细概率
     */
    private String relicsItemChance;

    private String traCh;

    public WarframeRelics() {
    }

    public WarframeRelics(Long relicsKeyId, String relicsId, String relicsTier, String relicsName, String relicsState, String relicsItemId, String relicsItemName, String relicsItemRarity, String relicsItemChance, String traCh) {
        this.relicsKeyId = relicsKeyId;
        this.relicsId = relicsId;
        this.relicsTier = relicsTier;
        this.relicsName = relicsName;
        this.relicsState = relicsState;
        this.relicsItemId = relicsItemId;
        this.relicsItemName = relicsItemName;
        this.relicsItemRarity = relicsItemRarity;
        this.relicsItemChance = relicsItemChance;
        this.traCh = traCh;
    }

    /**
     * get
     *
     * @return relicsKeyId
     */
    public Long getRelicsKeyId() {
        return this.relicsKeyId;
    }

    /**
     * set
     *
     * @param relicsKeyId
     */
    public void setRelicsKeyId(Long relicsKeyId) {
        this.relicsKeyId = relicsKeyId;
    }

    /**
     * get 遗物ID
     *
     * @return relicsId 遗物ID
     */
    public String getRelicsId() {
        return this.relicsId;
    }

    /**
     * set 遗物ID
     *
     * @param relicsId 遗物ID
     */
    public void setRelicsId(String relicsId) {
        this.relicsId = relicsId;
    }

    /**
     * get 纪元
     *
     * @return relicsTier 纪元
     */
    public String getRelicsTier() {
        return this.relicsTier;
    }

    /**
     * set 纪元
     *
     * @param relicsTier 纪元
     */
    public void setRelicsTier(String relicsTier) {
        this.relicsTier = relicsTier;
    }

    /**
     * get 遗物名称
     *
     * @return relicsName 遗物名称
     */
    public String getRelicsName() {
        return this.relicsName;
    }

    /**
     * set 遗物名称
     *
     * @param relicsName 遗物名称
     */
    public void setRelicsName(String relicsName) {
        this.relicsName = relicsName;
    }

    /**
     * get 遗物状态
     *
     * @return relicsState 遗物状态
     */
    public String getRelicsState() {
        return this.relicsState;
    }

    /**
     * set 遗物状态
     *
     * @param relicsState 遗物状态
     */
    public void setRelicsState(String relicsState) {
        this.relicsState = relicsState;
    }

    /**
     * get 遗物内物品ID
     *
     * @return relicsItemId 遗物内物品ID
     */
    public String getRelicsItemId() {
        return this.relicsItemId;
    }

    /**
     * set 遗物内物品ID
     *
     * @param relicsItemId 遗物内物品ID
     */
    public void setRelicsItemId(String relicsItemId) {
        this.relicsItemId = relicsItemId;
    }

    /**
     * get 物品名称
     *
     * @return relicsItemName 物品名称
     */
    public String getRelicsItemName() {
        return this.relicsItemName;
    }

    /**
     * set 物品名称
     *
     * @param relicsItemName 物品名称
     */
    public void setRelicsItemName(String relicsItemName) {
        this.relicsItemName = relicsItemName;
    }

    /**
     * get 概率
     *
     * @return relicsItemRarity 概率
     */
    public String getRelicsItemRarity() {
        return this.relicsItemRarity;
    }

    /**
     * set 概率
     *
     * @param relicsItemRarity 概率
     */
    public void setRelicsItemRarity(String relicsItemRarity) {
        this.relicsItemRarity = relicsItemRarity;
    }

    /**
     * get 详细概率
     *
     * @return relicsItemChance 详细概率
     */
    public String getRelicsItemChance() {
        return this.relicsItemChance;
    }

    /**
     * set 详细概率
     *
     * @param relicsItemChance 详细概率
     */
    public void setRelicsItemChance(String relicsItemChance) {
        this.relicsItemChance = relicsItemChance;
    }

    /**
     * get
     *
     * @return traCh
     */
    public String getTraCh() {
        return this.traCh;
    }

    /**
     * set
     *
     * @param traCh
     */
    public void setTraCh(String traCh) {
        this.traCh = traCh;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("relicsKeyId", relicsKeyId)
                .append("relicsId", relicsId)
                .append("relicsTier", relicsTier)
                .append("relicsTierD", relicsTierD)
                .append("relicsName", relicsName)
                .append("relicsState", relicsState)
                .append("relicsItemId", relicsItemId)
                .append("relicsItemName", relicsItemName)
                .append("relicsItemRarity", relicsItemRarity)
                .append("relicsItemChance", relicsItemChance)
                .append("traCh", traCh)
                .toString();
    }

    /**
     * get 纪元
     *
     * @return relicsTierD 纪元
     */
    public String getRelicsTierD() {
        return this.relicsTierD;
    }

    /**
     * set 纪元
     *
     * @param relicsTierD 纪元
     */
    public void setRelicsTierD(String relicsTierD) {
        this.relicsTierD = relicsTierD;
    }
}