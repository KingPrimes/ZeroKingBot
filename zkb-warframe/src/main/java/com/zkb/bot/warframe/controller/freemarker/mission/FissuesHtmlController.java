package com.zkb.bot.warframe.controller.freemarker.mission;

import com.zkb.bot.enums.WarframeFissureTypeEnum;
import com.zkb.bot.warframe.dao.FissureList;
import com.zkb.bot.warframe.utils.WarframeUtils;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warframe/mission")
public class FissuesHtmlController {
    @Autowired
    RedisCache redisCache;

    @LogInfo(title = TitleType.Warframe,orderType = "裂隙",businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getFissuesHtml/{type}")
    public String getImage(@PathVariable("type") WarframeFissureTypeEnum type, Model model) {
        FissureList fissureList = SpringUtils.getBean(WarframeUtils.class).getFissureList(type);
        model.addAttribute("fiss",fissureList);
        model.addAttribute("type",type.ordinal());
        return "html/fissues";

    }

}
