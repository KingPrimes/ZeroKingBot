package com.zkb.bot.warframe.dao;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


public class FissureList {
    private List<GlobalStates.Fissures> T1;
    private List<GlobalStates.Fissures> T2;
    private List<GlobalStates.Fissures> T3;
    private List<GlobalStates.Fissures> T4;
    private List<GlobalStates.Fissures> T5;

    public List<GlobalStates.Fissures> getT1() {
        return T1;
    }

    public void setT1(List<GlobalStates.Fissures> t1) {
        T1 = t1;
    }

    public List<GlobalStates.Fissures> getT2() {
        return T2;
    }

    public void setT2(List<GlobalStates.Fissures> t2) {
        T2 = t2;
    }

    public List<GlobalStates.Fissures> getT3() {
        return T3;
    }

    public void setT3(List<GlobalStates.Fissures> t3) {
        T3 = t3;
    }

    public List<GlobalStates.Fissures> getT4() {
        return T4;
    }

    public void setT4(List<GlobalStates.Fissures> t4) {
        T4 = t4;
    }

    public List<GlobalStates.Fissures> getT5() {
        return T5;
    }

    public void setT5(List<GlobalStates.Fissures> t5) {
        T5 = t5;
    }

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
