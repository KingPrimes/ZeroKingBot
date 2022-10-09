package com.zkb.bot.warframe.utils;


import com.zkb.bot.warframe.dao.GlobalStates;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.DateUtils;
import com.zkb.common.utils.spring.SpringUtils;

import java.util.Date;
import java.util.Locale;

import static com.zkb.bot.enums.WarframeEnum.REDIS_MISSION_KEY;

/**
 * @description: Warframe 全局状态查询
 */
public class WarframeMissionUtils {


    public static void isUpdated(SocketGlobalStates states) {
        SocketGlobalStates redisState;
        try {
            redisState = SpringUtils.getBean(RedisCache.class).getCacheObject(REDIS_MISSION_KEY.getType());
        } catch (Exception e) {
            SpringUtils.getBean(RedisCache.class).deleteObject(REDIS_MISSION_KEY.getType());
            redisState = states;
        }

        if (redisState == null) {
            SpringUtils.getBean(RedisCache.class).setCacheObject(REDIS_MISSION_KEY.getType(), states);
            return;
        }

        GlobalStates form = states.getPacket().getData();
        GlobalStates redisForm = redisState.getPacket().getData();

        if (form.getArbitration().getNode() == null) {
            states.getPacket().getData().setArbitration(redisForm.getArbitration());
        }
        SpringUtils.getBean(RedisCache.class).setCacheObject(REDIS_MISSION_KEY.getType(), states);

        //判断警报是否相同
        if (form.getAlerts() != null && redisForm.getAlerts() != null) {
            if (!form.getAlerts().equals(redisForm.getAlerts())) {
                WarframeDataUpdateMission.updateAlerts();
            }
        }

        //判断仲裁是否相同
        if (form.getArbitration() != null && redisForm.getArbitration() != null) {
            if (form.getArbitration().getNode() != null) {
                if (!form.getArbitration().equals(redisForm.getArbitration())) {
                    WarframeDataUpdateMission.updateArbitration();
                }
            }
        }


        //判断 希图斯 是否相同
        if (form.getCetusCycle() != null && redisForm.getCetusCycle() != null) {
            if (form.getCetusCycle().getState().toLowerCase(Locale.ROOT).equals("day")) {
                if (DateUtils.getDateHour(form.getCetusCycle().getExpiry(), new Date()) == 0) {
                    long date = DateUtils.getDateMin(form.getCetusCycle().getExpiry(), new Date());
                    if (date == 13) {
                        WarframeDataUpdateMission.updateCetusCycle(DateUtils.getDate(form.getCetusCycle().getExpiry(), new Date()));
                    }
                }
            }
        }
        //判断每日特惠是否相同
        if (form.getDailyDeals() != null && redisForm.getDailyDeals() != null) {
            if (form.getDailyDeals().get(0).getItem() != null) {
                if (!form.getDailyDeals().get(0).getItem().equals(redisForm.getDailyDeals().get(0).getItem())) {
                    WarframeDataUpdateMission.updateDailyDeals();
                }
            }
        }
        //判断活动是否相同
        if (form.getEvents() != null && redisForm.getEvents() != null) {
            if (form.getEvents().retainAll(redisForm.getEvents()) && redisForm.getEvents().retainAll(form.getEvents())) {
                WarframeDataUpdateMission.updateEvents();
            }
        }
        //判断入侵是否相同
        if (form.getInvasions() != null && redisForm.getInvasions() != null) {
            if (form.getInvasions().retainAll(redisForm.getInvasions()) && redisForm.getInvasions().retainAll(form.getInvasions())) {
                WarframeDataUpdateMission.updateInvasions();
            }
        }
        //判断钢铁轮换是否相同
        if (form.getSteelPath() != null && redisForm.getSteelPath() != null) {
            if (!form.getSteelPath().equals(redisForm.getSteelPath())) {
                WarframeDataUpdateMission.updateSteelPath();
            }
        }
        //判断虚空商人是否相同
        if (form.getVoidTrader() != null && redisForm.getVoidTrader() != null) {
            if (!form.getVoidTrader().equals(redisForm.getVoidTrader())) {
                if (form.getVoidTrader().getInventory().size() == 0 && !form.getVoidTrader().getActive()) {
                    WarframeDataUpdateMission.updateVoidTrader("奸商走了！\n下次会带来什么好东西呢？");
                } else {
                    WarframeDataUpdateMission.updateVoidTrader("奸商又来了！\n这次又带来了什么坏东西呢？\n奸商刺杀1等3");
                }
            }
        }
    }
}
