package com.zkb.bot.warframe.controller.mission;


import com.zkb.bot.warframe.dao.GlobalStates;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.zkb.bot.enums.WarframeEnum.REDIS_MISSION_KEY;

@RestController
@RequestMapping("/warframe/mission")
public class SteelPathImageController {
    @Autowired
    private RedisCache redisCache;

    @LogInfo(title = TitleType.Warframe,orderType = "钢铁",businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getSteelPathImage/{bot}/{user}/{group}/{rawMsg}")
    public void getImage(HttpServletResponse response, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg) throws IOException {
        response.setHeader("Content-Type", "image/png");


        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.SteelPath steelPath = sgs.getPacket().getData().getSteelPath();
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).steePathImage(steelPath);
        response.getOutputStream().write(out.toByteArray());

    }
}
