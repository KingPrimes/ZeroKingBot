package com.twg.bot.domain;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.twg.bot.utils.PrivateAddApi;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Bvoid {

    @JsonProperty("app")
    private String app;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("extra")
    private Extra extra;
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("needShareCallBack")
    private Boolean needShareCallBack;
    @JsonProperty("prompt")
    private String prompt;
    @JsonProperty("ver")
    private String ver;
    @JsonProperty("view")
    private String view;

    public static String getBV(long botId) {
        Bvoid bv = new Bvoid();
        bv.setApp("com.tencent.miniapp_01");
        bv.setDesc("哔哩哔哩");
        bv.setExtra(new Bvoid.Extra(1, 100951776, botId));
        bv.setMeta(new Bvoid.Meta(
                new Bvoid.Meta.Detail1(
                        0,
                        "1109937557",
                        "Warframe机器人-部署教程",
                        new Bvoid.Meta.Detail1.Host(
                                PrivateAddApi.getPrivateNick(botId),
                                botId
                        ),
                        "https://open.gtimg.cn/open/app_icon/00/95/17/76/100951776_100_m.png?t=1657790505",
                        1036,
                        "8C8E89B49BE609866298ADDFF2DBABA4",
                        "哔哩哔哩",
                        "m.q.qq.com/a/s/b2e250befd525a58e19e9ba20bf03f05"

                )
        ));
        String bvoid = JSON.toJSONString(bv);
        return bvoid.replace("&", "&amp;").replace(",", "&#44;").replace("[", "&#91;").replace("]", "&#93;");
    }

    @NoArgsConstructor
    @Data
    public static class Extra {
        @JsonProperty("app_type")
        private Integer appType;
        @JsonProperty("appid")
        private Integer appid;
        @JsonProperty("uin")
        private long uin;


        public Extra(Integer appType, Integer appid, long uin) {
            this.appType = appType;
            this.appid = appid;
            this.uin = uin;
        }
    }

    @NoArgsConstructor
    @Data
    public static class Meta {
        @JsonProperty("detail_1")
        private Detail1 detail1;

        public Meta(Detail1 detail1) {
            this.detail1 = detail1;
        }

        @NoArgsConstructor
        @Data
        public static class Detail1 {
            @JsonProperty("appType")
            private Integer appType;
            @JsonProperty("appid")
            private String appid;
            @JsonProperty("desc")
            private String desc;
            @JsonProperty("host")
            private Host host;
            @JsonProperty("icon")
            private String icon;
            @JsonProperty("scene")
            private Integer scene;
            @JsonProperty("shareTemplateId")
            private String shareTemplateId;
            @JsonProperty("title")
            private String title;
            @JsonProperty("url")
            private String url;

            public Detail1(Integer appType, String appid, String desc, Host host, String icon, Integer scene, String shareTemplateId, String title, String url) {
                this.appType = appType;
                this.appid = appid;
                this.desc = desc;
                this.host = host;
                this.icon = icon;
                this.scene = scene;
                this.shareTemplateId = shareTemplateId;
                this.title = title;
                this.url = url;
            }

            @NoArgsConstructor
            @Data
            public static class Host {
                @JsonProperty("nick")
                private String nick;
                @JsonProperty("uin")
                private long uin;

                public Host(String nick, long uin) {
                    this.nick = nick;
                    this.uin = uin;
                }
            }


        }
    }
}
