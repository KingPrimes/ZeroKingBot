package com.zkb.common.load;

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
import java.nio.file.Files;
import java.util.Locale;
import java.util.Objects;

@Component
@Configuration
public class LoadConfig {

    private static final Logger log = LoggerFactory.getLogger(LoadConfig.class);

    private static final String HTML_PATH = "./ZKBotHtml";

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

    //判断配置文件是否存在不存在则新建一个配置文件
    @PostConstruct
    public void WriteConfigFile() {
        log.info("开始初始化配置文件……");
        //config
        File file = new File("./config/config.ini");
        if (!file.isFile()) {
            try {
                File db = new File("./config");
                if (!db.isFile()) {
                    db.mkdirs();
                }
                InputStream in = LoadConfig.class.getResourceAsStream("/cfg.txt");
                assert in != null;
                Files.copy(in, file.toPath());

            } catch (Exception e) {
                log.error("创建config.ini失败，错误信息：{}", e.getMessage());
            }
        }
        log.info("配置文件初始化完毕……");

    }

    //创建Warframe指令配置文件
    //@PostConstruct
    public void WriteWarframeConfigFile() {
        File file = new File("./config/warframeConfig.ini");
        if (!file.isFile()) {
            try {
                File db = new File("./config");
                if (!db.isFile()) {
                    db.mkdirs();
                }
                InputStream in = LoadConfig.class.getResourceAsStream("/warframe.yml");
                assert in != null;
                Files.copy(in, file.toPath());

            } catch (Exception e) {
                log.error("创建warframeConfig.ini失败，错误信息：{}", e.getMessage());
            }

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
                   if( file.delete()){
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
        String versionNew = HttpUtils.sendGetOkHttp( "https://gitee.com/KingPrime/ZKBotHtml/raw/main/version.txt");
        String version = "";
        if (!file.exists()) {
            try {
                Git.cloneRepository()
                        .setURI("https://gitee.com/KingPrime/ZKBotHtml.git")
                        .setDirectory(file)
                        .call();
            } catch (GitAPIException e) {
                log.error("下载Html文件失败：{}", e.getMessage());
            }
        }else{
            version = FileUtils.getFileString(HTML_PATH+"/version.txt");
            if(!versionNew.equals(version) && versionNew.trim().length() != 0){
                try {
                    if(FileUtils.delAllFile(HTML_PATH)){
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
