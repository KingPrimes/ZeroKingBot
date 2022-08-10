package com.twg.bot.mapper;

import com.twg.bot.domain.Function;

import java.util.List;

/**
 * @author KingPrimes
 */
public interface FunctionMapper {

    /**
     * 查询功能列表
     *
     * @param function 功能实体类
     * @return 功能列表
     */
    List<Function> selectFunctionList(Function function);

    /**
     * 根据功能名称查询功能
     *
     * @param name 名称
     */
    Function selectFunctionByName(String name);

    /**
     * 插入功能实体类
     *
     * @param function 功能实体类
     * @return 影响行数
     */
    int insertFunction(Function function);
}
