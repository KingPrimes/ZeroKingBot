package com.zkb.bot.plugin.aiml;

import com.mikuac.shiro.annotation.GroupMessageHandler;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.aiml.enums.ChatModelEnum;
import com.zkb.bot.aiml.enums.ChatRoleEnum;
import com.zkb.bot.aiml.req.ChatGPTReq;
import com.zkb.bot.aiml.res.ChatGPTRes;
import com.zkb.bot.aiml.service.impl.ChatGPTServiceImpl;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Shiro
@Component
public class ChatGptPlugin {
    @Autowired
    ChatGPTServiceImpl service;

    Logger log = LoggerFactory.getLogger(ChatGptPlugin.class);

    private static boolean isch(String str) {
        Pattern p = Pattern.compile("^(chat).*?");
        Matcher m = p.matcher(str);
        while (m.find()) {
            return true;
        }
        return m.matches();
    }

    @GroupMessageHandler
    public int groupMessageHandler(Bot bot, GroupMessageEvent event) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_AI)) {
            if (isch(event.getRawMessage())) {
                AsyncManager.me().execute(new TimerTask() {
                    @Override
                    public void run() {
                        ChatGPTReq req = ChatGPTReq.builder();
                        req.setMod(ChatModelEnum.GPT35TURBO);
                        req.add(ChatRoleEnum.USER, event.getRawMessage().replaceAll("^chat*", "").trim());
                        ChatGPTRes res = service.sendChatGPT(req);
                        StringBuilder msg = new StringBuilder();
                        if (res.getError()!=null){
                            bot.sendGroupMsg(event.getGroupId(),"请求出错：\n"+res.getError().getMessage(),false);
                            return;
                        }

                        for (ChatGPTRes.Choices choice : res.getChoices()) {
                            msg.append(choice.getMessage().getContent()).append("\n");
                            bot.sendGroupMsg(event.getGroupId(), choice.getMessage().getContent(), false);
                        }
                        try {
                            log.info("ChatGPT,群：{}，用户：{}，消息：{}，本次回答共消耗：{} tokens\nChatGPT回答：{}",
                                    event.getGroupId(),
                                    event.getUserId(),
                                    event.getRawMessage(),
                                    res.getUsage().getTotalTokens(),
                                    msg
                            );
                        } catch (Exception e) {
                            log.info("ChatGPT,群：{}，消息：{}，本次回答共消耗：{} tokens\nChatGPT回答：{}",
                                    event.getGroupId(),
                                    event.getRawMessage(),
                                    res.getUsage().getTotalTokens(),
                                    msg
                            );
                        }
                    }
                });
            }
        }
        return 0;
    }


}
