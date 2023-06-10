package com.zkb.bot.task;

import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SendAdminMessage;
import com.zkb.common.load.LoadConfig;
import com.zkb.common.utils.JarManifest;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.file.FileUtils;
import com.zkb.common.utils.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.jar.Manifest;

@Component
public class UpdateTask {

    private static final Logger log = LoggerFactory.getLogger(UpdateTask.class);
    private static final String HTML_PATH = "./ZKBotHtml";
    private static final Manifest manifestFromClasspath = JarManifest.getManifestFromClasspath(LoadConfig.class);

    public static Boolean flag = true;

    @Async("taskExecutor")
    @Scheduled(cron = "0 0 9 * * *")
    public void updateHtml() {
        log.info("HTML----正在检查是否有新版本……");
        try {
            if (flag) {
                String version = FileUtils.getFileString(HTML_PATH + "/version.txt").replace(".", "").trim(),
                        versionNew = HttpUtils.sendGetOkHttp("https://gitee.com/KingPrime/ZKBotHtml/raw/main/version.txt").replace(".", "").trim();

                if (StringUtils.isNumber(version) && StringUtils.isNumber(versionNew)) {
                    long v = Long.parseLong(version), nv = Long.parseLong(versionNew);
                    if (nv > v) {
                        log.info("当前版本：{} 最新版本：{} 检测到新版Html模板", version, versionNew);
                        Msg msg = new Msg();
                        msg.text("检测到新版Html模板\n" +
                                "当前版本：" +
                                version +
                                "  最新版本：" +
                                versionNew +
                                "\n如果要更新请联系机器人管理员\n" +
                                "发送 更新html 指令.");
                        SendAdminMessage.sendAllAdminMsg(msg);
                    }
                }
            }
        } catch (Exception e) {
            log.error("下载Html文件失败：{}", e.getMessage());
        }

    }

   /* @Async("taskExecutor")
    @Scheduled(cron = "0 0 19 * * *")
    public void updateJar() {
        if (JarUtils.isStartupFromJarEx(UpdateTask.class)) {
            try {
                log.info("正在检查是否有新版本……");
                assert manifestFromClasspath != null;
                String version = manifestFromClasspath.getMainAttributes().getValue("ZeroKingBot-Version");
                ReleaseDomain release = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.github.com/repos/KingPrimes/ZeroKingBot/releases/latest"), ReleaseDomain.class);
                if (!version.equals(release.getTagName())) {
                    Msg msg = new Msg();
                    msg.text("当前版本：" + version + "\n最新版本：" + release.getTagName() + "\n有版本更新！！");
                    msg.text("\n最新版本更新日志："+release.getBody());
                    msg.text("\n是否确认自动更新？\n确认请发送 '自动更新'\n不更新请忽略此消息……");
                    SpringUtils.getBean(RedisCache.class).setCacheObject("updateJar",release);
                    SendAdminMessage.sendAllAdminMsg(msg);
                }
            } catch (Exception e) {
                log.error("获取版本信息错误：{}", e.getMessage());
            }

        }

    }*/


}
