package com.zkb.bot.warframe.controller.freemarker.mission;

import com.zkb.bot.warframe.dao.Nightwave;
import com.zkb.bot.warframe.utils.WarframeUtils;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/warframe/mission")
public class NighTwaveHtmlController {


    @GetMapping(value = "/{uuid}/getNighTwaveHtml")
    @LogInfo(title = TitleType.Warframe, orderType = "电波", businessType = BusinessType.SELECT)
    public String getHtml(Model model) {
        Nightwave n = SpringUtils.getBean(WarframeUtils.class).getNighTwave();
        model.addAttribute("nigh", n);
        return "html/nighTwave";
    }
}
