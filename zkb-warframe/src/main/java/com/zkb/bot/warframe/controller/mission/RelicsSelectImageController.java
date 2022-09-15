package com.zkb.bot.warframe.controller.mission;

import com.zkb.bot.warframe.domain.WarframeRelics;
import com.zkb.bot.warframe.service.impl.WarframeRelicsServiceImpl;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/warframe/mission")
public class RelicsSelectImageController {

    @Autowired
    WarframeRelicsServiceImpl rels;


    @GetMapping(value = "/{uuid}/getRelics/{key}")
    public void getImage(HttpServletResponse response, @PathVariable String key) throws IOException {
        response.setHeader("Content-Type", "image/png");
        List<WarframeRelics> rs = rels.selectWarframeRelicsByAll(URLDecoder.decode(key, "UTF-8").trim());
        if (StringUtils.regexG(key, "[A-z1-9]")) {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).relicsSelect(rs);
            response.getOutputStream().write(out.toByteArray());
        } else {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).relics(rs);
            response.getOutputStream().write(out.toByteArray());
        }


    }
}
