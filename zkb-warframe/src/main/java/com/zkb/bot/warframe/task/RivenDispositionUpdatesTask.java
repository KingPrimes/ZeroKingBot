package com.zkb.bot.warframe.task;


import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SendAllGroup;
import com.zkb.bot.warframe.domain.WarframeRivenTrend;
import com.zkb.bot.warframe.service.IWarframeRivenTrendService;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.bot.warframe.utils.forums.GetForumsRivenDispositionUpdates;
import com.zkb.bot.warframe.utils.forums.RivenDispositionUpdatesImage;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RivenDispositionUpdatesTask {

    /**
     * 更新紫卡倾向
     *
     * @return 更新的条数
     * @throws Exception 可能存在空异常
     */
    @Async("taskExecutor")
    @Scheduled(cron = "${task.cron.rivenTask}")
    public void renewRivenDisposition() throws Exception {
        List<WarframeRivenTrend> trends = GetForumsRivenDispositionUpdates.getRivenDispositionUpdates("");
        List<WarframeRivenTrend> redis_trends = null;
        try {
            //获取之前的缓存
            redis_trends = SpringUtils.getBean(RedisCache.class).getCacheList("renew-riven-disposition");
        } catch (Exception e) {
            System.out.println("紫卡更新失败，错误信息：" + e.getMessage());

        }

        assert redis_trends != null;
        trends.retainAll(redis_trends);
        if (trends.size() <= 0) {
            return;
        }

        List<WarframeRivenTrend> image = new ArrayList<>();
        //遍历集合写入到数据库
        for (WarframeRivenTrend trend : trends) {
            trend.setRivenTrendName(trend.getRivenTrendName().trim());
            trend.setRivenTrendOldNum(trend.getRivenTrendOldNum().trim());
            trend.setRivenTrendNewNum(trend.getRivenTrendNewNum().trim());
            trend.setTraCh(SpringUtils.getBean(IWarframeTranslationService.class).enToZh(trend.getRivenTrendName()));
            image.add(new WarframeRivenTrend(trend));
            SpringUtils.getBean(IWarframeRivenTrendService.class).insertAndUpDateWarframeRivenTrend(trend);
        }
        RivenDispositionUpdatesImage.getImage(image);
        try {
            //删除之前的缓存
            SpringUtils.getBean(RedisCache.class).deleteObject("renew-riven-disposition");
        } catch (Exception ignored) {
        }
        //添加新的缓存
        SpringUtils.getBean(RedisCache.class).setCacheList("renew-riven-disposition", trends);
        SendAllGroup.sendAllGroup(Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/forums/riven/getNewsImage"), FunctionEnums.FUNCTION_WARFRAME);


    }
}