package com.zkb.bot.plugin.music;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.domain.Music163;
import com.zkb.bot.domain.xmsj.model.IXmsjApi;
import com.zkb.bot.domain.xmsj.model.vo.Body;
import com.zkb.bot.enums.MusicEnum;
import com.zkb.bot.enums.MusicTypeEnum;
import com.zkb.bot.utils.Msg;
import com.zkb.common.utils.StringUtils;
import org.jetbrains.annotations.NotNull;
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
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        String rawMsg = event.getRawMessage();

        if (rawMsg.trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        if(MusicEnum.W163.desc().equals(StringUtils.substring(rawMsg, 0, MusicEnum.W163.desc().length()).toUpperCase(Locale.ROOT))){
            String key = event.getRawMessage().replaceAll(MusicEnum.W163.desc(),"").trim();
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().music(MusicTypeEnum.WY,Music163.getMusic163(key)).build(), false);
            return MESSAGE_IGNORE;
        }

        if(MusicEnum.QQ.desc().equals(StringUtils.substring(rawMsg, 0, MusicEnum.QQ.desc().length()).toUpperCase(Locale.ROOT))){
            String key = event.getRawMessage().toUpperCase(Locale.ROOT).replaceAll(MusicEnum.QQ.desc(),"").trim();
            bot.sendGroupMsg(event.getGroupId(), api.queryMusics(key,event.getGroupId(), event.getUserId()).build(), false);
            return MESSAGE_IGNORE;
        }

        if(MusicEnum.SONG.desc().equals(StringUtils.substring(rawMsg, 0, MusicEnum.SONG.desc().length()).toUpperCase(Locale.ROOT))){
            String key = event.getRawMessage().replaceAll(MusicEnum.SONG.desc(),"").trim();
            try {
                Body body = api.reqSong(event.getGroupId(), event.getUserId(), key);
                bot.sendGroupMsg(event.getGroupId(),Msg.builder().customMusic(
                        MusicTypeEnum.QQ,
                        body.getLink(),
                        body.getUrl(),
                        body.getTitle(),
                        body.getAuthor(),
                        body.getPic()

                ).build() , false);
            }catch (Exception e){
                bot.sendGroupMsg(event.getGroupId(),e.getMessage(),false);
            }
        }

        return MESSAGE_IGNORE;
    }

}
