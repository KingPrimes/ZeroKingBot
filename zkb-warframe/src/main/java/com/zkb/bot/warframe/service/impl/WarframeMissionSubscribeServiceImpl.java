package com.zkb.bot.warframe.service.impl;


import com.zkb.bot.warframe.domain.subscribe.WarframeMissionSubscribe;
import com.zkb.bot.warframe.mapper.WarframeMissionSubscribeMapper;
import com.zkb.bot.warframe.service.IWarframeMissionSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeMissionSubscribeServiceImpl implements IWarframeMissionSubscribeService {

    @Autowired
    WarframeMissionSubscribeMapper subscribeMapper;

    /**
     * 条件查询 无条件返回所有列表
     *
     * @param subscribe 条件
     * @return 数据集
     */
    @Override
    public List<WarframeMissionSubscribe> selectWarframeMissionSubscribeList(WarframeMissionSubscribe subscribe) {
        return subscribeMapper.selectWarframeMissionSubscribeList(subscribe);
    }

    /**
     * 添加订阅
     *
     * @param subscribe 订阅数据
     * @return 是否添加成功
     */
    @Override
    public int insertWarframeMissionSubscribe(WarframeMissionSubscribe subscribe) {
        return subscribeMapper.insertWarframeMissionSubscribe(subscribe);
    }

    /**
     * 移除或新增或修改订阅
     *
     * @param subscribe 数据
     * @return 结果
     */
    @Override
    public int updateWarframeMissionSubscribe(WarframeMissionSubscribe subscribe) {
        return subscribeMapper.updateWarframeMissionSubscribe(subscribe);
    }

    /**
     * 新增或修改
     *
     * @param subscribe 数据
     * @return 结果
     */
    @Override
    public int updateWarframeMissionSubscribeUser(WarframeMissionSubscribe subscribe) {
        WarframeMissionSubscribe s = new WarframeMissionSubscribe(subscribe);
        s.setSubscribeUser(null);
        //查询是否已经有词条数据
        List<WarframeMissionSubscribe> subscribes = subscribeMapper.selectWarframeMissionSubscribeList(s);
        //没有数据则添加书
        if (subscribes == null || subscribes.size() == 0) {
            return subscribeMapper.insertWarframeMissionSubscribe(subscribe);
        }
        boolean userIsEmpty = true;
        //如果有数据则遍历查询
        for (WarframeMissionSubscribe subs : subscribes) {
            //判断是否存在这个组
            if (subs.getSubscribeGroup().equals(subscribe.getSubscribeGroup()) && !subscribe.getSubscribeUser().equals("")) {
                //如果user为空则新增user
                if (subs.getSubscribeUser() == null) {
                    return subscribeMapper.updateWarframeMissionSubscribe(subscribe);
                }
                //user不为空
                for (String user : subs.getSubscribeUser().split("-")) {
                    //遍历判断user是否已经存在
                    if (user.equals(subscribe.getSubscribeUser())) {
                        userIsEmpty = false;
                        break;
                    }
                }
                //user列表中没有这个新的user
                if (userIsEmpty) {
                    //获取原来的user并在后方拼接上新的user
                    subscribe.setSubscribeUser(subs.getSubscribeUser() + "-" + subscribe.getSubscribeUser());
                    //修改 加入新的订阅user
                    return subscribeMapper.updateWarframeMissionSubscribe(subscribe);
                }
            }
        }
        return 0;
    }

    /**
     * 用户移除订阅
     *
     * @param subscribe 数据
     * @return 结果
     */
    @Override
    public int deleteWarframeMissionSubscribeUser(WarframeMissionSubscribe subscribe) {
        List<WarframeMissionSubscribe> subscribes = subscribeMapper.selectWarframeMissionSubscribeList(subscribe);
        //判断是否有结果 如果没有结果说明用户没有订阅 直接返回
        if (subscribes == null) {
            return 0;
        }
        String[] users;
        StringBuilder usert = new StringBuilder();
        for (WarframeMissionSubscribe sub : subscribes) {
            //判断是否是同一个类型
            if (sub.getSubscribeGroup().equals(subscribe.getSubscribeGroup()) && sub.getSubscribeMissionId().equals(subscribe.getSubscribeMissionId())) {
                users = sub.getSubscribeUser().split("-");
                for (String user : users) {
                    if (!user.equals(subscribe.getSubscribeUser())) {
                        usert.append(user)
                                .append("-");
                    }
                }
                break;
            }
        }
        subscribe.setSubscribeUser(usert.replace(usert.toString().length() - 1, usert.toString().length(), "-").toString());
        return subscribeMapper.updateWarframeMissionSubscribe(subscribe);
    }

    /**
     * 移除订阅
     *
     * @param subscribe 订阅数据
     * @return 是否移除成功
     */
    @Override
    public int deleteWarframeMissionSubscribe(WarframeMissionSubscribe subscribe) {
        return subscribeMapper.deleteWarframeMissionSubscribe(subscribe);
    }
}
