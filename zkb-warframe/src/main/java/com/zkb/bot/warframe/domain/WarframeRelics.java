package com.zkb.bot.warframe.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.List;

/**
 * @author KingPrimes
 * @date 2021-05-26
 */
@Entity
@Table(name = "warframe_relics")
public class WarframeRelics {

    @GeneratedValue
    @Id
    private Integer relicsKeyId;
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
    @Transient //忽略该字段，该字段不会用于创建表格
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

    @Transient
    private String traCh;

    @Transient
    private List<String> items;


    public WarframeRelics() {
    }

    public WarframeRelics(WarframeRelics relics) {
        this.relicsKeyId = relics.relicsKeyId;
        this.relicsId = relics.relicsId;
        this.relicsTier = relics.relicsTier;
        this.relicsName = relics.relicsName;
        this.relicsState = relics.relicsState;
        this.relicsItemId = relics.relicsItemId;
        this.relicsItemName = relics.relicsItemName;
        this.relicsItemRarity = relics.relicsItemRarity;
        this.relicsItemChance = relics.relicsItemChance;
        this.relicsTierD = relics.relicsTierD;
        this.traCh = relics.traCh;
    }

    public WarframeRelics( String relicsId, String relicsTier, String relicsName, String relicsState, String relicsItemId, String relicsItemName, String relicsItemRarity, String relicsItemChance) {
        this.relicsId = relicsId;
        this.relicsTier = relicsTier;
        this.relicsName = relicsName;
        this.relicsState = relicsState;
        this.relicsItemId = relicsItemId;
        this.relicsItemName = relicsItemName;
        this.relicsItemRarity = relicsItemRarity;
        this.relicsItemChance = relicsItemChance;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    /**
     * get
     *
     * @return relicsKeyId
     */
    public Integer getRelicsKeyId() {
        return this.relicsKeyId;
    }

    /**
     * set
     *
     * @param relicsKeyId
     */
    public void setRelicsKeyId(Integer relicsKeyId) {
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
