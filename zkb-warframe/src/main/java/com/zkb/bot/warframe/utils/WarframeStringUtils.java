package com.zkb.bot.warframe.utils;


import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.MarketEnum;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.StaticFinal;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class WarframeStringUtils {


    //获取选定的平台
    public static String getMarketForm(String str) {
        String form = "PC";
        for (String key : StaticFinal.PLATFORM) {
            if (StringUtils.substring(str.toUpperCase(Locale.ROOT), 2).contains(key)) {
                if ("XB1".equals(key)) {
                    form = MarketEnum.XB1.getForm();
                }
                if ("SWI".equals(key)) {
                    form = MarketEnum.SWI.getForm();
                }
            }
        }
        return form;
    }


    /**
     * 获取紫卡倾向更新
     *
     * @param bot   bot
     * @param event event
     * @return 0
     */
    public static int getRivenUpdate(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
            Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/forums/riven/" + UUID.fastUUID() + "/getNewsImage/"+bot.getSelfId()+"/"+event.getUserId()+"/"+event.getGroupId()+"/"+event.getRawMessage()).sendToGroup(bot, event);
        } else {
            return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
        }
        return 0;
    }

}
