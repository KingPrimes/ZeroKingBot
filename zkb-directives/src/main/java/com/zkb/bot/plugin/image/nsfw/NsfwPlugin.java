package com.zkb.bot.plugin.image.nsfw;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.ImageEnum;
import com.zkb.bot.nsfw.Nsfw;
import com.zkb.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_BLOCK;
import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;

@Shiro
@Component
public class NsfwPlugin {

    @GroupMessageHandler
    public int groupMessageHandler(Bot bot, GroupMessageEvent event) {
        if (ImageEnum.ORDER_NSFW.getType().equals(StringUtils.substring(event.getRawMessage(), 0, ImageEnum.ORDER_NSFW.getType().length()).toUpperCase(Locale.ROOT))) {
            bot.sendGroupMsg(event.getGroupId(), Nsfw.judge(event.getRawMessage().replaceAll(ImageEnum.ORDER_NSFW.getType(), "")), false);
            return MESSAGE_BLOCK;
        }
        return MESSAGE_IGNORE;
    }
}
