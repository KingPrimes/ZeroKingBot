package com.twg.bot.warframe.dao;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class MarketStatistic {
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
        StatisticsLive statisticsLive;

        public StatisticsLive getStatisticsLive() {
            return statisticsLive;
        }

        public void setStatisticsLive(StatisticsLive statisticsLive) {
            this.statisticsLive = statisticsLive;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("statisticsLive", getStatisticsLive())
                    .toString();
        }
    }

    public static class StatisticsLive {
        List<_$48hours> $48hours;
        List<_$90days> $90days;

        public List<_$48hours> get$48hours() {
            return $48hours;
        }

        public void set$48hours(List<_$48hours> $48hours) {
            this.$48hours = $48hours;
        }

        public List<_$90days> get$90days() {
            return $90days;
        }

        public void set$90days(List<_$90days> $90days) {
            this.$90days = $90days;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("48hours", get$48hours())
                    .append("90days", get$90days())
                    .toString();
        }
    }

    public static class _$48hours {
        String datetime;
        Integer volume;
        Integer minPrice; //最低价
        Integer maxPrice; //最高价
        Double avgPrice; //均价
        Double waPrice; //价格
        Double median; // 中位数
        String orderType;
        Double movingAvg;
        String id;

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public Integer getVolume() {
            return volume;
        }

        public void setVolume(Integer volume) {
            this.volume = volume;
        }

        public Integer getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(Integer minPrice) {
            this.minPrice = minPrice;
        }

        public Integer getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(Integer maxPrice) {
            this.maxPrice = maxPrice;
        }

        public Double getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(Double avgPrice) {
            this.avgPrice = avgPrice;
        }

        public Double getWaPrice() {
            return waPrice;
        }

        public void setWaPrice(Double waPrice) {
            this.waPrice = waPrice;
        }

        public Double getMedian() {
            return median;
        }

        public void setMedian(Double median) {
            this.median = median;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public Double getMovingAvg() {
            return movingAvg;
        }

        public void setMovingAvg(Double movingAvg) {
            this.movingAvg = movingAvg;
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
                    .append("datetime", getDatetime())
                    .append("volume", getVolume())
                    .append("minPrice", getMinPrice())
                    .append("maxPrice", getMaxPrice())
                    .append("avgPrice", getAvgPrice())
                    .append("waPrice", getWaPrice())
                    .append("median", getMedian())
                    .append("orderType", getOrderType())
                    .append("movingAvg", getMovingAvg())
                    .append("id", getId())
                    .toString();
        }
    }


    public static class _$90days {
        String datetime;
        Integer volume;
        Integer minPrice;
        Integer maxPrice;
        Double avgPrice;
        Double waPrice;
        Integer median;
        String orderType;
        Double movingAvg;
        String id;

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public Integer getVolume() {
            return volume;
        }

        public void setVolume(Integer volume) {
            this.volume = volume;
        }

        public Integer getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(Integer minPrice) {
            this.minPrice = minPrice;
        }

        public Integer getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(Integer maxPrice) {
            this.maxPrice = maxPrice;
        }

        public Double getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(Double avgPrice) {
            this.avgPrice = avgPrice;
        }

        public Double getWaPrice() {
            return waPrice;
        }

        public void setWaPrice(Double waPrice) {
            this.waPrice = waPrice;
        }

        public Integer getMedian() {
            return median;
        }

        public void setMedian(Integer median) {
            this.median = median;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public Double getMovingAvg() {
            return movingAvg;
        }

        public void setMovingAvg(Double movingAvg) {
            this.movingAvg = movingAvg;
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
                    .append("datetime", getDatetime())
                    .append("volume", getVolume())
                    .append("minPrice", getMinPrice())
                    .append("maxPrice", getMaxPrice())
                    .append("avgPrice", getAvgPrice())
                    .append("waPrice", getWaPrice())
                    .append("median", getMedian())
                    .append("orderType", getOrderType())
                    .append("movingAvg", getMovingAvg())
                    .append("id", getId())
                    .toString();
        }
    }
}
