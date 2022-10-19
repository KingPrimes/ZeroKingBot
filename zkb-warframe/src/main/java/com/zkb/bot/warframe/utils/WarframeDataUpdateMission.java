package com.zkb.bot.warframe.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotContainer;
import com.zkb.bot.enums.WarframeSubscribeEnums;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.warframe.domain.subscribe.WarframeMissionSubscribe;
import com.zkb.bot.warframe.service.IWarframeMissionSubscribeService;
import com.zkb.bot.warframe.service.impl.WarframeMissionSubscribeServiceImpl;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.utils.uuid.UUID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class WarframeDataUpdateMission {


    /**
     * 警报更新提醒
     */
    public static void updateAlerts() {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_ALERTS, "警报更新了！", "");
    }

    /**
     * 仲裁更新提醒
     */
    public static void updateArbitration() {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_ARBITRATION, "仲裁更新了！", "http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getArbitrationImage/0/0/0/0");
    }

    /**
     * 每日特惠更新 提醒
     */
    public static void updateDailyDeals() {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_DAILY_DEALS, "每日特惠更新了!", "http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getDailyDealsImage/0/0/0/0");
    }

    /**
     * 活动更新提醒
     */
    public static void updateEvents() {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_EVENTS, "有新的活动!", "");
    }

    /**
     * 新的入侵
     */
    public static void updateInvasions() {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_INVASIONS, "星系又开始骚动了！\n新的入侵已到来！", "http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getInvasionsImage/0/0/0/0");
    }

    /**
     * 钢铁之路兑换轮换
     */
    public static void updateSteelPath() {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_STEEL_PATH, "钢铁之路兑换奖励轮换！\n这次的奖励是什么呢？\n是U福马么？", "http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getSteelPathImage/0/0/0/0");
    }

    /**
     * 虚空商人 离开/到来 提醒
     *
     * @param msg 骚话！
     */
    public static void updateVoidTrader(String msg) {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_VOID, msg, "http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getVoidImage/0/0/0/0");
    }

    /**
     * 到黑夜前提醒
     */
    public static void updateCetusCycle(String time) {
        sendGroupsToUser(WarframeSubscribeEnums.SUBSCRIBE_CETUS_CYCLE, "夜灵平野即将黑夜！\n距离黑夜还剩 " + time, "");
    }

    /**
     * 订阅全部任务
     *
     * @param subscribe 群组
     * @return 影响行
     */
    public static int updateAll(WarframeMissionSubscribe subscribe) {
        int i = 0;
        for (WarframeSubscribeEnums enums : WarframeSubscribeEnums.values()) {
            subscribe.setSubscribeMissionId(enums.ordinal());
            i += SpringUtils.getBean(IWarframeMissionSubscribeService.class).updateWarframeMissionSubscribeUser(subscribe);
        }
        return i;
    }

    /**
     * 删除全部订阅任务
     *
     * @param subscribe 群组
     * @return 影响行
     */
    public static int deleteAll(WarframeMissionSubscribe subscribe) {
        int i = 0;
        for (WarframeSubscribeEnums enums : WarframeSubscribeEnums.values()) {
            subscribe.setSubscribeMissionId(enums.ordinal());
            i += SpringUtils.getBean(IWarframeMissionSubscribeService.class).deleteWarframeMissionSubscribe(subscribe);
        }
        return i;
    }

    public static WarframeSubscribeEnums getSubscribeEnums(Integer or) {
        for (WarframeSubscribeEnums enums : WarframeSubscribeEnums.values()) {
            if (enums.ordinal() == or) {
                return enums;
            }
        }
        return WarframeSubscribeEnums.SUBSCRIBE_ERROR;
    }

    /**
     * 通知所有的订阅群组与用户
     *
     * @param enums    通知类型
     * @param msgText  文本消息
     * @param imageUrl 图片Url地址
     */
    private static void sendGroupsToUser(WarframeSubscribeEnums enums, String msgText, String imageUrl) {
        //msgText imageUrl 不可同时为空或null
        if ((Objects.equals(msgText, "") || msgText == null) && (Objects.equals(imageUrl, "") || imageUrl == null)) {
            return;
        }
        //获取所有订阅
        List<WarframeMissionSubscribe> subscribes = SpringUtils.getBean(WarframeMissionSubscribeServiceImpl.class).selectWarframeMissionSubscribeList(null);
        if (subscribes == null) {
            return;
        }
        //获取Bots
        Map<Long, Bot> bots = SpringUtils.getBean(BotContainer.class).robots;

        try {
            //遍历所有的订阅
            for (WarframeMissionSubscribe subscribe : subscribes) {
                //构建消息体
                Msg msg = new Msg();
                //设置消息
                if (!Objects.equals(msgText, "")) {
                    msg.text(msgText + "\n");
                }
                if (!Objects.equals(imageUrl, "")) {
                    msg.img(imageUrl);
                }
                //如果user不为空则添加艾特 同时判断此用户是否开启订阅
                if (subscribe.getSubscribeUser() != null && subscribe.getSubscribeMissionId() == enums.ordinal()) {
                    String[] users = subscribe.getSubscribeUser().split("-");
                    for (String user : users) {
                        if (user != null && !user.equals("")) {
                            msg.at(Long.parseLong(user));
                        }
                    }
                }
                if (subscribe.getSubscribeMissionId() == enums.ordinal()) {
                    //bots.get(subscribe.getSubscriberBot()).sendGroupMsg(subscribe.getSubscribeGroup(),"",true);
                    //通知所有的订阅群组 同时判断此群组是否开启订阅
                    msg.sendToGroup(bots.get(subscribe.getSubscriberBot()), subscribe.getSubscribeGroup());
                    Thread.sleep(20);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
