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
public class VoidHtmlController {
    @Autowired
    RedisCache redisCache;

    @Autowired
    IWarframeTranslationService trans;

    @GetMapping(value = "/{uuid}/getVoidHtml")
    @LogInfo(title = TitleType.Warframe, orderType = "奸商", businessType = BusinessType.SELECT)
    public String getHtml(Model model) {


        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.VoidTrader v = sgs.getPacket().getData().getVoidTrader();
        v.setLocation(v.getLocation().replace(
                StringUtils.quStr(v.getLocation()),
                trans.enToZh(StringUtils.quStr(v.getLocation()))
        ));
        for (GlobalStates.VoidTrader.Inventory inventory : v.getInventory()) {
            inventory.setItem(trans.enToZh(inventory.getItem()).replace("&", "&amp;"));
            inventory.setCredits(inventory.getCredits() / 1000);
        }
        v.setEndString(DateUtils.getDate(v.getExpiry(), new Date()));
        v.setStartString(DateUtils.getDate(v.getActivation(), new Date()));
        model.addAttribute("vo", v);
        return "html/voidTrader";
    }
}
