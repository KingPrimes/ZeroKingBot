package com.zkb.bot.plugin.image_gif;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.imagetogif.utils.SendGifUtil;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;
import static com.zkb.bot.enums.GifEnums.*;


@Shiro
@Component
public class GifImagePlugin {
    @GroupMessageHandler
    public int groupMessageHandler(Bot bot, GroupMessageEvent event) {

        if (event.getRawMessage().trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        //Capoo 表情
        if (event.getRawMessage().toLowerCase(Locale.ROOT).contains(GIF_CAPOO.getType())) {
            if (SendGifUtil.random()) {
                return SendGifUtil.sendGif(bot, event, "/Gif/Capoo/Ding/1/getImage/");
            } else {
                return SendGifUtil.sendGif(bot, event, "/Gif/Capoo/Chuo/2/getImage/");
            }
        }
        //Email Funny 滑稽果表情
        if (event.getRawMessage().toLowerCase(Locale.ROOT).contains(GIF_EMAIL_FUNNY.getType())) {
            return SendGifUtil.sendGif(bot, event, "/Gif/Email/Funny/1/getImage/");
        }
        //精神支柱
        if (event.getRawMessage().toLowerCase(Locale.ROOT).contains(PNG_EMO_SUPT.getType())) {
            return SendGifUtil.sendGif(bot, event, "/Png/Emo/Supt/1/getImage/");
        }

        return MESSAGE_IGNORE;
    }
}
