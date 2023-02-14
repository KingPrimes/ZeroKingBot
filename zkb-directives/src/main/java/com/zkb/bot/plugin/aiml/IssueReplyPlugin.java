package com.zkb.bot.plugin.aiml;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.bot.aiml.utils.OtherUtils;
import com.zkb.bot.aiml.utils.TeachingUtils;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.html.EscapeUtil;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Shiro
@Component
public class IssueReplyPlugin {
    @Autowired
    private IssueReplyService service;

    @GroupMessageHandler
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_AI)) {
            //触发概率 不准确
            if (OtherUtils.randomEx(30)) {
                Msg msg = new Msg();
                IssueReply issueReply = SpringUtils.getBean(TeachingUtils.class).getIssue(event.getRawMessage());
                if(issueReply!=null){
                    issueReply = service.selectIssueReplyByMsgIssue(issueReply);
                }
                if (issueReply != null) {
                    if (issueReply.getMsgReplyImage() != null) {
                        String[] urls = issueReply.getMsgReplyImage().replaceAll("\\[", "").replaceAll("]", "").split(",");
                        for (String url : urls) {
                            msg.img(url.trim());
                        }
                    }
                    if (issueReply.getMsgReplyFace() != null) {
                        String[] ids = issueReply.getMsgReplyFace().replaceAll("\\[", "").replaceAll("]", "").trim().split(",");
                        for (String id : ids) {
                            msg.face(Integer.parseInt(id));
                        }
                    }
                    if (issueReply.getMsgReply() != null) {
                        msg.text(EscapeUtil.unescape(issueReply.getMsgReply()));
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
