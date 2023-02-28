package com.zkb.bot.warframe.controller;

import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/warframe")
public class TranslationImageController {
    @LogInfo(title = TitleType.Warframe, orderType = "翻译", businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getTraImage/{key}/{bot}/{user}/{group}/{rawMsg}")
    public void getImage(HttpServletResponse response, @PathVariable String key, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg) throws IOException {
        response.setHeader("Content-Type", "image/gif");
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).translationImage(URLDecoder.decode(key, "UTF-8"));
        response.getOutputStream().write(out.toByteArray());
    }
}
