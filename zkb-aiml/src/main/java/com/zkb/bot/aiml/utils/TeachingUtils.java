package com.zkb.bot.aiml.utils;

import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.aiml.domain.IssueReply;
import com.zkb.bot.aiml.domain.Leaderboard;
import com.zkb.bot.aiml.service.IssueReplyService;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SendAllGroup;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_REPLY;
import static com.zkb.bot.aiml.enums.OrderEnum.ORDER_TEACHING;
import static com.zkb.common.utils.StringUtils.isHttpUrl;
import static com.zkb.common.utils.StringUtils.isNumberAndDouble;

/**
 * @author KingPrimes
 */
@Component
public class TeachingUtils {

 @Resource
    RedisCache redisCache;

    /**
     * 教学
     *
     * @param bot   机器人实体类
     * @param event 消息实体类
     * @return 是否执行
     */
    public int teaching(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        System.out.println("收到教学指令");
        String str = StringUtils.substring(event.getRawMessage(), ORDER_TEACHING.length(), event.getRawMessage().length());
        if (str.length() == 0) {
            bot.sendGroupMsg(event.getGroupId(), "请在教学后面写上问题", false);
            return 1;
        }
        IssueReply issueReply = new IssueReply();
        String image;
        String issue = str;
        String face;
        if (event.getRawMessage().contains("image")) {
            image = getImageMD5(str);
            issue = issue.replace(getImageCq(str), "").trim();
            issueReply.setMsgIssueImage(image);
        }
        if (!event.getRawMessage().contains("image")) {
            issue = str.trim();
        }
        if (isHttpUrl(issue.trim())) {
            Msg.builder().text("不可以包含链接").at(event.getUserId()).sendToGroup(bot, event);
            return 1;
        }
        if (issue.length() > 80) {
            Msg.builder().text("你教的问题太长了！").sendToGroup(bot, event);
            return 1;
        }
        if (isNumberAndDouble(issue.trim())) {
            Msg.builder().text("不可以纯数字问题！").sendToGroup(bot, event);
            return 1;
        }
        issueReply.setMsgIssue(issue.trim().toUpperCase(Locale.ROOT));
        issueReply.setMsgCreateTime(new Date());
        issueReply.setMsgCreateGroup(String.valueOf(event.getGroupId()));
        issueReply.setMsgCreateMember(String.valueOf(event.getUserId()));
        String key = event.getGroupId() + "-" + event.getUserId();
        redisCache.setCacheObject(key, issueReply, 2, TimeUnit.MINUTES);
        Msg.builder().text("请发送 答+回答内容").at(event.getUserId()).sendToGroup(bot, event);
        return 0;
    }

    /**
     * 回答
     */
    public int reply(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        String key = event.getGroupId() + "-" + event.getUserId();
        String str = StringUtils.substring(event.getRawMessage(), ORDER_REPLY.length(), event.getRawMessage().length());
        IssueReply issueReply = redisCache.getCacheObject(key);
        String image;
        String reply = str;
        String face;
        if (issueReply != null) {
            if (event.getRawMessage().contains("image")) {
                image = getImageMD5(str);
                reply = reply.replace(getImageCq(str), "").trim();
                String url = "https://gchat.qpic.cn/gchatpic_new/0/-0-" + image + "/0";
                issueReply.setMsgReplyImage(HttpUtils.sendGetForFile(url));
            }
            if (!event.getRawMessage().contains("image")) {
                reply = str;
            }
            if (isHttpUrl(reply.trim())) {
                Msg.builder().text("不可以包含链接").at(event.getUserId()).sendToGroup(bot, event);
                return 1;
            }
            if (reply.trim().length() > 180) {
                Msg.builder().text("你教的答太长了！").at(event.getUserId()).sendToGroup(bot, event);
                return 1;
            }
            issueReply.setMsgReply(reply.trim());
            if (SpringUtils.getBean(IssueReplyService.class).insertIssueReply(issueReply) > 0) {
                redisCache.deleteObject(key);
                Msg.builder().text("教学完成！").at(event.getUserId()).sendToGroup(bot, event);
            } else {
                Msg.builder().text("请勿重复教学！").at(event.getUserId()).sendToGroup(bot, event);
            }
        } else {
            Msg.builder().text("未查询到您的教学！\n教学内容可能已经过期！").at(event.getUserId()).sendToGroup(bot, event);
        }
        return 0;
    }

    public IssueReply getImage(String str) {
        String image;
        String issue;
        IssueReply issueReply = new IssueReply();
        image = getImageMD5(str);
        issue = str.replace(getImageCq(str), "").trim();
        issueReply.setMsgIssue(issue);
        issueReply.setMsgIssueImage(image);
        return issueReply;
    }

    /**
     * 获取Cq码
     *
     * @param str
     * @return
     */
    private String getImageCq(String str) {
        String rex = "CQ:image,file=.*?,subType=[1-9]";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        String r = null;
        while (matcher.find()) {
            r = matcher.group();
        }
        return "[" + r + "]";
    }

    /**
     * 获取MD5
     *
     * @param str
     * @return
     */
    private String getImageMD5(String str) {
        return StringUtils.getSubString(str, "[CQ:image,file=", ",subType").replace(".image", "").trim().toUpperCase(Locale.ROOT);
    }

    private boolean isKey() {


        return false;
    }


    /**
     * 查询教学排行榜
     */
    public void leaderboard() throws InterruptedException {
        List<Leaderboard> labs = SpringUtils.getBean(IssueReplyService.class).selectIssueReplyLeaderboardList();
        if (labs != null && labs.size() != 0) {
            try {
                SpringUtils.getBean(RedisCache.class).deleteObject("leaderboard");
            } catch (Exception ignored) {
                return;
            }
            SpringUtils.getBean(RedisCache.class).setCacheList("leaderboard", labs);
        }
        Msg msg = new Msg();
        msg.img("http://localhost:" + GetServerPort.getPort() + "/leader/getImage");
        SendAllGroup.sendAllGroup(msg, FunctionEnums.FUNCTION_AI);
    }


}
