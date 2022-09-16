package com.zkb.bot.warframe.controller.mission;


import com.zkb.bot.warframe.dao.GlobalStates;
import com.zkb.bot.warframe.dao.SocketGlobalStates;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

import static com.zkb.bot.enums.WarframeTypeEnum.REDIS_MISSION_KEY;

@RestController
@RequestMapping("/warframe/mission")
public class AllCycleImageController {

    @Resource
    RedisCache redisCache;


    @GetMapping(value = "/{uuid}/getAllCycleImage")
    public void getImage(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "image/png");

        SocketGlobalStates sgs = redisCache.getCacheObject(REDIS_MISSION_KEY.getType());
        GlobalStates globalState = sgs.getPacket().getData();


        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).allCycleImage(globalState);
        response.getOutputStream().write(out.toByteArray());


    }
}
