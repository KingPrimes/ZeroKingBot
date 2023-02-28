package com.zkb.bot.warframe.controller.freemarker.mission;

import com.zkb.bot.warframe.domain.WarframeRelics;
import com.zkb.bot.warframe.service.impl.WarframeRelicsServiceImpl;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/warframe/mission")
public class RelicsSelectHtmlController {
    @Autowired
    WarframeRelicsServiceImpl rels;

    @GetMapping(value = "/{uuid}/getRelicsHtml/{key}")
    @LogInfo(title = TitleType.Warframe, orderType = "核桃", businessType = BusinessType.SELECT)
    public String getHtml(Model model, @PathVariable String key) throws UnsupportedEncodingException {

        key = URLDecoder.decode(key, "UTF-8").trim();
        List<WarframeRelics> rs = rels.selectWarframeRelicsByAll(key);

        model.addAttribute("rs", "0");
        model.addAttribute("wrs", "0");

        if (StringUtils.regex(key, "^[A-z][1-9]+$")) {
            List<WarframeRelics> lrs = new ArrayList<>();
            //根据纪元排序
            rs.sort((Comparator.comparing(WarframeRelics::getRelicsTierD)));
            List<String> items = new ArrayList<>();
            String tempName = "", tempTier = "";
            for (WarframeRelics r : rs) {
                if (tempName.equals(r.getRelicsName()) && tempTier.equals(r.getRelicsTier())) {
                    items.add(r.getRelicsItemName());
                } else {
                    if (items.size() != 0) {
                        WarframeRelics relics = new WarframeRelics(r);
                        relics.setItems(items);
                        lrs.add(relics);
                        items = new ArrayList<>();
                    }
                    tempName = r.getRelicsName();
                    tempTier = r.getRelicsTier();
                }
            }
            model.addAttribute("rs", lrs);
        } else {
            if (rs.size() != 0) {
                List<WarframeRelics> wrs = new ArrayList<>();
                for (WarframeRelics r : rs) {
                    List<WarframeRelics> rsl = rels.selectWarframeRelicsByRelicsId(r.getRelicsId());
                    List<String> items = new ArrayList<>();
                    WarframeRelics rely = new WarframeRelics(rsl.get(0));
                    for (WarframeRelics relics : rsl) {
                        items.add(relics.getRelicsItemName());
                    }
                    rely.setItems(items);
                    wrs.add(rely);
                }
                model.addAttribute("wrs", wrs);
            }
        }
        return "html/relics";
    }
}
