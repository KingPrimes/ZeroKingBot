package com.zkb.bot.server;

import com.zkb.bot.domain.Function;

import java.util.List;

/**
 * @author KingPrimes
 */
public interface FunctionServer {
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

    /**
     * 重置缓存
     */
    void resetFunction();

    /**
     * 清空缓存
     */
    void clearFunction();

    /**
     * 设置缓存
     */
    void loadingFunction();
}
