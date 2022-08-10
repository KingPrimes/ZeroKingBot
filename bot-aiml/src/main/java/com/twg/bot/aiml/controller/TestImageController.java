package com.twg.bot.aiml.controller;

import com.twg.bot.aiml.domain.IssueReply;
import com.twg.bot.aiml.service.IssueReplyService;
import com.twg.framework.interceptor.IgnoreAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/issue")
public class TestImageController {
    @Autowired
    IssueReplyService service;

    @IgnoreAuth
    @GetMapping(value = "{uuid}/getImage/{id}")
    public void getImage(HttpServletResponse response, @PathVariable Integer id) {
        try {
            response.setHeader("Content-Type", "image/gif");
            IssueReply issueReply = service.selectIssueReplyBuMsgId(id);
            response.getOutputStream().write(issueReply.getMsgReplyImage());
        } catch (Exception ignored) {

        }
    }

}
