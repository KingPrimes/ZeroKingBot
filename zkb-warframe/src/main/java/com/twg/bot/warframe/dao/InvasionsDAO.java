package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class InvasionsDAO {
    /**
     * 任务地点
     */
    private String node;
    /**
     * 进攻方
     */
    private String attackingFaction;
    /**
     * 进攻方奖励
     */
    private String attackerReward;

    /**
     * 进攻方奖励数量
     */
    private int attckerCount;
    /**
     * 进攻方奖励
     */
    private String attackerRewardE;
    /**
     * 防守方
     */
    private String defendingFaction;
    /**
     * 防守方奖励
     */
    private String defenderReward;

    /***
     * 防守方奖励数量
     */
    private int defenderCount;

    /**
     * 防守方奖励
     */
    private String defenderRewardE;
    /**
     * 是否对抗 Infestation
     */
    private Boolean vsInfestation;
    /**
     * 当前进度
     */
    private Integer count;
    /**
     * 所需进度
     */
    private Integer requiredRuns;
    /**
     * 完成的进度
     */
    private Double completion;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getAttackingFaction() {
        return attackingFaction;
    }

    public void setAttackingFaction(String attackingFaction) {
        this.attackingFaction = attackingFaction;
    }

    public String getAttackerReward() {
        return attackerReward;
    }

    public void setAttackerReward(String attackerReward) {
        this.attackerReward = attackerReward;
    }

    public String getDefendingFaction() {
        return defendingFaction;
    }

    public void setDefendingFaction(String defendingFaction) {
        this.defendingFaction = defendingFaction;
    }

    public String getDefenderReward() {
        return defenderReward;
    }

    public void setDefenderReward(String defenderReward) {
        this.defenderReward = defenderReward;
    }

    public Boolean getVsInfestation() {
        return vsInfestation;
    }

    public void setVsInfestation(Boolean vsInfestation) {
        this.vsInfestation = vsInfestation;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRequiredRuns() {
        return requiredRuns;
    }

    public void setRequiredRuns(Integer requiredRuns) {
        this.requiredRuns = requiredRuns;
    }

    public Double getCompletion() {
        return completion;
    }

    public void setCompletion(Double completion) {
        this.completion = completion;
    }

    public String getAttackerRewardE() {
        return attackerRewardE;
    }

    public void setAttackerRewardE(String attackerRewardE) {
        this.attackerRewardE = attackerRewardE;
    }

    public String getDefenderRewardE() {
        return defenderRewardE;
    }

    public void setDefenderRewardE(String defenderRewardE) {
        this.defenderRewardE = defenderRewardE;
    }

    public int getAttckerCount() {
        return attckerCount;
    }

    public void setAttckerCount(int attckerCount) {
        this.attckerCount = attckerCount;
    }

    public int getDefenderCount() {
        return defenderCount;
    }

    public void setDefenderCount(int defenderCount) {
        this.defenderCount = defenderCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("node", getNode())
                .append("attackingFaction", getAttackingFaction())
                .append("attackerReward", getAttackerReward())
                .append("defendingFaction", getDefendingFaction())
                .append("defenderReward", getDefenderReward())
                .append("vsInfestation", getVsInfestation())
                .append("count", getCount())
                .append("requiredRuns", getRequiredRuns())
                .append("completion", getCompletion())
                .toString();
    }
}
