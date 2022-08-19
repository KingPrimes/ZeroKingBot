package com.zkb.bot.warframe.controller.mission;


import com.zkb.bot.warframe.dao.FissureList;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.bot.warframe.utils.WarframeUtils;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping(value = "/{uuid}/getFissuesImage")
    public void getImage(HttpServletResponse response) throws InterruptedException, IOException {
        response.setHeader("Content-Type", "image/png");
        FissureList fissureList = SpringUtils.getBean(WarframeUtils.class).getFissureList();
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).fissuesImage(fissureList);
        response.getOutputStream().write(out.toByteArray());


    }

}
