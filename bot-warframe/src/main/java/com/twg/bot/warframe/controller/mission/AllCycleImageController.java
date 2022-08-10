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

import static com.twg.bot.enums.WarframeTypeEnum.REDIS_MISSION_KEY;

@RestController
@RequestMapping("/warframe/mission")
public class AllCycleImageController {

    @Autowired
    RedisCache redisCache;


    @IgnoreAuth
    @GetMapping(value = "/{uuid}/getAllCycleImage")
    public void getImage(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "image/png");

        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates globalState = sgs.getPacket().getData();


        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).allCycleImage(globalState);
        response.getOutputStream().write(out.toByteArray());


    }
}
