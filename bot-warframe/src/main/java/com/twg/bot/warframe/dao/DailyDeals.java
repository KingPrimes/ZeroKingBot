package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DailyDeals extends BaseWarframe {
    private String item;
    private Integer originalPrice;
    private Integer salePrice;
    private Integer total;
    private Integer sold;
    private String id;
    private String eta;
    private Integer discount;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .append("item", getItem())
                .append("originalPrice", getOriginalPrice())
                .append("salePrice", getSalePrice())
                .append("total", getTotal())
                .append("sold", getSold())
                .append("id", getId())
                .append("eta", getEta())
                .append("discount", getDiscount())
                .toString();
    }
}
