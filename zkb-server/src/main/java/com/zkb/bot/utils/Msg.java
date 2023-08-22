package com.zkb.bot.utils;

import com.mikuac.shiro.common.utils.MsgUtils;
import com.mikuac.shiro.common.utils.OneBotMedia;
import com.mikuac.shiro.common.utils.ShiroUtils;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.mikuac.shiro.dto.event.message.PrivateMessageEvent;
import com.zkb.bot.enums.MusicTypeEnum;
import org.eclipse.jgit.util.Base64;

import java.util.Arrays;

import static java.lang.String.format;

public class Msg extends MsgUtils {

    public Integer N = 0;
    public Integer Y = 1;
    private StringBuilder str = new StringBuilder();

    public Msg() {
    }

    public static Msg builder() {
        return new Msg();
    }

    @Override
    public Msg text(String text) {
        this.str.append(text);
        return this;
    }

    @Override
    public Msg img(String url) {
        this.str.append(
                format("[CQ:image,file=%s]", ShiroUtils.escape(url))
        );
        return this;
    }

    public Msg imgBase64(byte[] b) {
        this.str.append(
                format("[CQ:image,file=%s]", ShiroUtils.escape("base64://"+ Base64.encodeBytes(b)))
        );
        return this;
    }

    @Override
    public Msg img(OneBotMedia img) {
        this.str.append("[CQ:image,")
                .append(img.escape())
                .append("]");
        return this;
    }

    @Override
    public Msg video(String video, String cover) {
        this.str.append(
                format(
                        "[CQ:video,file=%s,cover=%s]",
                        ShiroUtils.escape(video),
                        ShiroUtils.escape(cover)
                )
        );
        return this;
    }

    @Override
    public Msg flashImg(String img) {
        this.str.append(
                format(
                        "[CQ:image,type=flash,file=%s]",
                        ShiroUtils.escape(img)
                )
        );
        return this;
    }

    @Override
    public Msg face(int id) {
        this.str.append(
                format("[CQ:face,id=%s]", id)
        );
        return this;
    }

    public Msg record(String record) {
        this.str.append(
                format(
                        "[CQ:record,file=%s]",
                        ShiroUtils.escape(record)
                )
        );
        return this;
    }

    public Msg record(OneBotMedia record) {
        this.str.append("[CQ:record,")
                .append(record.escape())
                .append("]");
        return this;
    }

    @Override
    public Msg at(long userId) {
        this.str.append(
                format(
                        "[CQ:at,qq=%s]",
                        userId
                )
        );
        return this;
    }

    @Override
    public Msg atAll() {
        this.str.append("[CQ:at,qq=all]");
        return this;
    }

    @Override
    public Msg poke(long userId) {
        this.str.append(
                format(
                        "[CQ:poke,qq=%s]",
                        userId
                )
        );
        return this;
    }

    @Override
    public Msg reply(int msgId) {
        this.str.append(
                format(
                        "[CQ:reply,id=%s]",
                        msgId
                )
        );
        return this;
    }

    @Override
    public Msg gift(long userId, int giftId) {
        this.str.append(
                format(
                        "[CQ:gift,qq=%s,id=%s]",
                        userId,
                        giftId
                )
        );
        return this;
    }

    @Override
    public Msg tts(String text) {
        this.str.append(
                format(
                        "[CQ:tts,text=%s]",
                        ShiroUtils.escape(text)
                )
        );
        return this;
    }

    @Override
    public Msg xml(String data) {
        this.str.append(
                format(
                        "[CQ:xml,data=%s]",
                        ShiroUtils.escape(data)
                )
        );
        return this;
    }

    @Override
    public Msg xml(String data, int resId) {
        this.str.append(
                format(
                        "[CQ:xml,data=%s,resid=%s]",
                        ShiroUtils.escape(data),
                        resId
                )
        );
        return this;
    }

