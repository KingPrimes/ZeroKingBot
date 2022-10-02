package com.zkb.bot.warframe.domain.market;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Warframe.Market 上的赤毒武器与信条武器拍卖
 *
 * @author KingPrimes
 * @date 2021-11-24
 */
public class WarframeMarketLichOrSister {
    private static final long serialVersionUID = 1L;

    /**
     * 物品ID
     */
    private String id;

    /**
     * 物品名称
     */

    private String itemName;

    /**
     * url查询
     */

    private String urlName;

    /**
     * 图片来源
     */

    private String iconFormat;

    /**
     * 缩略图地址
     */

    private String thumb;

    /**
     * 原图地址
     */

    private String icon;

    /**
     * 幻纹属性
     */

    private String element;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIconFormat() {
        return iconFormat;
    }

    public void setIconFormat(String iconFormat) {
        this.iconFormat = iconFormat;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("itemName", getItemName())
                .append("urlName", getUrlName())
                .append("iconFormat", getIconFormat())
                .append("thumb", getThumb())
                .append("icon", getIcon())
                .append("element", getElement())
                .toString();
    }
}
