package com.zkb.bot.warframe.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 所有未翻译的词条实体类
 *
 * @author KingPrimes
 * @className WfAllTranslNo
 * @Date 2022-3-25
 */
public class WfAllTranslNo {
    //任务ID
    private Long missId;
    //遗物ID
    private Long relicsKeyId;
    //紫卡词典ID
    private Long rivenTionId;
    //任务名称
    private String missRewardsName;
    //遗物名称
    private String relicsItemName;
    //紫卡
    private String rivenTionEn;

    public Long getRivenTionId() {
        return rivenTionId;
    }

    public void setRivenTionId(Long rivenTionId) {
        this.rivenTionId = rivenTionId;
    }

    public String getRivenTionEn() {
        return rivenTionEn;
    }

    public void setRivenTionEn(String rivenTionEn) {
        this.rivenTionEn = rivenTionEn;
    }

    public Long getMissId() {
        return missId;
    }

    public void setMissId(Long missId) {
        this.missId = missId;
    }

    public Long getRelicsKeyId() {
        return relicsKeyId;
    }

    public void setRelicsKeyId(Long relicsKeyId) {
        this.relicsKeyId = relicsKeyId;
    }


    public String getMissRewardsName() {
        return missRewardsName;
    }

    public void setMissRewardsName(String missRewardsName) {
        this.missRewardsName = missRewardsName;
    }

    public String getRelicsItemName() {
        return relicsItemName;
    }

    public void setRelicsItemName(String relicsItemName) {
        this.relicsItemName = relicsItemName;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("missId", getMissId())
                .toString();
    }
}
