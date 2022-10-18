package com.zkb.bot.warframe.controller.mission;


import com.zkb.bot.enums.WarframeFissureTypeEnum;
import com.zkb.bot.warframe.utils.WarframeHtmlToImage;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.ip.GetServerPort;
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

    @LogInfo(title = TitleType.Warframe,orderType = "裂隙",businessType = BusinessType.IMAGE)
    @GetMapping(value = "/{uuid}/getFissuesImage/{type}/{bot}/{user}/{group}/{rawMsg}")
    public void getImage(@PathVariable("type") WarframeFissureTypeEnum type, HttpServletResponse response, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg, @PathVariable String uuid) throws InterruptedException, IOException {
        response.setHeader("Content-Type", "image/png");
        ByteArrayOutputStream out = WarframeHtmlToImage.conver("http://localhost:"+ GetServerPort.getPort()+"/warframe/mission/"+uuid+"/getFissuesHtml/"+type);
        response.getOutputStream().write(out.toByteArray());
    }

}
