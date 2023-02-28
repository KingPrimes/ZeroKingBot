package com.zkb.system.service;

import com.zkb.system.domain.SysLogInfo;

import java.util.List;

public interface ISysLogInfoService {
    /**
     * 增加日志
     *
     * @param logInfo 日志详情
     * @return 影响行数
     */
    int insertSyslogInfo(SysLogInfo logInfo);

    /**
     * 条件查询
     *
     * @param logInfo 查询条件
     * @return 返回结果集
     */
    List<SysLogInfo> selectSysLogInfoList(SysLogInfo logInfo);

    /**
     * 批量删除日志
     *
     * @param ids ids
     * @return 影响行数
     */
    int deleteSysLogInfoByIds(String ids);

    /**
     * 查询日志详细
     *
     * @param logId 日志ID
     * @return 日志对象
     */
    SysLogInfo selectSysLogInfoById(Long logId);

    /**
     * 清空日志
     */
    void cleanSysLogInfo();
}
