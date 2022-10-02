package com.zkb.bot.warframe.service;

import com.zkb.bot.warframe.domain.TypeEnum;

public interface IWarframeTypeEnumService {
    /**
     * 修改
     * @param typeEnum 数据
     * @return 条数
     */
    int updateWarframeTypeEnum(TypeEnum typeEnum);
}
