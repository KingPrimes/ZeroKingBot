package com.zkb.bot.plugin.music;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.domain.xmsj.model.IXmsjApi;
import com.zkb.bot.domain.xmsj.model.vo.Body;
import com.zkb.bot.enums.MusicEnum;
import com.zkb.bot.utils.Msg;
import com.zkb.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;

@Shiro
@Component
public class MusicPlugin {

    @Autowired
    IXmsjApi api;

    @GroupMessageHandler
    public int groupMessageHandler(Bot bot, GroupMessageEvent event) {

        String rawMsg = event.getRawMessage();

        if (rawMsg.trim().isEmpty()) {
            return MESSAGE_IGNORE;
        }

        //执行搜索歌曲操作
        if (MusicEnum.SONG.desc().equals(StringUtils.substring(rawMsg, 0, MusicEnum.SONG.desc().length()).toUpperCase(Locale.ROOT))) {
            MusicEnum[] values = MusicEnum.values();
            for (MusicEnum e : values) {
                if (e.value() != 0) {
                    if (e.desc().equals(StringUtils.substring(rawMsg, 0, e.desc().length()).toUpperCase(Locale.ROOT))) {
                        String key = event.getRawMessage().toUpperCase(Locale.ROOT).replaceAll(e.desc(), "").trim();
                        bot.sendGroupMsg(event.getGroupId(), api.queryMusics(key, event.getGroupId(), event.getUserId(), e).build(), false);
                        return MESSAGE_IGNORE;
                    }
                }
            }
        }

        //执行发送歌曲操作
        if (MusicEnum.SONG.desc().equals(StringUtils.substring(rawMsg, 0, MusicEnum.SONG.desc().length()).toUpperCase(Locale.ROOT))) {
            String key = event.getRawMessage().replaceAll(MusicEnum.SONG.desc(), "").trim();
            try {
                Body body = api.reqSong(event.getGroupId(), event.getUserId(), key);
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().customMusic(
                        body.getMe(),
                        body.getLink(),
                        body.getUrl(),
                        body.getTitle(),
                        body.getAuthor(),
                        body.getPic()
                ).build(), false);
            } catch (Exception e) {
                bot.sendGroupMsg(event.getGroupId(), e.getMessage(), false);
            }
        }

        return MESSAGE_IGNORE;
    }

}
