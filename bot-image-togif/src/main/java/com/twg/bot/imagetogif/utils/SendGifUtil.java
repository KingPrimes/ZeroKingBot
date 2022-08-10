package com.twg.bot.imagetogif.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.twg.bot.enums.FunctionEnums;
import com.twg.bot.utils.ErroSendMessage;
import com.twg.bot.utils.Msg;
import com.twg.bot.utils.MsgUtils;
import com.twg.bot.utils.SelectGroupFunctionOnOff;
import com.twg.common.utils.ip.GetServerPort;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class SendGifUtil {

    /**
     * @param bot
     * @param event
     * @param url   /Gif/Email/Funny/getImage/
     * @return
     */
    public static int sendGif(@NotNull Bot bot, @NotNull GroupMessageEvent event, @NotNull String url) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_GIF)) {
            if (!event.getRawMessage().contains("[CQ:at,qq")) {
                if (event.getRawMessage().contains("-")) {
                    String ms = event.getRawMessage().split("-")[1];
                    bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + url + event.getUserId() + "/" + ms).build(), false);
                    return 0;
                }
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + url + event.getUserId() + "/0").build(), false);
                return 0;
            }
            //[CQ:at,qq=?]
            String qq = MsgUtils.getAtQQ(event.getRawMessage());
            if (event.getRawMessage().contains("-")) {
                String ms = event.getRawMessage().split("-")[1];
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + url + qq + "/" + ms).build(), false);
            } else {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + url + qq + "/0").build(), false);
            }
            return 0;
        } else {
            return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_GIF);
        }
    }

    public static boolean random() {
        Random r = new Random();
        int i = r.nextInt(100);
        boolean m;
        m = i < 50;
        return m;
    }
}
