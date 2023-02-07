package com.zkb.bot.warframe.service;

import com.zkb.bot.warframe.domain.TypeEnum;

import java.util.List;

public interface IWarframeTypeEnumService {
    /**
     * 修改
     * @param typeEnum 数据
     * @return 条数
     */
    int updateWarframeTypeEnum(TypeEnum typeEnum);


    /**
     * 条件查询
     * @param typeEnum 条件
     * @return 具体数据
     */
    List<TypeEnum> selectWarframeTypeEnumList(TypeEnum typeEnum);


    /**
     * 删除
     * @param key
     * @return
     */
    int daleteWarframeTypeEnum(String key);
}
