package com.twg.bot.enums;

public enum MarketEnum {
    PC("PC", ""),
    PS4("PS4", ""),
    XB1("XBOX", ""),
    SWI("SWITCH", ""),
    //离线
    offline("offline", ""),
    //在线
    online("online", ""),
    //游戏中
    ingame("ingame", ""),
    //买家
    buy("buy", ""),
    //卖家
    sell("sell", ""),
    en("", "国际"),
    ru("", "俄罗斯"),
    ko("", "韩国"),
    fr("", "法国"),
    sw("", "瑞典"),
    ge("", "德国");
    private final String form;
    private final String state;

    MarketEnum(String form, String state) {
        this.form = form;
        this.state = state;
    }

    public String getForm() {
        return form;
    }

    public String getState() {
        return state;
    }

}

