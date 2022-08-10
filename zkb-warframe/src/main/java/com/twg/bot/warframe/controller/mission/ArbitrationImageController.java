package com.twg.bot.warframe.controller.mission;


import com.twg.bot.warframe.dao.GlobalStates;
import com.twg.bot.warframe.dao.SocketGlobalStates;
import com.twg.bot.warframe.utils.HtmlToImage;
import com.twg.common.core.redis.RedisCache;
import com.twg.common.utils.spring.SpringUtils;
import com.twg.framework.interceptor.IgnoreAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.twg.bot.enums.WarframeTypeEnum.REDIS_MISSION_KEY;

@RestController
@RequestMapping("/warframe/mission")
public class ArbitrationImageController {

    @Autowired
    RedisCache redisCache;


    @IgnoreAuth
    @GetMapping(value = "/{uuid}/getArbitrationImage")
    public void getImage(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "image/png");
        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates.Arbitration arbitration = sgs.getPacket().getData().getArbitration();
        if (arbitration == null) {
            return;
        }

        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).arbitrationImage(arbitration);
        response.getOutputStream().write(out.toByteArray());
    }

}
