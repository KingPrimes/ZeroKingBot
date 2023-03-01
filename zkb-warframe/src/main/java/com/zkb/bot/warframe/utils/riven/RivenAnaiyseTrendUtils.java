package com.zkb.bot.warframe.utils.riven;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.domain.OCRData;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.WarframeRivenTrendTypeEnum;
import com.zkb.bot.utils.CqParse;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.bot.warframe.dao.RivenAnaiyseTrend;
import com.zkb.bot.warframe.domain.WarframeRivenAnalyseTrend;
import com.zkb.bot.warframe.domain.WarframeRivenTrend;
import com.zkb.bot.warframe.service.IWarframeRivenAnalyseTrendService;
import com.zkb.bot.warframe.service.IWarframeRivenTrendService;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.utils.MessageUtils;
import com.zkb.common.utils.RegularMatch;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RivenAnaiyseTrendUtils {

    static Logger log = LoggerFactory.getLogger(RivenAnaiyseTrendUtils.class);

    public static void rivenAnaiyse(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
            if (!StringUtils.isHttpUrl(event.getRawMessage())) {
                bot.sendGroupMsg(event.getGroupId(), "请在发送指令的同时携带图片，只能携带一张图片！", false);
                return;
            }
            Msg msg = RivenAnaiyseTrendUtils.rivenAnaiyse(event.getRawMessage(), bot);
            bot.sendGroupMsg(event.getGroupId(), msg.build(), false);
        }
    }


    private static Msg rivenAnaiyse(String raw, Bot bot) {
        raw = CqParse.build(raw).getCqImageMD5().get(0);
        OCRData ocrData = OCRData.ocrImage(raw + ".image", bot);
        RivenAnaiyseTrend trend = new RivenAnaiyseTrend();
        Msg msg = new Msg();
        boolean nag = false;
        int x = 0;
        try {
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
                                if(RegularMatch.isRivenNameEx(rivenName)){
                                    trend.setRivenName(RegularMatch.getRivenNameE(str) + rivenName);
                                }else{
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

                        if (attribute.getAttribute() < 0) {
                            nag = true;
                        }
                        trend.add(attribute);
                    }
                }
                //翻译武器名字
                String s = SpringUtils.getBean(IWarframeTranslationService.class).zhToEnTrim(trend.getWeaponsName());
                if (s == null || s.isEmpty()) {
                    msg.text(MessageUtils.message("warframe.riven.anaiyse")).img("https://i.niupic.com/images/2023/02/27/alan.png");
                    return msg;
                }
                WarframeRivenTrend analyseTrend = new WarframeRivenTrend();
                analyseTrend.setRivenTrendName(s);
                //查询武器紫卡具体的倾向
                List<WarframeRivenTrend> trendList = SpringUtils.getBean(IWarframeRivenTrendService.class).selectWarframeRivenTrendList(analyseTrend);
                //武器类型
                WarframeRivenTrendTypeEnum typeEnum;

                StringBuilder ret = new StringBuilder();

                //遍历所有的武器
                for (WarframeRivenTrend rivenTrend : trendList) {
                    typeEnum = rivenTrend.getRivenTrendType();
                    if (rivenTrend.getTraCh().replace(" ", "").equals(trend.getWeaponsName().replace(" ", ""))) {
                        ret
                                .append("【")
                                .append(rivenTrend.getTraCh())
                                .append(" ")
                                .append(trend.getRivenName())
                                .append("】\n");
                    } else {
                        ret
                                .append("变体：【")
                                .append(rivenTrend.getTraCh())
                                .append("】\n");
                    }

                    ret
                            .append("倾向：")
                            .append(rivenTrend.getRivenTrendNewDot())
                            .append("(")
                            .append(rivenTrend.getRivenTrendNewNum())
                            .append(")\n")
                            .append("此前版本倾向：")
                            .append(rivenTrend.getRivenTrendOldDot())
                            .append("(")
                            .append(rivenTrend.getRivenTrendOldNum())
                            .append(") \n武器类型：")
                            .append(typeEnum.getDesc())
                            .append("\n具体分析结果：\n")
                    ;
                    for (RivenAnaiyseTrend.Attribute attribute : trend.getC()) {
                        WarframeRivenAnalyseTrend analyse = SpringUtils.getBean(IWarframeRivenAnalyseTrendService.class).selectWarframeRivenAnalyseByName(attribute.getName());
                        if (analyse.getName() == null) {
                            analyse = SpringUtils.getBean(IWarframeRivenAnalyseTrendService.class).selectWarframeRivenAnalyseByName(StringUtils.substring(attribute.getName(), 1));
                        }
                        ret.append(attribute.getAttribute())
                                .append("%")
                                .append(analyse.getName())
                                .append("(");
                        boolean isNag = attribute.getAttribute() < 0;
                        switch (typeEnum) {
                            case SHOTGUN:
                                ret
                                        .append(
                                                attribute.getLowAttribute(
                                                        Double.valueOf(analyse.getShotgun()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                        .append("% - ")
                                        .append(
                                                attribute.getHighAttribute(
                                                        Double.valueOf(analyse.getShotgun()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                ;

                                if (!isNag) {
                                    ret.append("% | 高")
                                            .append(attribute.getLowAttributeDiff())
                                            .append("%)\n");
                                } else {
                                    ret.append("% | 低")
                                            .append(attribute.getHighAttributeDiff())
                                            .append("%)\n");
                                }
                                break;
                            case ARCHGUN:
                                ret
                                        .append(
                                                attribute.getLowAttribute(
                                                        Double.valueOf(analyse.getArchwing()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                        .append("% - ")
                                        .append(
                                                attribute.getHighAttribute(
                                                        Double.valueOf(analyse.getArchwing()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                ;
                                if (!isNag) {
                                    ret.append("% | 高")
                                            .append(attribute.getLowAttributeDiff()).append("%)\n");
                                } else {
                                    ret.append("% | 低")
                                            .append(attribute.getHighAttributeDiff()).append("%)\n");
                                }
                                break;
                            case PISTOL:
                                ret
                                        .append(
                                                attribute.getLowAttribute(
                                                        Double.valueOf(analyse.getPistol()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                        .append("% - ")
                                        .append(
                                                attribute.getHighAttribute(
                                                        Double.valueOf(analyse.getPistol()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                ;
                                if (!isNag) {
                                    ret.append("% | 高")
                                            .append(attribute.getLowAttributeDiff()).append("%)\n");
                                } else {
                                    ret.append("% | 低")
                                            .append(attribute.getHighAttributeDiff()).append("%)\n");
                                }
                                break;
                            case RIFLE:
                                ret
                                        .append(
                                                attribute.getLowAttribute(
                                                        Double.valueOf(analyse.getRifle()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                        .append("% - ")
                                        .append(
                                                attribute.getHighAttribute(
                                                        Double.valueOf(analyse.getRifle()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                ;
                                if (!isNag) {
                                    ret.append("% | 高")
                                            .append(attribute.getLowAttributeDiff()).append("%)\n");
                                } else {
                                    ret.append("% | 低")
                                            .append(attribute.getHighAttributeDiff()).append("%)\n");
                                }
                                break;
                            case MELEE:
                                ret
                                        .append(
                                                attribute.getLowAttribute(
                                                        Double.valueOf(analyse.getMelle()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                        .append("% - ")
                                        .append(
                                                attribute.getHighAttribute(
                                                        Double.valueOf(analyse.getMelle()),
                                                        Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                        trend.getC().size(),
                                                        nag,
                                                        isNag
                                                ))
                                ;
                                if (!isNag) {
                                    ret.append("% | 高")
                                            .append(attribute.getLowAttributeDiff()).append("%)\n");
                                } else {
                                    ret.append("% | 低")
                                            .append(attribute.getHighAttributeDiff()).append("%)\n");
                                }
                                break;
                        }
                    }
                }
                msg.text(ret.toString());
            } else {
                log.error("OCR识别结果为空！");
                msg.text(MessageUtils.message("warframe.riven.anaiyse")).img("https://i.niupic.com/images/2023/02/27/alan.png");
            }
        } catch (Exception e) {
            log.error("紫卡分析报错信息： ", e);
            msg.text(MessageUtils.message("warframe.riven.anaiyse")).img("https://i.niupic.com/images/2023/02/27/alan.png");
            return msg;
        }
        return msg;

    }


}
