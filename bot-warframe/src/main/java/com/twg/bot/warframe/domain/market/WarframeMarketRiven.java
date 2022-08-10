package com.twg.bot.warframe.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Warframe.Market 紫卡拍卖实体类
 */
public class WarframeMarketRiven {
    String thumb;
    String rivenType;
    String group;
    String id;
    String iconFormat;
    String urlName;
    String itemName;
    String icon;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getRivenType() {
        return rivenType;
    }

    public void setRivenType(String rivenType) {
        this.rivenType = rivenType;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIconFormat() {
        return iconFormat;
    }

    public void setIconFormat(String iconFormat) {
        this.iconFormat = iconFormat;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("thumb", getThumb())
                .append("riven_type", getRivenType())
                .append("group", getGroup())
                .append("id", getId())
                .append("icon_format", getIconFormat())
                .append("url_name", getUrlName())
                .append("item_name", getItemName())
                .append("icon", getIcon())
                .toString();
    }
}
