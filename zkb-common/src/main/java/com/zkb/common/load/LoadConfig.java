package com.zkb.common.load;

import com.zkb.common.utils.JarManifest;
import com.zkb.common.utils.JarUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.file.FileUtils;
import com.zkb.common.utils.http.HttpUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.util.FS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Objects;
import java.util.jar.Manifest;

@Component
@Configuration
public class LoadConfig {

    private static final Logger log = LoggerFactory.getLogger(LoadConfig.class);

    private static final String HTML_PATH = "./ZKBotHtml";

    private static final Manifest manifestFromClasspath = JarManifest.getManifestFromClasspath(LoadConfig.class);



    /**
     * 获取操作系统
     *
     * @return 1/Win
     * 2/Linux
     */
    private static int isOs() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            return 1;
        }
        if (os.contains("linux")) {
            return 2;
        }

        return 0;
    }

    //启动完成之后自动打开浏览器并访问 Url 地址
    public static void index(){
        String url ="http://localhost:8080";
        // 获取操作系统的名字
        String osName = System.getProperty("os.name", "");
        try{
            if (osName.startsWith("Mac OS")) {
                // 苹果的打开方式
                Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
                Method openURL = fileMgr.getDeclaredMethod("openURL",
                        String.class);
                openURL.invoke(null, url);
            } else if (osName.startsWith("Windows")) {
                // windows的打开方式。
                Runtime.getRuntime().exec(
                        "rundll32 url.dll,FileProtocolHandler " + url);
            } else {
                // Unix or Linux的打开方式
                String[] browsers = { "firefox", "opera", "konqueror", "epiphany",
                        "mozilla", "netscape" };
                String browser = null;
                for (int count = 0; count < browsers.length && browser == null; count++)
                    // 执行代码，在brower有值后跳出，
                    // 这里是如果进程创建成功了，==0是表示正常结束。
                    if (Runtime.getRuntime()
                            .exec(new String[] { "which", browsers[count] })
                            .waitFor() == 0)
                        browser = browsers[count];
                if (browser == null)
                    throw new Exception("Could not find web browser");
                else
                    // 这个值在上面已经成功的得到了一个进程。
                    Runtime.getRuntime().exec(new String[] { browser, url });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    private static boolean isRunRedis(String name) {
        Runtime run = Runtime.getRuntime();
        try {
            Process exec = run.exec("cmd /c Tasklist");
            BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String g;
            while ((g = in.readLine()) != null) {
                g = g.toLowerCase(Locale.ROOT);
                if (g.contains(name)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @PostConstruct
    public void init() {
        int os = isOs();
        if (os == 1) {
            initQQ();
            initWinRedis();
        }

    }

    @PostConstruct
    public void WriteSqlite() {
        log.info("开始初始化数据库文件……");
        File file = new File("./db/data.db3");
        if (file.isFile()) {
            try {
                long lastModifiedCopy = file.lastModified();
                long last = new File(Objects.requireNonNull(LoadConfig.class.getResource("/data.db3")).toURI()).lastModified();
                if (last > lastModifiedCopy) {
                    if (file.delete()) {
                        InputStream in = LoadConfig.class.getResourceAsStream("/data.db3");
                        assert in != null;
                        Files.copy(in, file.toPath());
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        } else {
            try {
                File db = new File("./db");
                if (!db.isFile()) {
                    db.mkdirs();
                }

                InputStream in = LoadConfig.class.getResourceAsStream("/data.db3");
                assert in != null;
                Files.copy(in, file.toPath());
            } catch (Exception e) {
                log.error("创建db数据库失败，错误信息：{}", e.getMessage());
            }
        }
        log.info("数据库文件初始化完毕……");
    }

    public void initQQ() {
        log.info("开始初始化GoCqHttp……");
        String x = System.getProperty("user.dir") + "\\gocqhttp\\go-cqhttp.bat";
        try {
            File file = new File("./gocqhttp");
            if (!file.exists()) {
                Git.cloneRepository()
                        .setURI("https://gitcode.net/KingPrimes/qq.git")
                        .setDirectory(file)
                        .call()
                ;
                boolean flg = RepositoryCache.FileKey.isGitRepository(file, FS.DETECTED);
                if (!flg) {
                    Runtime.getRuntime().exec(x);
                    return;
                }

                return;
            }
            if (file.exists()) {
                if (isRunRedis("go-cqhttp")) {
                    Runtime.getRuntime().exec(x);
                }
            }

        } catch (GitAPIException | IOException e) {
            log.error("初始化Go-cqhttp失败！错误信息：{}\n请自行下载Go-cqhttp: https://github.com/Mrs4s/go-cqhttp/releases", e.getMessage());
        }
        log.info("GoCqHttp初始化完毕……");
    }

    @PostConstruct
    public void initHtml() {
        log.info("开始初始化Html渲染模板……");
        File file = new File(HTML_PATH);
        long versionNew = Long.parseLong(HttpUtils.sendGetOkHttp("https://gitee.com/KingPrime/ZKBotHtml/raw/main/version.txt").replace(".", "").trim());
        long version = 0;
        if (!file.exists()) {
            try {
                Git.cloneRepository()
                        .setURI("https://gitee.com/KingPrime/ZKBotHtml.git")
                        .setDirectory(file)
                        .call();
            } catch (GitAPIException e) {
                log.error("下载Html文件失败：{}", e.getMessage());
            }
        } else {
            version = Long.parseLong(FileUtils.getFileString(HTML_PATH + "/version.txt").replace(".", "").trim());
            if (versionNew > version && versionNew != 0) {
                log.info("当前版本：{} 最新版本：{} 检测到新版Html模板，选择是否更新", version, versionNew);
                try {
                    if (FileUtils.delAllFile(HTML_PATH)) {
                        Git.cloneRepository()
                                .setURI("https://gitee.com/KingPrime/ZKBotHtml.git")
                                .setDirectory(file)
                                .call();
                    }
                } catch (Exception e) {
                    log.error("下载Html文件失败：{}", e.getMessage());
                }
            }
        }
        log.info("Html渲染模板初始化完毕……");
    }


    @PostConstruct
    public void updateJar() {
        //判断启动模式
        if (JarUtils.isStartupFromJarEx(LoadConfig.class)) {
            assert manifestFromClasspath != null;
            String version = manifestFromClasspath.getMainAttributes().getValue("ZeroKingBot-Version").replace(".", "").trim();
            String newVersion = HttpUtils.sendGetOkHttp("https://gitee.com/KingPrime/zero-king-bot/blob/main/version.txt").replace(".", "").trim();
            if (version != null && newVersion != null) {
                if (StringUtils.isNumber(version) && StringUtils.isNumber(newVersion)) {
                    long v = Long.parseLong(version), nv = Long.parseLong(newVersion);
                    if (nv > v) {
                        log.info("有版本更新，请访问 https://github.com/KingPrimes/ZeroKingBot 下载最新版本！！！");
                    }
                }
            }

        }

    }

    public void initWinRedis() {
        log.info("开始初始化Redis……");
        String x = "cmd /c start " + System.getProperty("user.dir") + "\\Redis\\redis-server.exe " + System.getProperty("user.dir") + "\\Redis\\redis.windows.conf";
        try {
            File file = new File("./Redis");
            if (!file.exists()) {
                Git.cloneRepository()
                        .setURI("https://gitcode.net/KingPrimes/win-redis.git")
                        .setDirectory(file)
                        .call()
                ;
                boolean flg = RepositoryCache.FileKey.isGitRepository(file, FS.DETECTED);
                if (!flg) {
                    Runtime.getRuntime().exec(x);
                    return;
                }
                return;
            }
            if (file.exists()) {
                if (isRunRedis("redis-server")) {
                    Runtime.getRuntime().exec(x);
                }
            }

        } catch (GitAPIException | IOException e) {
            log.error("初始化Redis失败！{}", e.getMessage());
        }
        log.info("初始化Redis完毕……");
    }


}
