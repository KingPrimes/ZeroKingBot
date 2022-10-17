package com.zkb.bot.warframe.controller.freemarker.mission;

import com.zkb.bot.warframe.dao.GlobalStates;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.zkb.bot.enums.WarframeEnum.REDIS_MISSION_KEY;

@Controller
@RequestMapping("/warframe/mission")
public class InvasionsHtmlController {
    @Autowired
    RedisCache redisCache;

    @Autowired
    IWarframeTranslationService trans;

    @GetMapping(value = "/{uuid}/getInvasionsHtml")
    @LogInfo(title = TitleType.Warframe,orderType = "入侵",businessType = BusinessType.SELECT)
    public String getHtml(Model model) {
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        List<GlobalStates.Invasions> invasions = sgs.getPacket().getData().getInvasions();
        for (GlobalStates.Invasions invasion : invasions) {
            if (invasion.getAttackerReward().getCountedItems().size() > 0) {
                invasion.getAttackerReward().getCountedItems().get(0).setType(
                        trans.enToZh(invasion.getAttackerReward().getCountedItems().get(0).getType()));
            }
            if (invasion.getDefenderReward().getCountedItems().size() > 0) {
                invasion.getDefenderReward().getCountedItems().get(0).setType(
                        trans.enToZh(invasion.getDefenderReward().getCountedItems().get(0).getType()));

            }
            invasion.setNode(invasion.getNode().replace(StringUtils.quStr(invasion.getNode()), trans.enToZh(StringUtils.quStr(invasion.getNode()))));
        }
        model.addAttribute("inv",invasions);
        return "html/invasions";
    }
}
