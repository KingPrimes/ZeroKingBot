package com.zkb.bot.warframe.plugin;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.WarframeSubscribeEnums;
import com.zkb.bot.utils.GroupAddApi;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.warframe.domain.subscribe.WarframeMissionSubscribe;
import com.zkb.bot.warframe.service.IWarframeMissionSubscribeService;
import com.zkb.bot.warframe.utils.WarframeDataUpdateMission;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WarframeSubscribePlugin extends BotPlugin {

    @Autowired
    IWarframeMissionSubscribeService service;

    private static final String SUB_LIST= "订阅列表";
    private static final String SUB_END= "取消订阅";
    private static final String SUB_RIVE_END = "取消私人订阅";
    private static final String SUB= "订阅";
    private static final String SUB_RIVE = "私人订阅";

    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {


        if (SUB_LIST.equals(StringUtils.substring(event.getRawMessage(), 0, SUB_LIST.length()))) {
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/subscriber/" + UUID.fastUUID() + "/getSubscriberHelp").build(), false);
            return MESSAGE_BLOCK;
        }

        if (SUB_END.equals(StringUtils.substring(event.getRawMessage(), 0, SUB_END.length()))) {
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

        if (SUB_RIVE_END.contains(StringUtils.substring(event.getRawMessage(), 0, SUB_RIVE_END.length()))) {
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

        if (SUB_RIVE.equals(StringUtils.substring(event.getRawMessage(), 0, SUB_RIVE.length()))) {
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


        if (SUB.equals(StringUtils.substring(event.getRawMessage(), 0, SUB.length()))) {
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
}
