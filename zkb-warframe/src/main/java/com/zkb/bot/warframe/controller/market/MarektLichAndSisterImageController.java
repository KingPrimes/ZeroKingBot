package com.zkb.bot.warframe.controller.market;

import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.warframe.dao.MarketLichOrSister;
import com.zkb.bot.warframe.service.IWarframeMarketLichOrSisterService;
import com.zkb.bot.warframe.service.IWarframeMarketSisterService;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.bot.warframe.utils.market.MarketLichAndSisterUtil;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Market 赤毒武器与幻纹
 */
@RestController
@RequestMapping("/warframe/market")
public class MarektLichAndSisterImageController {

    @Resource
    IWarframeMarketLichOrSisterService lichService;
    @Resource
    IWarframeMarketSisterService sisterService;


    @GetMapping(value = "/{uuid}/getLichOrSisterImage/{key}/{type}", produces = MediaType.IMAGE_PNG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable String key, @PathVariable WarframeTypeEnum type) throws IOException {
        response.setHeader("Content-Type", "image/png");
        // 查询 赤毒武器/幻纹 拍卖详情
        MarketLichOrSister licksOrSister;
        if (WarframeTypeEnum.TYPE_MARKET_CD.equals(type)) {
            licksOrSister = MarketLichAndSisterUtil.getMarketLich(URLDecoder.decode(key, "UTF-8"));
        } else {
            licksOrSister = MarketLichAndSisterUtil.getMarketSister(URLDecoder.decode(key, "UTF-8"));
        }

        if (licksOrSister != null) {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketLichAndSisterImage(licksOrSister, type);
            response.getOutputStream().write(out.toByteArray());
        } else {
            ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketNotImage();
            response.getOutputStream().write(out.toByteArray());
        }
    }
}
