package com.zkb.bot.warframe.controller.freemarker.mission;

import com.zkb.bot.warframe.dao.GlobalStates;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Locale;

import static com.zkb.bot.enums.WarframeEnum.REDIS_MISSION_KEY;

@Controller
@RequestMapping("/warframe/mission")
public class AllCycleHtmlController {
    @Autowired
    RedisCache redisCache;
    @Autowired
    IWarframeTranslationService trans;

    @LogInfo(title = TitleType.Warframe, orderType = "平原", businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getAllCycleHtml")
    public String getHtml(Model model) {
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates globalState = sgs.getPacket().getData();
        //地球
        GlobalStates.EarthCycle earth = globalState.getEarthCycle();
        earth.setState(trans.enToZh(earth.getState()));
        earth.setTimeLeft(DateUtils.getDate((earth.getExpiry()), new Date()));
        model.addAttribute("earth", earth);
        //夜灵平野
        GlobalStates.CetusCycle cetus = globalState.getCetusCycle();
        cetus.setState(trans.enToZh(cetus.getState()));
        cetus.setTimeLeft(DateUtils.getDate((cetus.getExpiry()), new Date()));
        model.addAttribute("cetus", cetus);
        //福尔图娜
        GlobalStates.VallisCycle vallis = globalState.getVallisCycle();
        vallis.setState(trans.enToZh(vallis.getState()));
        vallis.setTimeLeft(DateUtils.getDate((vallis.getExpiry()), new Date()));
        model.addAttribute("vallis", vallis);

        //魔胎之境
        GlobalStates.CambionCycle cambion = globalState.getCambionCycle();
        cambion.setActive(cambion.getActive().toUpperCase(Locale.ROOT));
        cambion.setTimeLeft(DateUtils.getDate((cambion.getExpiry()), new Date()));
        model.addAttribute("cambion", cambion);

        //扎里曼
        GlobalStates.ZarimanCycle zariman = globalState.getZarimanCycle();
        zariman.setState(zariman.getState().toUpperCase(Locale.ROOT));
        zariman.setTimeLeft(DateUtils.getDate((zariman.getExpiry()), new Date()));
        model.addAttribute("zariman", zariman);

        return "html/allCycle";
    }
}
