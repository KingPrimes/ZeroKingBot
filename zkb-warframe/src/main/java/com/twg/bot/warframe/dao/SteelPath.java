package com.twg.bot.warframe.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class SteelPath extends BaseWarframe {
    private String remaining;
    private Reward currentReward;
    private List<Reward> evergreens;
    private List<Reward> rotation;

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public Reward getCurrentReward() {
        return currentReward;
    }

    public void setCurrentReward(Reward currentReward) {
        this.currentReward = currentReward;
    }

    public List<Reward> getEvergreens() {
        return evergreens;
    }

    public void setEvergreens(List<Reward> evergreens) {
        this.evergreens = evergreens;
    }

    public List<Reward> getRotation() {
        return rotation;
    }

    public void setRotation(List<Reward> rotation) {
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("activation", getActivation())
                .append("expiry", getExpiry())
                .append("remaining", getRemaining())
                .append("currentReward", getCurrentReward())
                .append("rotation", getRotation())
                .append("evergreens", getEvergreens())
                .toString();
    }

    public static class Reward {
        private String name;
        private Integer cost;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCost() {
            return cost;
        }

        public void setCost(Integer cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("name", getName())
                    .append("cost", getCost())
                    .toString();
        }
    }
}
