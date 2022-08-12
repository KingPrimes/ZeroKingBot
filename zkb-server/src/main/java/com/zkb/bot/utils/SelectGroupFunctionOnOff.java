package com.zkb.bot.utils;

import com.alibaba.fastjson.JSONArray;
import com.zkb.bot.domain.GroupFunctionOnOff;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author KingPrimes
 */
@Component
public class SelectGroupFunctionOnOff {

    /**
     * 查询群组是否开启某项功能
     *
     * @param group        群组
     * @param functionName 功能名称
     * @return true/开启 -- false/未开启
     */
    public static boolean getGroupFunctionOnOff(long group, FunctionEnums functionName) {
        if (!SpringUtils.getBean(RedisCache.class).exists("group_function:" + group)) {
            return false;
        }
        GroupFunctionOnOff groups = SpringUtils.getBean(RedisCache.class).getCacheObject("group_function:" + group);
        List<Integer> integers = JSONArray.parseArray(groups.getFunctionId()).toJavaList(Integer.class);
        return integers.contains(functionName.ordinal());
    }
}
