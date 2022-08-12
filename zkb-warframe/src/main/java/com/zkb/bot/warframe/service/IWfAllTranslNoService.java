package com.zkb.bot.warframe.service;


import com.zkb.bot.warframe.domain.WfAllTranslNo;

import java.util.List;

public interface IWfAllTranslNoService {
    /**
     * 查询所有没有翻译的任务列表
     *
     * @param w 数据
     * @return 结果
     */
    List<WfAllTranslNo> selectAllNoMission(WfAllTranslNo w);

    /**
     * 查询所有没有翻译的遗物列表
     *
     * @param w 数据
     * @return 结果
     */
    List<WfAllTranslNo> selectAllNoRelics(WfAllTranslNo w);

    /**
     * 查询所有没有翻译的市场列表
     *
     * @param w 数据
     * @return 结果
     */
    List<WfAllTranslNo> selectAllNoMarket(WfAllTranslNo w);

    /**
     * 查询所有没有翻译的紫卡倾向列表
     *
     * @param w 数据
     * @return 结果
     */
    List<WfAllTranslNo> selectAllNoTrend(WfAllTranslNo w);
}
