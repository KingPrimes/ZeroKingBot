package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 电波
 */
public class Nightwave extends BaseWarframe {
    private String id;
    private String startString;
    private Boolean active;
    private Integer season;
    private String tag;
    private Integer phase;
    private List<GlobalStates.Nightwave.ActiveChallenges> activeChallenges;
    private List<GlobalStates.Nightwave.ActiveChallenges> daily;
    private List<GlobalStates.Nightwave.ActiveChallenges> week;
    private List<GlobalStates.Nightwave.ActiveChallenges> elite;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public List<GlobalStates.Nightwave.ActiveChallenges> getActiveChallenges() {
        return activeChallenges;
    }

    public void setActiveChallenges(List<GlobalStates.Nightwave.ActiveChallenges> activeChallenges) {
        this.activeChallenges = activeChallenges;
    }

    public List<GlobalStates.Nightwave.ActiveChallenges> getDaily() {
        return daily;
    }

    public void setDaily(List<GlobalStates.Nightwave.ActiveChallenges> daily) {
        this.daily = daily;
    }

    public List<GlobalStates.Nightwave.ActiveChallenges> getWeek() {
        return week;
    }

    public void setWeek(List<GlobalStates.Nightwave.ActiveChallenges> week) {
        this.week = week;
    }

    public List<GlobalStates.Nightwave.ActiveChallenges> getElite() {
        return elite;
    }

    public void setElite(List<GlobalStates.Nightwave.ActiveChallenges> elite) {
        this.elite = elite;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("startString", getStartString())
                .append("active", getActive())
                .append("season", getSeason())
                .append("tag", getTag())
                .append("phase", getPhase())
                .append("activeChallenges", getActiveChallenges())
                .append("daily", getDaily())
                .append("week", getWeek())
                .append("elite", getElite())
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .toString();
    }

    public static class Challenges extends BaseWarframe {
        private String id;
        private String startString;
        private Boolean active;
        private Boolean isDaily;
        private Boolean isElite;
        private String desc;
        private String title;
        private Integer reputation;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStartString() {
            return startString;
        }

        public void setStartString(String startString) {
            this.startString = startString;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public Boolean getDaily() {
            return isDaily;
        }

        public void setDaily(Boolean daily) {
            isDaily = daily;
        }

        public Boolean getElite() {
            return isElite;
        }

        public void setElite(Boolean elite) {
            isElite = elite;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getReputation() {
            return reputation;
        }

        public void setReputation(Integer reputation) {
            this.reputation = reputation;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("id", getId())
                    .append("startString", getStartString())
                    .append("active", getActive())
                    .append("isDaily", getDaily())
                    .append("isElite", getElite())
                    .append("desc", getDesc())
                    .append("title", getTitle())
                    .append("reputation", getReputation())
                    .append("activation", getActivation())
                    .append("expiry", getExpiry())
                    .toString();
        }
    }
}
