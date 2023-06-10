package com.zkb.bot.utils;

import com.alibaba.fastjson2.JSONObject;
import com.mikuac.shiro.core.Bot;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.load.LoadConfig;
import com.zkb.common.utils.DownLoadUtils;
import com.zkb.common.utils.JarManifest;
import com.zkb.common.utils.MessageUtils;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.utils.update.UpdateJar;
import com.zkb.common.vo.ReleaseDomain;
import org.springframework.http.HttpMethod;

import java.util.jar.Manifest;

public class ChackVersionToUpdateJar {

    private static final Manifest manifestFromClasspath = JarManifest.getManifestFromClasspath(LoadConfig.class);

    /**
     * 检查是否是最新版本
     *
     * @param bot bot
     * @param id  id
     */
    public static void chackVersion(Bot bot, Long id) {
        assert manifestFromClasspath != null;
        String version = manifestFromClasspath.getMainAttributes().getValue("ZeroKingBot-Version");
        String json = HttpUtils.sendGetOkHttp("https://api.github.com/repos/KingPrimes/ZeroKingBot/releases/latest");
        Msg msg = new Msg();
        if(json.equals("timeout")){
            msg.text("获取信息超时！");
            bot.sendPrivateMsg(id, msg.build(), false);
            return;
        }
        ReleaseDomain release = JSONObject.parseObject(json, ReleaseDomain.class);

        if (!version.equals(release.getTagName())) {
            msg.text("当前版本：" + version + "\n最新版本：" + release.getTagName() + "\n有版本更新！！");
            msg.text(MessageUtils.message("up.msg.log") + release.getBody());
            msg.text(MessageUtils.message("up.msg.isup"));
            SpringUtils.getBean(RedisCache.class).setCacheObject("updateJar", release);
        } else {
            msg.text(MessageUtils.message("up.msg.isnew"));
        }
        bot.sendPrivateMsg(id, msg.build(), false);
    }

    /**
     * 更新Jar文件
     * @param bot
     * @param id
     */
    public static void update(Bot bot, Long id) {
        RedisCache redis = SpringUtils.getBean(RedisCache.class);
        ReleaseDomain release;
        assert manifestFromClasspath != null;
        String version = manifestFromClasspath.getMainAttributes().getValue("ZeroKingBot-Version");
        if (!redis.exists("updateJar")) {
            release = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.github.com/repos/KingPrimes/ZeroKingBot/releases/latest"), ReleaseDomain.class);
        } else {
            release = redis.getCacheObject("updateJar");
            if (release == null) {
                release = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.github.com/repos/KingPrimes/ZeroKingBot/releases/latest"), ReleaseDomain.class);
            }
        }

        if (version.equals(release.getTagName())) {
            bot.sendPrivateMsg(id,MessageUtils.message("up.msg.isnew"), false);
        } else {
            Msg msg = new Msg();
            msg.text("当前版本：" + version + "\n最新版本：" + release.getTagName() + "\n有版本更新！！");
            msg.text(MessageUtils.message("up.msg.log") + release.getBody());
            msg.text(MessageUtils.message("up.msg.upin"));
            bot.sendPrivateMsg(id,msg.build(), false);

            boolean falg = DownLoadUtils.saveUrlAs("https://ghproxy.com/" + release.getAssets().get(0).getBrowserDownloadUrl(),
                    "./tmp",
                    release.getAssets().get(0).getName(),
                    HttpMethod.GET,
                    "jar"
            );
            if(falg){
                bot.sendPrivateMsg(id, MessageUtils.message("up.msg.upres"), false);
                redis.deleteObject("updateJar");
                SpringUtils.getBean(UpdateJar.class).restart(release.getAssets().get(0).getName());
            }else {
                bot.sendPrivateMsg(id,MessageUtils.message("up.msg.dowerr"), false);
            }


        }

    }


}
