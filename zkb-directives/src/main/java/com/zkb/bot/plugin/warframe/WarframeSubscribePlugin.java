package com.zkb.bot.plugin.warframe;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.WarframeSubscribeEnums;
import com.zkb.bot.utils.GroupAddApi;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.warframe.domain.subscribe.WarframeMissionSubscribe;
import com.zkb.bot.warframe.service.IWarframeMissionSubscribeService;
import com.zkb.bot.warframe.utils.WarframeDataUpdateMission;
import com.zkb.common.utils.MessageUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_BLOCK;
import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;

@Shiro
@Component
public class WarframeSubscribePlugin {

    private static final String SUB_LIST = "订阅列表";
    private static final String SUB_END = "取消订阅";
    private static final String SUB_RIVE_END = "取消私人订阅";
    private static final String SUB = "订阅";
    private static final String SUB_RIVE = "私人订阅";
    @Autowired
    IWarframeMissionSubscribeService service;

    @GroupMessageHandler
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        if (event.getRawMessage().trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        if (SUB_LIST.equals(event.getRawMessage().trim())) {
            bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/subscriber/" + UUID.fastUUID() + "/getSubscriberHelp").build(), false);
            return MESSAGE_BLOCK;
        }

        if (SUB_END.equals(StringUtils.substring(event.getRawMessage(), 0, SUB_END.length()))) {
            String str = event.getRawMessage().replace("取消订阅", "").trim();
            if (err(bot, event.getGroupId(), str)) {
                return MESSAGE_BLOCK;
            }
            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            WarframeMissionSubscribe subscribe1 = new WarframeMissionSubscribe(event.getGroupId(), "", bot.getSelfId(), enums.ordinal());
            List<WarframeMissionSubscribe> subscribes = service.selectWarframeMissionSubscribeList(subscribe1);
            if (subscribes.size() != 0) {
                if (!GroupAddApi.isAdmin(bot, event)) {
                    for (WarframeMissionSubscribe subscribe : subscribes) {
                        if (subscribe.getSubscribeUser() != null) {
                            if (subscribe.getSubscribeUser().length() != 0) {
                                Msg.builder().text(MessageUtils.message("warframe.sb.group.error")).sendToGroup(bot, event);
                                return MESSAGE_BLOCK;
                            }
                        }
                    }
                }
            }
            int i = service.deleteWarframeMissionSubscribe(subscribe1);
            if (i > 0) {
                Msg.builder().text("成功取消 [" + enums.getName() + "] 订阅").sendToGroup(bot, event);
            } else {
                Msg.builder().text(MessageUtils.message("warframe.sb.not")).sendToGroup(bot, event);
            }
            return MESSAGE_BLOCK;
        }

        if (SUB_RIVE_END.contains(StringUtils.substring(event.getRawMessage(), 0, SUB_RIVE_END.length()))) {
            String str = event.getRawMessage().replace("取消私人订阅", "").trim();
            if (err(bot, event.getGroupId(), str)) {
                return MESSAGE_BLOCK;
            }
            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            WarframeMissionSubscribe subscribe1 = new WarframeMissionSubscribe(event.getGroupId(), String.valueOf(event.getUserId()), bot.getSelfId(), enums.ordinal());
            int i = service.deleteWarframeMissionSubscribeUser(subscribe1);
            if (i > 0) {
                Msg.builder().at(event.getUserId()).text("成功取消 [" + enums.getName() + "] 订阅").sendToGroup(bot, event);
            } else {
                Msg.builder().at(event.getUserId()).text(MessageUtils.message("warframe.sb.not")).sendToGroup(bot, event);
            }
            return MESSAGE_BLOCK;
        }

        if (SUB_RIVE.equals(StringUtils.substring(event.getRawMessage(), 0, SUB_RIVE.length()))) {
            String str = event.getRawMessage().replace("私人订阅", "").trim();
            if (err(bot, event.getGroupId(), str)) {
                return MESSAGE_BLOCK;
            }
            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            int i = service.updateWarframeMissionSubscribeUser(new WarframeMissionSubscribe(event.getGroupId(), String.valueOf(event.getUserId()), bot.getSelfId(), enums.ordinal()));
            if (i > 0) {
                Msg.builder().at(event.getUserId()).text("成功订阅 : " + enums.getName()).sendToGroup(bot, event);
            } else {
                Msg.builder().at(event.getUserId()).text(enums.getName() + ",已经订阅过了").sendToGroup(bot, event);
            }
            return MESSAGE_BLOCK;
        }


        if (SUB.equals(StringUtils.substring(event.getRawMessage(), 0, SUB.length()))) {
            String str = event.getRawMessage().replace("订阅", "").trim();
            if (err(bot, event.getGroupId(), str)) {
                return MESSAGE_BLOCK;
            }
            WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
            int i = service.updateWarframeMissionSubscribeUser(new WarframeMissionSubscribe(event.getGroupId(), "", bot.getSelfId(), enums.ordinal()));
            if (i > 0) {
                Msg.builder().text("成功订阅 : " + enums.getName()).sendToGroup(bot, event);
            } else {
                Msg.builder().text(enums.getName() + ",已经订阅过了").sendToGroup(bot, event);
            }
            return MESSAGE_BLOCK;
        }


        return MESSAGE_IGNORE;
    }

    private boolean err(@NotNull Bot bot, long GroupId, String str) {
        if (str.length() == 0) {
            bot.sendGroupMsg(GroupId, Msg.builder().text("请在订阅后方填写要订阅的数字\n详情发送[订阅列表]查看").build(), false);
            return true;
        }
        if (!StringUtils.isNumber(str)) {
            bot.sendGroupMsg(GroupId, Msg.builder().text("请在订阅后方填写要订阅的整数数字\n详情发送[订阅列表]查看").build(), false);
            return true;
        }
        WarframeSubscribeEnums enums = WarframeDataUpdateMission.getSubscribeEnums(Integer.valueOf(str));
        if (enums.ordinal() == 0) {
            bot.sendGroupMsg(GroupId, Msg.builder().text("订阅数字不正确，请发送[订阅列表] 查看具体数值").build(), false);
            return true;
        }

        return false;
    }
}
