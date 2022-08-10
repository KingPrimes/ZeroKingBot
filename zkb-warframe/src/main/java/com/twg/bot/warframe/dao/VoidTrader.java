package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class VoidTrader extends BaseWarframe {
    private String id;
    private String startString; // 距离回归
    private boolean active; //是否回归
    private String charcter; //虚空商人
    private String location; // 到达地点
    private List<Inventory> inventory; //携带的物品
    private String psId;
    private String endString; //距离 离去

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCharcter() {
        return charcter;
    }

    public void setCharcter(String charcter) {
        this.charcter = charcter;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public String getEndString() {
        return endString;
    }

    public void setEndString(String endString) {
        this.endString = endString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .append("startString", getStartString())
                .append("active", isActive())
                .append("charcter", getCharcter())
                .append("location", getLocation())
                .append("inventory", getInventory())
                .append("endString", getEndString())
                .append("psId", getPsId())
                .toString();
    }

    public static class Inventory {
        private String item; //物品名称
        private Integer ducats; //杜卡币
        private Integer credits;//星币

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Integer getDucats() {
            return ducats;
        }

        public void setDucats(Integer ducats) {
            this.ducats = ducats;
        }

        public Integer getCredits() {
            return credits;
        }

        public void setCredits(Integer credits) {
            this.credits = credits;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("item", getItem())
                    .append("ducats", getDucats())
                    .append("credits", getCredits())
                    .toString();
        }
    }
}

