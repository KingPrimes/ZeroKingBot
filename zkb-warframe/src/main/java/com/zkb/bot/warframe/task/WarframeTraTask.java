package com.zkb.bot.warframe.task;

import com.zkb.bot.warframe.utils.WarframeTraUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WarframeTraTask {

    /*@Async("taskExecutor")
    @Scheduled(cron = "${task.cron.traTask}")*/
    public void TaskUserDict() {
        SpringUtils.getBean(WarframeTraUtils.class).getUserDict();
    }
}
