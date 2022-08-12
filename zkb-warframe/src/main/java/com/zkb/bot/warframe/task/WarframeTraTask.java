package com.zkb.bot.warframe.task;

import com.zkb.bot.warframe.utils.WarframeTraUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WarframeTraTask {

    @Scheduled(cron = "0 0 0 1/7 * ? ")
    //@Log(title = "WarframeTra",businessType = BusinessType.INSERT)
    public void TaskUserDict() {
        SpringUtils.getBean(WarframeTraUtils.class).getUserDict();
    }
}
