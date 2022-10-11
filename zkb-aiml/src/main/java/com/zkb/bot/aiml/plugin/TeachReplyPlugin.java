package com.zkb.bot.aiml.plugin;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.aiml.utils.TeachingUtils;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.GroupAddApi;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_REPLY;
import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_TEACHING;

@Shiro
@Component
public class TeachReplyPlugin {

    @GroupMessageHandler
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_AI)) {
            if(GroupAddApi.isAdmin(bot, event)){
                if (ORDER_TEACHING.equals(StringUtils.substring(event.getRawMessage(), 0, ORDER_TEACHING.length()))) {
                    return SpringUtils.getBean(TeachingUtils.class).teaching(bot, event);
                }
                if (ORDER_REPLY.equals(StringUtils.substring(event.getRawMessage(), 0, ORDER_REPLY.length()))) {
                    return SpringUtils.getBean(TeachingUtils.class).reply(bot, event);
                }
            }
        }
        return 0;
    }
}
