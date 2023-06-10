package com.zkb.bot.plugin.aiml;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.bot.aiml.utils.TeachingUtils;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.CqMatcher;
import com.zkb.bot.utils.CqParse;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.common.utils.html.EscapeUtil;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Shiro
@Component
public class IssueReplyPlugin {
    @Autowired
    private IssueReplyService service;

    @GroupMessageHandler
    public int groupMessageHandler(Bot bot, GroupMessageEvent event) {

        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_AI)) {
            //@Bot触发
            if (CqMatcher.isCqAt(event.getRawMessage())) {
                for (Long aLong : CqParse.build(event.getMessage()).getCqAt()) {
                    if (aLong.equals(bot.getSelfId())) {
                        Msg msg = new Msg();
                        IssueReply issueReply = SpringUtils.getBean(TeachingUtils.class).getIssue(event.getRawMessage());
                        if (issueReply != null) {
                            issueReply = service.selectIssueReplyByMsgIssue(issueReply);
                        }
                        if (issueReply == null) {
                            bot.sendGroupMsg(event.getGroupId(), bot.getGroupMemberInfo(event.getGroupId(), bot.getSelfId(), false).getData().getNickname() + "，不明白你在讲什么呢！", false);
                        }

                        if (issueReply != null) {

                            if (issueReply.getMsgReplyImage() != null) {
                                if (!issueReply.getMsgReplyImage().isEmpty()) {
                                    String[] urls = issueReply.getMsgReplyImage().replaceAll("\\[", "").replaceAll("]", "").split(",");
                                    for (String url : urls) {
                                        msg.img(url.trim());
                                    }
                                }
                            }
                            if (issueReply.getMsgReplyFace() != null && !issueReply.getMsgReplyFace().isEmpty()) {
                                String[] ids = issueReply.getMsgReplyFace().replaceAll("\\[", "").replaceAll("]", "").trim().split(",");
                                for (String id : ids) {
                                    msg.face(Integer.parseInt(id));
                                }
                            }
                            if (issueReply.getMsgReply() != null && !issueReply.getMsgReply().isEmpty()) {
                                String[] split = EscapeUtil.unescape(issueReply.getMsgReply()
                                        .replace("{name}", bot.getGroupMemberInfo(event.getGroupId(), event.getUserId(), true).getData().getNickname())
                                        .replace("{me}", bot.getGroupMemberInfo(event.getGroupId(), bot.getSelfId(), true).getData().getNickname())
                                ).split("\\{segment}");

                                if (split.length > 1) {
                                    for (String s : split) {
                                        bot.sendGroupMsg(event.getGroupId(), s, false);
                                    }
                                    return 1;
                                } else {
                                    msg.text(split[0]);
                                }
                            }
                            msg.sendToGroup(bot, event);
                            return 1;
                        }
                    }
                }
            }
            return 0;
        }
        return 0;
    }
}
