package com.zkb.bot.warframe.controller.market;


import com.zkb.bot.warframe.dao.Market;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.bot.warframe.utils.market.MarketItemUtil;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * @author KingPrimes
 */
@RestController
@RequestMapping("/warframe/market")
public class MarektImageController {



    @GetMapping(value = "/{uuid}/getMarektImage/{key}/{seBy}/{isMax}/{form}", produces = MediaType.IMAGE_PNG_VALUE)
    public synchronized void getImage(@NotNull HttpServletResponse response, @PathVariable String key, @PathVariable Boolean seBy, @PathVariable Boolean isMax, @PathVariable String form) throws IOException {
        response.setHeader("Content-Type", "image/png");
        Market market = new MarketItemUtil().market(form, key, seBy, isMax);
        if (market.getCode().equals("timeout")) {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).timeOutImage();
            response.getOutputStream().write(out.toByteArray());
            return;
        }
        if (market.getPayload().getOrders().size() != 0) {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketImage(market, seBy, isMax);
            response.getOutputStream().write(out.toByteArray());
        } else {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketNotImage();
            response.getOutputStream().write(out.toByteArray());
        }
    }

}
