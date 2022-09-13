package com.zkb.bot.warframe.controller.mission;

import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/warframe/mission")
public class RelicsToyImageController {

    @GetMapping(value = "/{uuid}/getRelicsToy")
    public void getImage(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "image/png");
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).relicsToy();
        response.getOutputStream().write(out.toByteArray());
    }
}
