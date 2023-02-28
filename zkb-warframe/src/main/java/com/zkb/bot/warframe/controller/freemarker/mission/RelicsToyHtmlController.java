package com.zkb.bot.warframe.controller.freemarker.mission;

import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warframe/mission")
public class RelicsToyHtmlController {
    @Autowired
    RedisCache redisCache;

    @GetMapping(value = "/{uuid}/getRelicsToyHtml")
    @LogInfo(title = TitleType.Warframe, orderType = "模拟核桃", businessType = BusinessType.SELECT)
    public String getHtml(Model model) {
        return "html/relicsToy";
    }
}
