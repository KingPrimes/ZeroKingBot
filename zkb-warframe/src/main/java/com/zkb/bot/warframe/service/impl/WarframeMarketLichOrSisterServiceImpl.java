package com.zkb.bot.warframe.service.impl;


import com.zkb.bot.warframe.domain.market.WarframeMarketLichOrSister;
import com.zkb.bot.warframe.mapper.WarframeMarketLichOrSisterMapper;
import com.zkb.bot.warframe.service.IWarframeMarketLichOrSisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * lichService业务层处理
 *
 * @author ruoyi
 * @date 2021-11-24
 */
@Service
public class WarframeMarketLichOrSisterServiceImpl implements IWarframeMarketLichOrSisterService {
    @Autowired
    private WarframeMarketLichOrSisterMapper warframeMarketLichOrSisterMapper;

    /**
     * 查询lich
     *
     * @param id lich主键
     * @return lich
     */
    @Override
    public WarframeMarketLichOrSister selectWarframeMarketLichById(String id) {
        return warframeMarketLichOrSisterMapper.selectWarframeMarketLichById(id);
    }

    /**
     * 查询lich列表
     *
     * @param warframeMarketLichOrSister lich
     * @return lich
     */
    @Override
    public List<WarframeMarketLichOrSister> selectWarframeMarketLichList(WarframeMarketLichOrSister warframeMarketLichOrSister) {
        return warframeMarketLichOrSisterMapper.selectWarframeMarketLichList(warframeMarketLichOrSister);
    }

    /**
     * 根据物品名称模糊查询结果
     *
     * @param itemName 物品名称
     * @return WarframeMarketLich
     */
    @Override
    public WarframeMarketLichOrSister selectWarframeMarketLichByItemName(String itemName) {
        return warframeMarketLichOrSisterMapper.selectWarframeMarketLichByItemName(itemName);
    }

    /**
     * 根据元素查询幻纹
     *
     * @param element 元素
     * @return 实体类
     */
    @Override
    public WarframeMarketLichOrSister selectWarframeMarketLichByElement(String element) {
        return warframeMarketLichOrSisterMapper.selectWarframeMarketLichByElement(element);
    }

    @Override
    public WarframeMarketLichOrSister selectWarframeMarketLichByUrlName(String urlName) {
        return warframeMarketLichOrSisterMapper.selectWarframeMarketLichByUrlName(urlName);
    }

    /**
     * 新增lich
     *
     * @param warframeMarketLichOrSister lich
     * @return 结果
     */
    @Override
    public int insertWarframeMarketLich(WarframeMarketLichOrSister warframeMarketLichOrSister) {
        return warframeMarketLichOrSisterMapper.insertWarframeMarketLich(warframeMarketLichOrSister);
    }

    /**
     * 修改lich
     *
     * @param warframeMarketLichOrSister lich
     * @return 结果
     */
    @Override
    public int updateWarframeMarketLich(WarframeMarketLichOrSister warframeMarketLichOrSister) {
        return warframeMarketLichOrSisterMapper.updateWarframeMarketLich(warframeMarketLichOrSister);
    }

    /**
     * 批量删除lich
     *
     * @param ids 需要删除的lich主键
     * @return 结果
     */
    @Override
    public int deleteWarframeMarketLichByIds(String[] ids) {
        return warframeMarketLichOrSisterMapper.deleteWarframeMarketLichByIds(ids);
    }

    /**
     * 删除lich信息
     *
     * @param id lich主键
     * @return 结果
     */
    @Override
    public int deleteWarframeMarketLichById(String id) {
        return warframeMarketLichOrSisterMapper.deleteWarframeMarketLichById(id);
    }
}
