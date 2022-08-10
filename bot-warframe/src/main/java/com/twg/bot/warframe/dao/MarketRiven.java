package com.twg.bot.warframe.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
 * Warframe.Market Riven查询
 */
public class MarketRiven {

    Payload payload;

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
                .toString();
    }

    public static class Payload {
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

    public static class Auctions {

        Item item;

        Integer buyoutPrice;

        Integer minimalReputation;

        String note;

        Boolean visible;

        @JsonProperty("private")
        Boolean _private;

        Integer startingPrice;

        Owner owner;

        String platform;

        Boolean closed;

        Object topBid;

        Object winner;

        Object isMarkedFor;

        Object markedOperationAt;

        String created;

        String updated;

        String noteRaw;

        Boolean isDirectSell;

        String id;

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public Integer getBuyoutPrice() {
            return buyoutPrice;
        }

        public void setBuyoutPrice(Integer buyoutPrice) {
            this.buyoutPrice = buyoutPrice;
        }

        public Integer getMinimalReputation() {
            return minimalReputation;
        }

        public void setMinimalReputation(Integer minimalReputation) {
            this.minimalReputation = minimalReputation;
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

        public Boolean get_private() {
            return _private;
        }

        public void set_private(Boolean _private) {
            this._private = _private;
        }

        public Integer getStartingPrice() {
            return startingPrice;
        }

        public void setStartingPrice(Integer startingPrice) {
            this.startingPrice = startingPrice;
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

        public Object getTopBid() {
            return topBid;
        }

        public void setTopBid(Object topBid) {
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

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
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
                    .append("item", getItem())
                    .append("buyout_price", getBuyoutPrice())
                    .append("minimal_reputation", getMinimalReputation())
                    .append("note", getNote())
                    .append("visible", getVisible())
                    .append("private", get_private())
                    .append("starting_price", getStartingPrice())
                    .append("owner", getOwner())
                    .append("platform", getPlatform())
                    .append("closed", getClosed())
                    .append("top_bid", getTopBid())
                    .append("winner", getWinner())
                    .append("is_marked_for", getIsMarkedFor())
                    .append("marked_operation_at", getMarkedOperationAt())
                    .append("created", getCreated())
                    .append("updated", getUpdated())
                    .append("note_raw", getNoteRaw())
                    .append("is_direct_sell", getDirectSell())
                    .append("id", getId())
                    .toString();
        }
    }

    public static class Item {

        List<Attributes> attributes;

        String name;

        Integer modRank;

        String type;

        Integer reRolls;

        String weaponUrlName;

        String polarity;

        Integer masteryLevel;

        public List<Attributes> getAttributes() {
            return attributes;
        }

        public void setAttributes(List<Attributes> attributes) {
            this.attributes = attributes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getModRank() {
            return modRank;
        }

        public void setModRank(Integer modRank) {
            this.modRank = modRank;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getReRolls() {
            return reRolls;
        }

        public void setReRolls(Integer reRolls) {
            this.reRolls = reRolls;
        }

        public String getWeaponUrlName() {
            return weaponUrlName;
        }

        public void setWeaponUrlName(String weaponUrlName) {
            this.weaponUrlName = weaponUrlName;
        }

        public String getPolarity() {
            return polarity;
        }

        public void setPolarity(String polarity) {
            this.polarity = polarity;
        }

        public Integer getMasteryLevel() {
            return masteryLevel;
        }

        public void setMasteryLevel(Integer masteryLevel) {
            this.masteryLevel = masteryLevel;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("attributes", getAttributes())
                    .append("name", getName())
                    .append("mod_rank", getModRank())
                    .append("type", getType())
                    .append("re_rolls", getReRolls())
                    .append("weapon_url_name", getWeaponUrlName())
                    .append("polarity", getPolarity())
                    .append("mastery_level", getMasteryLevel())
                    .toString();
        }
    }

    public static class Attributes {

        Boolean positive;

        Double value;

        String urlName;

        public Boolean getPositive() {
            return positive;
        }

        public void setPositive(Boolean positive) {
            this.positive = positive;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getUrlName() {
            return urlName;
        }

        public void setUrlName(String urlName) {
            this.urlName = urlName;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("positive", getPositive())
                    .append("value", getValue())
                    .append("url_name", getUrlName())
                    .toString();
        }
    }

    public static class Owner {

        String ingameName;

        String lastSeen;

        Integer reputation;

        String region;

        String status;

        String id;

        Object avatar;

        public String getIngameName() {
            return ingameName;
        }

        public void setIngameName(String ingameName) {
            this.ingameName = ingameName;
        }

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

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("ingame_name", getIngameName())
                    .append("last_seen", getLastSeen())
                    .append("reputation", getReputation())
                    .append("region", getRegion())
                    .append("status", getStatus())
                    .append("id", getId())
                    .append("avatar", getAvatar())
                    .toString();
        }
    }
}
