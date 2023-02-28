package com.zkb.bot.nsfw;


import com.alibaba.fastjson2.JSON;
import com.zkb.bot.enums.ImageEnum;
import com.zkb.bot.nsfw.entity.NsfwRes;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.http.HttpUtils;

import java.util.Locale;

public class Nsfw {

    public static String judge(String str) {
        str = str.toUpperCase(Locale.ROOT).replaceAll(ImageEnum.ORDER_NSFW.getType(), "").trim();
        if (StringUtils.isHttpUrl(str)) return "没有发现需要鉴定的图片";

        NsfwRes nr = res(str);

        if (nr == null) return "网络出错了……";

        if (nr.getNeutral() > 0.3) return "就这？一点激情都没有！";

        if (nr.getHentai() > 0.3) return "你个老变态";

        if (nr.getDrawings() > 0.3 || nr.getNeutral() < 0.3) {
            return "二次元";
        } else {
            return "三次元";
        }

    }

    private static NsfwRes res(String url) {
        String json = HttpUtils.sendGetOkHttp("https://nsfwtag.azurewebsites.net/api/nsfw?url=", url);
        if (json.equals("timeout")) {
            return null;
        }
        return JSON.parseObject(json).toJavaObject(NsfwRes.class);
    }
}
