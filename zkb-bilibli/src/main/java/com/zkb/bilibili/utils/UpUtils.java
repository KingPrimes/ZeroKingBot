package com.zkb.bilibili.utils;

import com.alibaba.fastjson2.JSONObject;
import com.zkb.bilibili.dao.BiliBili;
import com.zkb.common.utils.http.HttpUtils;

public class UpUtils {

    /**
     * 获取某位Up主得动态
     * @param uid 唯一UID
     * @return 具体结果
     */
    public static BiliBili getUpDynamic(String offset,long uid){
        String json = HttpUtils.sendGetOkHttp("https://api.bilibili.com/x/polymer/web-dynamic/v1/feed/space?offset="+offset+"&host_mid="+uid);
        return JSONObject.parseObject(json,BiliBili.class);
    }
}
