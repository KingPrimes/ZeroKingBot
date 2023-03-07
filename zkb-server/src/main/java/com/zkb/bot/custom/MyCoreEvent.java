package com.zkb.bot.custom;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.CoreEvent;
import com.zkb.common.utils.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MyCoreEvent extends CoreEvent {

    Logger log = LoggerFactory.getLogger(MyCoreEvent.class);


    @Override
    public void online(@NotNull Bot bot) {
        log.info("机器人已上线Bot:{},Time:{}", bot.getSelfId(), DateUtils.getTime());
        super.online(bot);
    }

    @Override
    public void offline(long account) {
        log.info("您的机器人已断开链接Bot:{},Time:{}", account, DateUtils.getTime());
        super.offline(account);
    }
}
