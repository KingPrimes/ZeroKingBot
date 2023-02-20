package com.zkb.bot.warframe.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "warframe_market_items",uniqueConstraints = @UniqueConstraint(name = "items",columnNames = {"itemName", "urlName"}))
public class WarframeMarketItems {

    @GeneratedValue
    @Id
    Long ids;

    String id;

    String thumb;


    String itemName;
    String urlName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public Long getIds() {
        return ids;
    }

    public void setIds(Long ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("thumb", getThumb())
                .append("item_name", getItemName())
                .append("url_name", getUrlName())
                .toString();
    }
}
