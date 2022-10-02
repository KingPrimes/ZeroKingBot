package com.zkb.bot.warframe.mapper;

import com.zkb.bot.warframe.domain.TypeEnum;

import java.util.List;

public interface WarframeTypeEnumMapper {
    /**
     * 条件查询
     * @param typeEnum 条件
     * @return 具体数据
     */
    List<TypeEnum> selectWarframeTypeEnumList(TypeEnum typeEnum);

    /**
     * 新增
     * @param typeEnum 数据
     * @return 条数
     */
    int insertWarframeTypeEnum(TypeEnum typeEnum);

    /**
     * 修改
     * @param typeEnum 数据
     * @return 条数
     */
    int updateWarframeTypeEnum(TypeEnum typeEnum);
}
