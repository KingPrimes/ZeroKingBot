package com.zkb.bot.server.impl;

import com.zkb.bot.domain.BotFunction;
import com.zkb.bot.mapper.BotFunctionMapper;
import com.zkb.bot.server.IBotFunctionServer;
import com.zkb.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author KingPrimes
 */
@Service
public class BotFunctionServerImpl implements IBotFunctionServer, CommandLineRunner {

    @Autowired
    BotFunctionMapper botFunctionMapper;

    @Autowired
    RedisCache redisCache;


    @Override
    public List<BotFunction> selectFunctionList(BotFunction botFunction) {
        return botFunctionMapper.selectFunctionList(botFunction);
    }

    @Override
    public BotFunction selectFunctionByName(String name) {
        return botFunctionMapper.selectFunctionByName(name);
    }

    @Override
    public int insertFunction(BotFunction botFunction) {
        return botFunctionMapper.insertFunction(botFunction);
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
        List<BotFunction> botFunctions = botFunctionMapper.selectFunctionList(new BotFunction());
        for (BotFunction f : botFunctions) {
            redisCache.setCacheObject("function:" + f.getFunctionId(), f);
        }
    }

  /*  @PostConstruct
    public void init(){
        if(botFunctionMapper.selectFunctionList(null).size()==0 ||botFunctionMapper.selectFunctionList(null)==null){
            botFunctionMapper.insertFunction(new BotFunction(
                    1L,
                    "warframe",
                    "提供Warframe游戏的各种查询，详情请发送wf帮助查看"
            ));
            botFunctionMapper.insertFunction(new BotFunction(
                    2L,
                    "ai",
                    "智障陪聊"
            ));
            botFunctionMapper.insertFunction(new BotFunction(
                    3L,
                    "gif",
                    "生成Gif图片"
            ));
            botFunctionMapper.insertFunction(new BotFunction(
                    4L,
                    "image",
                    "涩图"
            ));

        }

    }*/

    @Override
    public void run(String... args) throws Exception {
        if (botFunctionMapper.selectFunctionList(null).size() == 0 || botFunctionMapper.selectFunctionList(null) == null) {
            botFunctionMapper.insertFunction(new BotFunction(
                    1L,
                    "warframe",
                    "提供Warframe游戏的各种查询，详情请发送wf帮助查看"
            ));
            botFunctionMapper.insertFunction(new BotFunction(
                    2L,
                    "ai",
                    "智障陪聊"
            ));
            botFunctionMapper.insertFunction(new BotFunction(
                    3L,
                    "gif",
                    "生成Gif图片"
            ));
            botFunctionMapper.insertFunction(new BotFunction(
                    4L,
                    "image",
                    "涩图"
            ));

        }
    }
}