    @Override
    public Msg json(String data) {
        this.str.append(
                format(
                        "[CQ:json,data=%s]",
                        ShiroUtils.escape(data)
                )
        );
        return this;
    }

    @Override
    public Msg json(String data, int resId) {
        this.str.append(
                format(
                        "[CQ:json,data=%s,resid=%s]",
                        ShiroUtils.escape(data),
                        resId
                )
        );
        return this;
    }

    @Override
    public Msg cardImage(String file) {
        this.str.append(
                format(
                        "[CQ:cardimage,file=%s]",
                        ShiroUtils.escape(file)
                )
        );
        return this;
    }

    @Override
    public Msg cardImage(String file, long minWidth, long minHeight, long maxWidth, long maxHeight, String source, String icon) {
        this.str.append(
                format(
                        "[CQ:cardimage,file=%s,minwidth=%s,minheight=%s,maxwidth=%s,maxheight=%s,source=%s,icon=%s]",
                        ShiroUtils.escape(file),
                        minWidth,
                        minHeight,
                        maxWidth,
                        maxHeight,
                        ShiroUtils.escape(source),
                        ShiroUtils.escape(icon)
                )
        );
        return this;
    }


    public Msg music(MusicTypeEnum type, long id) {
        this.str.append(
                format(
                        "[CQ:music,type=%s,id=%s]",
                        ShiroUtils.escape(type.desc()),
                        id
                )
        );
        return this;
    }

    @Override
    public Msg customMusic(String url, String audio, String title, String content, String image) {
        this.str.append(
                format(
                        "[CQ:music,type=custom,url=%s,audio=%s,title=%s,content=%s,image=%s]",
                        ShiroUtils.escape(url),
                        ShiroUtils.escape(audio),
                        ShiroUtils.escape(title),
                        ShiroUtils.escape(content),
                        ShiroUtils.escape(image)
                )
        );
        return this;
    }

    public Msg customMusic(MusicTypeEnum type, String url, String audio, String title, String content, String image) {
        this.str.append(
                format(
                        "[CQ:music,type=custom,subtype=%s,url=%s,audio=%s,title=%s,content=%s,image=%s]",
                        ShiroUtils.escape(type.desc()),
                        ShiroUtils.escape(url),
                        ShiroUtils.escape(audio),
                        ShiroUtils.escape(title),
                        ShiroUtils.escape(content),
                        ShiroUtils.escape(image)
                )
        );
        return this;
    }

    @Override
    public Msg customMusic(String url, String audio, String title) {
        this.str.append(
                format(
                        "[CQ:music,type=custom,url=%s,audio=%s,title=%s]",
                        ShiroUtils.escape(url),
                        ShiroUtils.escape(audio),
                        ShiroUtils.escape(title)
                )
        );
        return this;
    }

    @Override
    public String build() {
        return this.str.toString();
    }

    public Msg forward(Integer msgId) {
        this.str.append(
                format(
                        "[CQ:forward,id=%s]",
                        msgId
                )
        );
        return this;
    }

    public Msg node(Integer msgId) {
        this.str.append(
                format(
                        "[CQ:node,id=%s]",
                        msgId
                )
        );
        return this;
    }

    public Msg node(Long userId, String nickname, String content) {
        this.str.append(
                format(
                        "[CQ:node,user_id=%s,nickname=%s,content=%s]",
                        userId,
                        nickname,
                        ShiroUtils.escape(content)
                )
        );
        return this;
    }

    public void sendToGroup(Bot bot, GroupMessageEvent group) {
        bot.sendGroupMsg(group.getGroupId(), this.build(), false);
    }

    public void sendToGroup(Bot bot, Long groupId) {
        bot.sendGroupMsg(groupId, this.build(), false);
    }


    public void sendToPrivate(Bot bot, PrivateMessageEvent priv) {
        bot.sendPrivateMsg(priv.getUserId(), this.build(), false);
    }
}
