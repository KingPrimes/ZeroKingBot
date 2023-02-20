package com.zkb.bot.warframe.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * WarframeInfo对象
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
@Entity
@Table(name = "warframe_info")
public class WarframeInfo {
    private static final long serialVersionUID = 1L;

    @GeneratedValue
    @Id
    private Long infoId;

    private String infoWhy;

    private String infoInse;


    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getInfoWhy() {
        return infoWhy;
    }

    public void setInfoWhy(String infoWhy) {
        this.infoWhy = infoWhy;
    }

    public String getInfoInse() {
        return infoInse;
    }

    public void setInfoInse(String infoInse) {
        this.infoInse = infoInse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("infoId", getInfoId())
                .append("infoWhy", getInfoWhy())
                .append("infoInse", getInfoInse())
                .toString();
    }
}
