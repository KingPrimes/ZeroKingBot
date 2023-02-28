package com.zkb.system.domain;

import com.zkb.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sys_log_info")
public class SysLogInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    //日志ID
    @GeneratedValue
    @Id
    private Long logId;

    //操作模块
    private String logTitle;

    //执行的命令
    private String logOrderType;

    //业务类型
    private Integer logBusinessType;

    //机器人QQ
    private Long logBot;

    //请求的群组
    private Long logGroup;

    //请求的用户
    private Long logUser;

    //原信息
    private String logRawMsg;

    //请求的Url
    private String logUrl;

    //请求方法
    private String logMethod;

    //请求方式
    private String logRequestMethod;

    //执行时间
    private Long logRunTime;

    //请求的参数
    private String logParam;

    //返回的结果
    private String logResult;

    //执行状态
    private Integer logStatus;

    //错误信息
    private String logErrorMsg;

    //日志时间
    private Date logTime;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("logId", logId)
                .append("logTtitle", logTitle)
                .append("logOrderType", logOrderType)
                .append("logBusinessType", logBusinessType)
                .append("logBot", logBot)
                .append("logGroup", logGroup)
                .append("logUser", logUser)
                .append("logRawMsg", logRawMsg)
                .append("logUrl", logUrl)
                .append("logMethod", logMethod)
                .append("logRequestMethod", logRequestMethod)
                .append("logRunTime", logRunTime)
                .append("logParam", logParam)
                .append("logResult", logResult)
                .append("logStatus", logStatus)
                .append("logErrorMsg", logErrorMsg)
                .append("logTime", logTime)
                .toString();
    }


    /**
     * 获取 日志ID
     *
     * @return logId 日志ID
     */
    public Long getLogId() {
        return this.logId;
    }

    /**
     * 设置 日志ID
     *
     * @param logId 日志ID
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 获取 操作模块
     *
     * @return logTitle 操作模块
     */
    public String getLogTitle() {
        return this.logTitle;
    }


    /**
     * 设置 操作模块
     *
     * @param logTitle 操作模块
     */
    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    /**
     * 获取 执行的命令
     *
     * @return logOrderType 执行的命令
     */
    public String getLogOrderType() {
        return this.logOrderType;
    }

    /**
     * 设置 执行的命令
     *
     * @param logOrderType 执行的命令
     */
    public void setLogOrderType(String logOrderType) {
        this.logOrderType = logOrderType;
    }

    /**
     * 获取 业务类型
     *
     * @return logBusinessType 业务类型
     */
    public Integer getLogBusinessType() {
        return this.logBusinessType;
    }

    /**
     * 设置 业务类型
     *
     * @param logBusinessType 业务类型
     */
    public void setLogBusinessType(Integer logBusinessType) {
        this.logBusinessType = logBusinessType;
    }

    /**
     * 获取 机器人QQ
     *
     * @return logBot 机器人QQ
     */
    public Long getLogBot() {
        return this.logBot;
    }

    /**
     * 设置 机器人QQ
     *
     * @param logBot 机器人QQ
     */
    public void setLogBot(Long logBot) {
        this.logBot = logBot;
    }

    /**
     * 获取 请求的群组
     *
     * @return logGroup 请求的群组
     */
    public Long getLogGroup() {
        return this.logGroup;
    }

    /**
     * 设置 请求的群组
     *
     * @param logGroup 请求的群组
     */
    public void setLogGroup(Long logGroup) {
        this.logGroup = logGroup;
    }

    /**
     * 获取 请求的用户
     *
     * @return logUser 请求的用户
     */
    public Long getLogUser() {
        return this.logUser;
    }

    /**
     * 设置 请求的用户
     *
     * @param logUser 请求的用户
     */
    public void setLogUser(Long logUser) {
        this.logUser = logUser;
    }

    /**
     * 获取 原信息
     *
     * @return logRawMsg 原信息
     */
    public String getLogRawMsg() {
        return this.logRawMsg;
    }

    /**
     * 设置 原信息
     *
     * @param logRawMsg 原信息
     */
    public void setLogRawMsg(String logRawMsg) {
        this.logRawMsg = logRawMsg;
    }

    /**
     * 获取 请求的Url
     *
     * @return logUrl 请求的Url
     */
    public String getLogUrl() {
        return this.logUrl;
    }

    /**
     * 设置 请求的Url
     *
     * @param logUrl 请求的Url
     */
    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    /**
     * 获取 请求方法
     *
     * @return logMethod 请求方法
     */
    public String getLogMethod() {
        return this.logMethod;
    }

    /**
     * 设置 请求方法
     *
     * @param logMethod 请求方法
     */
    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    /**
     * 获取 请求方式
     *
     * @return logRequestMethod 请求方式
     */
    public String getLogRequestMethod() {
        return this.logRequestMethod;
    }

    /**
     * 设置 请求方式
     *
     * @param logRequestMethod 请求方式
     */
    public void setLogRequestMethod(String logRequestMethod) {
        this.logRequestMethod = logRequestMethod;
    }

    /**
     * 获取 执行时间
     *
     * @return logRunTime 执行时间
     */
    public Long getLogRunTime() {
        return this.logRunTime;
    }

    /**
     * 设置 执行时间
     *
     * @param logRunTime 执行时间
     */
    public void setLogRunTime(Long logRunTime) {
        this.logRunTime = logRunTime;
    }

    /**
     * 获取 请求的参数
     *
     * @return logParam 请求的参数
     */
    public String getLogParam() {
        return this.logParam;
    }

    /**
     * 设置 请求的参数
     *
     * @param logParam 请求的参数
     */
    public void setLogParam(String logParam) {
        this.logParam = logParam;
    }

    /**
     * 获取 返回的结果
     *
     * @return logResult 返回的结果
     */
    public String getLogResult() {
        return this.logResult;
    }

    /**
     * 设置 返回的结果
     *
     * @param logResult 返回的结果
     */
    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    /**
     * 获取 执行状态
     *
     * @return logStatus 执行状态
     */
    public Integer getLogStatus() {
        return this.logStatus;
    }

    /**
     * 设置 执行状态
     *
     * @param logStatus 执行状态
     */
    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    /**
     * 获取 错误信息
     *
     * @return logErrorMsg 错误信息
     */
    public String getLogErrorMsg() {
        return this.logErrorMsg;
    }

    /**
     * 设置 错误信息
     *
     * @param logErrorMsg 错误信息
     */
    public void setLogErrorMsg(String logErrorMsg) {
        this.logErrorMsg = logErrorMsg;
    }

    /**
     * 获取 日志时间
     *
     * @return logTime 日志时间
     */
    public Date getLogTime() {
        return this.logTime;
    }

    /**
     * 设置 日志时间
     *
     * @param logTime 日志时间
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}
