package com.zkb.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;
import java.util.List;


/**
 * Market Lich Or Sister Class
 * Market 赤毒拍卖 与 信条拍卖 实体类
 */
public class MarketLichOrSister {

    /**
     * payload
     */
    Payload payload;

    String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("payload", getPayload())
                .append("itemName", getItemName())
                .toString();
    }

    /**
     * Payload
     */
    public static class Payload {
        /**
         * auctions
         */
        List<Auctions> auctions;

        public List<Auctions> getAuctions() {
            return auctions;
        }

        public void setAuctions(List<Auctions> auctions) {
            this.auctions = auctions;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("auctions", getAuctions())
                    .toString();
        }
    }

    /**
     * Auctions
     */
    public static class Auctions {
        /**
         * 买断价
         */
        Integer buyoutPrice;
        /**
         * 起拍价格
         */
        Integer startingPrice;
        /**
         * minimalReputation
         */
        Integer minimalReputation;
        /**
         * 物品信息
         */
        Item item;
        /**
         * 留言Html格式
         */
        String note;
        /**
         * 是否可见
         */
        Boolean visible;
        /**
         * 玩家信息
         */
        Owner owner;
        /**
         * 平台
         */
        String platform;
        /**
         * 是否关闭
         */
        Boolean closed;
        /**
         * 最高价
         */
        Integer topBid;
        /**
         * winner
         */
        Object winner;
        /**
         * isMarkedFor
         */
        Object isMarkedFor;
        /**
         * markedOperationAt
         */
        Object markedOperationAt;
        /**
         * 创建时间
         */
        Date created;
        /**
         * 最后修改时间
         */
        Date updated;
        /**
         * 留言
         */
        String noteRaw;
        /**
         * 是否一口价
         */
        Boolean isDirectSell;
        /**
         * 拍卖ID可用于详细地址
         * 如：https://warframe.market/zh-hans/auction/{id}
         */
        String id;

        public Integer getBuyoutPrice() {
            return buyoutPrice;
        }

        public void setBuyoutPrice(Integer buyoutPrice) {
            this.buyoutPrice = buyoutPrice;
        }

        public Integer getStartingPrice() {
            return startingPrice;
        }

        public void setStartingPrice(Integer startingPrice) {
            this.startingPrice = startingPrice;
        }

        public Integer getMinimalReputation() {
            return minimalReputation;
        }

        public void setMinimalReputation(Integer minimalReputation) {
            this.minimalReputation = minimalReputation;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public Boolean getVisible() {
            return visible;
        }

        public void setVisible(Boolean visible) {
            this.visible = visible;
        }

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public Boolean getClosed() {
            return closed;
        }

        public void setClosed(Boolean closed) {
            this.closed = closed;
        }

        public Integer getTopBid() {
            return topBid;
        }

        public void setTopBid(Integer topBid) {
            this.topBid = topBid;
        }

        public Object getWinner() {
            return winner;
        }

        public void setWinner(Object winner) {
            this.winner = winner;
        }

        public Object getIsMarkedFor() {
            return isMarkedFor;
        }

        public void setIsMarkedFor(Object isMarkedFor) {
            this.isMarkedFor = isMarkedFor;
        }

        public Object getMarkedOperationAt() {
            return markedOperationAt;
        }

        public void setMarkedOperationAt(Object markedOperationAt) {
            this.markedOperationAt = markedOperationAt;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public Date getUpdated() {
            return updated;
        }

        public void setUpdated(Date updated) {
            this.updated = updated;
        }

        public String getNoteRaw() {
            return noteRaw;
        }

        public void setNoteRaw(String noteRaw) {
            this.noteRaw = noteRaw;
        }

        public Boolean getDirectSell() {
            return isDirectSell;
        }

        public void setDirectSell(Boolean directSell) {
            isDirectSell = directSell;
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
                    .append("buyoutPrice", getBuyoutPrice())
                    .append("startingPrice", getStartingPrice())
                    .append("minimalReputation", getMinimalReputation())
                    .append("item", getItem())
                    .append("note", getNote())
                    .append("visible", getVisible())
                    .append("owner", getOwner())
                    .append("platform", getPlatform())
                    .append("closed", getClosed())
                    .append("topBid", getTopBid())
                    .append("winner", getWinner())
                    .append("isMarkedFor", getIsMarkedFor())
                    .append("markedOperationAt", getMarkedOperationAt())
                    .append("created", getCreated())
                    .append("updated", getUpdated())
                    .append("noteRaw", getNoteRaw())
                    .append("isDirectSell", getDirectSell())
                    .append("id", getId())
                    .toString();
        }
    }

    /**
     * 物品信息
     */
    public static class Item {
        /**
         * 类型
         */
        String type;
        /**
         * 是否携带幻纹
         */
        Boolean havingEphemera;
        /**
         * 附加元素
         */
        String element;
        /**
         * 附加元素数值
         */
        Integer damage;
        /**
         * 武器Url昵称
         */
        String weaponUrlName;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Boolean getHavingEphemera() {
            return havingEphemera;
        }

        public void setHavingEphemera(Boolean havingEphemera) {
            this.havingEphemera = havingEphemera;
        }

        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public Integer getDamage() {
            return damage;
        }

        public void setDamage(Integer damage) {
            this.damage = damage;
        }

        public String getWeaponUrlName() {
            return weaponUrlName;
        }

        public void setWeaponUrlName(String weaponUrlName) {
            this.weaponUrlName = weaponUrlName;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("type", getType())
                    .append("havingEphemera", getHavingEphemera())
                    .append("element", getElement())
                    .append("damage", getDamage())
                    .append("weaponUrlName", getWeaponUrlName())
                    .toString();
        }
    }

    /**
     * 玩家信息
     */
    public static class Owner {
        /**
         * 最后在线时间
         */
        String lastSeen;
        /**
         * 名誉
         */
        Integer reputation;
        /**
         * 区服
         */
        String region;
        /**
         * 玩家昵称
         */
        String ingameName;
        /**
         * 玩家状态/是否在线
         */
        String status;
        /**
         * 玩家Id
         */
        String id;
        /**
         * 头像地址
         */
        String avatar;

        public String getLastSeen() {
            return lastSeen;
        }

        public void setLastSeen(String lastSeen) {
            this.lastSeen = lastSeen;
        }

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

        public String getIngameName() {
            return ingameName;
        }

        public void setIngameName(String ingameName) {
            this.ingameName = ingameName;
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

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("lastSeen", getLastSeen())
                    .append("reputation", getReputation())
                    .append("region", getRegion())
                    .append("ingameName", getIngameName())
                    .append("status", getStatus())
                    .append("id", getId())
                    .append("avatar", getAvatar())
                    .toString();
        }
    }
}
