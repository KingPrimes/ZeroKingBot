package com.zkb.common.load;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WarframeConfig {
    //突击
    private String assault;
    //仲裁
    private String arbitration;
    //平原
    private String allCycle;
    //每日特惠
    private String dailyDeals;
    //入侵
    private String invasions;
    //裂隙
    private String fissues;
    //电波
    private String nighTwave;
    //紫卡倾向变动
    private String rivenDisUpdate;
    //翻译
    private String tra;
    //奸商
    private String voids;
    //钢铁
    private String steelPath;
    //核桃
    private String relics;

    // Warframe Market
    private String marketWm;
    // 满级
    private String marketMax;
    //买家
    private String marketBy;
    //卖家
    private String marketSet;

    //Warframe Market Riven
    private String rivenWR;

    // Warframe Market 赤毒
    private String c;
    // Warframe Market 信条
    private String x;

    //wiki
    private String wiki;

    //金垃圾
    private String godDump;
    //银垃圾
    private String silverDump;

    //模拟核桃
    private String openRelics;

    public WarframeConfig() {
    }

    /**
     * @param assault        突击
     * @param arbitration    仲裁
     * @param allCycle       平原
     * @param dailyDeals     每日特惠
     * @param invasions      入侵
     * @param fissues        裂隙
     * @param nighTwave      电波
     * @param rivenDisUpdate 紫卡倾向更新
     * @param tra            翻译
     * @param voids          奸商
     * @param steelPath      钢铁
     * @param relics         核桃
     * @param marketWm       wm
     * @param marketMax      满级
     * @param marketBy       买家
     * @param marketSet      卖家
     * @param rivenWR        wr
     * @param c              赤毒
     * @param x              信条
     * @param wiki           wiki
     * @param godDump        金垃圾
     * @param silverDump     银垃圾
     * @param openRelics     模拟开核桃
     */
    public WarframeConfig(String assault, String arbitration, String allCycle, String dailyDeals, String invasions, String fissues, String nighTwave, String rivenDisUpdate, String tra, String voids, String steelPath, String relics, String marketWm, String marketMax, String marketBy, String marketSet, String rivenWR, String c, String x, String wiki, String godDump, String silverDump, String openRelics) {
        this.assault = assault;
        this.arbitration = arbitration;
        this.allCycle = allCycle;
        this.dailyDeals = dailyDeals;
        this.invasions = invasions;
        this.fissues = fissues;
        this.nighTwave = nighTwave;
        this.rivenDisUpdate = rivenDisUpdate;
        this.tra = tra;
        this.voids = voids;
        this.steelPath = steelPath;
        this.relics = relics;
        this.marketWm = marketWm;
        this.marketMax = marketMax;
        this.marketBy = marketBy;
        this.marketSet = marketSet;
        this.rivenWR = rivenWR;
        this.c = c;
        this.x = x;
        this.wiki = wiki;
        this.godDump = godDump;
        this.silverDump = silverDump;
        this.openRelics = openRelics;
    }

    /**
     * 获取 突击
     *
     * @return assault 突击
     */
    public String getAssault() {
        return this.assault;
    }

    /**
     * 设置 突击
     *
     * @param assault 突击
     */
    public void setAssault(String assault) {
        this.assault = assault;
    }

    /**
     * 获取 仲裁
     *
     * @return arbitration 仲裁
     */
    public String getArbitration() {
        return this.arbitration;
    }

    /**
     * 设置 仲裁
     *
     * @param arbitration 仲裁
     */
    public void setArbitration(String arbitration) {
        this.arbitration = arbitration;
    }

    /**
     * 获取 平原
     *
     * @return allCycle 平原
     */
    public String getAllCycle() {
        return this.allCycle;
    }

    /**
     * 设置 平原
     *
     * @param allCycle 平原
     */
    public void setAllCycle(String allCycle) {
        this.allCycle = allCycle;
    }

    /**
     * 获取 每日特惠
     *
     * @return dailyDeals 每日特惠
     */
    public String getDailyDeals() {
        return this.dailyDeals;
    }

    /**
     * 设置 每日特惠
     *
     * @param dailyDeals 每日特惠
     */
    public void setDailyDeals(String dailyDeals) {
        this.dailyDeals = dailyDeals;
    }

    /**
     * 获取 入侵
     *
     * @return invasions 入侵
     */
    public String getInvasions() {
        return this.invasions;
    }

    /**
     * 设置 入侵
     *
     * @param invasions 入侵
     */
    public void setInvasions(String invasions) {
        this.invasions = invasions;
    }

    /**
     * 获取 裂隙
     *
     * @return fissues 裂隙
     */
    public String getFissues() {
        return this.fissues;
    }

    /**
     * 设置 裂隙
     *
     * @param fissues 裂隙
     */
    public void setFissues(String fissues) {
        this.fissues = fissues;
    }

    /**
     * 获取 电波
     *
     * @return nighTwave 电波
     */
    public String getNighTwave() {
        return this.nighTwave;
    }

    /**
     * 设置 电波
     *
     * @param nighTwave 电波
     */
    public void setNighTwave(String nighTwave) {
        this.nighTwave = nighTwave;
    }

    /**
     * 获取 紫卡倾向变动
     *
     * @return rivenDisUpdate 紫卡倾向变动
     */
    public String getRivenDisUpdate() {
        return this.rivenDisUpdate;
    }

    /**
     * 设置 紫卡倾向变动
     *
     * @param rivenDisUpdate 紫卡倾向变动
     */
    public void setRivenDisUpdate(String rivenDisUpdate) {
        this.rivenDisUpdate = rivenDisUpdate;
    }

    /**
     * 获取 翻译
     *
     * @return tra 翻译
     */
    public String getTra() {
        return this.tra;
    }

    /**
     * 设置 翻译
     *
     * @param tra 翻译
     */
    public void setTra(String tra) {
        this.tra = tra;
    }

    /**
     * 获取 奸商
     *
     * @return voids 奸商
     */
    public String getVoids() {
        return this.voids;
    }

    /**
     * 设置 奸商
     *
     * @param voids 奸商
     */
    public void setVoids(String voids) {
        this.voids = voids;
    }

    /**
     * 获取 钢铁
     *
     * @return steelPath 钢铁
     */
    public String getSteelPath() {
        return this.steelPath;
    }

    /**
     * 设置 钢铁
     *
     * @param steelPath 钢铁
     */
    public void setSteelPath(String steelPath) {
        this.steelPath = steelPath;
    }

    /**
     * 获取 核桃
     *
     * @return relics 核桃
     */
    public String getRelics() {
        return this.relics;
    }

    /**
     * 设置 核桃
     *
     * @param relics 核桃
     */
    public void setRelics(String relics) {
        this.relics = relics;
    }

    /**
     * 获取 Warframe Market
     *
     * @return marketWm Warframe Market
     */
    public String getMarketWm() {
        return this.marketWm;
    }

    /**
     * 设置 Warframe Market
     *
     * @param marketWm Warframe Market
     */
    public void setMarketWm(String marketWm) {
        this.marketWm = marketWm;
    }

    /**
     * 获取 满级
     *
     * @return marketMax 满级
     */
    public String getMarketMax() {
        return this.marketMax;
    }

    /**
     * 设置 满级
     *
     * @param marketMax 满级
     */
    public void setMarketMax(String marketMax) {
        this.marketMax = marketMax;
    }

    /**
     * 获取 买家
     *
     * @return marketBy 买家
     */
    public String getMarketBy() {
        return this.marketBy;
    }

    /**
     * 设置 买家
     *
     * @param marketBy 买家
     */
    public void setMarketBy(String marketBy) {
        this.marketBy = marketBy;
    }

    /**
     * 获取 卖家
     *
     * @return marketSet 卖家
     */
    public String getMarketSet() {
        return this.marketSet;
    }

    /**
     * 设置 卖家
     *
     * @param marketSet 卖家
     */
    public void setMarketSet(String marketSet) {
        this.marketSet = marketSet;
    }

    /**
     * 获取 Warframe Market Riven
     *
     * @return rivenWR Warframe Market Riven
     */
    public String getRivenWR() {
        return this.rivenWR;
    }

    /**
     * 设置 Warframe Market Riven
     *
     * @param rivenWR Warframe Market Riven
     */
    public void setRivenWR(String rivenWR) {
        this.rivenWR = rivenWR;
    }

    /**
     * 获取 Warframe Market 赤毒
     *
     * @return c Warframe Market 赤毒
     */
    public String getC() {
        return this.c;
    }

    /**
     * 设置 Warframe Market 赤毒
     *
     * @param c Warframe Market 赤毒
     */
    public void setC(String c) {
        this.c = c;
    }

    /**
     * 获取 Warframe Market 信条
     *
     * @return x Warframe Market 信条
     */
    public String getX() {
        return this.x;
    }

    /**
     * 设置 Warframe Market 信条
     *
     * @param x Warframe Market 信条
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * 获取 wiki
     *
     * @return wiki wiki
     */
    public String getWiki() {
        return this.wiki;
    }

    /**
     * 设置 wiki
     *
     * @param wiki wiki
     */
    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    /**
     * 获取 金垃圾
     *
     * @return godDump 金垃圾
     */
    public String getGodDump() {
        return this.godDump;
    }

    /**
     * 设置 金垃圾
     *
     * @param godDump 金垃圾
     */
    public void setGodDump(String godDump) {
        this.godDump = godDump;
    }

    /**
     * 获取 银垃圾
     *
     * @return silverDump 银垃圾
     */
    public String getSilverDump() {
        return this.silverDump;
    }

    /**
     * 设置 银垃圾
     *
     * @param silverDump 银垃圾
     */
    public void setSilverDump(String silverDump) {
        this.silverDump = silverDump;
    }

    /**
     * 获取 模拟核桃
     *
     * @return openRelics 模拟核桃
     */
    public String getOpenRelics() {
        return this.openRelics;
    }

    /**
     * 设置 模拟核桃
     *
     * @param openRelics 模拟核桃
     */
    public void setOpenRelics(String openRelics) {
        this.openRelics = openRelics;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("assault", assault)
                .append("arbitration", arbitration)
                .append("allCycle", allCycle)
                .append("dailyDeals", dailyDeals)
                .append("invasions", invasions)
                .append("fissues", fissues)
                .append("nighTwave", nighTwave)
                .append("rivenDisUpdate", rivenDisUpdate)
                .append("tra", tra)
                .append("voids", voids)
                .append("steelPath", steelPath)
                .append("relics", relics)
                .append("marketWm", marketWm)
                .append("marketMax", marketMax)
                .append("marketBy", marketBy)
                .append("marketSet", marketSet)
                .append("rivenWR", rivenWR)
                .append("c", c)
                .append("x", x)
                .append("wiki", wiki)
                .append("godDump", godDump)
                .append("silverDump", silverDump)
                .append("openRelics", openRelics)
                .toString();
    }
}
