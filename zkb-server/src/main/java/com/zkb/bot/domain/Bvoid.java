package com.zkb.bot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


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

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Boolean getNeedShareCallBack() {
        return needShareCallBack;
    }

    public void setNeedShareCallBack(Boolean needShareCallBack) {
        this.needShareCallBack = needShareCallBack;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    /*   public static String getBV(long botId) {
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
    }*/


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

        public Integer getAppType() {
            return appType;
        }

        public void setAppType(Integer appType) {
            this.appType = appType;
        }

        public Integer getAppid() {
            return appid;
        }

        public void setAppid(Integer appid) {
            this.appid = appid;
        }

        public long getUin() {
            return uin;
        }

        public void setUin(long uin) {
            this.uin = uin;
        }
    }


    public static class Meta {
        @JsonProperty("detail_1")
        private Detail1 detail1;

        public Meta(Detail1 detail1) {
            this.detail1 = detail1;
        }

        public Detail1 getDetail1() {
            return detail1;
        }

        public void setDetail1(Detail1 detail1) {
            this.detail1 = detail1;
        }

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



            public Integer getAppType() {
                return appType;
            }

            public void setAppType(Integer appType) {
                this.appType = appType;
            }

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public Host getHost() {
                return host;
            }

            public void setHost(Host host) {
                this.host = host;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Integer getScene() {
                return scene;
            }

            public void setScene(Integer scene) {
                this.scene = scene;
            }

            public String getShareTemplateId() {
                return shareTemplateId;
            }

            public void setShareTemplateId(String shareTemplateId) {
                this.shareTemplateId = shareTemplateId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

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


            public static class Host {
                @JsonProperty("nick")
                private String nick;
                @JsonProperty("uin")
                private long uin;

                public Host(String nick, long uin) {
                    this.nick = nick;
                    this.uin = uin;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public long getUin() {
                    return uin;
                }

                public void setUin(long uin) {
                    this.uin = uin;
                }
            }


        }
    }
}
