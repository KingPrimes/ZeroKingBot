package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//裂隙
public class Fissure extends BaseWarframe {
    private String startString;
    private boolean active;
    private String node;
    private String missionType;
    private String missionKey;
    private String enemy;
    private String enemyKey;
    private String nodeKey;
    private String tier;
    private Integer tierNum;
    private boolean expired;
    private String eta;
    private boolean isStorm;


    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getMissionKey() {
        return missionKey;
    }

    public void setMissionKey(String missionKey) {
        this.missionKey = missionKey;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getEnemyKey() {
        return enemyKey;
    }

    public void setEnemyKey(String enemyKey) {
        this.enemyKey = enemyKey;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Integer getTierNum() {
        return tierNum;
    }

    public void setTierNum(Integer tierNum) {
        this.tierNum = tierNum;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public boolean isStorm() {
        return isStorm;
    }

    public void setStorm(boolean storm) {
        isStorm = storm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .append("startString", getStartString())
                .append("active", isActive())
                .append("node", getNode())
                .append("missionType", getMissionType())
                .append("missionKey", getMissionKey())
                .append("enemy", getEnemy())
                .append("enemyKey", getEnemyKey())
                .append("nodeKey", getNodeKey())
                .append("tier", getTier())
                .append("tierNum", getTierNum())
                .append("expired", isExpired())
                .append("eta", getEta())
                .append("isStorm", isStorm())
                .toString();
    }
}
