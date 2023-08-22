package com.zkb.bot.warframe.utils;


import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.MarketEnum;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.StaticFinal;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class WarframeStringUtils {


    //获取选定的平台
    public static String getMarketForm(String str) {
        String form = "PC";
        for (String key : StaticFinal.PLATFORM) {
            if (str.toLowerCase().contains(key)) {
                switch (key) {
                    case "xb1":
                        form = MarketEnum.XB1.getForm();
                        break;
                    case "swi":
                        form = MarketEnum.SWI.getForm();
                        break;
                    case "ps4":
                        form = MarketEnum.PS4.getForm();
                        break;
                    default:
                        form = "PC";
                        break;
                }
            }
        }
        return form;
    }

    public static String removeForm(String str) {
        for (String key : StaticFinal.PLATFORM) {
            if (str.toLowerCase().contains(key)) {
                switch (key) {
                    case "xb1":
                        str = str.toLowerCase().replace("xb1", "").trim();
                        break;
                    case "swi":
                        str = str.toLowerCase().replace("swi", "").trim();
                        break;
                    case "ps4":
                        str = str.toLowerCase().replace("ps4", "").trim();
                        break;
                    default:
                        str = str.toLowerCase().replace("pc", "").trim();
                        break;
                }
            }
        }
        return str;
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
            byte[] bytes = HttpUtils.sendGetForFile("http://localhost:" + GetServerPort.getPort() + "/warframe/forums/riven/" + UUID.fastUUID() + "/getNewsImage/" + bot.getSelfId() + "/" + event.getUserId() + "/" + event.getGroupId() + "/" + event.getRawMessage());
            if(bytes!=null){
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().imgBase64(bytes).build(), false);
            }else{
                bot.sendGroupMsg(event.getGroupId(),"图片生成错误！",false);
            }
            //Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/forums/riven/" + UUID.fastUUID() + "/getNewsImage/" + bot.getSelfId() + "/" + event.getUserId() + "/" + event.getGroupId() + "/" + event.getRawMessage()).sendToGroup(bot, event);
        } else {
            return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
        }
        return 0;
    }


}
