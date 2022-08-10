package com.twg.bot.warframe.utils;


import com.twg.bot.warframe.dao.FissureList;
import com.twg.bot.warframe.dao.GlobalStates;
import com.twg.bot.warframe.dao.Nightwave;
import com.twg.bot.warframe.dao.SocketGlobalStates;
import com.twg.bot.warframe.service.IWarframeTranslationService;
import com.twg.common.core.redis.RedisCache;
import com.twg.common.utils.DateUtils;
import com.twg.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.twg.bot.enums.WarframeTypeEnum.REDIS_MISSION_KEY;

@Component
public class WarframeUtils {


    @Autowired
    RedisCache redisCache;
    @Autowired
    IWarframeTranslationService traService;

    /**
     * 裂隙
     */
    public FissureList getFissureList() {

        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        List<GlobalStates.Fissures> fissures = sgs.getPacket().getData().getFissures();

        List<GlobalStates.Fissures> T1 = new ArrayList<>();
        List<GlobalStates.Fissures> T2 = new ArrayList<>();
        List<GlobalStates.Fissures> T3 = new ArrayList<>();
        List<GlobalStates.Fissures> T4 = new ArrayList<>();
        List<GlobalStates.Fissures> T5 = new ArrayList<>();
        FissureList fissureList = new FissureList();
        for (GlobalStates.Fissures fissure : fissures) {
            if (fissure.getActive()) {
                fissure.setActive(true);
                String node;
                if (fissure.getIsStorm()) {
                    node = traService.enToZh(
                            StringUtils.substring(
                                    fissure.getNode(),
                                    0,
                                    fissure.getNode().indexOf('('))) +
                            "(" +
                            traService.enToZh(
                                    StringUtils.substring(
                                            fissure.getNode(),
                                            fissure.getNode().indexOf('('),
                                            fissure.getNode().indexOf(')')).replace("(", "").trim())
                            + "比邻星)";
                } else {
                    node = traService.enToZh(
                            StringUtils.substring(
                                    fissure.getNode(),
                                    0,
                                    fissure.getNode().indexOf('('))) +
                            "(" +
                            traService.enToZh(
                                    StringUtils.substring(
                                            fissure.getNode(),
                                            fissure.getNode().indexOf('('),
                                            fissure.getNode().indexOf(')')).replace("(", "").trim())
                            + ")";
                }
                fissure.setNode(node);
                String mission = traService.enToZh(fissure.getMissionType());
                fissure.setMissionType(mission);
                fissure.setMissionKey(mission);
                fissure.setNodeKey(node);
                fissure.setTier(traService.enToZh(fissure.getTier()));
                Date date = new Date();
                fissure.setEta(DateUtils.getDate(fissure.getExpiry(), date));
                switch (fissure.getTierNum()) {
                    case 1:
                        T1.add(fissure);
                        break;
                    case 2:
                        T2.add(fissure);
                        break;
                    case 3:
                        T3.add(fissure);
                        break;
                    case 4:
                        T4.add(fissure);
                        break;
                    case 5:
                        T5.add(fissure);
                        break;
                }
            }
        }
        fissureList.setT1(T1);
        fissureList.setT2(T2);
        fissureList.setT3(T3);
        fissureList.setT4(T4);
        fissureList.setT5(T5);
        return fissureList;
    }

    /**
     * 电波
     *
     * @return 实体类
     */
    public Nightwave getNighTwave() {

        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.Nightwave nightwave = sgs.getPacket().getData().getNightwave();


        Nightwave nightwaves = new Nightwave();
        List<GlobalStates.Nightwave.ActiveChallenges> daily = new ArrayList<>();
        List<GlobalStates.Nightwave.ActiveChallenges> week = new ArrayList<>();
        List<GlobalStates.Nightwave.ActiveChallenges> elite = new ArrayList<>();
        for (GlobalStates.Nightwave.ActiveChallenges c : nightwave.getActiveChallenges()) {
            if (c.getActive()) {
                if (c.getReputation() == 4500) {
                    c.setDesc(traService.enToZh(c.getDesc()));
                    //c.setTitle(traService.enToZh(c.getDesc()));
                    week.add(c);
                } else if (c.getReputation() == 1000) {
                    c.setDesc(traService.enToZh(c.getDesc()));
                    //c.setTitle(traService.enToZh(c.getDesc()));
                    daily.add(c);
                }
                if (c.getIsElite()) {
                    c.setDesc(traService.enToZh(c.getDesc()));
                    //c.setTitle(traService.enToZh(c.getDesc()));
                    elite.add(c);
                }
            }
        }
        nightwaves.setDaily(daily);
        nightwaves.setWeek(week);
        nightwaves.setElite(elite);
        nightwaves.setStartString(DateUtils.getDate(new Date(), nightwave.getActivation()));
        return nightwaves;
    }


}
