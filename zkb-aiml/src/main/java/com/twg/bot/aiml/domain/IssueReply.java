package com.twg.bot.aiml.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * @author KingPrimes
 */
public class IssueReply {
    Integer msgId;
    String msgIssue;
    String msgIssueImage;
    String msgIssueFace;
    String msgReply;
    byte[] msgReplyImage;
    String msgReplyImageBate64;
    Date msgCreateTime;
    String msgCreateGroup;
    String msgCreateMember;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgIssue() {
        return msgIssue;
    }

    public void setMsgIssue(String msgIssue) {
        this.msgIssue = msgIssue;
    }

    public String getMsgIssueImage() {
        return msgIssueImage;
    }

    public void setMsgIssueImage(String msgIssueImage) {
        this.msgIssueImage = msgIssueImage;
    }

    public String getMsgIssueFace() {
        return msgIssueFace;
    }

    public void setMsgIssueFace(String msgIssueFace) {
        this.msgIssueFace = msgIssueFace;
    }

    public String getMsgReply() {
        return msgReply;
    }

    public void setMsgReply(String msgReply) {
        this.msgReply = msgReply;
    }

    public byte[] getMsgReplyImage() {
        return msgReplyImage;
    }

    public void setMsgReplyImage(byte[] msgReplyImage) {
        this.msgReplyImage = msgReplyImage;
    }

    public Date getMsgCreateTime() {
        return msgCreateTime;
    }

    public void setMsgCreateTime(Date msgCreateTime) {
        this.msgCreateTime = msgCreateTime;
    }

    public String getMsgCreateGroup() {
        return msgCreateGroup;
    }

    public void setMsgCreateGroup(String msgCreateGroup) {
        this.msgCreateGroup = msgCreateGroup;
    }

    public String getMsgCreateMember() {
        return msgCreateMember;
    }

    public void setMsgCreateMember(String msgCreateMember) {
        this.msgCreateMember = msgCreateMember;
    }

    public String getMsgReplyImageBate64() {
        return msgReplyImageBate64;
    }

    public void setMsgReplyImageBate64(String msgReplyImageBate64) {
        this.msgReplyImageBate64 = msgReplyImageBate64;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("msgId", getMsgId())
                .append("msgIssue", getMsgIssue())
                .append("msgIssueImage", getMsgIssueImage())
                .append("msgIssueFace", getMsgIssueFace())
                .append("msgReply", getMsgReply())
                .append("msgReplyImage", getMsgReplyImage())
                .append("msgReplyImageBate64", getMsgReplyImageBate64())
                .append("msgCreateTime", getMsgCreateTime())
                .append("msgCreateGroup", getMsgCreateGroup())
                .append("msgCreateMember", getMsgCreateMember())
                .toString();
    }
}
