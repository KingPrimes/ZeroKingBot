package com.zkb.bot.warframe.plugin;


import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.WarframeFissureTypeEnum;
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

import static com.zkb.bot.enums.WarframeTypeEnum.*;


/**
 * @author KingPrimes
 */
@Component
public class WarframePlugin extends BotPlugin {

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        if (event.getRawMessage().trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        //突击
        if (TYPE_ASSAULT_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getAssaultImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //入侵
        if (TYPE_INVASIONS_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getInvasionsImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //奸商
        if (TYPE_VOID_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getVoidImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //仲裁
        if (TYPE_ARBITRATION_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getArbitrationImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //每日特惠
        if (TYPE_DAILY_DEALS_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getDailyDealsImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //钢铁
        if (TYPE_STEEL_PATH_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getSteelPathImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //模拟开核桃
        if (TYPE_OPEN_RELICS_PLUGIN.getType().equals(event.getRawMessage()) || TYPE_OPEN1_RELICS_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getRelicsToy").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //核桃
        if (TYPE_RELICS_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_RELICS_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                String key = event.getRawMessage().replaceAll(TYPE_RELICS_PLUGIN.getType(), "");
                if (key.trim().length() == 0) {
                    bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("请输入 遗物名称如 A1").build(), false);
                    return 0;
                }
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getRelics/" + key).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //裂隙
        if (TYPE_FISSUES_PLUGIN.getType().equals(event.getRawMessage()) || TYPE_FISSUESX_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getFissuesImage/" + WarframeFissureTypeEnum.ORDINARY).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //九重天裂隙
        if (TYPE_FISSUES_EMPYREAN_PLUGIN.getType().equals(event.getRawMessage()) || TYPE_FISSUES_EMPYREAN_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getFissuesImage/" + WarframeFissureTypeEnum.STORM).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //钢铁裂隙
        if (TYPE_FISSUES_PATH_PLUGIN.getType().equals(event.getRawMessage()) || TYPE_FISSUES_PATH_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getFissuesImage/" + WarframeFissureTypeEnum.HARD).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //平原
        if (TYPE_ALL_CYCLE_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getAllCycleImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //紫卡倾向变动
        if (TYPE_RIVEN_DIS_UPDATE_PLUGIN.getType().equals(event.getRawMessage())) {
            return WarframeStringUtils.getRivenUpdate(bot, event);
        }

        //电波
        if (TYPE_NIGH_TWAVE_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getNighTwaveImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //翻译
        if (TYPE_TRA_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_TRA_PLUGIN.getType().length()))) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                try {
                    bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/" + UUID.fastUUID() + "/getTraImage/" + URLEncoder.encode(event.getRawMessage().replace("翻译", "").trim(), "UTF-8")).build(), false);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //金银垃圾
        if (TYPE_MARKET_GOD_DUMP.getType().equals(event.getRawMessage()) || TYPE_MARKET_SILVER_DUMP.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/market/" + UUID.fastUUID() + "/getMarektDumpsImage").build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //WM
        if (TYPE_WM_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_WM_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketItemUtil.marketSelectItem(bot, event);
                }
            });
            return 0;
        }

        //RM
        if (TYPE_RM_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_RM_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {

        }

        // WR
        if (TYPE_WR_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_WR_PLUGIN.getType().length()).toUpperCase(Locale.ROOT)) || TYPE_ZKWM_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_ZKWM_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketRivenUtil.sendToGroupRiven(bot, event);
                }
            });
            return 0;
        }

        //赤毒武器
        if (TYPE_CD_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_CD_PLUGIN.getType().length()).toUpperCase(Locale.ROOT)) || TYPE_C_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_C_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketLichAndSisterUtil.marketLich(bot, event);
                }
            });
            return 0;
        }

        //信条武器
        if (TYPE_XT_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_XT_PLUGIN.getType().length()).toUpperCase(Locale.ROOT)) || TYPE_X_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_X_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            AsyncManager.me().execute(new TimerTask() {
                @Override
                public void run() {
                    MarketLichAndSisterUtil.marketSister(bot, event);
                }
            });
            return 0;
        }

        if(TYPE_SISTER_PLUGIN.getType().equals(event.getRawMessage())){
            bot.sendGroupMsg(event.getGroupId(),Msg.builder().text(WarframeUtils.getSister("")).build(), false);
        }

        //WIKI
        if (TYPE_WIKI_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_WIKI_PLUGIN.getType().toUpperCase(Locale.ROOT).length()))) {
            try {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("http://warframe.huijiwiki.com/index.php?search=" + URLEncoder.encode(event.getRawMessage().replace("wiki", "").trim(), "UTF-8")).build(), false);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return MESSAGE_IGNORE;
    }


}
