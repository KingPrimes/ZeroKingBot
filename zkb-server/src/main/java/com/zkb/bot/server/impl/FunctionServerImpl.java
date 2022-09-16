package com.zkb.bot.server.impl;

import com.zkb.bot.domain.Function;
import com.zkb.bot.mapper.FunctionMapper;
import com.zkb.bot.server.FunctionServer;
import com.zkb.common.core.redis.RedisCache;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author KingPrimes
 */
@Service
public class FunctionServerImpl implements FunctionServer {

 @Resource
    FunctionMapper functionMapper;

 @Resource
    RedisCache redisCache;

    //项目加载时 加载缓存
    @PostConstruct
    public void init() {

    }

    @Override
    public List<Function> selectFunctionList(Function function) {
        return functionMapper.selectFunctionList(function);
    }

    @Override
    public Function selectFunctionByName(String name) {
        return functionMapper.selectFunctionByName(name);
    }

    @Override
    public int insertFunction(Function function) {
        return functionMapper.insertFunction(function);
    }

    /**
     * 重置缓存
     */
    @Override
    public void resetFunction() {
        clearFunction();
        loadingFunction();
    }

    /**
     * 清空缓存
     */
    @Override
    public void clearFunction() {
        Collection<String> keys = redisCache.keys("function:*");
        redisCache.deleteObject(keys);
    }

    /**
     * 设置缓存
     */
    @Override
    public void loadingFunction() {
        List<Function> functions = functionMapper.selectFunctionList(new Function());
        for (Function f : functions) {
            redisCache.setCacheObject("function:" + f.getFunctionId(), f);
        }
    }
}
