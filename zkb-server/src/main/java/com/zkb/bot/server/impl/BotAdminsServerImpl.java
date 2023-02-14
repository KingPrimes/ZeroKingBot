package com.zkb.bot.server.impl;

import com.zkb.bot.domain.BotAdmins;
import com.zkb.bot.enums.BotAdminPrivilegeEnum;
import com.zkb.bot.mapper.BotAdminsMapper;
import com.zkb.bot.server.BotAdminsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotAdminsServerImpl implements BotAdminsServer {


    @Autowired
    private BotAdminsMapper adminsMapper;

    /**
     * 添加管理员
     *
     * @param admins 数据-实体类
     * @return 影响条数
     */
    @Override
    public int insertBotAdmin(BotAdmins admins) {
        return adminsMapper.insertBotAdmin(admins);
    }

    /**
     * 查询 管理员
     *
     * @param admins 查询条件 -实体类
     * @return 查询结果
     */
    @Override
    public List<BotAdmins> selectBotAdminsList(BotAdmins admins) {
        return adminsMapper.selectBotAdminsList(admins);
    }

    /**
     * 查询 管理员
     *
     * @param uid 查询条件
     * @return 查询结果
     */
    @Override
    public BotAdmins selectBotAdminsToUid(Long uid) {
        return adminsMapper.selectBotAdminsToUid(uid);
    }

    /**
     * 删除 管理员
     *
     * @param uid 删除条件
     * @return 影响条数
     */
    @Override
    public int deleteBotAdmins(Long uid) {
        return adminsMapper.deleteBotAdmins(uid);
    }

    /**
     * 修改 管理员
     *
     * @param admins 修改数据
     * @return 影响条数
     */
    @Override
    public int updateBotAdmins(BotAdmins admins) {
        return adminsMapper.updateBotAdmins(admins);
    }

    /**
     * 判断是不是管理员
     *
     * @param admins 数据
     * @return
     */
    @Override
    public boolean checkIsAdmin(BotAdmins admins, boolean t) {
        //查询匹配的管理员列表
        BotAdmins admin = adminsMapper.selectBotAdminsList(admins).get(0);
        //判断用户是否时管理员
        if (admin.getBotAdminUid().equals(admins.getBotAdminUid()) && admin.getBotUid().equals(admins.getBotUid())) {
            //判断用户是否是顶级管理员
            if (t) {
                return BotAdminPrivilegeEnum.TOP_ADMIN.value().equals(admin.getBotPrivilege().shortValue());
            } else {
                return BotAdminPrivilegeEnum.OWNER.value().equals(admin.getBotPrivilege().shortValue()) || BotAdminPrivilegeEnum.ADMIN.value().equals(admin.getBotPrivilege().shortValue());
            }
        }
        return false;
    }
}
