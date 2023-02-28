package com.zkb.bot.warframe.dao;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


public class Market {

    Payload payload;
    Include include;
    String code;

    public Market() {
    }

    public Market(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Include getInclude() {
        return include;
    }

    public void setInclude(Include include) {
        this.include = include;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("payload", getPayload())
                .append("include", getInclude())
                .toString();
    }

    public static class Payload {
        List<Orders> orders;

        public List<Orders> getOrders() {
            return orders;
        }

        public void setOrders(List<Orders> orders) {
            this.orders = orders;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("orders", getOrders())
                    .toString();
        }
    }

    public static class User {
        /**
         * reputation
         */
        Integer reputation;
        /**
         * region
         */
        String region;
        /**
         * lastSeen
         */
        String last_seen;
        /**
         * ingameName
         */
        String ingame_name;
        /**
         * avatar
         */
        String avatar;
        /**
         * status
         */
        String status;
        /**
         * id
         */
        String id;

        public Integer getReputation() {
            return reputation;
        }

        public void setReputation(Integer reputation) {
            this.reputation = reputation;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getLastSeen() {
            return last_seen;
        }

        public void setLastSeen(String lastSeen) {
            this.last_seen = lastSeen;
        }

        public String getIngameName() {
            return ingame_name;
        }

        public void setIngameName(String ingameName) {
            this.ingame_name = ingameName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("reputation", getReputation())
                    .append("region", getRegion())
                    .append("last_seen", getLastSeen())
                    .append("ingame_name", getIngameName())
                    .append("avatar", getAvatar())
                    .append("status", getStatus())
                    .append("id", getId())
                    .toString();
        }
    }

    public static class Orders {
        /**
         * visible
         */
        Boolean visible;
        /**
         * platinum
         */
        Integer platinum;
        /**
         * quantity
         */
        Integer quantity;
        /**
         * orderType
         */
        String order_type;
        /**
         * user
         */
        User user;
        /**
         * platform
         */
        String platform;
        /**
         * region
         */
        String region;
        /**
         * creationDate
         */
        String creation_date;
        /**
         * lastUpdate
         */
        String last_update;
        /**
         * id
         */
        String id;
        /**
         * modRank
         */
        Integer modRank;

        public Boolean getVisible() {
            return visible;
        }

        public void setVisible(Boolean visible) {
            this.visible = visible;
        }

        public Integer getPlatinum() {
            return platinum;
        }

        public void setPlatinum(Integer platinum) {
            this.platinum = platinum;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getOrderType() {
            return order_type;
        }

        public void setOrderType(String orderType) {
            this.order_type = orderType;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCreationDate() {
            return creation_date;
        }

        public void setCreationDate(String creationDate) {
            this.creation_date = creationDate;
        }

        public String getLastUpdate() {
            return last_update;
        }

        public void setLastUpdate(String lastUpdate) {
            this.last_update = lastUpdate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getModRank() {
            return modRank;
        }

        public void setModRank(Integer modRank) {
            this.modRank = modRank;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("visible", getVisible())
                    .append("platinum", getPlatinum())
                    .append("quantity", getQuantity())
                    .append("order_type", getOrderType())
                    .append("user", getUser())
                    .append("platform", getPlatform())
                    .append("region", getRegion())
                    .append("creation_date", getCreationDate())
                    .append("last_update", getLastUpdate())
                    .append("id", getId())
                    .append("modRank", getModRank())
                    .toString();
        }
    }

    public static class Include {
        Item item;

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("item", getItem())
                    .toString();
        }
    }

    public static class Item {
        String id;
        List<ItemsInSet> itemsInSet;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<ItemsInSet> getItems_in_set() {
            return itemsInSet;
        }

        public void setItems_in_set(List<ItemsInSet> items_in_set) {
            this.itemsInSet = items_in_set;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", getId())
                    .append("items_in_set", getItems_in_set())
                    .toString();
        }
    }

    public static class ItemsInSet {
        //图片地址
        String thumb;
        //url查询名称
        String urlName;
        //标签
        List<String> tags;
        //段位等级
        Integer masteryLevel;
        //图片icon
        String icon;
        //交易税
        Integer tradingTax;
        String subIcon;
        //物品id
        String id;
        //价值多少杜卡币
        Integer ducats;
        //icon来自哪里
        String iconFormat;
        Boolean setRoot;
        Laguage zhhans;
        //mod最大等级
        Integer modMaxRank;
        //稀有程度
        String rarity;


        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("thumb", getThumb())
                    .append("urlName", getUrlName())
                    .append("tags", getTags())
                    .append("masteryLevel", getMasteryLevel())
                    .append("icon", getIcon())
                    .append("tradingTax", getTradingTax())
                    .append("subIcon", getSubIcon())
                    .append("id", getId())
                    .append("ducats", getDucats())
                    .append("iconFormat", getIconFormat())
                    .append("setRoot", getSetRoot())
                    .append("zhhans", getZhhans())
                    .append("modMaxRank", getModMaxRank())
                    .append("rarity", getRarity())
                    .toString();
        }

        /**
         * 获取 图片地址
         *
         * @return thumb 图片地址
         */
        public String getThumb() {
            return this.thumb;
        }

        /**
         * 设置 图片地址
         *
         * @param thumb 图片地址
         */
        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        /**
         * 获取 url查询名称
         *
         * @return urlName url查询名称
         */
        public String getUrlName() {
            return this.urlName;
        }

        /**
         * 设置 url查询名称
         *
         * @param urlName url查询名称
         */
        public void setUrlName(String urlName) {
            this.urlName = urlName;
        }

        /**
         * 获取 标签
         *
         * @return tags 标签
         */
        public List<String> getTags() {
            return this.tags;
        }

        /**
         * 设置 标签
         *
         * @param tags 标签
         */
        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        /**
         * 获取 段位等级
         *
         * @return masteryLevel 段位等级
         */
        public Integer getMasteryLevel() {
            return this.masteryLevel;
        }

        /**
         * 设置 段位等级
         *
         * @param masteryLevel 段位等级
         */
        public void setMasteryLevel(Integer masteryLevel) {
            this.masteryLevel = masteryLevel;
        }

        /**
         * 获取 图片icon
         *
         * @return icon 图片icon
         */
        public String getIcon() {
            return this.icon;
        }

        /**
         * 设置 图片icon
         *
         * @param icon 图片icon
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

        /**
         * 获取 交易税
         *
         * @return tradingTax 交易税
         */
        public Integer getTradingTax() {
            return this.tradingTax;
        }

        /**
         * 设置 交易税
         *
         * @param tradingTax 交易税
         */
        public void setTradingTax(Integer tradingTax) {
            this.tradingTax = tradingTax;
        }

        /**
         * 获取
         *
         * @return subIcon
         */
        public String getSubIcon() {
            return this.subIcon;
        }

        /**
         * 设置
         *
         * @param subIcon
         */
        public void setSubIcon(String subIcon) {
            this.subIcon = subIcon;
        }

        /**
         * 获取 物品id
         *
         * @return id 物品id
         */
        public String getId() {
            return this.id;
        }

        /**
         * 设置 物品id
         *
         * @param id 物品id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * 获取 价值多少杜卡币
         *
         * @return ducats 价值多少杜卡币
         */
        public Integer getDucats() {
            return this.ducats;
        }

        /**
         * 设置 价值多少杜卡币
         *
         * @param ducats 价值多少杜卡币
         */
        public void setDucats(Integer ducats) {
            this.ducats = ducats;
        }

        /**
         * 获取 icon来自哪里
         *
         * @return iconFormat icon来自哪里
         */
        public String getIconFormat() {
            return this.iconFormat;
        }

        /**
         * 设置 icon来自哪里
         *
         * @param iconFormat icon来自哪里
         */
        public void setIconFormat(String iconFormat) {
            this.iconFormat = iconFormat;
        }

        /**
         * 获取
         *
         * @return setRoot
         */
        public Boolean getSetRoot() {
            return this.setRoot;
        }

        /**
         * 设置
         *
         * @param setRoot
         */
        public void setSetRoot(Boolean setRoot) {
            this.setRoot = setRoot;
        }

        /**
         * 获取
         *
         * @return zhhans
         */
        public Laguage getZhhans() {
            return this.zhhans;
        }

        /**
         * 设置
         *
         * @param zhhans
         */
        public void setZhhans(Laguage zhhans) {
            this.zhhans = zhhans;
        }

        /**
         * 获取 mod最大等级
         *
         * @return modMaxRank mod最大等级
         */
        public Integer getModMaxRank() {
            return this.modMaxRank;
        }

        /**
         * 设置 mod最大等级
         *
         * @param modMaxRank mod最大等级
         */
        public void setModMaxRank(Integer modMaxRank) {
            this.modMaxRank = modMaxRank;
        }

        /**
         * 获取 稀有程度
         *
         * @return rarity 稀有程度
         */
        public String getRarity() {
            return this.rarity;
        }

        /**
         * 设置 稀有程度
         *
         * @param rarity 稀有程度
         */
        public void setRarity(String rarity) {
            this.rarity = rarity;
        }
    }

    public static class Laguage {
        String itemName;
        String description;
        String wikiLink;
        List<Drop> drop;

        public String getItem_name() {
            return itemName;
        }

        public void setItem_name(String item_name) {
            this.itemName = item_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getWiki_link() {
            return wikiLink;
        }

        public void setWiki_link(String wiki_link) {
            this.wikiLink = wiki_link;
        }

        public List<Drop> getDrop() {
            return drop;
        }

        public void setDrop(List<Drop> drop) {
            this.drop = drop;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("item_name", getItem_name())
                    .append("description", getDescription())
                    .append("wiki_link", getWiki_link())
                    .append("drop", getDrop())
                    .toString();
        }
    }

    public static class Drop {
        String name;
        String link;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("name", getName())
                    .append("link", getLink())
                    .toString();
        }
    }
}
