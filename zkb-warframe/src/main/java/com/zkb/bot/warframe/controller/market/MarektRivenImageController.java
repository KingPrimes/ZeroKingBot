package com.zkb.bot.warframe.controller.market;


import com.zkb.bot.warframe.dao.MarketRiven;
import com.zkb.bot.warframe.dao.MarketRivenParameter;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.bot.warframe.utils.market.MarketRivenUtil;
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
import java.net.URLDecoder;

@RestController
@RequestMapping("/warframe/market")
public class MarektRivenImageController {

    @LogInfo(title = TitleType.Warframe, orderType = "WR", businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getMarektRivenImage/{key}/{bot}/{user}/{group}/{rawMsg}", produces = MediaType.IMAGE_PNG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable String key, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg) throws IOException {
        response.setHeader("Content-Type", "image/png");
        MarketRivenParameter parameter = MarketRivenUtil.toMarketRiven(URLDecoder.decode(key, "UTF-8"));
        MarketRiven riven = MarketRivenUtil.marketRiven(parameter);
        ByteArrayOutputStream out;
        if (riven != null) {
            out = SpringUtils.getBean(HtmlToImage.class).marketRiven(riven, parameter.getItemName());
        } else {
            out = SpringUtils.getBean(HtmlToImage.class).marketNotImage();
        }
        response.getOutputStream().write(out.toByteArray());

    }

}
