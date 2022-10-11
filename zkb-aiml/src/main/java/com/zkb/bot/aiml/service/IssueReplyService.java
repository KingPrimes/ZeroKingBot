package com.zkb.bot.aiml.service;

import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.domain.Leaderboard;

import java.util.List;

public interface IssueReplyService {
    /**
     * 根据问题查询回答
     *
     * @param issue 问题
     * @return 回答
     */
    IssueReply selectIssueReplyByMsgIssue(IssueReply issue);


    /**
     * 查询问答列表
     *
     * @param issue 问答
     * @return 问答集合
     */
    List<IssueReply> selectIssueReplyList(IssueReply issue);


    /**
     * 查询昨日排行榜
     *
     * @return 数据集
     */
    List<Leaderboard> selectIssueReplyLeaderboardList();

    /**
     * 根据Id查询值
     */
    IssueReply selectIssueReplyBuMsgId(Integer id);

    /**
     * 修改问答
     *
     * @param issueReply 问答
     * @return 结果
     */
    int updateIssueReply(IssueReply issueReply);

    /**
     * 添加问答
     *
     * @param issue 问答
     * @return 影响行数
     */
    int insertIssueReply(IssueReply issue);


    /**
     * 删除问答
     *
     * @param msgId 问答主键
     * @return 结果
     */
    int deleteIssueReplyByMsgId(Integer msgId);

    /**
     * 批量删除问答
     *
     * @param msgIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteIssueReplyByMsgIds(String msgIds);
}
