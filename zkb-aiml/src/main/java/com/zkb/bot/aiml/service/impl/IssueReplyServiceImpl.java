package com.zkb.bot.aiml.service.impl;

import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.domain.Leaderboard;
import com.zkb.bot.aiml.mapper.IssueReplyMapper;
import com.zkb.bot.aiml.service.IssueReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author
 */
@Service
public class IssueReplyServiceImpl implements IssueReplyService {
 @Resource
    private IssueReplyMapper issueReplyMapper;


    @Override
    public IssueReply selectIssueReplyByMsgIssue(IssueReply issue) {
        List<IssueReply> issues = issueReplyMapper.selectIssueReplyByMsgIssue(issue);
        if (issues.size() != 0) {
            Random rand = new Random();
            return issues.get(rand.nextInt(issues.size()));
        }
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
    public int deleteIssueReplyByMsgIds(Integer[] msgIds) {
        return issueReplyMapper.deleteIssueReplyByMsgIds(msgIds);
    }
}
