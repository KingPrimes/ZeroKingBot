package com.zkb.bot.warframe.domain.subscribe;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @description: 用户与群组的订阅 实体类
 */
public class WarframeMissionSubscribe {
    //群组
    Long subscribeGroup;
    //用户
    String subscribeUser;
    //订阅内容
    Integer subscribeMissionId;
    //Bot Id
    Long subscriberBot;

    public WarframeMissionSubscribe() {
    }

    public WarframeMissionSubscribe(WarframeMissionSubscribe subscribe) {
        this.subscribeGroup = subscribe.getSubscribeGroup();
        this.subscriberBot = subscribe.getSubscriberBot();
        this.subscribeUser = subscribe.getSubscribeUser();
        this.subscribeMissionId = subscribe.getSubscribeMissionId();

    }

    public WarframeMissionSubscribe(Long subscribeGroup, String subscribeUser, Long subscriberBot, Integer subscribeMissionId) {
        this.subscribeGroup = subscribeGroup;
        this.subscribeUser = subscribeUser;
        this.subscribeMissionId = subscribeMissionId;
        this.subscriberBot = subscriberBot;
    }

    public Long getSubscribeGroup() {
        return subscribeGroup;
    }

    public void setSubscribeGroup(Long subscribeGroup) {
        this.subscribeGroup = subscribeGroup;
    }

    public String getSubscribeUser() {
        return subscribeUser;
    }

    public void setSubscribeUser(String subscribeUser) {
        this.subscribeUser = subscribeUser;
    }

    public Integer getSubscribeMissionId() {
        return subscribeMissionId;
    }

    public void setSubscribeMissionId(Integer subscribeMissionId) {
        this.subscribeMissionId = subscribeMissionId;
    }

    public Long getSubscriberBot() {
        return subscriberBot;
    }

    public void setSubscriberBot(Long subscriberBot) {
        this.subscriberBot = subscriberBot;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("subscribeGroup", subscribeGroup)
                .append("subscribeUser", subscribeUser)
                .append("subscribeMissionId", subscribeMissionId)
                .append("subscriberBot", subscriberBot)
                .toString();
    }
}
