package com.zkb.bot.warframe.controller.market;

import com.zkb.bot.warframe.utils.DucatUtil;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/warframe/market")
public class MarketDumpsController {

    @LogInfo(title = TitleType.Warframe, orderType = "金银垃圾", businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getMarektDumpsImage/{bot}/{user}/{group}/{rawMsg}", produces = MediaType.IMAGE_PNG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg) throws IOException {
        response.setHeader("Content-Type", "image/png");
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketDucat(SpringUtils.getBean(DucatUtil.class).getDucats());
        response.getOutputStream().write(out.toByteArray());

    }
}
