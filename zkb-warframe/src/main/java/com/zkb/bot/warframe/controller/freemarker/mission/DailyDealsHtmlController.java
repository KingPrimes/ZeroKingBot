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

import static com.zkb.bot.enums.WarframeEnum.REDIS_MISSION_KEY;

@Controller
@RequestMapping("/warframe/mission")
public class DailyDealsHtmlController {

    @Autowired
    RedisCache redisCache;
    @Autowired
    IWarframeTranslationService trans;

    @GetMapping(value = "/{uuid}/getDailyDealsHtml")
    @LogInfo(title = TitleType.Warframe, orderType = "每日特惠", businessType = BusinessType.SELECT)
    public String getHtml(Model model) {
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates state = sgs.getPacket().getData();
        GlobalStates.DailyDeals deals = state.getDailyDeals().get(0);
        deals.setItem(trans.enToZh(deals.getItem()));
        deals.setEta(DateUtils.getDate(deals.getExpiry(), new Date()));
        model.addAttribute("deals", deals);
        return "html/daily";
    }
}
