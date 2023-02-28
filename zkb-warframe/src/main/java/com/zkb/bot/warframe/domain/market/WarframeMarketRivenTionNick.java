package com.zkb.bot.warframe.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "warframe_market_riven_tion_nick", uniqueConstraints = @UniqueConstraint(name = "rivenTionNick", columnNames = {"nickEn", "nickCh"}))
public class WarframeMarketRivenTionNick {

    @GeneratedValue
    @Id
    Long id;
    String nickEn;
    String nickCh;

    public WarframeMarketRivenTionNick() {
    }

    public WarframeMarketRivenTionNick(String nickEn, String nickCh) {
        this.nickEn = nickEn;
        this.nickCh = nickCh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickEn() {
        return nickEn;
    }

    public void setNickEn(String nickEn) {
        this.nickEn = nickEn;
    }

    public String getNickCh() {
        return nickCh;
    }

    public void setNickCh(String nickCh) {
        this.nickCh = nickCh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nick_en", getNickEn())
                .append("nick_ch", getNickCh())
                .toString();
    }
}
