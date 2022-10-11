package com.zkb.web.bot.ai;

import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.common.annotation.Log;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bot/ai/thesaurus")
public class ThesaurusController extends BaseController {

    @Autowired
    private IssueReplyService replyService;
    private final String PREFIX = "/bot/ai";

    @GetMapping()
    public String info(){
        return PREFIX+"/thesaurus";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IssueReply issueReply)
    {
        startPage();
        List<IssueReply> list = replyService.selectIssueReplyList(issueReply);
        return getDataTable(list);
    }

    @Log(title = "词库", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable String ids)
    {
        return toAjax(replyService.deleteIssueReplyByMsgIds(ids));
    }

    @GetMapping("/edit/{msgId}")
    public String edit(@PathVariable("msgId") Integer msgId, ModelMap mmap)
    {
        IssueReply issueReply = replyService.selectIssueReplyBuMsgId(msgId);
        mmap.put("ir", issueReply);
        return PREFIX + "/edit";
    }

    @Log(title = "词库", businessType = BusinessType.UPDATE)
    @PostMapping("/update/{issueReply}")
    @ResponseBody
    public AjaxResult update(@PathVariable IssueReply issueReply){
        return toAjax(replyService.updateIssueReply(issueReply));
    }
}
