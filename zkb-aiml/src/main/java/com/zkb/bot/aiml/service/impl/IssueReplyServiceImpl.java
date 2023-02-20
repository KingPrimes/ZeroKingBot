package com.zkb.bot.aiml.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;
import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.domain.Leaderboard;
import com.zkb.bot.aiml.mapper.IssueReplyMapper;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.bot.enums.GitHubUrlEnum;
import com.zkb.common.core.text.Convert;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.framework.manager.AsyncManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.TimerTask;

/**
 * @author
 */
@Service
public class IssueReplyServiceImpl implements IssueReplyService, CommandLineRunner {


    Logger log = LoggerFactory.getLogger(IssueReplyServiceImpl.class);

    @Autowired
    private IssueReplyMapper issueReplyMapper;


    @Override
    public IssueReply selectIssueReplyByMsgIssue(IssueReply issue) {
        List<IssueReply> issues = issueReplyMapper.selectIssueReplyByMsgIssue(issue);
        if (issues.size() != 0) {
            Random rand = new Random();
            if (!issue.getMsgIssue().equals("")) {

                issues.removeIf(issueReply -> issueReply.getMsgIssue().equals(""));
            }
            return issues.get(rand.nextInt(issues.size()));
        }
        return null;
    }

    /**
     * 根据问题查询回答
     *
     * @param issue 问题
     * @return 回答
     */
    @Override
    public List<IssueReply> selectIssueReplyByMsgIssueList(IssueReply issue) {
        return null;
    }

    @Override
    public List<IssueReply> selectIssueReplyList(IssueReply issue) {
        return issueReplyMapper.selectIssueReplyList(issue);
    }

    @Override
    public List<Leaderboard> selectIssueReplyLeaderboardList() {
        return issueReplyMapper.selectIssueReplyLeaderboardList();
    }

    @Override
    public IssueReply selectIssueReplyBuMsgId(Integer id) {
        return issueReplyMapper.selectIssueReplyBuMsgId(id);
    }

    @Override
    public int updateIssueReply(IssueReply issueReply) {
        return issueReplyMapper.updateIssueReply(issueReply);
    }

    @Override
    public int insertIssueReply(IssueReply issue) {
        return issueReplyMapper.insertIssueReply(issue);
    }

    @Override
    public int deleteIssueReplyByMsgId(Integer msgId) {
        return issueReplyMapper.deleteIssueReplyByMsgId(msgId);
    }

    @Override
    public int deleteIssueReplyByMsgIds(String msgIds) {
        return issueReplyMapper.deleteIssueReplyByMsgIds(Convert.toStrArray(msgIds));
    }

    @Override
    public void run(String... args) throws Exception {
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                log.info("开始初始化问答表数据……");
                final List<IssueReply> issueReplies = issueReplyMapper.selectIssueReplyList(null);
                if (issueReplies.isEmpty()) {
                    String aliasJson = HttpUtils.sendGetOkHttp(GitHubUrlEnum.ZeroKingBotDataSource.desc() + "bot_issue_reply.json");
                    if (aliasJson.trim().length() == 0) {
                        log.error("未获取到问答数据……");
                        return;
                    }
                    JSONObject alias = JSON.parseObject(aliasJson);
                    List<IssueReply> records = alias.getJSONArray("RECORDS").toJavaList(IssueReply.class);

                    List<List<IssueReply>> lists = Lists.partition(records, 500);
                    int i = 0;
                    for (List<IssueReply> mrs : lists) {
                        i += issueReplyMapper.insertIssueReplyList(mrs);
                    }
                    log.info("共更新问答表 {} 条数据！", i);
                } else {
                    log.info("问答表数据未做更改！");
                }
            }
        });
    }
}
