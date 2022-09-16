package com.zkb.bot.aiml.controller;

import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.service.IssueReplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/issue")
public class TestImageController {
 @Resource
    IssueReplyService service;


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
