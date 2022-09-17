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
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

            //触发概率 不准确
            if (OtherUtils.randomEx(30)) {
                Msg msg = new Msg();
                IssueReply issueReply = SpringUtils.getBean(TeachingUtils.class).getIssue(event.getRawMessage());
                issueReply = service.selectIssueReplyByMsgIssue(issueReply);
                if (issueReply != null) {
                    if (issueReply.getMsgReplyImage() != null) {
                        String[] urls = issueReply.getMsgReplyImage().replaceAll("\\[","").replaceAll("]","").split(",");
                        for (String url : urls) {
                            msg.img(url.trim());
                        }
                    }
                    if (issueReply.getMsgReplyFace()!=null){
                        String[] ids = issueReply.getMsgReplyFace().replaceAll("\\[","").replaceAll("]","").trim().split(",");
                        for (String id:ids){
                            msg.face(Integer.parseInt(id));
                        }
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
