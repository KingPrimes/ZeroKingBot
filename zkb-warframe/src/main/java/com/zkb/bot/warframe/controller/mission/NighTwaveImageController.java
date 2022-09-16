package com.zkb.bot.warframe.controller.mission;

import com.zkb.bot.warframe.dao.Nightwave;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.bot.warframe.utils.WarframeUtils;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/warframe/mission")
public class NighTwaveImageController {

    @Resource
    RedisCache redis;


    @GetMapping(value = "/{uuid}/getNighTwaveImage")
    public void getImage(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "image/png");

        Nightwave n = SpringUtils.getBean(WarframeUtils.class).getNighTwave();
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).nighTwaveImage(n);
        response.getOutputStream().write(out.toByteArray());

    }
}
