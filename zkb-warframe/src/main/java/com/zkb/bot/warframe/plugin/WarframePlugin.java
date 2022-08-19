package com.zkb.bot.warframe.plugin;


import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.mikuac.shiro.dto.event.message.PrivateMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.WarframeSubscribeEnums;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.GroupAddApi;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.bot.warframe.domain.subscribe.WarframeMissionSubscribe;
import com.zkb.bot.warframe.service.IWarframeMissionSubscribeService;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.bot.warframe.task.RivenDispositionUpdatesTask;
import com.zkb.bot.warframe.utils.WarframeDataUpdateMission;
import com.zkb.bot.warframe.utils.WarframeStringUtils;
import com.zkb.bot.warframe.utils.WarframeTraUtils;
import com.zkb.bot.warframe.utils.market.MarketItemUtil;
import com.zkb.bot.warframe.utils.market.MarketLichAndSisterUtil;
import com.zkb.bot.warframe.utils.market.MarketRivenUtil;
import com.zkb.bot.warframe.utils.market.RenewMarketUtil;
import com.zkb.common.load.LoadConfig;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.utils.uuid.UUID;
import com.zkb.framework.manager.AsyncManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;

import static com.zkb.bot.enums.WarframeTypeEnum.*;


/**
 * @author KingPrimes
 */
@Component
public class WarframePlugin extends BotPlugin {
    @Autowired
    IWarframeMissionSubscribeService service;
    @Autowired
    IWarframeTranslationService traService;

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

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

