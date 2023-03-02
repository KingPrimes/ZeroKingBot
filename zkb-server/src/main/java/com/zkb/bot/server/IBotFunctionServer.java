package com.zkb.bot.server;

import com.zkb.bot.domain.BotFunction;

import java.util.List;

/**
 * @author KingPrimes
 */
public interface BotFunctionServer {
    /**
     * 查询功能列表
     *
     * @param botFunction 功能实体类
     * @return 功能列表
     */
    List<BotFunction> selectFunctionList(BotFunction botFunction);

    /**
     * 根据功能名称查询功能
     *
     * @param name 名称
     */
    BotFunction selectFunctionByName(String name);

    /**
     * 插入功能实体类
     *
     * @param botFunction 功能实体类
     * @return 影响行数
     */
    int insertFunction(BotFunction botFunction);

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
