package com.zkb.bot.enums;


public enum WarframeTypeEnum {
    /**
     * Market 赤毒武器搜索
     */
    TYPE_MARKET_CD(""),
    /**
     * Market 信条武器搜索
     */
    TYPE_MARKET_XT(""),
    TYPE_ASSAULT_PLUGIN("突击"),
    TYPE_VOID_PLUGIN("奸商"),
    TYPE_ARBITRATION_PLUGIN("仲裁"),
    TYPE_STEEL_PATH_PLUGIN("钢铁"),
    TYPE_DAILY_DEALS_PLUGIN("每日特惠"),
    TYPE_INVASIONS_PLUGIN("入侵"),
    TYPE_FISSUES_PLUGIN("裂隙"),
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
    TYPE_RES_MARKET_ITEMS("更新WM物品"),
    TYPE_RES_MARKET_RIVEN("更新WM紫卡"),
    TYPE_RES_RM("更新RM紫卡"),
    TYPE_CODE("指令"),
    REDIS_MISSION_KEY("warframe-data-the-provided-plat"),
    ADMIN_QQ(1417333181),
    ;

    private String type;
    private long l;

    WarframeTypeEnum(String s) {
        type = s;
    }

    WarframeTypeEnum(long s) {
        l = s;
    }

    public String getType() {
        return type;
    }

    public long getL() {
        return l;
    }
}
