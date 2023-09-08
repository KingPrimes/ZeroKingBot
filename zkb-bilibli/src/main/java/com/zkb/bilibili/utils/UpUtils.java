package com.zkb.bilibili.utils;

import com.alibaba.fastjson2.JSONObject;
import com.zkb.bilibili.dao.BiliBili;
import com.zkb.common.utils.http.HttpUtils;
import okhttp3.Headers;


public class UpUtils {

    /**
     * 获取某位Up主得动态
     *
     * @param uid 唯一UID
     * @return 具体结果
     */
    public static BiliBili getUpDynamic(String offset, long uid) {
        String json = HttpUtils.sendGetOkHttp("https://api.bilibili.com/x/polymer/web-dynamic/v1/feed/space?offset=" + offset + "&host_mid=" + uid,"",
                Headers.of("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3").newBuilder()
        );
        return JSONObject.parseObject(json, BiliBili.class);
    }



}
