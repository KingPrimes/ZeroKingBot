package com.twg.bot.warframe.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 中英文翻译 实体类
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
public class WarframeTranslation {
    private static final long serialVersionUID = 1L;

    private Long traId;

    /**
     * 英文
     */
    private String traEn;

    /**
     * 中文
     */
    private String traCh;

    /**
     * 0不是prime 1是prime
     */
    private Long traPrime;
    /**
     * 0不是set 1是set
     */
    private Long traSet;

    public Long getTraId() {
        return traId;
    }

    public void setTraId(Long traId) {
        this.traId = traId;
    }

    public String getTraEn() {
        return traEn;
    }

    public void setTraEn(String traEn) {
        this.traEn = traEn;
    }

    public String getTraCh() {
        return traCh;
    }

    public void setTraCh(String traCh) {
        this.traCh = traCh;
    }

    public Long getTraPrime() {
        return traPrime;
    }

    public void setTraPrime(Long traPrime) {
        this.traPrime = traPrime;
    }

    public Long getTraSet() {
        return traSet;
    }

    public void setTraSet(Long traSet) {
        this.traSet = traSet;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("traId", getTraId())
                .append("traEn", getTraEn())
                .append("traCh", getTraCh())
                .append("traPrime", getTraPrime())
                .append("traSet", getTraSet())
                .toString();
    }
}
