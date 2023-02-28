package com.zkb.web.bot.ai;

import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.common.annotation.Log;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.utils.html.EscapeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bot/ai/thesaurus")
public class ThesaurusController extends BaseController {

    private final String PREFIX = "bot/ai/";
    @Autowired
    private IssueReplyService replyService;

    @GetMapping()
    public String info() {
        return PREFIX + "thesaurus";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IssueReply issueReply) {
        startPage();
        List<IssueReply> list = replyService.selectIssueReplyList(issueReply);
        return getDataTable(list);
    }

    @Log(title = "词库", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable String ids) {
        return toAjax(replyService.deleteIssueReplyByMsgIds(ids));
    }

    @GetMapping("/edit/{msgId}")
    public String edit(@PathVariable("msgId") Integer msgId, ModelMap mmap) {
        IssueReply issueReply = replyService.selectIssueReplyBuMsgId(msgId);
        issueReply.setMsgIssue(EscapeUtil.escape(EscapeUtil.unescape(issueReply.getMsgIssue())));
        mmap.put("ir", issueReply);
        return PREFIX + "/edit";
    }

    @Log(title = "词库", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(IssueReply issueReply) {
        issueReply.setMsgIssue(EscapeUtil.escape(EscapeUtil.unescape(issueReply.getMsgIssue())));
        return toAjax(replyService.updateIssueReply(issueReply));
    }
}