        //核桃
        if (TYPE_RELICS_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_RELICS_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                String key = event.getRawMessage().replaceAll(TYPE_RELICS_PLUGIN.getType(),"");
                if(key.trim().length()==0){
                    bot.sendGroupMsg(event.getGroupId(),Msg.builder().text("请输入 遗物名称如 A1").build(),false);
                    return 0;
                }
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getRelics/"+key).build(), false);
            } else {
                return ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
            }
        }

        //裂隙
        if (TYPE_FISSUES_PLUGIN.getType().equals(event.getRawMessage()) || TYPE_FISSUESX_PLUGIN.getType().equals(event.getRawMessage())) {
            if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/mission/" + UUID.fastUUID() + "/getFissuesImage").build(), false);
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
                    MarketLichAndSisterUtil.marketSister(bot, event);
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

        //WIKI
        if (TYPE_WIKI_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_WIKI_PLUGIN.getType().toUpperCase(Locale.ROOT).length()))) {
            try {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("http://warframe.huijiwiki.com/index.php?search=" + URLEncoder.encode(event.getRawMessage().replace("wiki", "").trim(), "UTF-8")).build(), false);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if ("订阅列表".equals(StringUtils.substring(event.getRawMessage(), 0, "订阅列表".length()))) {
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/subscriber/" + UUID.fastUUID() + "/getSubscriberHelp").build(), false);
            return MESSAGE_BLOCK;
        }
        if ("取消订阅".equals(StringUtils.substring(event.getRawMessage(), 0, "取消订阅".length()))) {
            String str = event.getRawMessage().replace("取消订阅", "").trim();
            if (str.length() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("请在订阅后方填写要订阅的数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }
            if (!StringUtils.isNumber(str)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("请在订阅后方填写要订阅的整数数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }
            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            if (enums.ordinal() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("订阅数字不正确，请发送[订阅列表] 查看具体数值").build(), false);
                return MESSAGE_BLOCK;
            }
            WarframeMissionSubscribe subscribe1 = new WarframeMissionSubscribe(event.getGroupId(), "", bot.getSelfId(), enums.ordinal());
            List<WarframeMissionSubscribe> subscribes = service.selectWarframeMissionSubscribeList(subscribe1);
            if (subscribes.size() != 0) {
                if (!GroupAddApi.isAdmin(bot, event)) {
                    for (WarframeMissionSubscribe subscribe : subscribes) {
                        if (subscribe.getSubscribeUser() != null) {
                            if (subscribe.getSubscribeUser().length() != 0) {
                                Msg.builder().text("不可以取消群订阅！\n群内有其它玩家订阅了此内容！").sendToGroup(bot, event);
                                return MESSAGE_BLOCK;
                            }
                        }
                    }
                }
            }
            int i = service.deleteWarframeMissionSubscribe(subscribe1);
            if (i > 0) {
                Msg.builder().text("成功取消 [" + enums.getName() + "] 订阅").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text("从未有过此订阅").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        if ("私人订阅".equals(StringUtils.substring(event.getRawMessage(), 0, "私人订阅".length()))) {
            String str = event.getRawMessage().replace("私人订阅", "").trim();
            if (str.length() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().at(event.getUserId()).text("请在订阅后方填写要订阅的数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }
            if (!StringUtils.isNumber(str)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().at(event.getUserId()).text("请在订阅后方填写要订阅的整数数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }

            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            if (enums.ordinal() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().at(event.getUserId()).text("订阅数字不正确，请发送[订阅列表] 查看具体数值").build(), false);
                return MESSAGE_BLOCK;
            }
            int i = service.updateWarframeMissionSubscribeUser(new WarframeMissionSubscribe(event.getGroupId(), String.valueOf(event.getUserId()), bot.getSelfId(), enums.ordinal()));
            if (i > 0) {
                Msg.builder().at(event.getUserId()).text("成功订阅 : " + enums.getName()).sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().at(event.getUserId()).text(enums.getName() + ",已经订阅过了").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        if ("取消私人订阅".equals(StringUtils.substring(event.getRawMessage(), 0, "取消私人订阅".length()))) {
            String str = event.getRawMessage().replace("取消私人订阅", "").trim();
            if (str.length() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().at(event.getUserId()).text("请在订阅后方填写要订阅的数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }
            if (!StringUtils.isNumber(str)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().at(event.getUserId()).text("请在订阅后方填写要订阅的整数数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }
            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            if (enums.ordinal() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().at(event.getUserId()).text("订阅数字不正确，请发送[订阅列表] 查看具体数值").build(), false);
                return MESSAGE_BLOCK;
            }
            WarframeMissionSubscribe subscribe1 = new WarframeMissionSubscribe(event.getGroupId(), String.valueOf(event.getUserId()), bot.getSelfId(), enums.ordinal());
            int i = service.deleteWarframeMissionSubscribeUser(subscribe1);
            if (i > 0) {
                Msg.builder().at(event.getUserId()).text("成功取消 [" + enums.getName() + "] 订阅").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().at(event.getUserId()).text("从未有过此订阅").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        if ("订阅".equals(StringUtils.substring(event.getRawMessage(), 0, "订阅".length()))) {
            String str = event.getRawMessage().replace("订阅", "").trim();
            if (str.length() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("请在订阅后方填写要订阅的数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }
            if (!StringUtils.isNumber(str)) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("请在订阅后方填写要订阅的整数数字\n详情发送[订阅列表]查看").build(), false);
                return MESSAGE_BLOCK;
            }
            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            if (enums.ordinal() == 0) {
                bot.sendGroupMsg(event.getGroupId(), Msg.builder().text("订阅数字不正确，请发送[订阅列表] 查看具体数值").build(), false);
                return MESSAGE_BLOCK;
            }
            int i = service.updateWarframeMissionSubscribeUser(new WarframeMissionSubscribe(event.getGroupId(), "", bot.getSelfId(), enums.ordinal()));
            if (i > 0) {
                Msg.builder().text("成功订阅 : " + enums.getName()).sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            } else {
                Msg.builder().text(enums.getName() + ",已经订阅过了").sendToGroup(bot, event);
                return MESSAGE_BLOCK;
            }
        }
        return MESSAGE_IGNORE;
    }

    @Override
    public int onPrivateMessage(@NotNull Bot bot, @NotNull PrivateMessageEvent event) {
        if (event.getUserId() == LoadConfig.getAdmin()) {
            if (TYPE_RES_MARKET_ITEMS.getType().equals(event.getRawMessage())) {
                int x = RenewMarketUtil.resMarketItems();
                bot.sendPrivateMsg(event.getUserId(), "更新成功，共更新" + x + "条数据!", false);
            }
            if (TYPE_RES_MARKET_RIVEN.getType().equals(event.getRawMessage())) {
                int x = RenewMarketUtil.resMarketRiven();
                bot.sendPrivateMsg(event.getUserId(), "更新成功，共更新" + x + "条数据!", false);
            }
            if ("更新紫卡倾向变动".equals(event.getRawMessage())) {
                try {
                    new RivenDispositionUpdatesTask().renewRivenDisposition();
                    bot.sendPrivateMsg(event.getUserId(), "已执行请稍后，在群内使用 紫卡倾向变动查看", false);
                    return 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("更新信条".equals(event.getRawMessage())) {
                Msg msg = new Msg();
                int[] i = RenewMarketUtil.resMarketSister();
                msg.text("更新信条武器条数：" + i[0])
                        .text("\n更新信条幻纹条数：" + i[1])
                        .build();
                bot.sendPrivateMsg(event.getUserId(), msg.build(), false);
            }
            if ("更新翻译".equals(event.getRawMessage())) {
                bot.sendPrivateMsg(event.getUserId(), "正在准备更新", false);
                int i = SpringUtils.getBean(WarframeTraUtils.class).getUserDict();
                bot.sendPrivateMsg(event.getUserId(), "更新完成，共更新：" + i + "条数据", false);

            }
            if (TYPE_CODE.getType().equals(event.getRawMessage())) {
                bot.sendPrivateMsg(event.getUserId(), "更新WM物品\n更新WM紫卡\n更新信条\n更新翻译\n更新紫卡倾向变动", false);
            }

        }
        return 0;
    }

}