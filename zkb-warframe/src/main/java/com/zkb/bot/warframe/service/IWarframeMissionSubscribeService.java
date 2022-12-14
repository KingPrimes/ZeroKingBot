package com.zkb.bot.warframe.service;


import com.zkb.bot.warframe.domain.subscribe.WarframeMissionSubscribe;

import java.util.List;

public interface IWarframeMissionSubscribeService {
    /**
     * 条件查询 无条件返回所有列表
     *
     * @param subscribe 条件
     * @return 数据集
     */
    List<WarframeMissionSubscribe> selectWarframeMissionSubscribeList(WarframeMissionSubscribe subscribe);

    /**
     * 添加订阅
     *
     * @param subscribe 订阅数据
     * @return 是否添加成功
     */
    int insertWarframeMissionSubscribe(WarframeMissionSubscribe subscribe);

    /**
     * 移除或新增订阅
     *
     * @param subscribe 数据
     * @return 结果
     */
    int updateWarframeMissionSubscribe(WarframeMissionSubscribe subscribe);

    /**
     * 新增或修改User
     *
     * @param subscribe 数据
     * @return 结果
     */
    int updateWarframeMissionSubscribeUser(WarframeMissionSubscribe subscribe);

    /**
     * 用户移除订阅
     *
     * @param subscribe 数据
     * @return 结果
     */
    int deleteWarframeMissionSubscribeUser(WarframeMissionSubscribe subscribe);

    /**
     * 移除订阅
     *
     * @param subscribe 订阅数据
     * @return 是否移除成功
     */
    int deleteWarframeMissionSubscribe(WarframeMissionSubscribe subscribe);
}
