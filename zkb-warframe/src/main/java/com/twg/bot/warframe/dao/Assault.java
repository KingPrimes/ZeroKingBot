package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Warframe 突击任务
 */
public class Assault extends BaseWarframe {

    private String id;
    private String startString; //距离上个任务过去了多久
    private boolean active; // 任务是否处于开启状态
    private String rewardPool;
    private List<Variants> variants; //任务详细介绍
    private String boss;//Boss
    private String faction;//任务的主要派系
    private boolean expired;
    private String eta;//距离结束

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 上个任务结束之后过了多久
     */
    public String getStartString() {
        return startString;
    }

    /**
     * 上个任务结束之后过了多久
     */
    public void setStartString(String startString) {
        this.startString = startString;
    }

    /**
     * 任务是否开启
     */
    public boolean isActive() {
        return active;
    }

    /**
     * 任务是否开启
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRewardPool() {
        return rewardPool;
    }

    public void setRewardPool(String rewardPool) {
        this.rewardPool = rewardPool;
    }

    /**
     * 任务详细介绍
     */
    public List<Variants> getVariants() {
        return variants;
    }

    /**
     * 任务详细介绍
     */
    public void setVariants(List<Variants> variants) {
        this.variants = variants;
    }

    /**
     * Boss
     */
    public String getBoss() {
        return boss;
    }

    /**
     * Boss
     */
    public void setBoss(String boss) {
        this.boss = boss;
    }

    /**
     * 任务主要派系
     */
    public String getFaction() {
        return faction;
    }

    /**
     * 任务主要派系
     */
    public void setFaction(String faction) {
        this.faction = faction;
    }


    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * 距离结束
     */
    public String getEta() {
        return eta;
    }

    /**
     * 距离结束
     */
    public void setEta(String eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("activation", getActivation())
                .append("startString", getStartString())
                .append("expiry", getExpiry())
                .append("active", isActive())
                .append("rewardPool", getRewardPool())
                .append("variants", getVariants())
                .append("boss", getBoss())
                .append("faction", getFaction())
                .append("eta", getEta())
                .toString();
    }

    /**
     * 突击任务具体位置信息
     */
    public static class Variants {
        private String missionType; //任务类型 -> 防御
        private String modifier;// 任务限定 -> 敌人护甲强化
        private String modifierDescription; // 任务限定介绍 -> 敌人已有强化护甲
        private String node; //任务位置 Berehynia(赛德娜)

        /**
         * 获取任务类型
         */
        public String getMissionType() {
            return missionType;
        }

        /**
         * 设置任务类型
         */
        public void setMissionType(String missionType) {
            this.missionType = missionType;
        }

        /**
         * 获取任务限定
         */
        public String getModifier() {
            return modifier;
        }

        /**
         * 设置任务限定
         */
        public void setModifier(String modifier) {
            this.modifier = modifier;
        }

        /**
         * 获取任务限定介绍
         */
        public String getModifierDescription() {
            return modifierDescription;
        }

        /**
         * 设置任务限定介绍
         */
        public void setModifierDescription(String modifierDescription) {
            this.modifierDescription = modifierDescription;
        }

        /**
         * 获取任务所在地 Berehynia(赛德娜)
         */
        public String getNode() {
            return node;
        }

        /**
         * 设置任务所在地
         */
        public void setNode(String node) {
            this.node = node;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("missionType", getMissionType())
                    .append("modifier", getModifier())
                    .append("modifierDescription", getModifierDescription())
                    .append("node", getNode())
                    .toString();
        }
    }
}
