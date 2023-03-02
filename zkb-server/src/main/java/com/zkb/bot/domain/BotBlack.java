package com.zkb.bot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "bot_black", uniqueConstraints = @UniqueConstraint(name = "botBlack", columnNames = {"userId", "groupId"}))
public class BotBlack {
    @Id
    Long blackId;

    Long userId;
    Long groupId;

    public Long getBlackId() {
        return blackId;
    }

    public void setBlackId(Long blackId) {
        this.blackId = blackId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("blackId", blackId)
                .append("userId", userId)
                .append("groupId", groupId)
                .toString();
    }
}
