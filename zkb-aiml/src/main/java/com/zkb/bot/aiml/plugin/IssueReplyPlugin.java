package com.zkb.bot.aiml.plugin;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.bot.aiml.utils.OtherUtils;
import com.zkb.bot.aiml.utils.TeachingUtils;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_REPLY;
import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_TEACHING;

/**
 * @author KingPrimes
 */
@Shiro
@Component
public class IssueReplyPlugin {

 @Resource
    private IssueReplyService service;

    @GroupMessageHandler
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_AI)) {
            if (ORDER_TEACHING.equals(StringUtils.substring(event.getRawMessage(), 0, ORDER_TEACHING.length()))) {
                return SpringUtils.getBean(TeachingUtils.class).teaching(bot, event);
            }
            if (ORDER_REPLY.equals(StringUtils.substring(event.getRawMessage(), 0, ORDER_REPLY.length()))) {
                return SpringUtils.getBean(TeachingUtils.class).reply(bot, event);
            }
            Msg msg = new Msg();
            if (OtherUtils.random(30)) {
                IssueReply issueReply = new IssueReply();

                if (event.getRawMessage().contains("image")) {
                    issueReply = SpringUtils.getBean(TeachingUtils.class).getImage(event.getRawMessage());
                }

                if (!event.getRawMessage().contains("image")) {
                    issueReply.setMsgIssue(event.getRawMessage().toUpperCase(Locale.ROOT));
                }

                issueReply = service.selectIssueReplyByMsgIssue(issueReply);
                if (issueReply != null) {
                    if (issueReply.getMsgReplyImage() != null) {
                        msg.img("http://localhost:" + GetServerPort.getPort() + "/issue/" + UUID.fastUUID() + "/getImage/" + issueReply.getMsgId());
                    }
                    if (issueReply.getMsgReply() != null) {
                        msg.text(issueReply.getMsgReply());
                    }
                    msg.sendToGroup(bot, event);
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

}
