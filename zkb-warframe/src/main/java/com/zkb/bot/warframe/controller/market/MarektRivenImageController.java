package com.zkb.bot.warframe.controller.market;


import com.zkb.bot.warframe.dao.MarketRiven;
import com.zkb.bot.warframe.dao.MarketRivenParameter;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.bot.warframe.utils.market.MarketRivenUtil;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.framework.interceptor.IgnoreAuth;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/warframe/market")
public class MarektRivenImageController {

    @IgnoreAuth
    @GetMapping(value = "/{uuid}/getMarektRivenImage/{key}", produces = MediaType.IMAGE_PNG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable String key) throws IOException {
        response.setHeader("Content-Type", "image/png");
        MarketRivenParameter parameter = MarketRivenUtil.toMarketRiven(URLDecoder.decode(key, "UTF-8"));
        MarketRiven riven = MarketRivenUtil.marketRiven(parameter);
        if (riven != null) {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketRiven(riven, parameter.getItemName());
            response.getOutputStream().write(out.toByteArray());
        } else {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketNotImage();
            response.getOutputStream().write(out.toByteArray());
        }

    }

}
