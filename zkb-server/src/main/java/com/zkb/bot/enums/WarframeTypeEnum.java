package com.zkb.bot.enums;


public enum WarframeTypeEnum {

    TYPE_ASSAULT_PLUGIN("突击"),

    TYPE_ARCHON_HUNT_PLUGIN("执刑官猎杀"),
    TYPE_VOID_PLUGIN("奸商"),
    TYPE_ARBITRATION_PLUGIN("仲裁"),
    TYPE_STEEL_PATH_PLUGIN("钢铁"),
    TYPE_DAILY_DEALS_PLUGIN("每日特惠"),
    TYPE_INVASIONS_PLUGIN("入侵"),
    TYPE_FISSUES_PLUGIN("裂隙"),

    TYPE_FISSUES_EMPYREAN_PLUGIN("九重天裂隙"),

    TYPE_FISSUES_PATH_PLUGIN("钢铁裂隙"),
    TYPE_FISSUESX_PLUGIN("裂缝"),
    TYPE_ALL_CYCLE_PLUGIN("平原"),
    TYPE_NIGH_TWAVE_PLUGIN("电波"),
    TYPE_RIVEN_DIS_UPDATE_PLUGIN("紫卡倾向变动"),
    TYPE_TRA_PLUGIN("翻译"),
    TYPE_WM_PLUGIN("/WM"),
    TYPE_MARKET_MAX("满级"),
    TYPE_MARKET_BY("买家"),
    TYPE_MARKET_SET("卖家"),
    TYPE_ZKWM_PLUGIN("/ZKWM"),
    TYPE_RM_PLUGIN("/RM"),
    TYPE_WR_PLUGIN("/WR"),
    TYPE_CD_PLUGIN("/CD"),
    TYPE_C_PLUGIN("/C"),
    TYPE_XT_PLUGIN("/XT"),
    TYPE_X_PLUGIN("/X"),
    TYPE_WIKI_PLUGIN("/WIKI"),

    TYPE_SISTER_PLUGIN("信条"),

    TYPE_MARKET_GOD_DUMP("金垃圾"),

    TYPE_RELICS_PLUGIN("核桃"),

    TYPE_OPEN_RELICS_PLUGIN("开核桃"),
    TYPE_OPEN1_RELICS_PLUGIN("砸核桃"),

    TYPE_MARKET_SILVER_DUMP("银垃圾"),



    ;

    private String type;

    WarframeTypeEnum(String s) {
        type = s;
    }


    public String getType() {
        return type;
    }

    public WarframeTypeEnum setType(String type) {
        this.type = type;
        return this;
    }

}
