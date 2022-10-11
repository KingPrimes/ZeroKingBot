package com.zkb.bot.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zkb.bot.domain.BotGroupFunctionOnOff;
import com.zkb.bot.domain.GroupFunctionOnOff;
import com.zkb.bot.mapper.GroupFunctionOnOffMapper;
import com.zkb.bot.server.GroupFunctionOnOffServer;
import com.zkb.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

/**
 * @author KingPrimes
 */
@Service
public class GroupFunctionOnOffServerImpl implements GroupFunctionOnOffServer {

 @Autowired
    GroupFunctionOnOffMapper offMapper;

 @Autowired
    RedisCache redisCache;


    //加载时设置缓存
    @PostConstruct
    public void init() {
        resetGroupFunction();
    }


    @Override
    public List<GroupFunctionOnOff> selectGroupFunctionOnOffList(GroupFunctionOnOff groupFunctionOnOff) {
        return offMapper.selectGroupFunctionOnOffList(groupFunctionOnOff);
    }

    @Override
    public List<BotGroupFunctionOnOff> selectGroupFunctionOnOffByGroupList(long group) {
        return offMapper.selectGroupFunctionOnOffByGroupList(group);
    }

    @Override
    public int insertGroupFunctionOnOff(GroupFunctionOnOff groupFunctionOnOff) {
        return offMapper.insertGroupFunctionOnOff(groupFunctionOnOff);
    }

    @Override
    public int deleteGroupFunctionOnOff(GroupFunctionOnOff groupFunctionOnOff) {
        if (!redisCache.exists("group_function:" + groupFunctionOnOff.getGroup())) {
            return 0;
        }
        GroupFunctionOnOff gf = redisCache.getCacheObject("group_function:" + groupFunctionOnOff.getGroup());
        List<Integer> fs = JSONArray.parseArray(gf.getFunctionId()).toJavaList(Integer.class);
        if (fs.remove(Integer.valueOf(groupFunctionOnOff.getFunctionId()))) {
            if (fs.size() == 0) {
                redisCache.deleteObject("group_function:" + groupFunctionOnOff.getGroup());
                return offMapper.deleteGroupFunctionOnOff(groupFunctionOnOff);
            }
            gf.setFunctionId(JSONArray.parseArray(JSON.toJSONString(fs)).toString());
            redisCache.setCacheObject("group_function:" + groupFunctionOnOff.getGroup(), gf);
            return offMapper.updateGroupFunctionOnOff(gf);
        }
        return 0;
    }

    /**
     * 修改群组功能
     */
    @Override
    public int updateGroupFunctionOnOff(GroupFunctionOnOff groupFunctionOnOff) {
        if (!redisCache.exists("group_function:" + groupFunctionOnOff.getGroup())) {
            groupFunctionOnOff.setFunctionId("[" + groupFunctionOnOff.getFunctionId() + "]");
            redisCache.setCacheObject("group_function:" + groupFunctionOnOff.getGroup(), groupFunctionOnOff);
            return offMapper.insertGroupFunctionOnOff(groupFunctionOnOff);
        }
        GroupFunctionOnOff gf = redisCache.getCacheObject("group_function:" + groupFunctionOnOff.getGroup());
        List<Integer> fs = JSONArray.parseArray(gf.getFunctionId()).toJavaList(Integer.class);
        for (Integer f : fs) {
            if (f.equals(Integer.valueOf(groupFunctionOnOff.getFunctionId()))) {
                return -1;
            }
        }
        fs.add(Integer.valueOf(groupFunctionOnOff.getFunctionId()));
        gf.setFunctionId(JSONArray.parseArray(JSON.toJSONString(fs)).toString());
        redisCache.setCacheObject("group_function:" + groupFunctionOnOff.getGroup(), gf);
        return offMapper.updateGroupFunctionOnOff(gf);
    }

    /**
     * 重置缓存
     */
    @Override
    public void resetGroupFunction() {
        clearGroupFunction();
        loadingGroupFunction();

    }

    /**
     * 清空缓存
     */
    @Override
    public void clearGroupFunction() {
        Collection<String> keys = redisCache.keys("group_function:*");
        redisCache.deleteObject(keys);
    }

    /**
     * 设置缓存
     */
    @Override
    public void loadingGroupFunction() {
        List<GroupFunctionOnOff> functions = offMapper.selectGroupFunctionOnOffList(new GroupFunctionOnOff());
        for (GroupFunctionOnOff gf : functions) {
            redisCache.setCacheObject("group_function:" + gf.getGroup(), gf);
        }
    }


}
