package com.zkb.system.service.impl;

import com.zkb.system.domain.SysLogInfo;
import com.zkb.system.mapper.SysLogInfoMapper;
import com.zkb.system.service.ISysLogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysLogInfoServiceImpl implements ISysLogInfoService {

    @Autowired
    private SysLogInfoMapper logInfoMapper;

    /**
     * 增加日志
     *
     * @param logInfo 日志详情
     * @return 影响行数
     */
    @Override
    public int insertSyslogInfo(SysLogInfo logInfo) {
        return logInfoMapper.insertSyslogInfo(logInfo);
    }

    /**
     * 条件查询
     *
     * @param logInfo 查询条件
     * @return 返回结果集
     */
    @Override
    public List<SysLogInfo> selectSysLogInfoList(SysLogInfo logInfo) {
        return logInfoMapper.selectSysLogInfoList(logInfo);
    }

    /**
     * 批量删除日志
     *
     * @param ids ids
     * @return 影响行数
     */
    @Override
    public int deleteSysLogInfoByIds(String ids) {
        return logInfoMapper.deleteSysLogInfoByIds(ids);
    }

    /**
     * 查询日志详细
     *
     * @param logId 日志ID
     * @return 日志对象
     */
    @Override
    public SysLogInfo selectSysLogInfoById(Long logId) {
        return logInfoMapper.selectSysLogInfoById(logId);
    }

    /**
     * 清空日志
     */
    @Override
    public void cleanSysLogInfo() {
        logInfoMapper.deleteAll();
        logInfoMapper.deleteSequen();
    }
}
