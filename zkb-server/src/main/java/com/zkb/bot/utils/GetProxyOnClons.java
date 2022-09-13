package com.zkb.bot.utils;

import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.spring.SpringUtils;

public class GetProxyOnClons {
    public static boolean getProxyOnClons() {
        return SpringUtils.getBean(RedisCache.class).getCacheObject("http-proxy");
    }

    public static void isHttpProxy() {
        if (!SpringUtils.getBean(RedisCache.class).exists("http-proxy")) {
            SpringUtils.getBean(RedisCache.class).setCacheObject("http-proxy", false);
        }
    }

    public static boolean getSocketProxyOnClons() {
        return SpringUtils.getBean(RedisCache.class).getCacheObject("socket-proxy");
    }

    public static void isSocketProxy() {
        if (!SpringUtils.getBean(RedisCache.class).exists("socket-proxy")) {
            SpringUtils.getBean(RedisCache.class).setCacheObject("socket-proxy", false);
        }
    }

}
