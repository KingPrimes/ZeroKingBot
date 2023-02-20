package com.zkb.bot.warframe.service;

import com.zkb.bot.warframe.domain.WarframeTypeEnum;

import java.util.List;

public interface IWarframeTypeEnumService {
    /**
     * 修改
     * @param typeEnum 数据
     * @return 条数
     */
    int updateWarframeTypeEnum(WarframeTypeEnum typeEnum);


    /**
     * 条件查询
     * @param typeEnum 条件
     * @return 具体数据
     */
    List<WarframeTypeEnum> selectWarframeTypeEnumList(WarframeTypeEnum typeEnum);


    /**
     * 删除
     * @param key
     * @return
     */
    int daleteWarframeTypeEnum(String key);
}
