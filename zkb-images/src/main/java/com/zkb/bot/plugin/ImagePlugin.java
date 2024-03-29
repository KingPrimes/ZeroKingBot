package com.zkb.bot.plugin;

import com.alibaba.fastjson2.JSONObject;
import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.common.utils.OneBotMedia;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.ImageEnum;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.http.HttpUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_BLOCK;
import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;

@Shiro
@Component
public class ImagePlugin {
    @GroupMessageHandler
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        if (event.getRawMessage().trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        if (ImageEnum.ORDER_IMAGE.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_IMAGE)) {
                JSONObject object = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.lolicon.app/setu/v2?r18=2"));
                String url = object.getJSONArray("data").getJSONObject(0).getJSONObject("urls").getString("original");
                OneBotMedia oneBotMedia = OneBotMedia.builder()
                        .cache(false)
                        .proxy(false)
                        .timeout(30)
                        .file(url);
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img(oneBotMedia).build(), false);
                return MESSAGE_BLOCK;
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_IMAGE);
            }
        }

        return MESSAGE_IGNORE;
    }
}
