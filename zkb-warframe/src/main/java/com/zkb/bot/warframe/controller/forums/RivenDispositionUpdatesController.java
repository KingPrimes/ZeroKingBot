package com.zkb.bot.warframe.controller.forums;


import com.zkb.bot.warframe.domain.WarframeRivenTrend;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.bot.warframe.task.RivenDispositionUpdatesTask;
import com.zkb.bot.warframe.utils.forums.RivenDispositionUpdatesImage;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.common.utils.file.FileUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/warframe/forums/riven")
public class RivenDispositionUpdatesController {

    @Autowired
    RedisCache redisCache;

    @LogInfo(title = TitleType.Warframe, orderType = "紫卡倾向变动", businessType = BusinessType.SELECT)
    @GetMapping(value = "/{uuid}/getNewsImage/{bot}/{user}/{group}/{rawMsg}")
    public void getRivenDisUpdatesImage(HttpServletResponse response, @PathVariable long bot, @PathVariable long user, @PathVariable long group, @PathVariable String rawMsg) {
        response.setHeader("Content-Type", "image/png");
        try {
            //获取文件流返回
            response.getOutputStream().write(FileUtils.toByteArray3("./renew-riven-disposition.jpg"));
        } catch (Exception e) {
            //如果文件不存在创建文件
            List<WarframeRivenTrend> trends;
            try {
                trends = redisCache.getCacheList("renew-riven-disposition");
                if (trends.size() <= 0) {
                    new RivenDispositionUpdatesTask().renewRivenDisposition();
                    trends = redisCache.getCacheList("renew-riven-disposition");
                }
                List<WarframeRivenTrend> image = new ArrayList<>();
                for (WarframeRivenTrend trend : trends) {
                    trend.setTraCh(SpringUtils.getBean(IWarframeTranslationService.class).enToZh(trend.getRivenTrendName()));
                    image.add(new WarframeRivenTrend(trend));
                }
                //创建文件
                RivenDispositionUpdatesImage.getImage(image);
                //返回文件流
                response.getOutputStream().write(FileUtils.toByteArray3("./renew-riven-disposition.jpg"));
            } catch (Exception ex) {
                ex.printStackTrace();
                //如果Redis中没有缓存则获取缓存
                new RivenDispositionUpdatesTask().renewRivenDisposition();
            }
        }
    }
}
