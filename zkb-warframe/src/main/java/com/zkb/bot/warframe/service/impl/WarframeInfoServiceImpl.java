package com.zkb.bot.warframe.service.impl;


import com.zkb.bot.warframe.domain.WarframeInfo;
import com.zkb.bot.warframe.mapper.WarframeInfoMapper;
import com.zkb.bot.warframe.service.IWarframeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * WarframeInfoService业务层处理
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
@Service
public class WarframeInfoServiceImpl implements IWarframeInfoService {
    @Resource
    private WarframeInfoMapper infoMapper;

    /**
     * 查询
     *
     * @param infoId ID
     * @return 实体类
     */
    @Override
    public WarframeInfo selectWarframeInfoById(Long infoId) {
        return infoMapper.selectWarframeInfoById(infoId);
    }

    /**
     * 查询列表
     *
     * @param warframeInfo 数据
     * @return 集合
     */
    @Override
    public List<WarframeInfo> selectWarframeInfoList(WarframeInfo warframeInfo) {
        return infoMapper.selectWarframeInfoList(warframeInfo);
    }

    /**
     * 新增
     *
     * @param warframeInfo 数据
     * @return 结果
     */
    @Override
    public int insertWarframeInfo(WarframeInfo warframeInfo) {
        return infoMapper.insertWarframeInfo(warframeInfo);
    }

    /**
     * 修改
     *
     * @param warframeInfo 数据
     * @return 结果
     */
    @Override
    public int updateWarframeInfo(WarframeInfo warframeInfo) {
        return infoMapper.updateWarframeInfo(warframeInfo);
    }

    /**
     * 删除
     *
     * @param infoId ID
     * @return 结果
     */
    @Override
    public int deleteWarframeInfoById(Long infoId) {
        return infoMapper.deleteWarframeInfoById(infoId);
    }

    /**
     * 批量删除
     *
     * @param infoIds 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarframeInfoByIds(Long[] infoIds) {
        return infoMapper.deleteWarframeInfoByIds(infoIds);
    }
}
