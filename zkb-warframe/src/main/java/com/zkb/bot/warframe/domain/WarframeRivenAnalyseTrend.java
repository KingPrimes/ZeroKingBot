package com.zkb.bot.warframe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "warframe_riven_analyse_trend", uniqueConstraints = @UniqueConstraint(name = "name", columnNames = "name"))
public class WarframeRivenAnalyseTrend {
    @Id
    Long id;
    //效果
    String name;
    //前缀
    String prefix;
    //后缀
    String suffix;
    //步枪
    String rifle;
    //霰弹枪
    String shotgun;
    //手枪
    String pistol;
    //Archwing枪械
    String archwing;
    //近战
    String melle;

    public WarframeRivenAnalyseTrend() {
    }


    /**
     * get @Id
     *
     * @return id @Id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * set @Id
     *
     * @param id @Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get 前缀
     *
     * @return prefix 前缀
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * set 前缀
     *
     * @param prefix 前缀
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * get 后缀
     *
     * @return suffix 后缀
     */
    public String getSuffix() {
        return this.suffix;
    }

    /**
     * set 后缀
     *
     * @param suffix 后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * get 步枪
     *
     * @return rifle 步枪
     */
    public String getRifle() {
        return this.rifle;
    }

    /**
     * set 步枪
     *
     * @param rifle 步枪
     */
    public void setRifle(String rifle) {
        this.rifle = rifle;
    }

    /**
     * get 霰弹枪
     *
     * @return shotgun 霰弹枪
     */
    public String getShotgun() {
        return this.shotgun;
    }

    /**
     * set 霰弹枪
     *
     * @param shotgun 霰弹枪
     */
    public void setShotgun(String shotgun) {
        this.shotgun = shotgun;
    }

    /**
     * get 手枪
     *
     * @return pistol 手枪
     */
    public String getPistol() {
        return this.pistol;
    }

    /**
     * set 手枪
     *
     * @param pistol 手枪
     */
    public void setPistol(String pistol) {
        this.pistol = pistol;
    }

    /**
     * get Archwing枪械
     *
     * @return archwing Archwing枪械
     */
    public String getArchwing() {
        return this.archwing;
    }

    /**
     * set Archwing枪械
     *
     * @param archwing Archwing枪械
     */
    public void setArchwing(String archwing) {
        this.archwing = archwing;
    }

    /**
     * get 近战
     *
     * @return melle 近战
     */
    public String getMelle() {
        return this.melle;
    }

    /**
     * set 近战
     *
     * @param melle 近战
     */
    public void setMelle(String melle) {
        this.melle = melle;
    }

    /**
     * get 效果
     *
     * @return name 效果
     */
    public String getName() {
        return this.name;
    }

    /**
     * set 效果
     *
     * @param name 效果
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("prefix", prefix)
                .append("suffix", suffix)
                .append("rifle", rifle)
                .append("shotgun", shotgun)
                .append("pistol", pistol)
                .append("archwing", archwing)
                .append("melle", melle)
                .toString();
    }
}
