package com.zkb.bot.warframe.controller.mission;

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

@RestController
@RequestMapping("/warframe/mission")
public class RelicsToyImageController {
    @LogInfo(title = TitleType.Warframe,orderType = "模拟核桃",businessType = BusinessType.IMAGE)
    @GetMapping(value = "/{uuid}/getRelicsToy/{bot}/{user}/{group}/{rawMsg}")
    public void getImage(HttpServletResponse response, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg, @PathVariable String uuid) throws IOException {
        response.setHeader("Content-Type", "image/png");
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).relicsToy();
        response.getOutputStream().write(out.toByteArray());
    }
}
