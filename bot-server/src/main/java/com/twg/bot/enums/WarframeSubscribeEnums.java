package com.twg.bot.enums;

public enum WarframeSubscribeEnums {
    /**
     * 订阅所有内容
     */
    SUBSCRIBE_ERROR("没有此数值！"),
    /**
     * 警报
     */
    SUBSCRIBE_ALERTS("警报"),
    /**
     * 仲裁
     */
    SUBSCRIBE_ARBITRATION("仲裁"),
    /**
     * 夜灵平野
     */
    SUBSCRIBE_CETUS_CYCLE("夜灵平野"),
    /**
     * 每日特惠
     */
    SUBSCRIBE_DAILY_DEALS("每日特惠"),
    /**
     * 活动
     */
    SUBSCRIBE_EVENTS("活动"),
    /**
     * 入侵
     */
    SUBSCRIBE_INVASIONS("入侵"),
    /**
     * 钢铁兑换
     */
    SUBSCRIBE_STEEL_PATH("钢铁兑换"),
    /**
     * 奸商
     */
    SUBSCRIBE_VOID("奸商"),
    /**
     * 入侵双方的建筑情况
     */
    //SUBSCRIBE_CONSTRUCTION_PROGRESS("入侵建筑"),
    /**
     * 裂隙
     */
    //SUBSCRIBE_FISSURES("裂隙"),
    /**
     * 新闻
     */
    //SUBSCRIBE_NEWS("新闻"),
    /**
     * 电波
     */
    //SUBSCRIBE_NIGHTWAVE("电波"),
    /**
     * 大黄脸中枢的结合目标
     */
    //SUBSCRIBE_SIMARIS("结合目标"),
    /**
     * 突击
     */
    //SUBSCRIBE_SORTIE("突击"),
    /**
     * 集团任务
     */
    //SUBSCRIBE_SYNDICATE_MISSIONS("集团任务"),
    /**
     * 奥布山谷
     */
    //SUBSCRIBE_VALLIS_CYCLE("奥布山谷"),
    /**
     * 地球昼夜轮换
     */
    //SUBSCRIBE_EARTH_CYCLE("地球昼夜"),
    ;
    private String name = "";

    WarframeSubscribeEnums(String name) {
        this.name = name;
    }

    WarframeSubscribeEnums() {
    }

    public String getName() {
        return name;
    }

}
