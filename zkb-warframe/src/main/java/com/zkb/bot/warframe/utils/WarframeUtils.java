package com.zkb.bot.warframe.utils;


import com.zkb.bilibili.dao.BiliBili;
import com.zkb.bilibili.enums.BiliBliTypeEnum;
import com.zkb.bilibili.utils.UpUtils;
import com.zkb.bot.enums.WarframeFissureTypeEnum;
import com.zkb.bot.warframe.dao.FissureList;
import com.zkb.bot.warframe.dao.GlobalStates;
import com.zkb.bot.warframe.dao.Nightwave;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.DateUtils;
import com.zkb.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

import static com.zkb.bot.enums.WarframeTypeEnum.REDIS_MISSION_KEY;

@Component
public class WarframeUtils {

    @Resource
    RedisCache redisCache;
    @Resource
    IWarframeTranslationService traService;

    /**
     * 裂隙
     */
    public FissureList getFissureList(WarframeFissureTypeEnum type) {

        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        List<GlobalStates.Fissures> fissures = sgs.getPacket().getData().getFissures();
        Map<WarframeFissureTypeEnum, List<GlobalStates.Fissures>> fissMap = fissType(fissures);
        return getFissureListType(fissMap.get(type));
    }

    /**
     * 获取裂隙类型并分类
     *
     * @param fissures 裂隙
     * @return Map集合
     * ordinary：普通
     * storm：九重天
     * hard：钢铁
     */
    private Map<WarframeFissureTypeEnum, List<GlobalStates.Fissures>> fissType(List<GlobalStates.Fissures> fissures) {
        Map<WarframeFissureTypeEnum, List<GlobalStates.Fissures>> fiss = new HashMap<>();
        List<GlobalStates.Fissures> ordinary = new ArrayList<>();
        List<GlobalStates.Fissures> storm = new ArrayList<>();
        List<GlobalStates.Fissures> hard = new ArrayList<>();
        for (GlobalStates.Fissures f : fissures) {
            if (f.getActive()) {
                if (!f.getIsStorm() && !f.getIsHard()) {
                    ordinary.add(f);
                }
            }
        }

        for (GlobalStates.Fissures f : fissures) {
            if (f.getActive()) {
                if (f.getIsStorm()) {
                    storm.add(f);
                }
            }
        }

        for (GlobalStates.Fissures f : fissures) {
            if (f.getActive()) {
                if (f.getIsHard()) {
                    hard.add(f);
                }
            }
        }

        fiss.put(WarframeFissureTypeEnum.ORDINARY, ordinary);
        fiss.put(WarframeFissureTypeEnum.STORM, storm);
        fiss.put(WarframeFissureTypeEnum.HARD, hard);

        return fiss;

    }

    /**
     * 获取裂隙的等级并分类
     *
     * @param fissures 裂隙集合
     * @return 分类好的实体类
     */
    private FissureList getFissureListType(List<GlobalStates.Fissures> fissures) {
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

    public String getSister(){
        BiliBili bili = UpUtils.getUpDynamic(16730771L);
        BiliBili.BDataDao.Items item = new BiliBili.BDataDao.Items();
        long isTime = new Date().getTime();
        for(BiliBili.BDataDao.Items items:bili.getData().getItems()){
            if(items.getType().equals(BiliBliTypeEnum.DYNAMIC_TYPE_DRAW)){
                long time = items.getModules().getModuleAuthor().getPubTs();
                BiliBili.BDataDao.Items.Modules.ModuleDynamic.Desc desc = items.getModules().getModuleDynamic().getDesc();
                if((isTime-time)<isTime){
                    if(desc!=null){
                        if(desc.getText().contains("信条近战武器")){
                            item = items;
                        }
                    }
                }
            }
        }
        return item.getModules().getModuleDynamic().getDesc().getText()+"\n数据来自B站Up："+item.getModules().getModuleAuthor().getName();
    }


}
