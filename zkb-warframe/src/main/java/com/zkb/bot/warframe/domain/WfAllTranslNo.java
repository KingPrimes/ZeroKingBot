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


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("missId", missId)
                .append("relicsKeyId", relicsKeyId)
                .append("rivenTionId", rivenTionId)
                .append("missRewardsName", missRewardsName)
                .append("relicsItemName", relicsItemName)
                .append("rivenTionEn", rivenTionEn)
                .toString();
    }

    /**
     * get 任务ID
     *
     * @return missId 任务ID
     */
    public Long getMissId() {
        return this.missId;
    }

    /**
     * set 任务ID
     *
     * @param missId 任务ID
     */
    public void setMissId(Long missId) {
        this.missId = missId;
    }

    /**
     * get 遗物ID
     *
     * @return relicsKeyId 遗物ID
     */
    public Long getRelicsKeyId() {
        return this.relicsKeyId;
    }

    /**
     * set 遗物ID
     *
     * @param relicsKeyId 遗物ID
     */
    public void setRelicsKeyId(Long relicsKeyId) {
        this.relicsKeyId = relicsKeyId;
    }

    /**
     * get 紫卡词典ID
     *
     * @return rivenTionId 紫卡词典ID
     */
    public Long getRivenTionId() {
        return this.rivenTionId;
    }

    /**
     * set 紫卡词典ID
     *
     * @param rivenTionId 紫卡词典ID
     */
    public void setRivenTionId(Long rivenTionId) {
        this.rivenTionId = rivenTionId;
    }

    /**
     * get 任务名称
     *
     * @return missRewardsName 任务名称
     */
    public String getMissRewardsName() {
        return this.missRewardsName;
    }

    /**
     * set 任务名称
     *
     * @param missRewardsName 任务名称
     */
    public void setMissRewardsName(String missRewardsName) {
        this.missRewardsName = missRewardsName;
    }

    /**
     * get 遗物名称
     *
     * @return relicsItemName 遗物名称
     */
    public String getRelicsItemName() {
        return this.relicsItemName;
    }

    /**
     * set 遗物名称
     *
     * @param relicsItemName 遗物名称
     */
    public void setRelicsItemName(String relicsItemName) {
        this.relicsItemName = relicsItemName;
    }

    /**
     * get 紫卡
     *
     * @return rivenTionEn 紫卡
     */
    public String getRivenTionEn() {
        return this.rivenTionEn;
    }

    /**
     * set 紫卡
     *
     * @param rivenTionEn 紫卡
     */
    public void setRivenTionEn(String rivenTionEn) {
        this.rivenTionEn = rivenTionEn;
    }
}
