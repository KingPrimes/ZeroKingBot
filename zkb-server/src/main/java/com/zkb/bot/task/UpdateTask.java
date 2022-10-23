package com.zkb.bot.task;

import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SendAllGroup;
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

    public static Boolean flag = true;

    private static final Logger log = LoggerFactory.getLogger(UpdateTask.class);
    private static final String HTML_PATH = "./ZKBotHtml";
    private static final Manifest manifestFromClasspath = JarManifest.getManifestFromClasspath(LoadConfig.class);


    @Async("taskExecutor")
    @Scheduled(cron = "0 0 8 * * *",initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(10*1200*1000)}")
    public void updateHtml() {
        try {
            if(flag){
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
                        SendAllGroup.sendAllGroup(msg);
                    }
                }
            }
        } catch (Exception e) {
            log.error("下载Html文件失败：{}", e.getMessage());
        }

    }

    @Async("taskExecutor")
    @Scheduled(cron = "0 0 9 * * *",initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(10*1200*1000)}")
    public void updateJar() {
        if(flag){
            try{
                String version = manifestFromClasspath.getMainAttributes().getValue("ZeroKingBot-Version").replace(".", "").trim();
                String newVersion = HttpUtils.sendGetOkHttp("https://gitee.com/KingPrime/zero-king-bot/blob/main/version.txt").replace(".", "").trim();
                if (version != null && newVersion != null ) {
                    if (StringUtils.isNumber(version) && StringUtils.isNumber(newVersion)) {
                        long v = Long.parseLong(version), nv = Long.parseLong(newVersion);
                        if (nv > v) {
                            log.info("有版本更新，请访问 https://github.com/KingPrimes/ZeroKingBot 下载最新版本！！！");
                            Msg msg = new Msg();
                            msg.text("当前版本：" + version + "\n最新版本：" + newVersion + "\n有版本更新，请访问 https://github.com/KingPrimes/ZeroKingBot 下载最新版本！！！");
                            SendAllGroup.sendAllGroup(msg);
                        }
                    }
                }
            }catch (Exception e){
                log.error("获取版本信息错误：{}",e.getMessage());
            }

        }

    }


}
