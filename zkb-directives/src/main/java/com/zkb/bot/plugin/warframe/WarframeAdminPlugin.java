package com.zkb.bot.plugin.warframe;

import com.mikuac.shiro.annotation.PrivateMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.PrivateMessageEvent;
import com.zkb.bot.domain.BotAdmins;
import com.zkb.bot.server.BotAdminsServer;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.warframe.task.RivenDispositionUpdatesTask;
import com.zkb.bot.warframe.utils.WarframeTraUtils;
import com.zkb.bot.warframe.utils.market.RenewMarketUtil;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mikuac.shiro.core.BotPlugin.MESSAGE_IGNORE;
import static com.zkb.bot.enums.AdminControlEnum.*;

@Shiro
@Component
public class WarframeAdminPlugin {

    @Autowired
    BotAdminsServer adminsServer;

    @PrivateMessageHandler
    public int onPrivateMessage(@NotNull Bot bot, @NotNull PrivateMessageEvent event) {
        if (event.getRawMessage().trim().length() == 0) {
            return MESSAGE_IGNORE;
        }

        if (adminsServer.checkIsAdmin(new BotAdmins(bot.getSelfId(),event.getUserId()),true)) {
            if (UPDATE_RES_MARKET_ITEMS.getType().equals(event.getRawMessage())) {
                int x = RenewMarketUtil.resMarketItems();
                bot.sendPrivateMsg(event.getUserId(), "更新成功，共更新" + x + "条数据!", false);
            }
            if (UPDATE_RES_MARKET_RIVEN.getType().equals(event.getRawMessage())) {
                int x = RenewMarketUtil.resMarketRiven();
                bot.sendPrivateMsg(event.getUserId(), "更新成功，共更新" + x + "条数据!", false);
            }
            if (UPDATE_RIVEN_CHANGES.getType().equals(event.getRawMessage())) {
                try {
                    new RivenDispositionUpdatesTask().renewRivenDisposition();
                    bot.sendPrivateMsg(event.getUserId(), "已执行请稍后，在群内使用 紫卡倾向变动查看", false);
                    return 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (UPDATE_SISTER.getType().equals(event.getRawMessage())) {
                Msg msg = new Msg();
                int[] i = RenewMarketUtil.resMarketSister();
                msg.text("更新信条武器条数：" + i[0]).text("\n更新信条幻纹条数：" + i[1]).build();
                bot.sendPrivateMsg(event.getUserId(), msg.build(), false);
            }
            if (UPDATE_TAR.getType().equals(event.getRawMessage())) {
                bot.sendPrivateMsg(event.getUserId(), "正在准备更新", false);
                int i = SpringUtils.getBean(WarframeTraUtils.class).getUserDict();
                bot.sendPrivateMsg(event.getUserId(), "更新完成，共更新：" + i + "条数据", false);

            }


        }
        return 0;
    }
}
