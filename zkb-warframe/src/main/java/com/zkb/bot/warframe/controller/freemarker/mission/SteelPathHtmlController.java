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

import java.util.Calendar;
import java.util.Date;

import static com.zkb.bot.enums.WarframeEnum.REDIS_MISSION_KEY;

@Controller
@RequestMapping("/warframe/mission")
public class SteelPathHtmlController {
    @Autowired
    RedisCache redisCache;

    @Autowired
    IWarframeTranslationService trans;

    @GetMapping(value = "/{uuid}/getSteelPathHtml")
    @LogInfo(title = TitleType.Warframe, orderType = "钢铁", businessType = BusinessType.SELECT)
    public String getHtml(Model model) {
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.SteelPath steelPath = sgs.getPacket().getData().getSteelPath();
        String key = "";
        for (int i = 0; i < steelPath.getRotation().size(); i++) {
            if (steelPath.getCurrentReward().getName().equals(steelPath.getRotation().get(i).getName())) {
                if (i + 1 < steelPath.getRotation().size()) {
                    key = steelPath.getRotation().get(i + 1).getName();
                } else {
                    key = steelPath.getRotation().get(0).getName();
                }
                break;
            }
        }
        steelPath.setNexReward(trans.enToZh(key));
        steelPath.setIsReward(trans.enToZh(steelPath.getCurrentReward().getName()));
        steelPath.setEtc(DateUtils.getDateWeek(steelPath.getActivation(), new Date(), Calendar.DAY_OF_MONTH, 7));
        steelPath.setCost(steelPath.getCurrentReward().getCost());
        model.addAttribute("stee",steelPath);
        return "html/steePath";
    }
}
