package com.zkb.bot.mapper;

import com.zkb.bot.domain.BotAdmins;

import java.util.List;

public interface BotAdminsMapper {
    /**
     * 添加管理员
     *
     * @param admins 数据-实体类
     * @return 影响条数
     */
    int insertBotAdmin(BotAdmins admins);

    /**
     * 查询 管理员
     *
     * @param admins 查询条件 -实体类
     * @return 查询结果
     */
    List<BotAdmins> selectBotAdminsList(BotAdmins admins);

    /**
     * 查询 管理员
     *
     * @param uid 查询条件
     * @return 查询结果
     */
    BotAdmins selectBotAdminsToUid(Long uid);

    /**
     * 删除 管理员
     *
     * @param uid 删除条件
     * @return 影响条数
     */
    int deleteBotAdmins(Long uid);

    /**
     * 修改 管理员
     *
     * @param admins 修改数据
     * @return 影响条数
     */
    int updateBotAdmins(BotAdmins admins);

}
