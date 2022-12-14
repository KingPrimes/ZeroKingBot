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
        //????????????
        String thumb;
        //url????????????
        String urlName;
        //??????
        List<String> tags;
        //????????????
        Integer masteryLevel;
        //??????icon
        String icon;
        //?????????
        Integer tradingTax;
        String subIcon;
        //??????id
        String id;
        //?????????????????????
        Integer ducats;
        //icon????????????
        String iconFormat;
        Boolean setRoot;
        Laguage zhhans;
        //mod????????????
        Integer modMaxRank;
        //????????????
        String rarity;


        @Override
        public String toString() {
            return new ToStringBuilder(this,ToStringStyle.JSON_STYLE)
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
         * ?????? ????????????
         *
         * @return thumb ????????????
         */
        public String getThumb() {
            return this.thumb;
        }

        /**
         * ?????? ????????????
         *
         * @param thumb ????????????
         */
        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        /**
         * ?????? url????????????
         *
         * @return urlName url????????????
         */
        public String getUrlName() {
            return this.urlName;
        }

        /**
         * ?????? url????????????
         *
         * @param urlName url????????????
         */
        public void setUrlName(String urlName) {
            this.urlName = urlName;
        }

        /**
         * ?????? ??????
         *
         * @return tags ??????
         */
        public List<String> getTags() {
            return this.tags;
        }

        /**
         * ?????? ??????
         *
         * @param tags ??????
         */
        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        /**
         * ?????? ????????????
         *
         * @return masteryLevel ????????????
         */
        public Integer getMasteryLevel() {
            return this.masteryLevel;
        }

        /**
         * ?????? ????????????
         *
         * @param masteryLevel ????????????
         */
        public void setMasteryLevel(Integer masteryLevel) {
            this.masteryLevel = masteryLevel;
        }

        /**
         * ?????? ??????icon
         *
         * @return icon ??????icon
         */
        public String getIcon() {
            return this.icon;
        }

        /**
         * ?????? ??????icon
         *
         * @param icon ??????icon
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

        /**
         * ?????? ?????????
         *
         * @return tradingTax ?????????
         */
        public Integer getTradingTax() {
            return this.tradingTax;
        }

        /**
         * ?????? ?????????
         *
         * @param tradingTax ?????????
         */
        public void setTradingTax(Integer tradingTax) {
            this.tradingTax = tradingTax;
        }

        /**
         * ??????
         *
         * @return subIcon
         */
        public String getSubIcon() {
            return this.subIcon;
        }

        /**
         * ??????
         *
         * @param subIcon
         */
        public void setSubIcon(String subIcon) {
            this.subIcon = subIcon;
        }

        /**
         * ?????? ??????id
         *
         * @return id ??????id
         */
        public String getId() {
            return this.id;
        }

        /**
         * ?????? ??????id
         *
         * @param id ??????id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * ?????? ?????????????????????
         *
         * @return ducats ?????????????????????
         */
        public Integer getDucats() {
            return this.ducats;
        }

        /**
         * ?????? ?????????????????????
         *
         * @param ducats ?????????????????????
         */
        public void setDucats(Integer ducats) {
            this.ducats = ducats;
        }

        /**
         * ?????? icon????????????
         *
         * @return iconFormat icon????????????
         */
        public String getIconFormat() {
            return this.iconFormat;
        }

        /**
         * ?????? icon????????????
         *
         * @param iconFormat icon????????????
         */
        public void setIconFormat(String iconFormat) {
            this.iconFormat = iconFormat;
        }

        /**
         * ??????
         *
         * @return setRoot
         */
        public Boolean getSetRoot() {
            return this.setRoot;
        }

        /**
         * ??????
         *
         * @param setRoot
         */
        public void setSetRoot(Boolean setRoot) {
            this.setRoot = setRoot;
        }

        /**
         * ??????
         *
         * @return zhhans
         */
        public Laguage getZhhans() {
            return this.zhhans;
        }

        /**
         * ??????
         *
         * @param zhhans
         */
        public void setZhhans(Laguage zhhans) {
            this.zhhans = zhhans;
        }

        /**
         * ?????? mod????????????
         *
         * @return modMaxRank mod????????????
         */
        public Integer getModMaxRank() {
            return this.modMaxRank;
        }

        /**
         * ?????? mod????????????
         *
         * @param modMaxRank mod????????????
         */
        public void setModMaxRank(Integer modMaxRank) {
            this.modMaxRank = modMaxRank;
        }

        /**
         * ?????? ????????????
         *
         * @return rarity ????????????
         */
        public String getRarity() {
            return this.rarity;
        }

        /**
         * ?????? ????????????
         *
         * @param rarity ????????????
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
