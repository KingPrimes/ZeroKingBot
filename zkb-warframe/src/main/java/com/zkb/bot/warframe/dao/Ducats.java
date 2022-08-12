package com.zkb.bot.warframe.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * 杜卡币实体类
 */

public class Ducats {


    private List<Ducat> ducats;


    public void setDucats(List<Ducat> ducats) {
        this.ducats = ducats;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("ducats", ducats).toString();
    }

    public static class Ducat {
        /**
         * 时间
         */
        @JsonProperty("datetime")
        private String datetime;
        /**
         * 月变动
         */
        @JsonProperty("position_change_month")
        private Integer positionChangeMonth;
        /**
         * 周变动
         */
        @JsonProperty("position_change_week")
        private Integer positionChangeWeek;
        /**
         * 日变动
         */
        @JsonProperty("position_change_day")
        private Integer positionChangeDay;
        /**
         * 平台价值
         */
        @JsonProperty("plat_worth")
        private String platWorth;
        /**
         * 存货
         */
        @JsonProperty("volume")
        private Integer volume;
        /**
         * 1白金=?杜卡币
         */
        @JsonProperty("ducats_per_platinum")
        private String ducatsPerPlatinum;
        /**
         * 1白金=?杜卡币 实时
         */
        @JsonProperty("ducats_per_platinum_wa")
        private Double ducatsPerPlatinumWa;
        /**
         * 杜卡币
         */
        @JsonProperty("ducats")
        private Integer ducats;
        /**
         * 物品Id
         */
        @JsonProperty("item")
        private String item;
        /**
         * 中位数
         */
        @JsonProperty("median")
        private Integer median;
        /**
         * 均价
         */
        @JsonProperty("wa_price")
        private String waPrice;
        /**
         * 当前ID
         */
        @JsonProperty("id")
        private String id;

        /**
         * 物品名称
         */
        private String item_name;


        /**
         * get 时间
         *
         * @return datetime 时间
         */
        public String getDatetime() {
            return this.datetime;
        }

        /**
         * set 时间
         *
         * @param datetime 时间
         */
        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        /**
         * get 月变动
         *
         * @return positionChangeMonth 月变动
         */
        public Integer getPositionChangeMonth() {
            return this.positionChangeMonth;
        }

        /**
         * set 月变动
         *
         * @param positionChangeMonth 月变动
         */
        public void setPositionChangeMonth(Integer positionChangeMonth) {
            this.positionChangeMonth = positionChangeMonth;
        }

        /**
         * get 周变动
         *
         * @return positionChangeWeek 周变动
         */
        public Integer getPositionChangeWeek() {
            return this.positionChangeWeek;
        }

        /**
         * set 周变动
         *
         * @param positionChangeWeek 周变动
         */
        public void setPositionChangeWeek(Integer positionChangeWeek) {
            this.positionChangeWeek = positionChangeWeek;
        }

        /**
         * get 日变动
         *
         * @return positionChangeDay 日变动
         */
        public Integer getPositionChangeDay() {
            return this.positionChangeDay;
        }

        /**
         * set 日变动
         *
         * @param positionChangeDay 日变动
         */
        public void setPositionChangeDay(Integer positionChangeDay) {
            this.positionChangeDay = positionChangeDay;
        }

        /**
         * get 平台价值
         *
         * @return platWorth 平台价值
         */
        public String getPlatWorth() {
            return this.platWorth;
        }

        /**
         * set 平台价值
         *
         * @param platWorth 平台价值
         */
        public void setPlatWorth(String platWorth) {
            this.platWorth = platWorth;
        }

        /**
         * get 存货
         *
         * @return volume 存货
         */
        public Integer getVolume() {
            return this.volume;
        }

        /**
         * set 存货
         *
         * @param volume 存货
         */
        public void setVolume(Integer volume) {
            this.volume = volume;
        }

        /**
         * get 1白金=?杜卡币
         *
         * @return ducatsPerPlatinum 1白金=?杜卡币
         */
        public String getDucatsPerPlatinum() {
            return this.ducatsPerPlatinum;
        }

