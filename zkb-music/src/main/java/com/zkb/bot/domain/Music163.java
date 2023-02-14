package com.zkb.bot.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zkb.common.utils.http.HttpUtils;

public class Music163 {
    private static final String MUSIC_URL = "https://music.163.com/api/cloudsearch/pc";

    public static long getMusic163(String key){
        String str = "&s=" +
                key +
                "&type=1" +
                "&offset=0";
        JSONObject object = JSON.parseObject(HttpUtils.sendGetOkHttp(MUSIC_URL, str));

        return object.getJSONObject("result").getJSONArray("songs").getJSONObject(0).getLong("id");
    }


}
