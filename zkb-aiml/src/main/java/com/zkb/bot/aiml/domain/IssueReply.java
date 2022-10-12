package com.zkb.bot.aiml.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * @author KingPrimes
 */
public class IssueReply {
    //msgID
    Integer msgId;
    //问题
    String msgIssue;
    //图片MD5集合
    String msgIssueImage;
    //表情ID集合
    String msgIssueFace;
    //文字回答
    String msgReply;
    //图片Url地址集合
    String msgReplyImage;
    //表情ID集合
    String msgReplyFace;
    //创建日期
    String msgCreateTime;
    //创建群组
    String msgCreateGroup;
    //创建人员
    String msgCreateMember;




    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("msgId", msgId)
                .append("msgIssue", msgIssue)
                .append("msgIssueImage", msgIssueImage)
                .append("msgIssueFace", msgIssueFace)
                .append("msgReply", msgReply)
                .append("msgReplyImage", msgReplyImage)
                .append("msgReplyFace", msgReplyFace)
                .append("msgCreateTime", msgCreateTime)
                .append("msgCreateGroup", msgCreateGroup)
                .append("msgCreateMember", msgCreateMember)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssueReply that = (IssueReply) o;

        if (!Objects.equals(msgId, that.msgId)) return false;
        if (!Objects.equals(msgIssue, that.msgIssue)) return false;
        if (!Objects.equals(msgIssueImage, that.msgIssueImage))
            return false;
        if (!Objects.equals(msgIssueFace, that.msgIssueFace)) return false;
        if (!Objects.equals(msgReply, that.msgReply)) return false;
        if (!Objects.equals(msgReplyImage, that.msgReplyImage))
            return false;
        if (!Objects.equals(msgReplyFace, that.msgReplyFace)) return false;
        if (!Objects.equals(msgCreateTime, that.msgCreateTime))
            return false;
        if (!Objects.equals(msgCreateGroup, that.msgCreateGroup))
            return false;
        return Objects.equals(msgCreateMember, that.msgCreateMember);
    }

    @Override
    public int hashCode() {
        int result = msgId != null ? msgId.hashCode() : 0;
        result = 31 * result + (msgIssue != null ? msgIssue.hashCode() : 0);
        result = 31 * result + (msgIssueImage != null ? msgIssueImage.hashCode() : 0);
        result = 31 * result + (msgIssueFace != null ? msgIssueFace.hashCode() : 0);
        result = 31 * result + (msgReply != null ? msgReply.hashCode() : 0);
        result = 31 * result + (msgReplyImage != null ? msgReplyImage.hashCode() : 0);
        result = 31 * result + (msgReplyFace != null ? msgReplyFace.hashCode() : 0);
        result = 31 * result + (msgCreateTime != null ? msgCreateTime.hashCode() : 0);
        result = 31 * result + (msgCreateGroup != null ? msgCreateGroup.hashCode() : 0);
        result = 31 * result + (msgCreateMember != null ? msgCreateMember.hashCode() : 0);
        return result;
    }

    /**
     * 获取 msgID
     *
     * @return msgId msgID
     */
    public Integer getMsgId() {
        return this.msgId;
    }

    /**
     * 设置 msgID
     *
     * @param msgId msgID
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * 获取 问题
     *
     * @return msgIssue 问题
     */
    public String getMsgIssue() {
        return this.msgIssue;
    }

    /**
     * 设置 问题
     *
     * @param msgIssue 问题
     */
    public void setMsgIssue(String msgIssue) {
        this.msgIssue = msgIssue;
    }

    /**
     * 获取 图片MD5集合
     *
     * @return msgIssueImage 图片MD5集合
     */
    public String getMsgIssueImage() {
        return this.msgIssueImage;
    }

    /**
     * 设置 图片MD5集合
     *
     * @param msgIssueImage 图片MD5集合
     */
    public void setMsgIssueImage(String msgIssueImage) {
        this.msgIssueImage = msgIssueImage;
    }

    /**
     * 获取 表情ID集合
     *
     * @return msgIssueFace 表情ID集合
     */
    public String getMsgIssueFace() {
        return this.msgIssueFace;
    }

    /**
     * 设置 表情ID集合
     *
     * @param msgIssueFace 表情ID集合
     */
    public void setMsgIssueFace(String msgIssueFace) {
        this.msgIssueFace = msgIssueFace;
    }

    /**
     * 获取 文字回答
     *
     * @return msgReply 文字回答
     */
    public String getMsgReply() {
        return this.msgReply;
    }

    /**
     * 设置 文字回答
     *
     * @param msgReply 文字回答
     */
    public void setMsgReply(String msgReply) {
        this.msgReply = msgReply;
    }

    /**
     * 获取 图片Url地址集合
     *
     * @return msgReplyImage 图片Url地址集合
     */
    public String getMsgReplyImage() {
        return this.msgReplyImage;
    }

    /**
     * 设置 图片Url地址集合
     *
     * @param msgReplyImage 图片Url地址集合
     */
    public void setMsgReplyImage(String msgReplyImage) {
        this.msgReplyImage = msgReplyImage;
    }

    /**
     * 获取 表情ID集合
     *
     * @return msgReplyFace 表情ID集合
     */
    public String getMsgReplyFace() {
        return this.msgReplyFace;
    }

    /**
     * 设置 表情ID集合
     *
     * @param msgReplyFace 表情ID集合
     */
    public void setMsgReplyFace(String msgReplyFace) {
        this.msgReplyFace = msgReplyFace;
    }

    /**
     * 获取 创建日期
     *
     * @return msgCreateTime 创建日期
     */
    public String getMsgCreateTime() {
        return this.msgCreateTime;
    }

    /**
     * 设置 创建日期
     *
     * @param msgCreateTime 创建日期
     */
    public void setMsgCreateTime(String msgCreateTime) {
        this.msgCreateTime = msgCreateTime;
    }

    /**
     * 获取 创建群组
     *
     * @return msgCreateGroup 创建群组
     */
    public String getMsgCreateGroup() {
        return this.msgCreateGroup;
    }

    /**
     * 设置 创建群组
     *
     * @param msgCreateGroup 创建群组
     */
    public void setMsgCreateGroup(String msgCreateGroup) {
        this.msgCreateGroup = msgCreateGroup;
    }

    /**
     * 获取 创建人员
     *
     * @return msgCreateMember 创建人员
     */
    public String getMsgCreateMember() {
        return this.msgCreateMember;
    }

    /**
     * 设置 创建人员
     *
     * @param msgCreateMember 创建人员
     */
    public void setMsgCreateMember(String msgCreateMember) {
        this.msgCreateMember = msgCreateMember;
    }
}
