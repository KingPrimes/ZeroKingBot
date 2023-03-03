package com.zkb.bot.warframe.utils.riven;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.domain.OCRData;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.CqParse;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.bot.warframe.dao.RivenAnaiyseTrend;
import com.zkb.common.utils.RegularMatch;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class RivenAnaiyseTrendUtils {

    static Logger log = LoggerFactory.getLogger(RivenAnaiyseTrendUtils.class);

    static String errorHtmlUrl = "http://localhost:" + GetServerPort.getPort() + "/warframe/riven/anaiyse/rivenErrorHtml";

    public static void rivenAnaiyse(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
            if (!StringUtils.isHttpUrl(event.getRawMessage())) {
                bot.sendGroupMsg(event.getGroupId(), "请在发送指令的同时携带图片，只能携带一张图片！", false);
                return;
            }
            Msg msg = new Msg();
            RivenAnaiyseTrend trend = RivenAnaiyseTrendUtils.rivenAnaiyse(event.getRawMessage(), bot);
            System.out.println("ORC:"+trend);
            if(trend == null){
                msg.img(errorHtmlUrl);
            }else{
               try {
                   msg.img("http://localhost:" + GetServerPort.getPort() + "/warframe/riven/anaiyse/" + UUID.fastUUID() + "/getRivenAnaiyseImage?trend="+ URLEncoder.encode(trend.toString(),"UTF-8"));
               }catch (Exception e){
                   msg.img(errorHtmlUrl);
               }
            }
            bot.sendGroupMsg(event.getGroupId(), msg.build(), false);
        }
    }


    private static RivenAnaiyseTrend rivenAnaiyse(String raw, Bot bot) {
        raw = CqParse.build(raw).getCqImageMD5().get(0);
        OCRData ocrData = OCRData.ocrImage(raw + ".image", bot);
        RivenAnaiyseTrend trend = new RivenAnaiyseTrend();
        int x = 0;
        //判断识别文本是否为空
        if (!ocrData.getTexts().isEmpty()) {
            for (int i = 0; i < ocrData.getTexts().size(); i++) {
                String str = ocrData.getTexts().get(i).getText();
                //检查是否是武器名字
                if (RegularMatch.isWeaponsName(str)) {
                    if (trend.getWeaponsName() == null || trend.getWeaponsName().isEmpty()) {
                        trend.setWeaponsName(RegularMatch.getChines(str));
                        if (i + 1 < ocrData.getTexts().size() - 1) {
                            String rivenName = ocrData.getTexts().get(i + 1).getText();
                            if (RegularMatch.isRivenNameEx(rivenName)) {
                                trend.setRivenName(RegularMatch.getRivenNameE(str) + rivenName);
                            } else {
                                trend.setRivenName(RegularMatch.getRivenNameE(str));
                            }
                        }
                    }
                }

                //检查是否是紫卡名字
                if (RegularMatch
                        .isRivenName(str)) {
                    trend.setRivenName(RegularMatch.getRivenName(str));
                }
                //检查是否是紫卡属性
                if (RegularMatch.isAttribute(str.replace(" ", ""))) {
                    x++;
                    RivenAnaiyseTrend.Attribute attribute = new RivenAnaiyseTrend.Attribute();
                    attribute.setName(RegularMatch.getAttribetName(str.replace(" ", "")));
                    attribute.setAttribute(RegularMatch.getAttributeNum(str.replace(" ", "")));
                    if (x >= 4) {
                        if (!str.contains("-")) {
                            attribute.setAttribute(RegularMatch.getAttributeNum("-" + str.replace(" ", "")));
                        }
                    }

                    attribute.setNag(attribute.getAttribute() < 0);
                    trend.add(attribute);
                }
            }
            return trend;
        }
        return null;
    }


}
