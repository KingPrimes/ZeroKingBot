package com.twg.bot.warframe.dao;


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
        String thumb;
        String urlName;
        List<String> tags;
        Integer masteryLevel;
        String icon;
        Integer tradingTax;
        String subIcon;
        String id;
        Integer ducats;
        String iconFormat;
        Boolean setRoot;
        Laguage zhhans;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getUrl_name() {
            return urlName;
        }

        public void setUrl_name(String url_name) {
            this.urlName = url_name;
        }

        public Integer getMastery_level() {
            return masteryLevel;
        }

        public void setMastery_level(Integer mastery_level) {
            this.masteryLevel = mastery_level;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getTrading_tax() {
            return tradingTax;
        }

        public void setTrading_tax(Integer trading_tax) {
            this.tradingTax = trading_tax;
        }

        public String getSub_icon() {
            return subIcon;
        }

        public void setSub_icon(String sub_icon) {
            this.subIcon = sub_icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getDucats() {
            return ducats;
        }

        public void setDucats(Integer ducats) {
            this.ducats = ducats;
        }

        public String getIcon_format() {
            return iconFormat;
        }

        public void setIcon_format(String icon_format) {
            this.iconFormat = icon_format;
        }

        public Boolean getSet_root() {
            return setRoot;
        }

        public void setSet_root(Boolean set_root) {
            this.setRoot = set_root;
        }

        public Laguage getZhHans() {
            return zhhans;
        }

        public void setZhHans(Laguage zhHans) {
            this.zhhans = zhHans;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", getId())
                    .append("thumb", getThumb())
                    .append("url_name", getUrl_name())
                    .append("icon", getIcon())
                    .append("sub_icon", getSub_icon())
                    .append("icon_format", getIcon_format())
                    .append("tags", getTags())
                    .append("mastery_level", getMastery_level())
                    .append("trading_tax", getTrading_tax())
                    .append("ducats", getDucats())
                    .append("set_root", getSet_root())
                    .append("zh-hans", getZhHans())
                    .toString();
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
