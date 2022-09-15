package com.zkb.plugin;

import com.alibaba.fastjson2.JSONObject;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.ImageEnum;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.http.HttpUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ImagePlugin extends BotPlugin {
    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        if (event.getRawMessage().trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        if (ImageEnum.ORDER_IMAGE.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_IMAGE)) {
                JSONObject object = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.lolicon.app/setu/v2?r18=2"));
                String url = object.getJSONArray("data").getJSONObject(0).getJSONObject("urls").getString("original");
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img(url).build(), false);
                return MESSAGE_BLOCK;
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_IMAGE);
            }
        }

        return MESSAGE_IGNORE;
    }
}
