package com.zkb.bot.warframe.controller.freemarker.mission;

import com.zkb.bot.warframe.dao.GlobalStates;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.DateUtils;
import com.zkb.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import static com.zkb.bot.enums.WarframeEnum.REDIS_MISSION_KEY;

@Controller
@RequestMapping("/warframe/mission")
public class ArchonHuntHtmlController {
    @Autowired
    RedisCache redisCache;

    @Autowired
    IWarframeTranslationService trans;

    @LogInfo(title = TitleType.Warframe, orderType = "执刑官猎杀", businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getArchonHuntHtml")
    public String getHtml(Model model) {
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.ArchonHunt archonHunt = sgs.getPacket().getData().getArchonHunt();
        for (GlobalStates.ArchonHunt.Mission mission : archonHunt.getMissions()) {
            mission.setNode(mission.getNode()
                    .replace(
                            StringUtils.quStr(
                                    mission.getNode()),
                            trans.enToZh(StringUtils.quStr(mission.getNode()))));
            mission.setType(trans.enToZh(mission.getType()));
        }
        archonHunt.setEta(DateUtils.getDate((archonHunt.getExpiry()), new Date()));
        model.addAttribute("archonHunt", archonHunt);
        return "html/archonHunt";
    }
}
