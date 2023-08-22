package com.zkb.common.load;

import com.alibaba.fastjson.JSONObject;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.utils.JarManifest;
import com.zkb.common.utils.RuntimeUtils;
import com.zkb.common.utils.file.FileUtils;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.vo.ReleaseDomain;
import com.zkb.common.zero.ZeroConfig;
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
import java.util.Locale;
import java.util.jar.Manifest;

@Component
@Configuration
public class LoadConfig {

    private static final Logger log = LoggerFactory.getLogger(LoadConfig.class);

    private static final String HTML_PATH = "./ZKBotHtml";

    private static final Manifest manifestFromClasspath = JarManifest.getManifestFromClasspath(LoadConfig.class);

    /**
     * 获取操作系统
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
    public static void index() {
        String url = "http://localhost:8080";
        // 获取操作系统的名字
        String osName = System.getProperty("os.name", "");
        try {
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
                String[] browsers = {"firefox", "opera", "konqueror", "epiphany",
                        "mozilla", "netscape"};
                String browser = null;
                for (int count = 0; count < browsers.length && browser == null; count++)
                    // 执行代码，在brower有值后跳出，
                    // 这里是如果进程创建成功了，==0是表示正常结束。
                    if (Runtime.getRuntime()
                            .exec(new String[]{"which", browsers[count]})
                            .waitFor() == 0)
                        browser = browsers[count];
                if (browser == null)
                    throw new Exception("Could not find web browser");
                else
                    // 这个值在上面已经成功的得到了一个进程。
                    Runtime.getRuntime().exec(new String[]{browser, url});
            }
        } catch (Exception e) {
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

    public static void initSqliteFile() {
        log.info("检查是否存在数据库文件!");
        File file = new File("./db/data.db3");

        File dir = file.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (!file.exists()) {
            log.info("数据库文件不存在，正在初始化……");
            try {
                file.createNewFile();
                log.info("数据库文件初始化完毕……");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostConstruct
    public void init() {
        int os = isOs();
        if (os == 1) {
            initWinRedis();
            initQQ("go-cqhttp_windows_amd64.exe");
        }
    }

    public void initQQ(String os) {
        log.info("开始初始化GoCqHttp……");
        if(RuntimeUtils.exec("go-cqhttp")){
            log.info("检测到go-cqhttp正在运行！已停止go-cqhttp初始化！");
            return;
        }
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
                if (!flg && upGocq(os)) {
                    Runtime.getRuntime().exec(x);
                    return;
                }

                return;
            }
            if (file.exists()) {
                if(upGocq(os)){
                    if (isRunRedis("go-cqhttp")) {
                        Runtime.getRuntime().exec(x);
                    }
                }
            }

        } catch (GitAPIException | IOException e) {
            log.error("初始化Go-cqhttp失败！错误信息：{}\n请自行下载Go-cqhttp: https://github.com/Mrs4s/go-cqhttp/releases", e.getMessage());
        }
        log.info("GoCqHttp初始化完毕……");
    }

    public static boolean upGocq(String os){
        ReleaseDomain release;
        release = JSONObject.parseObject(HttpUtils.sendGetOkHttp("https://api.github.com/repos/Mrs4s/go-cqhttp/releases/latest"), ReleaseDomain.class);
        String value;
        value = release.getName();
        boolean exists = SpringUtils.getBean(RedisCache.class).exists("gocq-value");
        if(exists){
            String Rvalue = SpringUtils.getBean(RedisCache.class).getCacheObject("gocq-value");
            if(Rvalue.equals(value)){
                return true;
            }
        }

        String url = "";
        for (ReleaseDomain.Assets asset : release.getAssets()) {
            if(asset.getName().equals(os)){
                url = asset.getBrowserDownloadUrl();
            }
        }

        byte[] bytes = HttpUtils.sendGetForFile("https://ghproxy.com/" + url);
        File mkd = new File("./gocqhttp/");
        if (!mkd.exists()) {
            mkd.mkdirs();
        }
        File gocq = new File("./gocqhttp/"+os);
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(gocq);
            if (bytes != null) {
                outputStream.write(bytes);
            }
            outputStream.close();
            SpringUtils.getBean(RedisCache.class).setCacheObject("gocq-value",value);
        } catch (IOException e) {
            log.error("下载GoCqHttp文件失败！错误信息：{}",e.getMessage());
            return false;
        }
        return true;
    }

    @PostConstruct
    public void initHtml() {
        log.info("开始初始化Html渲染模板……");
        File file = new File(HTML_PATH);
        String v = HttpUtils.sendGetOkHttp("https://ghproxy.com/https://github.com/KingPrimes/ZKBotImageHtml/blob/main/version.txt");
        if(v.isEmpty() ||v.equals("timeout")){
            log.info("HTML渲染模板超时！\n如果你是初次启动请手动下载！\n不是初次启动请忽略本条消息！");
            return;
        }
        long versionNew = Long.parseLong(v.replace(".", "").trim());
        long version = 0;
        if (!file.exists()) {
            try {
                Git.cloneRepository()
                        .setURI("https://ghproxy.com/https://github.com/KingPrimes/ZKBotImageHtml")
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
                                .setURI("https://ghproxy.com/https://github.com/KingPrimes/ZKBotImageHtml")
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

  /*  @PostConstruct
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
    }*/

    public void initWinRedis() {
        log.info("开始初始化Redis……");
        if(RuntimeUtils.exec("redis")){
            log.info("监测到Redis正在运行！已停止初始化Redis！");
            return;
        }
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

    /**
     * 获取表情图片
     */
    @PostConstruct
    public void getInitPng() {
        if(ZeroConfig.getTest()){
            log.info("开始初始化表情文件……");
            try {
                File file = new File("./temp-png");
                if (!file.exists()){
                    file.mkdirs();
                    Git.cloneRepository().setURI("https://gitcode.net/KingPrimes/zerokingbot-gif.git").setDirectory(file).call();
                }
            } catch (Exception e) {
                log.error("错误信息：{}", e.getMessage());
            }
        }
    }


}
