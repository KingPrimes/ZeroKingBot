package com.zkb.bot.aiml.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class Leaderboard {
    int count;
    long msgCreateGroup;
    long msgCreateMember;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("count", getCount())
                .append("msgCreateGroup", getMsgCreateGroup())
                .append("msgCreateMember", getMsgCreateMember())
                .toString();
    }
}
