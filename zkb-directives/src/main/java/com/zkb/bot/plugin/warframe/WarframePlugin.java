package com.zkb.bot.plugin.warframe;


import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.WarframeFissureTypeEnum;
import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.bot.warframe.utils.WarframeStringUtils;
import com.zkb.bot.warframe.utils.WarframeUtils;
import com.zkb.bot.warframe.utils.market.MarketItemUtil;
import com.zkb.bot.warframe.utils.market.MarketLichAndSisterUtil;
import com.zkb.bot.warframe.utils.market.MarketRivenUtil;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.uuid.UUID;
import com.zkb.framework.manager.AsyncManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.TimerTask;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;
import static com.zkb.bot.enums.WarframeTypeEnum.*;


/**
 * @author KingPrimes
 */
@Shiro
@Component
public class WarframePlugin {

    @GroupMessageHandler
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        long botId = bot.getSelfId();
        long user = event.getUserId();
        long group = event.getGroupId();
        String rawMsg = event.getRawMessage();

        if (rawMsg.trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        //突击
        if (TYPE_ASSAULT_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getAssaultImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //执政官突击
        if (TYPE_ARCHON_HUNT_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getArchonHuntImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //入侵
        if (TYPE_INVASIONS_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getInvasionsImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //奸商
        if (TYPE_VOID_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getVoidImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //仲裁
        if (TYPE_ARBITRATION_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getArbitrationImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //每日特惠
        if (TYPE_DAILY_DEALS_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getDailyDealsImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //钢铁
        if (TYPE_STEEL_PATH_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getSteelPathImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //模拟开核桃
        if (TYPE_OPEN_RELICS_PLUGIN.getType().equals(rawMsg) || TYPE_OPEN1_RELICS_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getRelicsToy/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //核桃
        if (TYPE_RELICS_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_RELICS_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                String key = rawMsg.replaceAll(TYPE_RELICS_PLUGIN.getType(), "");
                if (key.trim().length() == 0) {
                    bot.sendGroupMsg(group, Msg.builder().text("请输入 遗物名称如 A1").build(), false);
                    return 0;
                }
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getRelics/" + key+"/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //裂隙
        if (TYPE_FISSUES_PLUGIN.getType().equals(rawMsg) || TYPE_FISSUESX_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getFissuesImage/" + WarframeFissureTypeEnum.ORDINARY+"/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //九重天裂隙
        if (TYPE_FISSUES_EMPYREAN_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getFissuesImage/" + WarframeFissureTypeEnum.STORM+"/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //钢铁裂隙
        if (TYPE_FISSUES_PATH_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getFissuesImage/" + WarframeFissureTypeEnum.HARD+"/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //平原
        if (TYPE_ALL_CYCLE_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getAllCycleImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //紫卡倾向变动
        if (TYPE_RIVEN_DIS_UPDATE_PLUGIN.getType().equals(rawMsg)) {
            return WarframeStringUtils.getRivenUpdate(bot, event);
        }

        //电波
        if (TYPE_NIGH_TWAVE_PLUGIN.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getNighTwaveImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //翻译
        if (TYPE_TRA_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_TRA_PLUGIN.getType().length()))) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                try {
                    bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/" + UUID.fastUUID() + "/getTraImage/" + URLEncoder.encode(rawMsg.replace("翻译", "").trim(), "UTF-8")+"/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //金银垃圾
        if (TYPE_MARKET_GOD_DUMP.getType().equals(rawMsg) || TYPE_MARKET_SILVER_DUMP.getType().equals(rawMsg)) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(group, FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(group, Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/market/" + UUID.fastUUID() + "/getMarektDumpsImage/"+botId+"/"+user+"/"+group+"/"+rawMsg).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //WM
        if (TYPE_WM_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_WM_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketItemUtil.marketSelectItem(bot, event);
                }
            });
            return 0;
        }

        //RM
        if (TYPE_RM_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_RM_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {

        }

        // WR
        if (TYPE_WR_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_WR_PLUGIN.getType().length()).toUpperCase(Locale.ROOT)) || TYPE_ZKWM_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_ZKWM_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketRivenUtil.sendToGroupRiven(bot, event);
                }
            });
            return 0;
        }

        //赤毒武器
        if (TYPE_CD_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_CD_PLUGIN.getType().length()).toUpperCase(Locale.ROOT)) || TYPE_C_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_C_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketLichAndSisterUtil.marketLich(bot, event);
                }
            });
            return 0;
        }

        //信条武器
        if (TYPE_XT_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_XT_PLUGIN.getType().length()).toUpperCase(Locale.ROOT)) || TYPE_X_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_X_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketLichAndSisterUtil.marketSister(bot, event);
                }
            });
            return 0;
        }

        if(TYPE_SISTER_PLUGIN.getType().equals(rawMsg)){
            bot.sendGroupMsg(group,Msg.builder().text(WarframeUtils.getSister("",botId,user,group,rawMsg)).build(), false);
        }

        //WIKI
        if (TYPE_WIKI_PLUGIN.getType().equals(StringUtils.substring(rawMsg, 0, TYPE_WIKI_PLUGIN.getType().toUpperCase(Locale.ROOT).length()))) {
            try {
                bot.sendGroupMsg(group, Msg.builder().text("http://warframe.huijiwiki.com/index.php?search=" + URLEncoder.encode(rawMsg.replace("wiki", "").trim(), "UTF-8")).build(), false);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }




        return MESSAGE_IGNORE;
    }


}
