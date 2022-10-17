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
public class ArbitrationHtmlController {

    @Autowired
    RedisCache redisCache;

    @Autowired
    IWarframeTranslationService trans;

    @LogInfo(title = TitleType.Warframe, orderType = "仲裁", businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getArbitrationHtml")
    public String getHtml(Model model) {
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.Arbitration arbitration = sgs.getPacket().getData().getArbitration();
        arbitration.setNode(arbitration.getNode().
                replace(
                        StringUtils.quStr(arbitration.getNode()),
                        trans.enToZh(StringUtils.quStr(arbitration.getNode())
                        )
                ));
        arbitration.setType(trans.enToZh(arbitration.getType()));
        arbitration.setEtc(DateUtils.getDate((arbitration.getExpiry()), new Date()));
        model.addAttribute("arbit", arbitration);
        return "html/arbitration";
    }
}
