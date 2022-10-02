package com.zkb.bot.warframe.controller.mission;


import com.zkb.bot.enums.WarframeFissureTypeEnum;
import com.zkb.bot.warframe.dao.FissureList;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.bot.warframe.utils.WarframeUtils;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/warframe/mission")
public class FissuesImageController {

    @Autowired
    RedisCache redisCache;

    @LogInfo(title = TitleType.Warframe,orderType = "裂隙",businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getFissuesImage/{type}/{bot}/{user}/{group}/{rawMsg}")
    public void getImage(@PathVariable("type") WarframeFissureTypeEnum type, HttpServletResponse response, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg) throws InterruptedException, IOException {
        response.setHeader("Content-Type", "image/png");
        FissureList fissureList = SpringUtils.getBean(WarframeUtils.class).getFissureList(type);
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).fissuesImage(fissureList);
        response.getOutputStream().write(out.toByteArray());
    }

}
