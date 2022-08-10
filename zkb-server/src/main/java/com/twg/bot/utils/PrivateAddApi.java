package com.twg.bot.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.twg.common.enums.HttpMethod;
import com.twg.common.utils.StringUtils;
import com.twg.common.utils.http.HttpUtils;


/**
 * QQ-SDK的扩展
 * 对于私人-好友
 */
public class PrivateAddApi {
    /**
     * 根据QQ号获取头像
     *
     * @param userId QQ账号
     */
    public static String getPrivateHeadImage(Long userId) {
        //返回拼接的QQ头像网址
        return "https://q2.qlogo.cn/headimg_dl?dst_uin=" + userId + "&spec=100";
    }

    public static String getPrivateHeadHDImage(Long userId) {
        return "http://q1.qlogo.cn/g?b=qq&nk=" + userId + "&s=640";
    }

    /**
     * 根据QQ号获取昵称
     *
     * @param userId QQ账号
     */
    public static String getPrivateNick(Long userId) {
        //根据APi获取QQ账号信息并截取中间信息
        String nick = StringUtils.getSubStringEx(HttpUtils.sendResponse("https://r.qzone.qq.com/fcg-bin/cgi_get_portrait.fcg?uins=" + userId, HttpMethod.GET, "GBK"), "{", "}");
        //转换成Json格式的数据
        JSONObject object = JSON.parseObject(nick);
        //提取JsonArray
        JSONArray array = object.getJSONArray(String.valueOf(userId));
        //根据下标获取昵称 并返回
        return array.getString(6);
    }
}
