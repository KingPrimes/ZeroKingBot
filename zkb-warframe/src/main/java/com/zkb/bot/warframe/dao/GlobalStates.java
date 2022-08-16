package com.zkb.bot.warframe.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GlobalStates {
    /**
     * 警报
     */
    @JsonProperty("alerts")
    private List<Alerts> alerts;
    /**
     * 仲裁
     */
    @JsonProperty("arbitration")
    private Arbitration arbitration;
    /**
     * 魔胎之境
     */
    @JsonProperty("cambionCycle")
    private CambionCycle cambionCycle;
    /**
     * 希图斯
     */
    @JsonProperty("cetusCycle")
    private CetusCycle cetusCycle;
    /**
     * 入侵双方的建筑情况
     */
    @JsonProperty("constructionProgress")
    private ConstructionProgress constructionProgress;
    /**
     * 每日特惠
     */
    @JsonProperty("dailyDeals")
    private List<DailyDeals> dailyDeals;
    /**
     * 地球
     */
    @JsonProperty("earthCycle")
    private EarthCycle earthCycle;
    /**
     * 活动
     */
    @JsonProperty("events")
    private List<Events> events;
    /**
     * 裂隙
     */
    @JsonProperty("fissures")
    private List<Fissures> fissures;

    @JsonProperty("globalUpgrades")
    private List<GlobalUpgrades> globalUpgrades;

    /**
     * 入侵
     */
    @JsonProperty("invasions")
    private List<Invasions> invasions;
    /**
     * 新闻
     */
    @JsonProperty("news")
    private List<News> news;
    /**
     * 电波
     */
    @JsonProperty("nightwave")
    private Nightwave nightwave;
    /**
     * 大黄脸中枢的结合目标
     */
    @JsonProperty("simaris")
    private Simaris simaris;
    /**
     * 突击
     */
    @JsonProperty("sortie")
    private Sortie sortie;
    /**
     * 钢铁兑换轮换
     */
    @JsonProperty("steelPath")
    private SteelPath steelPath;
    /**
     * 集团任务
     */
    @JsonProperty("syndicateMissions")
    private List<SyndicateMissions> syndicateMissions;
    /**
     * 奥布山谷 轮换
     */
    @JsonProperty("vallisCycle")
    private VallisCycle vallisCycle;
    /**
     * 扎里曼轮换
     */
    @JsonProperty("zarimanCycle")
    private ZarimanCycle zarimanCycle;
    /**
     * 虚空商人
     */
    @JsonProperty("voidTrader")
    private VoidTrader voidTrader;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("alerts", alerts).append("arbitration", arbitration).append("cambionCycle", cambionCycle).append("cetusCycle", cetusCycle).append("constructionProgress", constructionProgress).append("dailyDeals", dailyDeals).append("earthCycle", earthCycle).append("events", events).append("fissures", fissures).append("globalUpgrades", globalUpgrades).append("invasions", invasions).append("news", news).append("nightwave", nightwave).append("simaris", simaris).append("sortie", sortie).append("steelPath", steelPath).append("syndicateMissions", syndicateMissions).append("vallisCycle", vallisCycle).append("zarimanCycle", zarimanCycle).append("voidTrader", voidTrader).toString();
    }

    /**
     * get 警报
     *
     * @return alerts 警报
     */
    public List<Alerts> getAlerts() {
        return this.alerts;
    }

    /**
     * set 警报
     *
     * @param alerts 警报
     */
    public void setAlerts(List<Alerts> alerts) {
        this.alerts = alerts;
    }

    /**
     * get 仲裁
     *
     * @return arbitration 仲裁
     */
    public Arbitration getArbitration() {
        return this.arbitration;
    }

    /**
     * set 仲裁
     *
     * @param arbitration 仲裁
     */
    public void setArbitration(Arbitration arbitration) {
        this.arbitration = arbitration;
    }

    /**
     * get 魔胎之境
     *
     * @return cambionCycle 魔胎之境
     */
    public CambionCycle getCambionCycle() {
        return this.cambionCycle;
    }

    /**
     * set 魔胎之境
     *
     * @param cambionCycle 魔胎之境
     */
    public void setCambionCycle(CambionCycle cambionCycle) {
        this.cambionCycle = cambionCycle;
    }

    /**
     * get 希图斯
     *
     * @return cetusCycle 希图斯
     */
    public CetusCycle getCetusCycle() {
        return this.cetusCycle;
    }

    /**
     * set 希图斯
     *
     * @param cetusCycle 希图斯
     */
    public void setCetusCycle(CetusCycle cetusCycle) {
        this.cetusCycle = cetusCycle;
    }

    /**
     * get 入侵双方的建筑情况
     *
     * @return constructionProgress 入侵双方的建筑情况
     */
    public ConstructionProgress getConstructionProgress() {
        return this.constructionProgress;
    }

    /**
     * set 入侵双方的建筑情况
     *
     * @param constructionProgress 入侵双方的建筑情况
     */
    public void setConstructionProgress(ConstructionProgress constructionProgress) {
        this.constructionProgress = constructionProgress;
    }

    /**
     * get 每日特惠
     *
     * @return dailyDeals 每日特惠
     */
    public List<DailyDeals> getDailyDeals() {
        return this.dailyDeals;
    }

    /**
     * set 每日特惠
     *
     * @param dailyDeals 每日特惠
     */
    public void setDailyDeals(List<DailyDeals> dailyDeals) {
        this.dailyDeals = dailyDeals;
    }

    /**
     * get 地球
     *
     * @return earthCycle 地球
     */
    public EarthCycle getEarthCycle() {
        return this.earthCycle;
    }

    /**
     * set 地球
     *
     * @param earthCycle 地球
     */
    public void setEarthCycle(EarthCycle earthCycle) {
        this.earthCycle = earthCycle;
    }

    /**
     * get 活动
     *
     * @return events 活动
     */
    public List<Events> getEvents() {
        return this.events;
    }

    /**
     * set 活动
     *
     * @param events 活动
     */
    public void setEvents(List<Events> events) {
        this.events = events;
    }

    /**
     * get 裂隙
     *
     * @return fissures 裂隙
     */
    public List<Fissures> getFissures() {
        return this.fissures;
    }

    /**
     * set 裂隙
     *
     * @param fissures 裂隙
     */
    public void setFissures(List<Fissures> fissures) {
        this.fissures = fissures;
    }

    /**
     * get @JsonProperty("globalUpgrades")
     *
     * @return globalUpgrades @JsonProperty("globalUpgrades")
     */
    public List<GlobalUpgrades> getGlobalUpgrades() {
        return this.globalUpgrades;
    }

    /**
     * set @JsonProperty("globalUpgrades")
     *
     * @param globalUpgrades @JsonProperty("globalUpgrades")
     */
    public void setGlobalUpgrades(List<GlobalUpgrades> globalUpgrades) {
        this.globalUpgrades = globalUpgrades;
    }

    /**
     * get 入侵
     *
     * @return invasions 入侵
     */
    public List<Invasions> getInvasions() {
        return this.invasions;
    }

    /**
     * set 入侵
     *
     * @param invasions 入侵
     */
    public void setInvasions(List<Invasions> invasions) {
        this.invasions = invasions;
    }

    /**
     * get 新闻
     *
     * @return news 新闻
     */
    public List<News> getNews() {
        return this.news;
    }

    /**
     * set 新闻
     *
     * @param news 新闻
     */
    public void setNews(List<News> news) {
        this.news = news;
    }

    /**
     * get 电波
     *
     * @return nightwave 电波
     */
    public Nightwave getNightwave() {
        return this.nightwave;
    }

    /**
     * set 电波
     *
     * @param nightwave 电波
     */
    public void setNightwave(Nightwave nightwave) {
        this.nightwave = nightwave;
    }

    /**
     * get 大黄脸中枢的结合目标
     *
     * @return simaris 大黄脸中枢的结合目标
     */
    public Simaris getSimaris() {
        return this.simaris;
    }

    /**
     * set 大黄脸中枢的结合目标
     *
     * @param simaris 大黄脸中枢的结合目标
     */
    public void setSimaris(Simaris simaris) {
        this.simaris = simaris;
    }

    /**
     * get 突击
     *
     * @return sortie 突击
     */
    public Sortie getSortie() {
        return this.sortie;
    }

    /**
     * set 突击
     *
     * @param sortie 突击
     */
    public void setSortie(Sortie sortie) {
        this.sortie = sortie;
    }

    /**
     * get 钢铁兑换轮换
     *
     * @return steelPath 钢铁兑换轮换
     */
    public SteelPath getSteelPath() {
        return this.steelPath;
    }

    /**
     * set 钢铁兑换轮换
     *
     * @param steelPath 钢铁兑换轮换
     */
    public void setSteelPath(SteelPath steelPath) {
        this.steelPath = steelPath;
    }

    /**
     * get 集团任务
     *
     * @return syndicateMissions 集团任务
     */
    public List<SyndicateMissions> getSyndicateMissions() {
        return this.syndicateMissions;
    }

    /**
     * set 集团任务
     *
     * @param syndicateMissions 集团任务
     */
    public void setSyndicateMissions(List<SyndicateMissions> syndicateMissions) {
        this.syndicateMissions = syndicateMissions;
    }

    /**
     * get 奥布山谷 轮换
     *
     * @return vallisCycle 奥布山谷 轮换
     */
    public VallisCycle getVallisCycle() {
        return this.vallisCycle;
    }

    /**
     * set 奥布山谷 轮换
     *
     * @param vallisCycle 奥布山谷 轮换
     */
    public void setVallisCycle(VallisCycle vallisCycle) {
        this.vallisCycle = vallisCycle;
    }

    /**
     * get 扎里曼轮换
     *
     * @return zarimanCycle 扎里曼轮换
     */
    public ZarimanCycle getZarimanCycle() {
        return this.zarimanCycle;
    }

    /**
     * set 扎里曼轮换
     *
     * @param zarimanCycle 扎里曼轮换
     */
    public void setZarimanCycle(ZarimanCycle zarimanCycle) {
        this.zarimanCycle = zarimanCycle;
    }

    /**
     * get 虚空商人
     *
     * @return voidTrader 虚空商人
     */
    public VoidTrader getVoidTrader() {
        return this.voidTrader;
    }

    /**
     * set 虚空商人
     *
     * @param voidTrader 虚空商人
     */
    public void setVoidTrader(VoidTrader voidTrader) {
        this.voidTrader = voidTrader;
    }

    public static class Fissures {

        @JsonProperty("node")
        private String node;
        @JsonProperty("expired")
        private Boolean expired;
        @JsonProperty("eta")
        private String eta;
        @JsonProperty("missionType")
        private String missionType;
        @JsonProperty("missionKey")
        private String missionKey;
        @JsonProperty("nodeKey")
        private String nodeKey;
        @JsonProperty("tier")
        private String tier;
        @JsonProperty("tierNum")
        private Integer tierNum;
        @JsonProperty("enemy")
        private String enemy;
        @JsonProperty("enemyKey")
        private String enemyKey;
        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("isStorm")
        private Boolean isStorm;
        @JsonProperty("active")
        private Boolean active;
        @JsonProperty("startString")
        private String startString;
        public Fissures() {
        }

        public Fissures(String node, Boolean expired, String eta, String missionType, String missionKey, String nodeKey, String tier, Integer tierNum, String enemy, String enemyKey, String id, Date activation, Date expiry, Boolean isStorm, Boolean active, String startString) {
            this.node = node;
            this.expired = expired;
            this.eta = eta;
            this.missionType = missionType;
            this.missionKey = missionKey;
            this.nodeKey = nodeKey;
            this.tier = tier;
            this.tierNum = tierNum;
            this.enemy = enemy;
            this.enemyKey = enemyKey;
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.isStorm = isStorm;
            this.active = active;
            this.startString = startString;
        }

        public Boolean getStorm() {
            return isStorm;
        }

        public void setStorm(Boolean storm) {
            isStorm = storm;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fissures)) return false;
            Fissures fissures = (Fissures) o;
            return Objects.equals(node, fissures.node) && Objects.equals(missionType, fissures.missionType) && Objects.equals(tierNum, fissures.tierNum);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, missionType, tierNum);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("node", node).append("expired", expired).append("eta", eta).append("missionType", missionType).append("missionKey", missionKey).append("nodeKey", nodeKey).append("tier", tier).append("tierNum", tierNum).append("enemy", enemy).append("enemyKey", enemyKey).append("id", id).append("activation", activation).append("expiry", expiry).append("isStorm", isStorm).append("active", active).append("startString", startString).toString();
        }


        /**
         * get @JsonProperty("node")
         *
         * @return node @JsonProperty("node")
         */
        public String getNode() {
            return this.node;
        }

        /**
         * set @JsonProperty("node")
         *
         * @param node @JsonProperty("node")
         */
        public void setNode(String node) {
            this.node = node;
        }

        /**
         * get @JsonProperty("expired")
         *
         * @return expired @JsonProperty("expired")
         */
        public Boolean getExpired() {
            return this.expired;
        }

        /**
         * set @JsonProperty("expired")
         *
         * @param expired @JsonProperty("expired")
         */
        public void setExpired(Boolean expired) {
            this.expired = expired;
        }

        /**
         * get @JsonProperty("eta")
         *
         * @return eta @JsonProperty("eta")
         */
        public String getEta() {
            return this.eta;
        }

        /**
         * set @JsonProperty("eta")
         *
         * @param eta @JsonProperty("eta")
         */
        public void setEta(String eta) {
            this.eta = eta;
        }

        /**
         * get @JsonProperty("missionType")
         *
         * @return missionType @JsonProperty("missionType")
         */
        public String getMissionType() {
            return this.missionType;
        }

        /**
         * set @JsonProperty("missionType")
         *
         * @param missionType @JsonProperty("missionType")
         */
        public void setMissionType(String missionType) {
            this.missionType = missionType;
        }

        /**
         * get @JsonProperty("missionKey")
         *
         * @return missionKey @JsonProperty("missionKey")
         */
        public String getMissionKey() {
            return this.missionKey;
        }

        /**
         * set @JsonProperty("missionKey")
         *
         * @param missionKey @JsonProperty("missionKey")
         */
        public void setMissionKey(String missionKey) {
            this.missionKey = missionKey;
        }

        /**
         * get @JsonProperty("nodeKey")
         *
         * @return nodeKey @JsonProperty("nodeKey")
         */
        public String getNodeKey() {
            return this.nodeKey;
        }

        /**
         * set @JsonProperty("nodeKey")
         *
         * @param nodeKey @JsonProperty("nodeKey")
         */
        public void setNodeKey(String nodeKey) {
            this.nodeKey = nodeKey;
        }

        /**
         * get @JsonProperty("tier")
         *
         * @return tier @JsonProperty("tier")
         */
        public String getTier() {
            return this.tier;
        }

        /**
         * set @JsonProperty("tier")
         *
         * @param tier @JsonProperty("tier")
         */
        public void setTier(String tier) {
            this.tier = tier;
        }

        /**
         * get @JsonProperty("tierNum")
         *
         * @return tierNum @JsonProperty("tierNum")
         */
        public Integer getTierNum() {
            return this.tierNum;
        }

        /**
         * set @JsonProperty("tierNum")
         *
         * @param tierNum @JsonProperty("tierNum")
         */
        public void setTierNum(Integer tierNum) {
            this.tierNum = tierNum;
        }

        /**
         * get @JsonProperty("enemy")
         *
         * @return enemy @JsonProperty("enemy")
         */
        public String getEnemy() {
            return this.enemy;
        }

        /**
         * set @JsonProperty("enemy")
         *
         * @param enemy @JsonProperty("enemy")
         */
        public void setEnemy(String enemy) {
            this.enemy = enemy;
        }

        /**
         * get @JsonProperty("enemyKey")
         *
         * @return enemyKey @JsonProperty("enemyKey")
         */
        public String getEnemyKey() {
            return this.enemyKey;
        }

        /**
         * set @JsonProperty("enemyKey")
         *
         * @param enemyKey @JsonProperty("enemyKey")
         */
        public void setEnemyKey(String enemyKey) {
            this.enemyKey = enemyKey;
        }

        /**
         * get @JsonProperty("id")
         *
         * @return id @JsonProperty("id")
         */
        public String getId() {
            return this.id;
        }

        /**
         * set @JsonProperty("id")
         *
         * @param id @JsonProperty("id")
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * get @JsonProperty("activation")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         *
         * @return activation @JsonProperty("activation")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         */
        public Date getActivation() {
            return this.activation;
        }

        /**
         * set @JsonProperty("activation")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         *
         * @param activation @JsonProperty("activation")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         */
        public void setActivation(Date activation) {
            this.activation = activation;
        }

        /**
         * get @JsonProperty("expiry")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         *
         * @return expiry @JsonProperty("expiry")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         */
        public Date getExpiry() {
            return this.expiry;
        }

        /**
         * set @JsonProperty("expiry")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         *
         * @param expiry @JsonProperty("expiry")        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" timezone = "GMT+8")
         */
        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        /**
         * get @JsonProperty("isStorm")
         *
         * @return isStorm @JsonProperty("isStorm")
         */
        public Boolean getIsStorm() {
            return this.isStorm;
        }

        /**
         * set @JsonProperty("isStorm")
         *
         * @param isStorm @JsonProperty("isStorm")
         */
        public void setIsStorm(Boolean isStorm) {
            this.isStorm = isStorm;
        }

        /**
         * get @JsonProperty("active")
         *
         * @return active @JsonProperty("active")
         */
        public Boolean getActive() {
            return this.active;
        }

        /**
         * set @JsonProperty("active")
         *
         * @param active @JsonProperty("active")
         */
        public void setActive(Boolean active) {
            this.active = active;
        }

        /**
         * get @JsonProperty("startString")
         *
         * @return startString @JsonProperty("startString")
         */
        public String getStartString() {
            return this.startString;
        }

        /**
         * set @JsonProperty("startString")
         *
         * @param startString @JsonProperty("startString")
         */
        public void setStartString(String startString) {
            this.startString = startString;
        }
    }

    public static class GlobalUpgrades {

        @JsonProperty("start")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        //开始时间
        private Date start;
        @JsonProperty("end")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        //结束时间
        private Date end;
        @JsonProperty("upgrade")
        //加成类型
        private String upgrade;
        @JsonProperty("operation")
        //加成方式 乘/加
        private String operation;
        @JsonProperty("operationSymbol")
        //加成方式 x/+
        private String operationSymbol;
        @JsonProperty("upgradeOperationValue")
        //加成倍数
        private Integer upgradeOperationValue;
        @JsonProperty("expired")
        //是否关闭
        private Boolean expired;
        @JsonProperty("eta")
        //结束时间
        private String eta;
        @JsonProperty("desc")
        //具体字符串
        private String desc;


        public GlobalUpgrades() {
        }

        public GlobalUpgrades(Date start, Date end, String upgrade, String operation, String operationSymbol, Integer upgradeOperationValue, Boolean expired, String eta, String desc) {
            this.start = start;
            this.end = end;
            this.upgrade = upgrade;
            this.operation = operation;
            this.operationSymbol = operationSymbol;
            this.upgradeOperationValue = upgradeOperationValue;
            this.expired = expired;
            this.eta = eta;
            this.desc = desc;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GlobalUpgrades)) return false;
            GlobalUpgrades that = (GlobalUpgrades) o;
            return start.equals(that.start) && end.equals(that.end) && upgrade.equals(that.upgrade);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, upgrade);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("start", start).append("end", end).append("upgrade", upgrade).append("operation", operation).append("operationSymbol", operationSymbol).append("upgradeOperationValue", upgradeOperationValue).append("expired", expired).append("eta", eta).append("desc", desc).toString();
        }

        /**
         * get 开始时间
         *
         * @return 开始时间
         */
        public Date getStart() {
            return this.start;
        }

        /**
         * set开始时间
         *
         * @param start 开始时间
         */
        public void setStart(Date start) {
            this.start = start;
        }

        /**
         * get 结束时间
         *
         * @return end 结束时间
         */
        public Date getEnd() {
            return this.end;
        }

        /**
         * set 结束时间
         *
         * @param end 结束时间
         */
        public void setEnd(Date end) {
            this.end = end;
        }

        /**
         * get 加成类型
         *
         * @return upgrade  加成类型
         */
        public String getUpgrade() {
            return this.upgrade;
        }

        /**
         * set   加成类型
         *
         * @param upgrade 加成类型
         */
        public void setUpgrade(String upgrade) {
            this.upgrade = upgrade;
        }

        /**
         * get 加成方式 乘加
         *
         * @return operation  加成方式 乘加
         */
        public String getOperation() {
            return this.operation;
        }

        /**
         * set   加成方式 乘加
         *
         * @param operation 加成方式 乘加
         */
        public void setOperation(String operation) {
            this.operation = operation;
        }

        /**
         * get    加成方式 x+
         *
         * @return operationSymbol    加成方式 x+
         */
        public String getOperationSymbol() {
            return this.operationSymbol;
        }

        /**
         * set  加成方式 x+
         *
         * @param operationSymbol 加成方式 x+
         */
        public void setOperationSymbol(String operationSymbol) {
            this.operationSymbol = operationSymbol;
        }

        /**
         * get  加成倍数
         *
         * @return upgradeOperationValue    加成倍数
         */
        public Integer getUpgradeOperationValue() {
            return this.upgradeOperationValue;
        }

        /**
         * set     加成倍数
         *
         * @param upgradeOperationValue 加成倍数
         */
        public void setUpgradeOperationValue(Integer upgradeOperationValue) {
            this.upgradeOperationValue = upgradeOperationValue;
        }

        /**
         * get   是否关闭
         *
         * @return expired    是否关闭
         */
        public Boolean getExpired() {
            return this.expired;
        }

        /**
         * set     是否关闭
         *
         * @param expired 是否关闭
         */
        public void setExpired(Boolean expired) {
            this.expired = expired;
        }

        /**
         * get    结束时间
         *
         * @return eta     结束时间
         */
        public String getEta() {
            return this.eta;
        }

        /**
         * set     结束时间
         *
         * @param eta 结束时间
         */
        public void setEta(String eta) {
            this.eta = eta;
        }

        /**
         * get     具体字符串
         *
         * @return desc      具体字符串
         */
        public String getDesc() {
            return this.desc;
        }

        /**
         * set    具体字符串
         *
         * @param desc 具体字符串
         */
        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static class Invasions {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Invasions)) return false;
            Invasions invasions = (Invasions) o;
            return attacker.equals(invasions.attacker) && attackerReward.equals(invasions.attackerReward) && attackingFaction.equals(invasions.attackingFaction) && defender.equals(invasions.defender) && defenderReward.equals(invasions.defenderReward) && defendingFaction.equals(invasions.defendingFaction) && node.equals(invasions.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(attacker, attackerReward, attackingFaction, defender, defenderReward, defendingFaction, node);
        }

        public Invasions() {
        }

        public Invasions(String id, Date activation, Date expiry, Attacker attacker, AttackerReward attackerReward, String attackingFaction, Boolean completed, Integer count, Defender defender, DefenderReward defenderReward, String defendingFaction, String desc, String eta, String node, String nodeKey, Integer requiredRuns, List<String> rewardTypes, String startString, Boolean vsInfestation, String completion) {
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.attacker = attacker;
            this.attackerReward = attackerReward;
            this.attackingFaction = attackingFaction;
            this.completed = completed;
            this.count = count;
            this.defender = defender;
            this.defenderReward = defenderReward;
            this.defendingFaction = defendingFaction;
            this.desc = desc;
            this.eta = eta;
            this.node = node;
            this.nodeKey = nodeKey;
            this.requiredRuns = requiredRuns;
            this.rewardTypes = rewardTypes;
            this.startString = startString;
            this.vsInfestation = vsInfestation;
            this.completion = completion;
        }

        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("attacker")
        private Attacker attacker;
        @JsonProperty("attackerReward")
        private AttackerReward attackerReward;
        @JsonProperty("attackingFaction")
        private String attackingFaction;
        @JsonProperty("completed")
        private Boolean completed;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("defender")
        private Defender defender;
        @JsonProperty("defenderReward")
        private DefenderReward defenderReward;
        @JsonProperty("defendingFaction")
        private String defendingFaction;
        @JsonProperty("desc")
        private String desc;
        @JsonProperty("eta")
        private String eta;
        @JsonProperty("node")
        private String node;
        @JsonProperty("nodeKey")
        private String nodeKey;
        @JsonProperty("requiredRuns")
        private Integer requiredRuns;
        @JsonProperty("rewardTypes")
        private List<String> rewardTypes;
        @JsonProperty("startString")
        private String startString;
        @JsonProperty("vsInfestation")
        private Boolean vsInfestation;
        @JsonProperty("completion")
        private String completion;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public Attacker getAttacker() {
            return attacker;
        }

        public void setAttacker(Attacker attacker) {
            this.attacker = attacker;
        }

        public AttackerReward getAttackerReward() {
            return attackerReward;
        }

        public void setAttackerReward(AttackerReward attackerReward) {
            this.attackerReward = attackerReward;
        }

        public String getAttackingFaction() {
            return attackingFaction;
        }

        public void setAttackingFaction(String attackingFaction) {
            this.attackingFaction = attackingFaction;
        }

        public Boolean getCompleted() {
            return completed;
        }

        public void setCompleted(Boolean completed) {
            this.completed = completed;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Defender getDefender() {
            return defender;
        }

        public void setDefender(Defender defender) {
            this.defender = defender;
        }

        public DefenderReward getDefenderReward() {
            return defenderReward;
        }

        public void setDefenderReward(DefenderReward defenderReward) {
            this.defenderReward = defenderReward;
        }

        public String getDefendingFaction() {
            return defendingFaction;
        }

        public void setDefendingFaction(String defendingFaction) {
            this.defendingFaction = defendingFaction;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEta() {
            return eta;
        }

        public void setEta(String eta) {
            this.eta = eta;
        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }

        public String getNodeKey() {
            return nodeKey;
        }

        public void setNodeKey(String nodeKey) {
            this.nodeKey = nodeKey;
        }

        public Integer getRequiredRuns() {
            return requiredRuns;
        }

        public void setRequiredRuns(Integer requiredRuns) {
            this.requiredRuns = requiredRuns;
        }

        public List<String> getRewardTypes() {
            return rewardTypes;
        }

        public void setRewardTypes(List<String> rewardTypes) {
            this.rewardTypes = rewardTypes;
        }

        public String getStartString() {
            return startString;
        }

        public void setStartString(String startString) {
            this.startString = startString;
        }

        public Boolean getVsInfestation() {
            return vsInfestation;
        }

        public void setVsInfestation(Boolean vsInfestation) {
            this.vsInfestation = vsInfestation;
        }

        public String getCompletion() {
            return completion;
        }

        public void setCompletion(String completion) {
            this.completion = completion;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("id", id).append("activation", activation).append("expiry", expiry).append("attacker", attacker).append("attackerReward", attackerReward).append("attackingFaction", attackingFaction).append("completed", completed).append("count", count).append("defender", defender).append("defenderReward", defenderReward).append("defendingFaction", defendingFaction).append("desc", desc).append("eta", eta).append("node", node).append("nodeKey", nodeKey).append("requiredRuns", requiredRuns).append("rewardTypes", rewardTypes).append("startString", startString).append("vsInfestation", vsInfestation).append("completion", completion).toString();
        }


        public static class Attacker {
            @JsonProperty("reward")
            private Reward reward;
            @JsonProperty("faction")
            private String faction;
            @JsonProperty("factionKey")
            private String factionKey;

            public Attacker(Reward reward, String faction, String factionKey) {
                this.reward = reward;
                this.faction = faction;
                this.factionKey = factionKey;
            }

            public Attacker() {
            }

            public Reward getReward() {
                return reward;
            }

            public void setReward(Reward reward) {
                this.reward = reward;
            }

            public String getFaction() {
                return faction;
            }

            public void setFaction(String faction) {
                this.faction = faction;
            }

            public String getFactionKey() {
                return factionKey;
            }

            public void setFactionKey(String factionKey) {
                this.factionKey = factionKey;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("reward", reward)
                        .append("faction", faction)
                        .append("factionKey", factionKey)
                        .toString();
            }


            public static class Reward {

                public Reward() {
                }

                public Reward(List<CountedItems> countedItems, String thumbnail, Integer color, Integer credits, String asString, String itemString) {
                    this.countedItems = countedItems;
                    this.thumbnail = thumbnail;
                    this.color = color;
                    this.credits = credits;
                    this.asString = asString;
                    this.itemString = itemString;
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (!(o instanceof Reward)) return false;
                    Reward reward = (Reward) o;
                    return countedItems.equals(reward.countedItems) && itemString.equals(reward.itemString);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(countedItems, itemString);
                }

                @Override
                public String toString() {
                    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                            .append("countedItems", countedItems)
                            .append("thumbnail", thumbnail)
                            .append("color", color)
                            .append("credits", credits)
                            .append("asString", asString)
                            .append("itemString", itemString)
                            .toString();
                }

                @JsonProperty("countedItems")
                private List<CountedItems> countedItems;
                @JsonProperty("thumbnail")
                private String thumbnail;
                @JsonProperty("color")
                private Integer color;
                @JsonProperty("credits")
                private Integer credits;
                @JsonProperty("asString")
                private String asString;
                @JsonProperty("itemString")
                private String itemString;


                public List<CountedItems> getCountedItems() {
                    return countedItems;
                }

                public void setCountedItems(List<CountedItems> countedItems) {
                    this.countedItems = countedItems;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public Integer getColor() {
                    return color;
                }

                public void setColor(Integer color) {
                    this.color = color;
                }

                public Integer getCredits() {
                    return credits;
                }

                public void setCredits(Integer credits) {
                    this.credits = credits;
                }

                public String getAsString() {
                    return asString;
                }

                public void setAsString(String asString) {
                    this.asString = asString;
                }

                public String getItemString() {
                    return itemString;
                }

                public void setItemString(String itemString) {
                    this.itemString = itemString;
                }


                public static class CountedItems {

                    public CountedItems() {
                    }

                    public CountedItems(Integer count, String type) {
                        this.count = count;
                        this.type = type;
                    }

                    @JsonProperty("count")
                    private Integer count;
                    @JsonProperty("type")
                    private String type;

                    @Override
                    public String toString() {
                        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                                .append("count", count)
                                .append("type", type)
                                .toString();
                    }

                    public Integer getCount() {
                        return count;
                    }

                    public void setCount(Integer count) {
                        this.count = count;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }
                }
            }
        }


        public static class AttackerReward {
            public AttackerReward() {
            }

            public AttackerReward(List<CountedItems> countedItems, String thumbnail, Integer color, Integer credits, String asString, String itemString) {
                this.countedItems = countedItems;
                this.thumbnail = thumbnail;
                this.color = color;
                this.credits = credits;
                this.asString = asString;
                this.itemString = itemString;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof AttackerReward)) return false;
                AttackerReward that = (AttackerReward) o;
                return countedItems.equals(that.countedItems) && itemString.equals(that.itemString);
            }

            @Override
            public int hashCode() {
                return Objects.hash(countedItems, itemString);
            }

            @JsonProperty("countedItems")
            private List<CountedItems> countedItems;
            @JsonProperty("thumbnail")
            private String thumbnail;
            @JsonProperty("color")
            private Integer color;
            @JsonProperty("credits")
            private Integer credits;
            @JsonProperty("asString")
            private String asString;
            @JsonProperty("itemString")
            private String itemString;

            public List<CountedItems> getCountedItems() {
                return countedItems;
            }

            public void setCountedItems(List<CountedItems> countedItems) {
                this.countedItems = countedItems;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public Integer getColor() {
                return color;
            }

            public void setColor(Integer color) {
                this.color = color;
            }

            public Integer getCredits() {
                return credits;
            }

            public void setCredits(Integer credits) {
                this.credits = credits;
            }

            public String getAsString() {
                return asString;
            }

            public void setAsString(String asString) {
                this.asString = asString;
            }

            public String getItemString() {
                return itemString;
            }

            public void setItemString(String itemString) {
                this.itemString = itemString;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("countedItems", countedItems).append("thumbnail", thumbnail).append("color", color).append("credits", credits).append("asString", asString).append("itemString", itemString).toString();
            }

            public static class CountedItems {

                public CountedItems() {
                }

                public CountedItems(Integer count, String type) {
                    this.count = count;
                    this.type = type;
                }

                @JsonProperty("count")
                private Integer count;
                @JsonProperty("type")
                private String type;

                public Integer getCount() {
                    return count;
                }

                public void setCount(Integer count) {
                    this.count = count;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                @Override
                public String toString() {
                    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("count", count).append("type", type).toString();
                }
            }

        }


        public static class Defender {

            public Defender() {
            }

            public Defender(Reward reward, String faction, String factionKey) {
                this.reward = reward;
                this.faction = faction;
                this.factionKey = factionKey;
            }

            @JsonProperty("reward")
            private Reward reward;
            @JsonProperty("faction")
            private String faction;
            @JsonProperty("factionKey")
            private String factionKey;

            public Reward getReward() {
                return reward;
            }

            public void setReward(Reward reward) {
                this.reward = reward;
            }

            public String getFaction() {
                return faction;
            }

            public void setFaction(String faction) {
                this.faction = faction;
            }

            public String getFactionKey() {
                return factionKey;
            }

            public void setFactionKey(String factionKey) {
                this.factionKey = factionKey;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("reward", reward).append("faction", faction).append("factionKey", factionKey).toString();
            }

            public static class Reward {

                public Reward() {
                }

                public Reward(List<CountedItems> countedItems, String thumbnail, Integer color, Integer credits, String asString, String itemString) {
                    this.countedItems = countedItems;
                    this.thumbnail = thumbnail;
                    this.color = color;
                    this.credits = credits;
                    this.asString = asString;
                    this.itemString = itemString;
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (!(o instanceof Reward)) return false;
                    Reward reward = (Reward) o;
                    return countedItems.equals(reward.countedItems) && itemString.equals(reward.itemString);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(countedItems, itemString);
                }

                @JsonProperty("countedItems")
                private List<CountedItems> countedItems;
                @JsonProperty("thumbnail")
                private String thumbnail;
                @JsonProperty("color")
                private Integer color;
                @JsonProperty("credits")
                private Integer credits;
                @JsonProperty("asString")
                private String asString;
                @JsonProperty("itemString")
                private String itemString;

                public List<CountedItems> getCountedItems() {
                    return countedItems;
                }

                public void setCountedItems(List<CountedItems> countedItems) {
                    this.countedItems = countedItems;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public Integer getColor() {
                    return color;
                }

                public void setColor(Integer color) {
                    this.color = color;
                }

                public Integer getCredits() {
                    return credits;
                }

                public void setCredits(Integer credits) {
                    this.credits = credits;
                }

                public String getAsString() {
                    return asString;
                }

                public void setAsString(String asString) {
                    this.asString = asString;
                }

                public String getItemString() {
                    return itemString;
                }

                public void setItemString(String itemString) {
                    this.itemString = itemString;
                }

                @Override
                public String toString() {
                    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("countedItems", countedItems).append("thumbnail", thumbnail).append("color", color).append("credits", credits).append("asString", asString).append("itemString", itemString).toString();
                }


                public static class CountedItems {


                    public CountedItems() {
                    }

                    public CountedItems(Integer count, String type) {
                        this.count = count;
                        this.type = type;
                    }

                    @JsonProperty("count")
                    private Integer count;
                    @JsonProperty("type")
                    private String type;

                    public Integer getCount() {
                        return count;
                    }

                    public void setCount(Integer count) {
                        this.count = count;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    @Override
                    public String toString() {
                        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("count", count).append("type", type).toString();
                    }
                }

            }

        }


        public static class DefenderReward {

            public DefenderReward() {
            }

            public DefenderReward(List<CountedItems> countedItems, String thumbnail, Integer color, Integer credits, String asString, String itemString) {
                this.countedItems = countedItems;
                this.thumbnail = thumbnail;
                this.color = color;
                this.credits = credits;
                this.asString = asString;
                this.itemString = itemString;
            }

            @JsonProperty("countedItems")
            private List<CountedItems> countedItems;
            @JsonProperty("thumbnail")
            private String thumbnail;
            @JsonProperty("color")
            private Integer color;
            @JsonProperty("credits")
            private Integer credits;
            @JsonProperty("asString")
            private String asString;
            @JsonProperty("itemString")
            private String itemString;

            public List<CountedItems> getCountedItems() {
                return countedItems;
            }

            public void setCountedItems(List<CountedItems> countedItems) {
                this.countedItems = countedItems;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public Integer getColor() {
                return color;
            }

            public void setColor(Integer color) {
                this.color = color;
            }

            public Integer getCredits() {
                return credits;
            }

            public void setCredits(Integer credits) {
                this.credits = credits;
            }

            public String getAsString() {
                return asString;
            }

            public void setAsString(String asString) {
                this.asString = asString;
            }

            public String getItemString() {
                return itemString;
            }

            public void setItemString(String itemString) {
                this.itemString = itemString;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("countedItems", countedItems).append("thumbnail", thumbnail).append("color", color).append("credits", credits).append("asString", asString).append("itemString", itemString).toString();
            }


            public static class CountedItems {

                public CountedItems() {
                }

                public CountedItems(Integer count, String type) {
                    this.count = count;
                    this.type = type;
                }

                @JsonProperty("count")
                private Integer count;
                @JsonProperty("type")
                private String type;

                public Integer getCount() {
                    return count;
                }

                public void setCount(Integer count) {
                    this.count = count;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                @Override
                public String toString() {
                    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("count", count).append("type", type).toString();
                }

            }


        }
    }

    public static class News {

        public News(Date date, String imageLink, String eta, Boolean primeAccess, Boolean stream, Translations translations, String link, Boolean update, String id, String asString, String message, Boolean priority) {
            this.date = date;
            this.imageLink = imageLink;
            this.eta = eta;
            this.primeAccess = primeAccess;
            this.stream = stream;
            this.translations = translations;
            this.link = link;
            this.update = update;
            this.id = id;
            this.asString = asString;
            this.message = message;
            this.priority = priority;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof News)) return false;
            News news = (News) o;
            return message.equals(news.message);
        }

        @Override
        public int hashCode() {
            return Objects.hash(message);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("date", date)
                    .append("imageLink", imageLink)
                    .append("eta", eta)
                    .append("primeAccess", primeAccess)
                    .append("stream", stream)
                    .append("translations", translations)
                    .append("link", link)
                    .append("update", update)
                    .append("id", id)
                    .append("asString", asString)
                    .append("message", message)
                    .append("priority", priority)
                    .toString();
        }

        public News() {
        }

        @JsonProperty("date")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date date;
        @JsonProperty("imageLink")
        private String imageLink;
        @JsonProperty("eta")
        private String eta;
        @JsonProperty("primeAccess")
        private Boolean primeAccess;
        @JsonProperty("stream")
        private Boolean stream;
        @JsonProperty("translations")
        private Translations translations;
        @JsonProperty("link")
        private String link;
        @JsonProperty("update")
        private Boolean update;
        @JsonProperty("id")
        private String id;
        @JsonProperty("asString")
        private String asString;
        @JsonProperty("message")
        private String message;
        @JsonProperty("priority")
        private Boolean priority;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getImageLink() {
            return imageLink;
        }

        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }

        public String getEta() {
            return eta;
        }

        public void setEta(String eta) {
            this.eta = eta;
        }

        public Boolean getPrimeAccess() {
            return primeAccess;
        }

        public void setPrimeAccess(Boolean primeAccess) {
            this.primeAccess = primeAccess;
        }

        public Boolean getStream() {
            return stream;
        }

        public void setStream(Boolean stream) {
            this.stream = stream;
        }

        public Translations getTranslations() {
            return translations;
        }

        public void setTranslations(Translations translations) {
            this.translations = translations;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Boolean getUpdate() {
            return update;
        }

        public void setUpdate(Boolean update) {
            this.update = update;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAsString() {
            return asString;
        }

        public void setAsString(String asString) {
            this.asString = asString;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Boolean getPriority() {
            return priority;
        }

        public void setPriority(Boolean priority) {
            this.priority = priority;
        }


        public static class Translations {

            public Translations() {
            }

            public Translations(String es, String zh) {
                this.es = es;
                this.zh = zh;
            }

            @JsonProperty("es")
            private String es;
            @JsonProperty("zh")
            private String zh;

            public String getEs() {
                return es;
            }

            public void setEs(String es) {
                this.es = es;
            }

            public String getZh() {
                return zh;
            }

            public void setZh(String zh) {
                this.zh = zh;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("es", es)
                        .append("zh", zh)
                        .toString();
            }
        }
    }


    public static class SyndicateMissions {
        public SyndicateMissions(List<String> nodes, String eta, List<Jobs> jobs, String syndicate, String id, Date activation, Date expiry) {
            this.nodes = nodes;
            this.eta = eta;
            this.jobs = jobs;
            this.syndicate = syndicate;
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SyndicateMissions)) return false;
            SyndicateMissions that = (SyndicateMissions) o;
            return nodes.equals(that.nodes) && jobs.equals(that.jobs);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nodes, jobs);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("nodes", nodes)
                    .append("eta", eta)
                    .append("jobs", jobs)
                    .append("syndicate", syndicate)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .toString();
        }

        public SyndicateMissions() {
        }

        @JsonProperty("nodes")
        private List<String> nodes;
        @JsonProperty("eta")
        private String eta;
        @JsonProperty("jobs")
        private List<Jobs> jobs;
        @JsonProperty("syndicate")
        private String syndicate;
        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;

        public List<String> getNodes() {
            return nodes;
        }

        public void setNodes(List<String> nodes) {
            this.nodes = nodes;
        }

        public String getEta() {
            return eta;
        }

        public void setEta(String eta) {
            this.eta = eta;
        }

        public List<Jobs> getJobs() {
            return jobs;
        }

        public void setJobs(List<Jobs> jobs) {
            this.jobs = jobs;
        }

        public String getSyndicate() {
            return syndicate;
        }

        public void setSyndicate(String syndicate) {
            this.syndicate = syndicate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }


        public static class Jobs {

            public Jobs() {
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Jobs)) return false;
                Jobs jobs = (Jobs) o;
                return rewardPool.equals(jobs.rewardPool);
            }

            @Override
            public int hashCode() {
                return Objects.hash(rewardPool);
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("activation", activation)
                        .append("expiry", expiry)
                        .append("rewardPool", rewardPool)
                        .append("type", type)
                        .append("enemyLevels", enemyLevels)
                        .append("standingStages", standingStages)
                        .append("minMR", minMR)
                        .toString();
            }


            public String getActivation() {
                return activation;
            }

            public void setActivation(String activation) {
                this.activation = activation;
            }

            public String getExpiry() {
                return expiry;
            }

            public void setExpiry(String expiry) {
                this.expiry = expiry;
            }

            public List<String> getRewardPool() {
                return rewardPool;
            }

            public void setRewardPool(List<String> rewardPool) {
                this.rewardPool = rewardPool;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Integer> getEnemyLevels() {
                return enemyLevels;
            }

            public void setEnemyLevels(List<Integer> enemyLevels) {
                this.enemyLevels = enemyLevels;
            }

            public List<Integer> getStandingStages() {
                return standingStages;
            }

            public void setStandingStages(List<Integer> standingStages) {
                this.standingStages = standingStages;
            }

            public Integer getMinMR() {
                return minMR;
            }

            public void setMinMR(Integer minMR) {
                this.minMR = minMR;
            }

            @JsonProperty("activation")
            private String activation;
            @JsonProperty("expiry")
            private String expiry;
            @JsonProperty("rewardPool")
            private List<String> rewardPool;
            @JsonProperty("type")
            private String type;
            @JsonProperty("enemyLevels")
            private List<Integer> enemyLevels;
            @JsonProperty("standingStages")
            private List<Integer> standingStages;
            @JsonProperty("minMR")
            private Integer minMR;
        }
    }


    public static class Arbitration {

        public Arbitration() {
        }

        public Arbitration(Date activation, Date expiry, String node, String enemy, String type, Boolean archwing, Boolean sharkwing) {
            this.activation = activation;
            this.expiry = expiry;
            this.node = node;
            this.enemy = enemy;
            this.type = type;
            this.archwing = archwing;
            this.sharkwing = sharkwing;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Arbitration)) return false;
            Arbitration that = (Arbitration) o;
            return node.equals(that.node) && enemy.equals(that.enemy) && type.equals(that.type) && archwing.equals(that.archwing) && sharkwing.equals(that.sharkwing);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, enemy, type, archwing, sharkwing);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("node", node)
                    .append("enemy", enemy)
                    .append("type", type)
                    .append("archwing", archwing)
                    .append("sharkwing", sharkwing)
                    .toString();
        }

        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("node")
        private String node;
        @JsonProperty("enemy")
        private String enemy;
        @JsonProperty("type")
        private String type;
        @JsonProperty("archwing")
        private Boolean archwing;
        @JsonProperty("sharkwing")
        private Boolean sharkwing;

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }

        public String getEnemy() {
            return enemy;
        }

        public void setEnemy(String enemy) {
            this.enemy = enemy;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Boolean getArchwing() {
            return archwing;
        }

        public void setArchwing(Boolean archwing) {
            this.archwing = archwing;
        }

        public Boolean getSharkwing() {
            return sharkwing;
        }

        public void setSharkwing(Boolean sharkwing) {
            this.sharkwing = sharkwing;
        }
    }


    public static class CambionCycle {

        public CambionCycle() {
        }

        public CambionCycle(String id, Date expiry, Date activation, String active, String timeLeft) {
            this.id = id;
            this.expiry = expiry;
            this.activation = activation;
            this.active = active;
            this.timeLeft = timeLeft;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CambionCycle)) return false;
            CambionCycle that = (CambionCycle) o;
            return id.equals(that.id) && active.equals(that.active);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, active);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("expiry", expiry)
                    .append("activation", activation)
                    .append("active", active)
                    .append("timeLeft", timeLeft)
                    .toString();
        }


        @JsonProperty("id")
        private String id;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("active")
        private String active;
        @JsonProperty("timeLeft")
        private String timeLeft;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getTimeLeft() {
            return timeLeft;
        }

        public void setTimeLeft(String timeLeft) {
            this.timeLeft = timeLeft;
        }
    }


    public static class CetusCycle {

        public CetusCycle() {
        }

        public CetusCycle(String id, Date expiry, Date activation, Boolean isDay, String state, String timeLeft, Boolean isCetus, String shortString) {
            this.id = id;
            this.expiry = expiry;
            this.activation = activation;
            this.isDay = isDay;
            this.state = state;
            this.timeLeft = timeLeft;
            this.isCetus = isCetus;
            this.shortString = shortString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CetusCycle)) return false;
            CetusCycle that = (CetusCycle) o;
            return isDay.equals(that.isDay) && state.equals(that.state) && isCetus.equals(that.isCetus);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isDay, state, isCetus);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("expiry", expiry)
                    .append("activation", activation)
                    .append("isDay", isDay)
                    .append("state", state)
                    .append("timeLeft", timeLeft)
                    .append("isCetus", isCetus)
                    .append("shortString", shortString)
                    .toString();
        }

        @JsonProperty("id")
        private String id;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("isDay")
        private Boolean isDay;
        @JsonProperty("state")
        private String state;
        @JsonProperty("timeLeft")
        private String timeLeft;
        @JsonProperty("isCetus")
        private Boolean isCetus;
        @JsonProperty("shortString")
        private String shortString;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Boolean getDay() {
            return isDay;
        }

        public void setDay(Boolean day) {
            isDay = day;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTimeLeft() {
            return timeLeft;
        }

        public void setTimeLeft(String timeLeft) {
            this.timeLeft = timeLeft;
        }

        public Boolean getCetus() {
            return isCetus;
        }

        public void setCetus(Boolean cetus) {
            isCetus = cetus;
        }

        public String getShortString() {
            return shortString;
        }

        public void setShortString(String shortString) {
            this.shortString = shortString;
        }
    }


    public static class ConstructionProgress {

        public ConstructionProgress() {
        }

        public ConstructionProgress(String id, String fomorianProgress, String razorbackProgress, String unknownProgress) {
            this.id = id;
            this.fomorianProgress = fomorianProgress;
            this.razorbackProgress = razorbackProgress;
            this.unknownProgress = unknownProgress;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("fomorianProgress", fomorianProgress)
                    .append("razorbackProgress", razorbackProgress)
                    .append("unknownProgress", unknownProgress)
                    .toString();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFomorianProgress() {
            return fomorianProgress;
        }

        public void setFomorianProgress(String fomorianProgress) {
            this.fomorianProgress = fomorianProgress;
        }

        public String getRazorbackProgress() {
            return razorbackProgress;
        }

        public void setRazorbackProgress(String razorbackProgress) {
            this.razorbackProgress = razorbackProgress;
        }

        public String getUnknownProgress() {
            return unknownProgress;
        }

        public void setUnknownProgress(String unknownProgress) {
            this.unknownProgress = unknownProgress;
        }

        @JsonProperty("id")
        private String id;
        @JsonProperty("fomorianProgress")
        private String fomorianProgress;
        @JsonProperty("razorbackProgress")
        private String razorbackProgress;
        @JsonProperty("unknownProgress")
        private String unknownProgress;
    }


    public static class EarthCycle {

        public EarthCycle() {
        }

        public EarthCycle(String id, Date activation, Date expiry, Boolean isDay, String state, String timeLeft) {
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.isDay = isDay;
            this.state = state;
            this.timeLeft = timeLeft;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof EarthCycle)) return false;
            EarthCycle that = (EarthCycle) o;
            return isDay.equals(that.isDay) && state.equals(that.state);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isDay, state);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("isDay", isDay)
                    .append("state", state)
                    .append("timeLeft", timeLeft)
                    .toString();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public Boolean getDay() {
            return isDay;
        }

        public void setDay(Boolean day) {
            isDay = day;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTimeLeft() {
            return timeLeft;
        }

        public void setTimeLeft(String timeLeft) {
            this.timeLeft = timeLeft;
        }

        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("isDay")
        private Boolean isDay;
        @JsonProperty("state")
        private String state;
        @JsonProperty("timeLeft")
        private String timeLeft;
    }


    public static class Nightwave {

        public Nightwave() {
        }

        public Nightwave(String id, Date activation, Date expiry, List<String> rewardTypes, Integer season, String tag, Integer phase, List<ActiveChallenges> activeChallenges) {
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.rewardTypes = rewardTypes;
            this.season = season;
            this.tag = tag;
            this.phase = phase;
            this.activeChallenges = activeChallenges;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Nightwave)) return false;
            Nightwave nightwave = (Nightwave) o;
            return season.equals(nightwave.season) && activeChallenges.equals(nightwave.activeChallenges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(season, activeChallenges);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("rewardTypes", rewardTypes)
                    .append("season", season)
                    .append("tag", tag)
                    .append("phase", phase)
                    .append("activeChallenges", activeChallenges)
                    .toString();
        }

        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("rewardTypes")
        private List<String> rewardTypes;
        @JsonProperty("season")
        private Integer season;
        @JsonProperty("tag")
        private String tag;
        @JsonProperty("phase")
        private Integer phase;
        @JsonProperty("activeChallenges")
        private List<ActiveChallenges> activeChallenges;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public List<String> getRewardTypes() {
            return rewardTypes;
        }

        public void setRewardTypes(List<String> rewardTypes) {
            this.rewardTypes = rewardTypes;
        }

        public Integer getSeason() {
            return season;
        }

        public void setSeason(Integer season) {
            this.season = season;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public Integer getPhase() {
            return phase;
        }

        public void setPhase(Integer phase) {
            this.phase = phase;
        }

        public List<ActiveChallenges> getActiveChallenges() {
            return activeChallenges;
        }

        public void setActiveChallenges(List<ActiveChallenges> activeChallenges) {
            this.activeChallenges = activeChallenges;
        }

        public static class ActiveChallenges {

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof ActiveChallenges)) return false;
                ActiveChallenges that = (ActiveChallenges) o;
                return title.equals(that.title) && desc.equals(that.desc);
            }

            @Override
            public int hashCode() {
                return Objects.hash(title, desc);
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("id", id)
                        .append("activation", activation)
                        .append("expiry", expiry)
                        .append("isDaily", isDaily)
                        .append("isElite", isElite)
                        .append("title", title)
                        .append("desc", desc)
                        .append("reputation", reputation)
                        .append("active", active)
                        .toString();
            }

            public ActiveChallenges(String id, Date activation, Date expiry, Boolean isDaily, Boolean isElite, String title, String desc, Integer reputation, Boolean active) {
                this.id = id;
                this.activation = activation;
                this.expiry = expiry;
                this.isDaily = isDaily;
                this.isElite = isElite;
                this.title = title;
                this.desc = desc;
                this.reputation = reputation;
                this.active = active;
            }

            public ActiveChallenges() {
            }

            @JsonProperty("id")
            private String id;
            @JsonProperty("activation")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date activation;
            @JsonProperty("expiry")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date expiry;
            @JsonProperty("isDaily")
            private Boolean isDaily;
            @JsonProperty("isElite")
            private Boolean isElite;
            @JsonProperty("title")
            private String title;
            @JsonProperty("desc")
            private String desc;
            @JsonProperty("reputation")
            private Integer reputation;
            @JsonProperty("active")
            private Boolean active;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Date getActivation() {
                return activation;
            }

            public void setActivation(Date activation) {
                this.activation = activation;
            }

            public Date getExpiry() {
                return expiry;
            }

            public void setExpiry(Date expiry) {
                this.expiry = expiry;
            }

            public Boolean getDaily() {
                return isDaily;
            }

            public void setDaily(Boolean daily) {
                isDaily = daily;
            }

            public Boolean getElite() {
                return isElite;
            }

            public void setElite(Boolean elite) {
                isElite = elite;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public Integer getReputation() {
                return reputation;
            }

            public void setReputation(Integer reputation) {
                this.reputation = reputation;
            }

            public Boolean getActive() {
                return active;
            }

            public void setActive(Boolean active) {
                this.active = active;
            }
        }
    }


    public static class Simaris {
        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("target", target)
                    .append("isTargetActive", isTargetActive)
                    .append("asString", asString)
                    .toString();
        }

        public Simaris(String target, Boolean isTargetActive, String asString) {
            this.target = target;
            this.isTargetActive = isTargetActive;
            this.asString = asString;
        }

        public Simaris() {
        }

        @JsonProperty("target")
        private String target;
        @JsonProperty("isTargetActive")
        private Boolean isTargetActive;
        @JsonProperty("asString")
        private String asString;

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public Boolean getTargetActive() {
            return isTargetActive;
        }

        public void setTargetActive(Boolean targetActive) {
            isTargetActive = targetActive;
        }

        public String getAsString() {
            return asString;
        }

        public void setAsString(String asString) {
            this.asString = asString;
        }
    }

    public static class Sortie {

        public Sortie() {
        }

        public Sortie(String id, Date activation, Date expiry, String rewardPool, List<Variants> variants, String boss, String faction, Boolean expired, String eta) {
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.rewardPool = rewardPool;
            this.variants = variants;
            this.boss = boss;
            this.faction = faction;
            this.expired = expired;
            this.eta = eta;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Sortie)) return false;
            Sortie sortie = (Sortie) o;
            return variants.equals(sortie.variants) && boss.equals(sortie.boss);
        }

        @Override
        public int hashCode() {
            return Objects.hash(variants, boss);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("rewardPool", rewardPool)
                    .append("variants", variants)
                    .append("boss", boss)
                    .append("faction", faction)
                    .append("expired", expired)
                    .append("eta", eta)
                    .toString();
        }

        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("rewardPool")
        private String rewardPool;
        @JsonProperty("variants")
        private List<Variants> variants;
        @JsonProperty("boss")
        private String boss;
        @JsonProperty("faction")
        private String faction;
        @JsonProperty("expired")
        private Boolean expired;
        @JsonProperty("eta")
        private String eta;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public String getRewardPool() {
            return rewardPool;
        }

        public void setRewardPool(String rewardPool) {
            this.rewardPool = rewardPool;
        }

        public List<Variants> getVariants() {
            return variants;
        }

        public void setVariants(List<Variants> variants) {
            this.variants = variants;
        }

        public String getBoss() {
            return boss;
        }

        public void setBoss(String boss) {
            this.boss = boss;
        }

        public String getFaction() {
            return faction;
        }

        public void setFaction(String faction) {
            this.faction = faction;
        }

        public Boolean getExpired() {
            return expired;
        }

        public void setExpired(Boolean expired) {
            this.expired = expired;
        }

        public String getEta() {
            return eta;
        }

        public void setEta(String eta) {
            this.eta = eta;
        }


        public static class Variants {
            public Variants() {
            }

            public Variants(String node, String boss, String missionType, String planet, String modifier, String modifierDescription) {
                this.node = node;
                this.boss = boss;
                this.missionType = missionType;
                this.planet = planet;
                this.modifier = modifier;
                this.modifierDescription = modifierDescription;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("node", node)
                        .append("boss", boss)
                        .append("missionType", missionType)
                        .append("planet", planet)
                        .append("modifier", modifier)
                        .append("modifierDescription", modifierDescription)
                        .toString();
            }

            @JsonProperty("node")
            private String node;
            @JsonProperty("boss")
            private String boss;
            @JsonProperty("missionType")
            private String missionType;
            @JsonProperty("planet")
            private String planet;
            @JsonProperty("modifier")
            private String modifier;
            @JsonProperty("modifierDescription")
            private String modifierDescription;

            public String getNode() {
                return node;
            }

            public void setNode(String node) {
                this.node = node;
            }

            public String getBoss() {
                return boss;
            }

            public void setBoss(String boss) {
                this.boss = boss;
            }

            public String getMissionType() {
                return missionType;
            }

            public void setMissionType(String missionType) {
                this.missionType = missionType;
            }

            public String getPlanet() {
                return planet;
            }

            public void setPlanet(String planet) {
                this.planet = planet;
            }

            public String getModifier() {
                return modifier;
            }

            public void setModifier(String modifier) {
                this.modifier = modifier;
            }

            public String getModifierDescription() {
                return modifierDescription;
            }

            public void setModifierDescription(String modifierDescription) {
                this.modifierDescription = modifierDescription;
            }
        }
    }

    public static class SteelPath {

        public SteelPath() {
        }

        public SteelPath(Date activation, Date expiry, CurrentReward currentReward, String remaining, List<Rotation> rotation, List<Evergreens> evergreens) {
            this.activation = activation;
            this.expiry = expiry;
            this.currentReward = currentReward;
            this.remaining = remaining;
            this.rotation = rotation;
            this.evergreens = evergreens;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SteelPath)) return false;
            SteelPath steelPath = (SteelPath) o;
            return currentReward.equals(steelPath.currentReward);
        }


        @Override
        public int hashCode() {
            return Objects.hash(currentReward);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("currentReward", currentReward)
                    .append("remaining", remaining)
                    .append("rotation", rotation)
                    .append("evergreens", evergreens)
                    .toString();
        }

        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("currentReward")
        private CurrentReward currentReward;
        @JsonProperty("remaining")
        private String remaining;
        @JsonProperty("rotation")
        private List<Rotation> rotation;
        @JsonProperty("evergreens")
        private List<Evergreens> evergreens;

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public CurrentReward getCurrentReward() {
            return currentReward;
        }

        public void setCurrentReward(CurrentReward currentReward) {
            this.currentReward = currentReward;
        }

        public String getRemaining() {
            return remaining;
        }

        public void setRemaining(String remaining) {
            this.remaining = remaining;
        }

        public List<Rotation> getRotation() {
            return rotation;
        }

        public void setRotation(List<Rotation> rotation) {
            this.rotation = rotation;
        }

        public List<Evergreens> getEvergreens() {
            return evergreens;
        }

        public void setEvergreens(List<Evergreens> evergreens) {
            this.evergreens = evergreens;
        }


        public static class CurrentReward {
            public CurrentReward() {
            }

            public CurrentReward(String name, Integer cost) {
                this.name = name;
                this.cost = cost;
            }

            @JsonProperty("name")
            private String name;
            @JsonProperty("cost")
            private Integer cost;

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("name", name)
                        .append("cost", cost)
                        .toString();
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getCost() {
                return cost;
            }

            public void setCost(Integer cost) {
                this.cost = cost;
            }
        }


        public static class Rotation {
            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("name", name)
                        .append("cost", cost)
                        .toString();
            }

            public Rotation() {
            }

            public Rotation(String name, Integer cost) {
                this.name = name;
                this.cost = cost;
            }

            @JsonProperty("name")
            private String name;
            @JsonProperty("cost")
            private Integer cost;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getCost() {
                return cost;
            }

            public void setCost(Integer cost) {
                this.cost = cost;
            }
        }


        public static class Evergreens {
            public Evergreens() {
            }

            public Evergreens(String name, Integer cost) {
                this.name = name;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("name", name)
                        .append("cost", cost)
                        .toString();
            }

            @JsonProperty("name")
            private String name;
            @JsonProperty("cost")
            private Integer cost;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getCost() {
                return cost;
            }

            public void setCost(Integer cost) {
                this.cost = cost;
            }
        }
    }

    public static class VallisCycle {

        public VallisCycle() {
        }

        public VallisCycle(String id, Date activation, Date expiry, String timeLeft, Boolean isWarm, String state) {
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.timeLeft = timeLeft;
            this.isWarm = isWarm;
            this.state = state;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VallisCycle)) return false;
            VallisCycle that = (VallisCycle) o;
            return isWarm.equals(that.isWarm) && state.equals(that.state);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isWarm, state);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("timeLeft", timeLeft)
                    .append("isWarm", isWarm)
                    .append("state", state)
                    .toString();
        }


        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("timeLeft")
        private String timeLeft;
        @JsonProperty("isWarm")
        private Boolean isWarm;
        @JsonProperty("state")
        private String state;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public String getTimeLeft() {
            return timeLeft;
        }

        public void setTimeLeft(String timeLeft) {
            this.timeLeft = timeLeft;
        }

        public Boolean getWarm() {
            return isWarm;
        }

        public void setWarm(Boolean warm) {
            isWarm = warm;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }


    public static class ZarimanCycle {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ZarimanCycle)) return false;
            ZarimanCycle that = (ZarimanCycle) o;
            return isCorpus.equals(that.isCorpus) && state.equals(that.state);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isCorpus, state);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("bountiesEndDate", bountiesEndDate)
                    .append("isCorpus", isCorpus)
                    .append("state", state)
                    .append("timeLeft", timeLeft)
                    .append("shortString", shortString)
                    .toString();
        }

        public ZarimanCycle() {
        }

        public ZarimanCycle(String id, Date activation, Date expiry, Date bountiesEndDate, Boolean isCorpus, String state, String timeLeft, String shortString) {
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.bountiesEndDate = bountiesEndDate;
            this.isCorpus = isCorpus;
            this.state = state;
            this.timeLeft = timeLeft;
            this.shortString = shortString;
        }


        @JsonProperty("id")
        private String id;

        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;

        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;

        @JsonProperty("bountiesEndDate")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date bountiesEndDate;

        @JsonProperty("isCorpus")
        private Boolean isCorpus;

        @JsonProperty("state")
        private String state;

        @JsonProperty("timeLeft")
        private String timeLeft;

        @JsonProperty("shortString")
        private String shortString;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public Date getBountiesEndDate() {
            return bountiesEndDate;
        }

        public void setBountiesEndDate(Date bountiesEndDate) {
            this.bountiesEndDate = bountiesEndDate;
        }

        public Boolean getCorpus() {
            return isCorpus;
        }

        public void setCorpus(Boolean corpus) {
            isCorpus = corpus;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTimeLeft() {
            return timeLeft;
        }

        public void setTimeLeft(String timeLeft) {
            this.timeLeft = timeLeft;
        }

        public String getShortString() {
            return shortString;
        }

        public void setShortString(String shortString) {
            this.shortString = shortString;
        }
    }


    public static class VoidTrader {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VoidTrader)) return false;
            VoidTrader that = (VoidTrader) o;
            return location.equals(that.location) && inventory.equals(that.inventory) && active.equals(that.active);
        }
        @Override
        public int hashCode() {
            return Objects.hash(location, inventory, active);
        }
        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("character", character)
                    .append("location", location)
                    .append("inventory", inventory)
                    .append("psId", psId)
                    .append("active", active)
                    .append("startString", startString)
                    .append("endString", endString)
                    .toString();
        }
        public VoidTrader() {
        }
        public VoidTrader(String id, Date activation, Date expiry, String character, String location, List<Inventory> inventory, String psId, Boolean active, String startString, String endString) {
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.character = character;
            this.location = location;
            this.inventory = inventory;
            this.psId = psId;
            this.active = active;
            this.startString = startString;
            this.endString = endString;
        }

        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("character")
        private String character;
        @JsonProperty("location")
        private String location;
        @JsonProperty("inventory")
        private List<Inventory> inventory;
        @JsonProperty("psId")
        private String psId;
        @JsonProperty("active")
        private Boolean active;
        @JsonProperty("startString")
        private String startString;
        @JsonProperty("endString")
        private String endString;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public Date getActivation() {
            return activation;
        }
        public void setActivation(Date activation) {
            this.activation = activation;
        }
        public Date getExpiry() {
            return expiry;
        }
        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }
        public String getCharacter() {
            return character;
        }
        public void setCharacter(String character) {
            this.character = character;
        }
        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }
        public List<Inventory> getInventory() {
            return inventory;
        }
        public void setInventory(List<Inventory> inventory) {
            this.inventory = inventory;
        }

        public String getPsId() {
            return psId;
        }

        public void setPsId(String psId) {
            this.psId = psId;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public String getStartString() {
            return startString;
        }

        public void setStartString(String startString) {
            this.startString = startString;
        }

        public String getEndString() {
            return endString;
        }

        public void setEndString(String endString) {
            this.endString = endString;
        }

        public static class Inventory {
            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("item", item)
                        .append("ducats", ducats)
                        .append("credits", credits)
                        .toString();
            }
            public Inventory() {
            }
            public Inventory(String item, Integer ducats, Integer credits) {
                this.item = item;
                this.ducats = ducats;
                this.credits = credits;
            }
            @JsonProperty("item")
            private String item;
            @JsonProperty("ducats")
            private Integer ducats;
            @JsonProperty("credits")
            private Integer credits;
            public String getItem() {
                return item;
            }
            public void setItem(String item) {
                this.item = item;
            }
            public Integer getDucats() {
                return ducats;
            }
            public void setDucats(Integer ducats) {
                this.ducats = ducats;
            }
            public Integer getCredits() {
                return credits;
            }
            public void setCredits(Integer credits) {
                this.credits = credits;
            }
        }
    }

    public static class Alerts {
        public Alerts() {
        }

        public Alerts(Mission mission, Boolean expired, String eta, String id, Date activation, Date expiry, List<String> rewardTypes) {
            this.mission = mission;
            this.expired = expired;
            this.eta = eta;
            this.id = id;
            this.activation = activation;
            this.expiry = expiry;
            this.rewardTypes = rewardTypes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Alerts)) return false;
            Alerts alerts = (Alerts) o;
            return mission.equals(alerts.mission) && expired.equals(alerts.expired) && rewardTypes.equals(alerts.rewardTypes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mission, expired, rewardTypes);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("mission", mission)
                    .append("expired", expired)
                    .append("eta", eta)
                    .append("id", id)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("rewardTypes", rewardTypes)
                    .toString();
        }

        @JsonProperty("mission")
        private Mission mission;
        @JsonProperty("expired")
        private Boolean expired;
        @JsonProperty("eta")
        private String eta;
        @JsonProperty("id")
        private String id;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("rewardTypes")
        private List<String> rewardTypes;

        public Mission getMission() {
            return mission;
        }

        public void setMission(Mission mission) {
            this.mission = mission;
        }

        public Boolean getExpired() {
            return expired;
        }

        public void setExpired(Boolean expired) {
            this.expired = expired;
        }

        public String getEta() {
            return eta;
        }

        public void setEta(String eta) {
            this.eta = eta;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public List<String> getRewardTypes() {
            return rewardTypes;
        }

        public void setRewardTypes(List<String> rewardTypes) {
            this.rewardTypes = rewardTypes;
        }


        public static class Mission {
            public Mission() {
            }

            public Mission(Reward reward, String node, String faction, Integer maxEnemyLevel, Integer minEnemyLevel, Integer maxWaveNum, String type, Boolean nightmare, Boolean archwingRequired, Boolean isSharkwing, String enemySpec, String levelOverride, List<String> advancedSpawners, List<String> requiredItems, Boolean consumeRequiredItems, Boolean leadersAlwaysAllowed, List<String> levelAuras) {
                this.reward = reward;
                this.node = node;
                this.faction = faction;
                this.maxEnemyLevel = maxEnemyLevel;
                this.minEnemyLevel = minEnemyLevel;
                this.maxWaveNum = maxWaveNum;
                this.type = type;
                this.nightmare = nightmare;
                this.archwingRequired = archwingRequired;
                this.isSharkwing = isSharkwing;
                this.enemySpec = enemySpec;
                this.levelOverride = levelOverride;
                this.advancedSpawners = advancedSpawners;
                this.requiredItems = requiredItems;
                this.consumeRequiredItems = consumeRequiredItems;
                this.leadersAlwaysAllowed = leadersAlwaysAllowed;
                this.levelAuras = levelAuras;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("reward", reward)
                        .append("node", node)
                        .append("faction", faction)
                        .append("maxEnemyLevel", maxEnemyLevel)
                        .append("minEnemyLevel", minEnemyLevel)
                        .append("maxWaveNum", maxWaveNum)
                        .append("type", type)
                        .append("nightmare", nightmare)
                        .append("archwingRequired", archwingRequired)
                        .append("isSharkwing", isSharkwing)
                        .append("enemySpec", enemySpec)
                        .append("levelOverride", levelOverride)
                        .append("advancedSpawners", advancedSpawners)
                        .append("requiredItems", requiredItems)
                        .append("consumeRequiredItems", consumeRequiredItems)
                        .append("leadersAlwaysAllowed", leadersAlwaysAllowed)
                        .append("levelAuras", levelAuras)
                        .toString();
            }

            @JsonProperty("reward")
            private Reward reward;
            @JsonProperty("node")
            private String node;
            @JsonProperty("faction")
            private String faction;
            @JsonProperty("maxEnemyLevel")
            private Integer maxEnemyLevel;
            @JsonProperty("minEnemyLevel")
            private Integer minEnemyLevel;
            @JsonProperty("maxWaveNum")
            private Integer maxWaveNum;
            @JsonProperty("type")
            private String type;
            @JsonProperty("nightmare")
            private Boolean nightmare;
            @JsonProperty("archwingRequired")
            private Boolean archwingRequired;
            @JsonProperty("isSharkwing")
            private Boolean isSharkwing;
            @JsonProperty("enemySpec")
            private String enemySpec;
            @JsonProperty("levelOverride")
            private String levelOverride;
            @JsonProperty("advancedSpawners")
            private List<String> advancedSpawners;
            @JsonProperty("requiredItems")
            private List<String> requiredItems;
            @JsonProperty("consumeRequiredItems")
            private Boolean consumeRequiredItems;
            @JsonProperty("leadersAlwaysAllowed")
            private Boolean leadersAlwaysAllowed;
            @JsonProperty("levelAuras")
            private List<String> levelAuras;

            public Reward getReward() {
                return reward;
            }

            public void setReward(Reward reward) {
                this.reward = reward;
            }

            public String getNode() {
                return node;
            }

            public void setNode(String node) {
                this.node = node;
            }

            public String getFaction() {
                return faction;
            }

            public void setFaction(String faction) {
                this.faction = faction;
            }

            public Integer getMaxEnemyLevel() {
                return maxEnemyLevel;
            }

            public void setMaxEnemyLevel(Integer maxEnemyLevel) {
                this.maxEnemyLevel = maxEnemyLevel;
            }

            public Integer getMinEnemyLevel() {
                return minEnemyLevel;
            }

            public void setMinEnemyLevel(Integer minEnemyLevel) {
                this.minEnemyLevel = minEnemyLevel;
            }

            public Integer getMaxWaveNum() {
                return maxWaveNum;
            }

            public void setMaxWaveNum(Integer maxWaveNum) {
                this.maxWaveNum = maxWaveNum;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Boolean getNightmare() {
                return nightmare;
            }

            public void setNightmare(Boolean nightmare) {
                this.nightmare = nightmare;
            }

            public Boolean getArchwingRequired() {
                return archwingRequired;
            }

            public void setArchwingRequired(Boolean archwingRequired) {
                this.archwingRequired = archwingRequired;
            }

            public Boolean getSharkwing() {
                return isSharkwing;
            }

            public void setSharkwing(Boolean sharkwing) {
                isSharkwing = sharkwing;
            }

            public String getEnemySpec() {
                return enemySpec;
            }

            public void setEnemySpec(String enemySpec) {
                this.enemySpec = enemySpec;
            }

            public String getLevelOverride() {
                return levelOverride;
            }

            public void setLevelOverride(String levelOverride) {
                this.levelOverride = levelOverride;
            }

            public List<String> getAdvancedSpawners() {
                return advancedSpawners;
            }

            public void setAdvancedSpawners(List<String> advancedSpawners) {
                this.advancedSpawners = advancedSpawners;
            }

            public List<String> getRequiredItems() {
                return requiredItems;
            }

            public void setRequiredItems(List<String> requiredItems) {
                this.requiredItems = requiredItems;
            }

            public Boolean getConsumeRequiredItems() {
                return consumeRequiredItems;
            }

            public void setConsumeRequiredItems(Boolean consumeRequiredItems) {
                this.consumeRequiredItems = consumeRequiredItems;
            }

            public Boolean getLeadersAlwaysAllowed() {
                return leadersAlwaysAllowed;
            }

            public void setLeadersAlwaysAllowed(Boolean leadersAlwaysAllowed) {
                this.leadersAlwaysAllowed = leadersAlwaysAllowed;
            }

            public List<String> getLevelAuras() {
                return levelAuras;
            }

            public void setLevelAuras(List<String> levelAuras) {
                this.levelAuras = levelAuras;
            }



            public static class Reward {
                public Reward() {
                }

                public Reward(List<CountedItems> countedItems, String thumbnail, Integer color, Integer credits, String asString, List<String> items, String itemString) {
                    this.countedItems = countedItems;
                    this.thumbnail = thumbnail;
                    this.color = color;
                    this.credits = credits;
                    this.asString = asString;
                    this.items = items;
                    this.itemString = itemString;
                }

                @Override
                public String toString() {
                    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                            .append("countedItems", countedItems)
                            .append("thumbnail", thumbnail)
                            .append("color", color)
                            .append("credits", credits)
                            .append("asString", asString)
                            .append("items", items)
                            .append("itemString", itemString)
                            .toString();
                }

                @JsonProperty("countedItems")
                private List<CountedItems> countedItems;
                @JsonProperty("thumbnail")
                private String thumbnail;
                @JsonProperty("color")
                private Integer color;
                @JsonProperty("credits")
                private Integer credits;
                @JsonProperty("asString")
                private String asString;
                @JsonProperty("items")
                private List<String> items;
                @JsonProperty("itemString")
                private String itemString;

                public List<CountedItems> getCountedItems() {
                    return countedItems;
                }

                public void setCountedItems(List<CountedItems> countedItems) {
                    this.countedItems = countedItems;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public Integer getColor() {
                    return color;
                }

                public void setColor(Integer color) {
                    this.color = color;
                }

                public Integer getCredits() {
                    return credits;
                }

                public void setCredits(Integer credits) {
                    this.credits = credits;
                }

                public String getAsString() {
                    return asString;
                }

                public void setAsString(String asString) {
                    this.asString = asString;
                }

                public List<String> getItems() {
                    return items;
                }

                public void setItems(List<String> items) {
                    this.items = items;
                }

                public String getItemString() {
                    return itemString;
                }

                public void setItemString(String itemString) {
                    this.itemString = itemString;
                }


                public static class CountedItems {
                    public CountedItems() {
                    }

                    public CountedItems(Integer count, String type) {
                        this.count = count;
                        this.type = type;
                    }

                    @Override
                    public String toString() {
                        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                                .append("count", count)
                                .append("type", type)
                                .toString();
                    }

                    @JsonProperty("count")
                    private Integer count;
                    @JsonProperty("type")
                    private String type;

                    public Integer getCount() {
                        return count;
                    }

                    public void setCount(Integer count) {
                        this.count = count;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }
                }
            }
        }
    }

    public static class DailyDeals {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DailyDeals)) return false;
            DailyDeals that = (DailyDeals) o;
            return item.equals(that.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("sold", sold)
                    .append("item", item)
                    .append("total", total)
                    .append("eta", eta)
                    .append("originalPrice", originalPrice)
                    .append("salePrice", salePrice)
                    .append("discount", discount)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("id", id)
                    .toString();
        }

        public DailyDeals() {
        }

        public DailyDeals(Integer sold, String item, Integer total, String eta, Integer originalPrice, Integer salePrice, Integer discount, Date activation, Date expiry, String id) {
            this.sold = sold;
            this.item = item;
            this.total = total;
            this.eta = eta;
            this.originalPrice = originalPrice;
            this.salePrice = salePrice;
            this.discount = discount;
            this.activation = activation;
            this.expiry = expiry;
            this.id = id;
        }

        @JsonProperty("sold")
        private Integer sold;
        @JsonProperty("item")
        private String item;
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("eta")
        private String eta;
        @JsonProperty("originalPrice")
        private Integer originalPrice;
        @JsonProperty("salePrice")
        private Integer salePrice;
        @JsonProperty("discount")
        private Integer discount;
        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("id")
        private String id;

        public Integer getSold() {
            return sold;
        }

        public void setSold(Integer sold) {
            this.sold = sold;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public String getEta() {
            return eta;
        }

        public void setEta(String eta) {
            this.eta = eta;
        }

        public Integer getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(Integer originalPrice) {
            this.originalPrice = originalPrice;
        }

        public Integer getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(Integer salePrice) {
            this.salePrice = salePrice;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Events {
        public Events() {
        }

        public Events(Date activation, Date expiry, Integer maximumScore, Integer currentScore, Integer smallInterval, Integer largeInterval, String faction, String description, String tooltip, String node, List<String> concurrentNodes, String victimNode, String scoreLocTag, List<Rewards> rewards, Boolean expired, Integer health, String affiliatedWith, Integer progressTotal, Boolean showTotalAtEndOfMission, Boolean isPersonal, Boolean isCommunity, List<String> regionDrops, List<String> archwingDrops, String asString, List<Integer> completionBonuses, String scoreVar, Date altExpiry, Date altActivation) {
            this.activation = activation;
            this.expiry = expiry;
            this.maximumScore = maximumScore;
            this.currentScore = currentScore;
            this.smallInterval = smallInterval;
            this.largeInterval = largeInterval;
            this.faction = faction;
            this.description = description;
            this.tooltip = tooltip;
            this.node = node;
            this.concurrentNodes = concurrentNodes;
            this.victimNode = victimNode;
            this.scoreLocTag = scoreLocTag;
            this.rewards = rewards;
            this.expired = expired;
            this.health = health;
            this.affiliatedWith = affiliatedWith;
            this.progressTotal = progressTotal;
            this.showTotalAtEndOfMission = showTotalAtEndOfMission;
            this.isPersonal = isPersonal;
            this.isCommunity = isCommunity;
            this.regionDrops = regionDrops;
            this.archwingDrops = archwingDrops;
            this.asString = asString;
            this.completionBonuses = completionBonuses;
            this.scoreVar = scoreVar;
            this.altExpiry = altExpiry;
            this.altActivation = altActivation;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Events)) return false;
            Events events = (Events) o;
            return description.equals(events.description) && rewards.equals(events.rewards);
        }

        @Override
        public int hashCode() {
            return Objects.hash(description, rewards);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("activation", activation)
                    .append("expiry", expiry)
                    .append("maximumScore", maximumScore)
                    .append("currentScore", currentScore)
                    .append("smallInterval", smallInterval)
                    .append("largeInterval", largeInterval)
                    .append("faction", faction)
                    .append("description", description)
                    .append("tooltip", tooltip)
                    .append("node", node)
                    .append("concurrentNodes", concurrentNodes)
                    .append("victimNode", victimNode)
                    .append("scoreLocTag", scoreLocTag)
                    .append("rewards", rewards)
                    .append("expired", expired)
                    .append("health", health)
                    .append("affiliatedWith", affiliatedWith)
                    .append("progressTotal", progressTotal)
                    .append("showTotalAtEndOfMission", showTotalAtEndOfMission)
                    .append("isPersonal", isPersonal)
                    .append("isCommunity", isCommunity)
                    .append("regionDrops", regionDrops)
                    .append("archwingDrops", archwingDrops)
                    .append("asString", asString)
                    .append("completionBonuses", completionBonuses)
                    .append("scoreVar", scoreVar)
                    .append("altExpiry", altExpiry)
                    .append("altActivation", altActivation)
                    .toString();
        }

        @JsonProperty("activation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date activation;
        @JsonProperty("expiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date expiry;
        @JsonProperty("maximumScore")
        private Integer maximumScore;
        @JsonProperty("currentScore")
        private Integer currentScore;
        @JsonProperty("smallInterval")
        private Integer smallInterval;
        @JsonProperty("largeInterval")
        private Integer largeInterval;
        @JsonProperty("faction")
        private String faction;
        @JsonProperty("description")
        private String description;
        @JsonProperty("tooltip")
        private String tooltip;
        @JsonProperty("node")
        private String node;
        @JsonProperty("concurrentNodes")
        private List<String> concurrentNodes;
        @JsonProperty("victimNode")
        private String victimNode;
        @JsonProperty("scoreLocTag")
        private String scoreLocTag;
        @JsonProperty("rewards")
        private List<Rewards> rewards;
        @JsonProperty("expired")
        private Boolean expired;
        @JsonProperty("health")
        private Integer health;
        @JsonProperty("affiliatedWith")
        private String affiliatedWith;
        @JsonProperty("progressTotal")
        private Integer progressTotal;
        @JsonProperty("showTotalAtEndOfMission")
        private Boolean showTotalAtEndOfMission;
        @JsonProperty("isPersonal")
        private Boolean isPersonal;
        @JsonProperty("isCommunity")
        private Boolean isCommunity;
        @JsonProperty("regionDrops")
        private List<String> regionDrops;
        @JsonProperty("archwingDrops")
        private List<String> archwingDrops;
        @JsonProperty("asString")
        private String asString;
        @JsonProperty("metadata")
        private List<Integer> completionBonuses;
        @JsonProperty("scoreVar")
        private String scoreVar;
        @JsonProperty("altExpiry")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date altExpiry;
        @JsonProperty("altActivation")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date altActivation;

        public Date getActivation() {
            return activation;
        }

        public void setActivation(Date activation) {
            this.activation = activation;
        }

        public Date getExpiry() {
            return expiry;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }

        public Integer getMaximumScore() {
            return maximumScore;
        }

        public void setMaximumScore(Integer maximumScore) {
            this.maximumScore = maximumScore;
        }

        public Integer getCurrentScore() {
            return currentScore;
        }

        public void setCurrentScore(Integer currentScore) {
            this.currentScore = currentScore;
        }

        public Integer getSmallInterval() {
            return smallInterval;
        }

        public void setSmallInterval(Integer smallInterval) {
            this.smallInterval = smallInterval;
        }

        public Integer getLargeInterval() {
            return largeInterval;
        }

        public void setLargeInterval(Integer largeInterval) {
            this.largeInterval = largeInterval;
        }

        public String getFaction() {
            return faction;
        }

        public void setFaction(String faction) {
            this.faction = faction;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTooltip() {
            return tooltip;
        }

        public void setTooltip(String tooltip) {
            this.tooltip = tooltip;
        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }

        public List<String> getConcurrentNodes() {
            return concurrentNodes;
        }

        public void setConcurrentNodes(List<String> concurrentNodes) {
            this.concurrentNodes = concurrentNodes;
        }

        public String getVictimNode() {
            return victimNode;
        }

        public void setVictimNode(String victimNode) {
            this.victimNode = victimNode;
        }

        public String getScoreLocTag() {
            return scoreLocTag;
        }

        public void setScoreLocTag(String scoreLocTag) {
            this.scoreLocTag = scoreLocTag;
        }

        public List<Rewards> getRewards() {
            return rewards;
        }

        public void setRewards(List<Rewards> rewards) {
            this.rewards = rewards;
        }

        public Boolean getExpired() {
            return expired;
        }

        public void setExpired(Boolean expired) {
            this.expired = expired;
        }

        public Integer getHealth() {
            return health;
        }

        public void setHealth(Integer health) {
            this.health = health;
        }

        public String getAffiliatedWith() {
            return affiliatedWith;
        }

        public void setAffiliatedWith(String affiliatedWith) {
            this.affiliatedWith = affiliatedWith;
        }

        public Integer getProgressTotal() {
            return progressTotal;
        }

        public void setProgressTotal(Integer progressTotal) {
            this.progressTotal = progressTotal;
        }

        public Boolean getShowTotalAtEndOfMission() {
            return showTotalAtEndOfMission;
        }

        public void setShowTotalAtEndOfMission(Boolean showTotalAtEndOfMission) {
            this.showTotalAtEndOfMission = showTotalAtEndOfMission;
        }

        public Boolean getPersonal() {
            return isPersonal;
        }

        public void setPersonal(Boolean personal) {
            isPersonal = personal;
        }

        public Boolean getCommunity() {
            return isCommunity;
        }

        public void setCommunity(Boolean community) {
            isCommunity = community;
        }

        public List<String> getRegionDrops() {
            return regionDrops;
        }

        public void setRegionDrops(List<String> regionDrops) {
            this.regionDrops = regionDrops;
        }

        public List<String> getArchwingDrops() {
            return archwingDrops;
        }

        public void setArchwingDrops(List<String> archwingDrops) {
            this.archwingDrops = archwingDrops;
        }

        public String getAsString() {
            return asString;
        }

        public void setAsString(String asString) {
            this.asString = asString;
        }

        public List<Integer> getCompletionBonuses() {
            return completionBonuses;
        }

        public void setCompletionBonuses(List<Integer> completionBonuses) {
            this.completionBonuses = completionBonuses;
        }

        public String getScoreVar() {
            return scoreVar;
        }

        public void setScoreVar(String scoreVar) {
            this.scoreVar = scoreVar;
        }

        public Date getAltExpiry() {
            return altExpiry;
        }

        public void setAltExpiry(Date altExpiry) {
            this.altExpiry = altExpiry;
        }

        public Date getAltActivation() {
            return altActivation;
        }

        public void setAltActivation(Date altActivation) {
            this.altActivation = altActivation;
        }

        public static class Rewards {
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Rewards)) return false;
                Rewards rewards = (Rewards) o;
                return countedItems.equals(rewards.countedItems) && asString.equals(rewards.asString) && itemString.equals(rewards.itemString);
            }

            @Override
            public int hashCode() {
                return Objects.hash(countedItems, asString, itemString);
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("countedItems", countedItems)
                        .append("thumbnail", thumbnail)
                        .append("color", color)
                        .append("credits", credits)
                        .append("asString", asString)
                        .append("items", items)
                        .append("itemString", itemString)
                        .toString();
            }

            public Rewards() {
            }

            public Rewards(List<CountedItems> countedItems, String thumbnail, Integer color, Integer credits, String asString, List<String> items, String itemString) {
                this.countedItems = countedItems;
                this.thumbnail = thumbnail;
                this.color = color;
                this.credits = credits;
                this.asString = asString;
                this.items = items;
                this.itemString = itemString;
            }

            @JsonProperty("countedItems")
            private List<CountedItems> countedItems;
            @JsonProperty("thumbnail")
            private String thumbnail;
            @JsonProperty("color")
            private Integer color;
            @JsonProperty("credits")
            private Integer credits;
            @JsonProperty("asString")
            private String asString;
            @JsonProperty("items")
            private List<String> items;
            @JsonProperty("itemString")
            private String itemString;

            public List<CountedItems> getCountedItems() {
                return countedItems;
            }

            public void setCountedItems(List<CountedItems> countedItems) {
                this.countedItems = countedItems;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public Integer getColor() {
                return color;
            }

            public void setColor(Integer color) {
                this.color = color;
            }

            public Integer getCredits() {
                return credits;
            }

            public void setCredits(Integer credits) {
                this.credits = credits;
            }

            public String getAsString() {
                return asString;
            }

            public void setAsString(String asString) {
                this.asString = asString;
            }

            public List<String> getItems() {
                return items;
            }

            public void setItems(List<String> items) {
                this.items = items;
            }

            public String getItemString() {
                return itemString;
            }

            public void setItemString(String itemString) {
                this.itemString = itemString;
            }


            public static class CountedItems {
                public CountedItems() {
                }

                public CountedItems(Integer count, String type) {
                    this.count = count;
                    this.type = type;
                }

                @Override
                public String toString() {
                    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                            .append("count", count)
                            .append("type", type)
                            .toString();
                }

                @JsonProperty("count")
                private Integer count;
                @JsonProperty("type")
                private String type;

                public Integer getCount() {
                    return count;
                }

                public void setCount(Integer count) {
                    this.count = count;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }
        }

    }

}