        /**
         * set 1白金=?杜卡币
         *
         * @param ducatsPerPlatinum 1白金=?杜卡币
         */
        public void setDucatsPerPlatinum(String ducatsPerPlatinum) {
            this.ducatsPerPlatinum = ducatsPerPlatinum;
        }

        /**
         * get 1白金=?杜卡币 实时
         *
         * @return ducatsPerPlatinumWa 1白金=?杜卡币 实时
         */
        public Double getDucatsPerPlatinumWa() {
            return this.ducatsPerPlatinumWa;
        }

        /**
         * set 1白金=?杜卡币 实时
         *
         * @param ducatsPerPlatinumWa 1白金=?杜卡币 实时
         */
        public void setDucatsPerPlatinumWa(Double ducatsPerPlatinumWa) {
            this.ducatsPerPlatinumWa = ducatsPerPlatinumWa;
        }

        /**
         * get 杜卡币
         *
         * @return ducats 杜卡币
         */
        public Integer getDucats() {
            return this.ducats;
        }

        /**
         * set 杜卡币
         *
         * @param ducats 杜卡币
         */
        public void setDucats(Integer ducats) {
            this.ducats = ducats;
        }

        /**
         * get 物品Id
         *
         * @return item 物品Id
         */
        public String getItem() {
            return this.item;
        }

        /**
         * set 物品Id
         *
         * @param item 物品Id
         */
        public void setItem(String item) {
            this.item = item;
        }

        /**
         * get 中位数
         *
         * @return median 中位数
         */
        public Integer getMedian() {
            return this.median;
        }

        /**
         * set 中位数
         *
         * @param median 中位数
         */
        public void setMedian(Integer median) {
            this.median = median;
        }

        /**
         * get 均价
         *
         * @return waPrice 均价
         */
        public String getWaPrice() {
            return this.waPrice;
        }

        /**
         * set 均价
         *
         * @param waPrice 均价
         */
        public void setWaPrice(String waPrice) {
            this.waPrice = waPrice;
        }

        /**
         * get 当前ID
         *
         * @return id 当前ID
         */
        public String getId() {
            return this.id;
        }

        /**
         * set 当前ID
         *
         * @param id 当前ID
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * get 物品名称
         *
         * @return item_name 物品名称
         */
        public String getItem_name() {
            return this.item_name;
        }

        /**
         * set 物品名称
         *
         * @param item_name 物品名称
         */
        public void setItem_name(String item_name) {
            this.item_name = item_name;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("datetime", datetime).append("positionChangeMonth", positionChangeMonth).append("positionChangeWeek", positionChangeWeek).append("positionChangeDay", positionChangeDay).append("platWorth", platWorth).append("volume", volume).append("ducatsPerPlatinum", ducatsPerPlatinum).append("ducatsPerPlatinumWa", ducatsPerPlatinumWa).append("ducats", ducats).append("item", item).append("median", median).append("waPrice", waPrice).append("id", id).toString();
        }


    }


    /**
     * 获取银垃圾列表
     *
     * @return
     */
    public List<Ducat> getSilverDump() {
        if (this.ducats.size() == 0) return new ArrayList<>();
        List<Ducat> silver = new ArrayList<>();
        for (Ducat ducat : this.ducats) {
            if (ducat.getDucats() == 45) silver.add(ducat);
        }
        silver.sort((((o1, o2) -> o2.getDucatsPerPlatinumWa().compareTo(o1.getDucatsPerPlatinumWa()))));
        return silver;
    }

    /**
     * 获取金垃圾列表
     *
     * @return
     */
    public List<Ducat> getGodDump() {
        if (this.ducats.size() == 0) return new ArrayList<>();
        List<Ducat> silver = new ArrayList<>();
        for (Ducat ducat : this.ducats) {
            if (ducat.getDucats() == 100) silver.add(ducat);
        }
        silver.sort((((o1, o2) -> o2.getDucatsPerPlatinumWa().compareTo(o1.getDucatsPerPlatinumWa()))));
        return silver;
    }
}
