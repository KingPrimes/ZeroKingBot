package com.zkb.bot.warframe.dao;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Data
public class FissureList {
    private List<GlobalStates.Fissures> T1;
    private List<GlobalStates.Fissures> T2;
    private List<GlobalStates.Fissures> T3;
    private List<GlobalStates.Fissures> T4;
    private List<GlobalStates.Fissures> T5;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("T1", getT1())
                .append("T2", getT2())
                .append("T3", getT3())
                .append("T4", getT4())
                .append("T5", getT5())
                .toString();
    }
}
