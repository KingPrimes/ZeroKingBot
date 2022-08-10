package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Invasions extends BaseWarframe {

    /**
     * id
     */
    public String id;
    /**
     * 开始了多久
     */
    public String startString;
    /**
     * 任务地点
     */
    public String node;
    /**
     * 任务地点
     */
    public String nodeKey;
    /**
     * 介绍
     */
    public String desc;
    /**
     * 进攻方
     */
    public AttackerReward attackerReward;
    /**
     * 进攻派系
     */
    public String attackingFaction;
    /**
     * 进攻方 详情
     */
    public Attacker attacker;
    /**
     * 防守奖励
     */
    public DefenderReward defenderReward;
    /**
     * 防守派系
     */
    public String defendingFaction;
    /**
     * 防守方 详情
     */
    public Defender defender;
    /**
     * 是否对抗Infestation派系
     */
    public Boolean vsInfestation;
    /**
     * 当前进度
     */
    public Integer count;
    /**
     * 所需进度
     */
    public Integer requiredRuns;
    /**
     * 完成的进度
     */
    public Double completion;
    /**
     * 是否完成
     */
    public Boolean completed;
    /**
     * 距离结束
     */
    public String eta;
    /**
     * 奖励类型
     */
    public List<String> rewardTypes;

    /**
     * id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 开始了多久
     */
    public String getStartString() {
        return startString;
    }

    /**
     * 开始了多久
     */
    public void setStartString(String startString) {
        this.startString = startString;
    }

    /**
     * 任务地点
     */
    public String getNode() {
        return node;
    }

    /**
     * 任务地点
     */
    public void setNode(String node) {
        this.node = node;
    }

    /**
     * 任务地点
     */
    public String getNodeKey() {
        return nodeKey;
    }

    /**
     * 任务地点
     */
    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    /**
     * 介绍
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 介绍
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 进攻方
     */
    public AttackerReward getAttackerReward() {
        return attackerReward;
    }

    /**
     * 进攻方
     */
    public void setAttackerReward(AttackerReward attackerReward) {
        this.attackerReward = attackerReward;
    }

    /**
     * 进攻派系
     */
    public String getAttackingFaction() {
        return attackingFaction;
    }

    /**
     * 进攻派系
     */
    public void setAttackingFaction(String attackingFaction) {
        this.attackingFaction = attackingFaction;
    }

    /**
     * 进攻方 详情
     */
    public Attacker getAttacker() {
        return attacker;
    }

    /**
     * 进攻方 详情
     */
    public void setAttacker(Attacker attacker) {
        this.attacker = attacker;
    }

    /**
     * 防守奖励
     */
    public DefenderReward getDefenderReward() {
        return defenderReward;
    }

    /**
     * 防守奖励
     */
    public void setDefenderReward(DefenderReward defenderReward) {
        this.defenderReward = defenderReward;
    }

    /**
     * 防守派系
     */
    public String getDefendingFaction() {
        return defendingFaction;
    }

    /**
     * 防守派系
     */
    public void setDefendingFaction(String defendingFaction) {
        this.defendingFaction = defendingFaction;
    }

    /**
     * 防守方 详情
     */
    public Defender getDefender() {
        return defender;
    }

    /**
     * 防守方 详情
     */
    public void setDefender(Defender defender) {
        this.defender = defender;
    }

    /**
     * 是否对抗Infestation派系
     */
    public Boolean getVsInfestation() {
        return vsInfestation;
    }

    /**
     * 是否对抗Infestation派系
     */
    public void setVsInfestation(Boolean vsInfestation) {
        this.vsInfestation = vsInfestation;
    }

    /**
     * 当前进度
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 当前进度
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 所需进度
     */
    public Integer getRequiredRuns() {
        return requiredRuns;
    }

    /**
     * 所需进度
     */
    public void setRequiredRuns(Integer requiredRuns) {
        this.requiredRuns = requiredRuns;
    }

    /**
     * 完成的进度
     */
    public Double getCompletion() {
        return completion;
    }

    /**
     * 完成的进度
     */
    public void setCompletion(Double completion) {
        this.completion = completion;
    }

    /**
     * 是否完成
     */
    public Boolean getCompleted() {
        return completed;
    }

    /**
     * 是否完成
     */
    public void setCompleted(Boolean completed) {
        this.completed = completed;
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

    /**
     * 奖励类型
     */
    public List<String> getRewardTypes() {
        return rewardTypes;
    }

    /**
     * 奖励类型
     */
    public void setRewardTypes(List<String> rewardTypes) {
        this.rewardTypes = rewardTypes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("startString", getStartString())
                .append("node", getNode())
                .append("nodeKey", getNodeKey())
                .append("desc", getDesc())
                .append("attackerReward", getAttackerReward())
                .append("attackingFaction", getAttackingFaction())
                .append("attacker", getAttacker())
                .append("defenderReward", getDefenderReward())
                .append("defendingFaction", getDefendingFaction())
                .append("defender", getDefender())
                .append("vsInfestation", getVsInfestation())
                .append("count", getCount())
                .append("requiredRuns", getRequiredRuns())
                .append("completion", getCompletion())
                .append("completed", getCompleted())
                .append("rewardTypes", getRewardTypes())
                .toString();
    }

    /**
     * 进攻方
     */
    public static class AttackerReward {
        /**
         * items
         */
        public List<?> items;
        /**
         * 奖励列表
         */
        public List<CountedItems> countedItems;
        /**
         * credits
         */
        public Integer credits;
        /**
         * 奖励名称
         */
        public String asString;
        /**
         * 奖励名称
         */
        public String itemString;
        /**
         * 缩略图地址
         */
        public String thumbnail;
        /**
         * 颜色
         */
        public Integer color;

        public List<?> getItems() {
            return items;
        }

        public void setItems(List<?> items) {
            this.items = items;
        }

        /**
         * 奖励列表
         */
        public List<CountedItems> getCountedItems() {
            return countedItems;
        }

        /**
         * 奖励列表
         */
        public void setCountedItems(List<CountedItems> countedItems) {
            this.countedItems = countedItems;
        }

        public Integer getCredits() {
            return credits;
        }

        public void setCredits(Integer credits) {
            this.credits = credits;
        }

        /**
         * 奖励名称
         */
        public String getAsString() {
            return asString;
        }

        /**
         * 奖励名称
         */
        public void setAsString(String asString) {
            this.asString = asString;
        }

        /**
         * 奖励名称
         */
        public String getItemString() {
            return itemString;
        }

        /**
         * 奖励名称
         */
        public void setItemString(String itemString) {
            this.itemString = itemString;
        }

        /**
         * 缩略图地址
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         * 缩略图地址
         */
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         * 颜色
         */
        public Integer getColor() {
            return color;
        }

        /**
         * 颜色
         */
        public void setColor(Integer color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("items", getItems())
                    .append("countedItems", getCountedItems())
                    .append("credits", getCredits())
                    .append("asString", getAsString())
                    .append("itemString", getItemString())
                    .append("thumbnail", getThumbnail())
                    .append("color", getColor())
                    .toString();
        }
    }

    /**
     * 进攻方 详情
     */
    public static class Attacker {
        /**
         * 奖励
         */
        public Reward reward;
        /**
         * 派系
         */
        public String faction;
        /**
         * 派系
         */
        public String factionKey;

        /**
         * 奖励
         */
        public Reward getReward() {
            return reward;
        }

        /**
         * 奖励
         */
        public void setReward(Reward reward) {
            this.reward = reward;
        }

        /**
         * 派系
         */
        public String getFaction() {
            return faction;
        }

        /**
         * 派系
         */
        public void setFaction(String faction) {
            this.faction = faction;
        }

        /**
         * 派系
         */
        public String getFactionKey() {
            return factionKey;
        }

        /**
         * 派系
         */
        public void setFactionKey(String factionKey) {
            this.factionKey = factionKey;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("reward", getReward())
                    .append("faction", getFaction())
                    .append("factionKey", getFactionKey())
                    .toString();
        }
    }

    /**
     * 防守方
     */
    public static class DefenderReward {
        /**
         * items
         */
        public List<?> items;
        /**
         * 奖励列表
         */
        public List<CountedItems> countedItems;
        /**
         * credits
         */
        public Integer credits;
        /**
         * 奖励名称
         */
        public String asString;
        /**
         * 奖励名称
         */
        public String itemString;
        /**
         * 缩略图地址
         */
        public String thumbnail;
        /**
         * 颜色
         */
        public Integer color;

        public List<?> getItems() {
            return items;
        }

        public void setItems(List<?> items) {
            this.items = items;
        }

        /**
         * 奖励列表
         */
        public List<CountedItems> getCountedItems() {
            return countedItems;
        }

        /**
         * 奖励列表
         */
        public void setCountedItems(List<CountedItems> countedItems) {
            this.countedItems = countedItems;
        }

        public Integer getCredits() {
            return credits;
        }

        public void setCredits(Integer credits) {
            this.credits = credits;
        }

        /**
         * 奖励名称
         */
        public String getAsString() {
            return asString;
        }

        /**
         * 奖励名称
         */
        public void setAsString(String asString) {
            this.asString = asString;
        }

        /**
         * 奖励名称
         */
        public String getItemString() {
            return itemString;
        }

        /**
         * 奖励名称
         */
        public void setItemString(String itemString) {
            this.itemString = itemString;
        }

        /**
         * 缩略图地址
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         * 缩略图地址
         */
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         * 颜色
         */
        public Integer getColor() {
            return color;
        }

        /**
         * 颜色
         */
        public void setColor(Integer color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("items", getItems())
                    .append("countedItems", getCountedItems())
                    .append("credits", getCredits())
                    .append("asString", getAsString())
                    .append("itemString", getItemString())
                    .append("thumbnail", getThumbnail())
                    .append("color", getColor())
                    .toString();
        }
    }

    /**
     * 防守方 详情
     */
    public static class Defender {
        /**
         * 奖励
         */
        public Reward reward;
        /**
         * 派系
         */
        public String faction;
        /**
         * 派系
         */
        public String factionKey;

        /**
         * 奖励
         */
        public Reward getReward() {
            return reward;
        }

        /**
         * 奖励
         */
        public void setReward(Reward reward) {
            this.reward = reward;
        }

        /**
         * 派系
         */
        public String getFaction() {
            return faction;
        }

        /**
         * 派系
         */
        public void setFaction(String faction) {
            this.faction = faction;
        }

        /**
         * 派系
         */
        public String getFactionKey() {
            return factionKey;
        }

        /**
         * 派系
         */
        public void setFactionKey(String factionKey) {
            this.factionKey = factionKey;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("reward", getReward())
                    .append("faction", getFaction())
                    .append("factionKey", getFactionKey())
                    .toString();
        }
    }

    /**
     * 奖励
     */
    public static class Reward {
        /**
         * items
         */
        public List<?> items;
        /**
         * 奖励物品列表
         */
        public List<CountedItems> countedItems;
        /**
         * credits
         */
        public Integer credits;
        /**
         * 奖励物品
         */
        public String asString;
        /**
         * 奖励物品
         */
        public String itemString;
        /**
         * 缩略图
         */
        public String thumbnail;
        /**
         * 颜色
         */
        public Integer color;

        public List<?> getItems() {
            return items;
        }

        public void setItems(List<?> items) {
            this.items = items;
        }

        /**
         * 奖励物品列表
         */
        public List<CountedItems> getCountedItems() {
            return countedItems;
        }

        /**
         * 奖励物品列表
         */
        public void setCountedItems(List<CountedItems> countedItems) {
            this.countedItems = countedItems;
        }

        public Integer getCredits() {
            return credits;
        }

        public void setCredits(Integer credits) {
            this.credits = credits;
        }

        /**
         * 奖励物品
         */
        public String getAsString() {
            return asString;
        }

        /**
         * 奖励物品
         */
        public void setAsString(String asString) {
            this.asString = asString;
        }

        /**
         * 奖励物品
         */
        public String getItemString() {
            return itemString;
        }

        /**
         * 奖励物品
         */
        public void setItemString(String itemString) {
            this.itemString = itemString;
        }

        /**
         * 缩略图
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         * 缩略图
         */
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         * 颜色
         */
        public Integer getColor() {
            return color;
        }

        /**
         * 颜色
         */
        public void setColor(Integer color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("items", getItems())
                    .append("countedItems", getCountedItems())
                    .append("credits", getCredits())
                    .append("asString", getAsString())
                    .append("itemString", getItemString())
                    .append("thumbnail", getThumbnail())
                    .append("color", getColor())
                    .toString();
        }
    }

    /**
     * 奖励详情
     */
    public static class CountedItems {
        /**
         * 物品数量
         */
        public Integer count;
        /**
         * 奖励物品
         */
        public String type;
        /**
         * 奖励物品
         */
        public String key;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        /**
         * 奖励物品
         */
        public String getType() {
            return type;
        }

        /**
         * 奖励物品
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * 奖励物品
         */
        public String getKey() {
            return key;
        }

        /**
         * 奖励物品
         */
        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("count", getCount())
                    .append("type", getType())
                    .append("key", getKey())
                    .toString();
        }
    }
}

