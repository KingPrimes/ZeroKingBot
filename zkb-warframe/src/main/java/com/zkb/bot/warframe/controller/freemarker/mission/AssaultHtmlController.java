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
public class AssaultHtmlController {

    @Autowired
    RedisCache redisCache;
    @Autowired
    IWarframeTranslationService trans;


    @GetMapping(value = "/{uuid}/getAssaultHtml")
    @LogInfo(title = TitleType.Warframe,orderType = "突击",businessType = BusinessType.SELECT)
    public String getHtml(Model model) {
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.Sortie assault = sgs.getPacket().getData().getSortie();
        assault.setEta(DateUtils.getDate((assault.getExpiry()), new Date()));

        for (GlobalStates.Sortie.Variants variant : assault.getVariants()) {
            variant.setNode(variant.getNode()
                    .replace(
                            StringUtils.quStr(
                                    variant.getNode()),
                            trans.enToZh(StringUtils.quStr(variant.getNode()))));
            variant.setMissionType(trans.enToZh(variant.getMissionType()));
            variant.setModifier(trans.enToZh(variant.getModifier()));
            variant.setModifierDescription(trans.enToZh(variant.getModifierDescription()));
        }

        model.addAttribute("assault",assault);
     return "html/assault";
    }
}
