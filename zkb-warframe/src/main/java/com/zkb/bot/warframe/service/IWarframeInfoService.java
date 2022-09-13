package com.zkb.bot.warframe.service;


import com.zkb.bot.warframe.domain.WarframeInfo;

import java.util.List;

/**
 * WarframeInfoService接口
 *
 * @author KingPrimes
 * @Date 2021-05-24
 */
public interface IWarframeInfoService {
    /**
     * 查询
     *
     * @param infoId ID
     * @return 实体类
     */
    WarframeInfo selectWarframeInfoById(Long infoId);

    /**
     * 查询列表
     *
     * @param warframeInfo 数据
     * @return 集合
     */
    List<WarframeInfo> selectWarframeInfoList(WarframeInfo warframeInfo);

    /**
     * 新增
     *
     * @param warframeInfo 数据
     * @return 结果
     */
    int insertWarframeInfo(WarframeInfo warframeInfo);

    /**
     * 修改
     *
     * @param warframeInfo 数据
     * @return 结果
     */
    int updateWarframeInfo(WarframeInfo warframeInfo);

    /**
     * 删除
     *
     * @param infoId ID
     * @return 结果
     */
    int deleteWarframeInfoById(Long infoId);

    /**
     * 批量删除
     *
     * @param infoIds 需要删除的数据ID
     * @return 结果
     */
    int deleteWarframeInfoByIds(Long[] infoIds);
}
