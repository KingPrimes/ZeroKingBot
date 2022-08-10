package com.twg.bot.warframe.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 仲裁
 */
public class Arbitration extends BaseWarframe {
    @JsonProperty("etc")
    private String etc;
    @JsonProperty("node")
    private String node;
    @JsonProperty("enemy")
    private String enemy;
    @JsonProperty("type")
    private String type;
    @JsonProperty("archwing")
    private Boolean archwing;
    @JsonProperty("sharkwing")
    private Boolean sharkwing;

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getArchwing() {
        return archwing;
    }

    public void setArchwing(Boolean archwing) {
        this.archwing = archwing;
    }

    public Boolean getSharkwing() {
        return sharkwing;
    }

    public void setSharkwing(Boolean sharkwing) {
        this.sharkwing = sharkwing;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arbitration)) return false;
        Arbitration that = (Arbitration) o;
        return new EqualsBuilder().append(getEnemy(), that.getEnemy())
                .append(getType(), that.getType())
                .append(getArchwing(), that.getArchwing())
                .append(getSharkwing(), that.getSharkwing())
                .append(getNode(), that.getNode())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getEnemy())
                .append(getType())
                .append(getArchwing())
                .append(getSharkwing())
                .append(getNode())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .append("enemy", getEnemy())
                .append("type", getType())
                .append("archwing", getArchwing())
                .append("sharkwing", getSharkwing())
                .append("node", getNode())
                .append("ect", getEtc())
                .toString();
    }
}
