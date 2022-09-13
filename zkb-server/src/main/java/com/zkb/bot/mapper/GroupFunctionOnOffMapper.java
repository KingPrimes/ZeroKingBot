package com.zkb.bot.mapper;

import com.zkb.bot.domain.BotGroupFunctionOnOff;
import com.zkb.bot.domain.GroupFunctionOnOff;

import java.util.List;

/**
 * @author KingPrimes
 */
public interface GroupFunctionOnOffMapper {

    /**
     * 查询所有的群组功能列表
     */
    List<GroupFunctionOnOff> selectGroupFunctionOnOffList(GroupFunctionOnOff groupFunctionOnOff);

    /**
     * 查询所有的群组功能列表
     * 查看某群组是否开启某功能
     */
    List<BotGroupFunctionOnOff> selectGroupFunctionOnOffByGroupList(long group);

    /**
     * 插入群组功能列表
     * 打开某项功能
     */
    int insertGroupFunctionOnOff(GroupFunctionOnOff groupFunctionOnOff);

    /**
     * 删除群组功能
     * 关闭某项功能
     * 不填写功能ID == 关闭所有功能
     */
    int deleteGroupFunctionOnOff(GroupFunctionOnOff groupFunctionOnOff);

    /**
     * 修改群组功能
     */
    int updateGroupFunctionOnOff(GroupFunctionOnOff groupFunctionOnOff);
}
