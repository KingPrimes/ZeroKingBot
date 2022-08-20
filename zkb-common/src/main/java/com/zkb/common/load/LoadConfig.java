package com.zkb.common.load;

import com.zkb.common.utils.StringUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.util.FS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Properties;

@Component
@Configuration
public class LoadConfig {

    private static final Logger log = LoggerFactory.getLogger(LoadConfig.class);

    private static final String HTML_PATH = "./ZKBotHtml";
    public static Properties prop = new Properties();

    @PostConstruct
    public static boolean init(){
        if (!initHtml()) {
            log.error("下载Html文件失败请手动创建或重试\n手动下载请到：https://gitee.com/KingPrime/ZKBotHtml 网站中下载文件");
            return false;
        }
        if(isOs()==1){
            if(initWinRedis()){
                log.error("初始化Redis失败！");
                return false;
            }
            if(initQQ()){
                log.error("初始化Go-cqhttp失败！请自行下载Go-cqhttp: https://github.com/Mrs4s/go-cqhttp/releases");
                return false;
            }
        }
        if (!WriteConfigFile()) {
            log.error("创建配置文件失败！");
            return false;
        }
        if (!WriteSqlite()) {
            log.error("创建缓存文件失败！");
            return false;
        }
        return initConfig();
    }

    @PreDestroy
    public static void end(){
        if(isOs()==1){
            String go = "taskkill /f /im go*";
            String redis = "taskkill /f /im redis*";
            String cmd = "taskkill /f /im cmd*";
            try{
                Runtime.getRuntime().exec(go);
                Runtime.getRuntime().exec(redis);
                Runtime.getRuntime().exec(cmd);
            }catch (Exception e){
                log.error("未能成功退出程序错误信息：{}",e.getMessage());
            }
        }
    }

    private static boolean initConfig() {
        try {
            prop.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/config.ini")));
            return true;
        } catch (Exception e) {
            log.error("读取config.ini文件出错，错误信息：{}", e.getMessage());
            return false;
        }

    }

    public static long getAdmin() {
        initConfig();
        String admin = prop.getProperty("admin");
        if (StringUtils.isNumber(admin)) return Long.parseLong(admin);
        return 0;
    }

    //判断配置文件是否存在不存在则新建一个配置文件
    private static boolean WriteConfigFile() {
        //config
        File file = new File("./config.ini");
        if (!file.isFile()) {
            try {
                InputStream in = LoadConfig.class.getResourceAsStream("/cfg.txt");
                assert in != null;
                Files.copy(in, file.toPath());
            } catch (Exception e) {
                return false;
            }

        }
        return file.isFile();
    }

    private static boolean WriteSqlite() {
        File file = new File("./db/data.db3");
        if (!file.isFile()) {
            try {
                File db = new File("./db");
                if (!db.isFile()) {
                    db.mkdirs();
                }
                InputStream in = LoadConfig.class.getResourceAsStream("/data.db3");
                assert in != null;
                Files.copy(in, file.toPath());
            } catch (Exception e) {
                log.error("创建db数据库失败，错误信息：{}",e.getMessage());
                return false;
            }

        }
        return file.isFile();
    }

    /**
     * 获取操作系统
     * @return 1/Win
     *         2/Linux
     */
    private static int isOs(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("windows")){
            return 1;
        }
        if(os.contains("linux")){
            return 2;
        }

        return 0;
    }

    private static boolean initQQ(){
        String x = System.getProperty("user.dir")+"\\gocqhttp\\go-cqhttp.bat";
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
                    Process exec = Runtime.getRuntime().exec(x);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    if (bufferedReader.readLine() == null){
                        return true;
                    }
                }
                return flg;
            }
            if (file.exists()) {
                if(isRunRedis("go-cqhttp")){
                    Runtime.getRuntime().exec(x);
                }
            }
            return false;
        } catch (GitAPIException e) {
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean initHtml() {
        File file = new File(HTML_PATH);
        if (!file.exists()) {
            try {
                Git.cloneRepository()
                        .setURI("https://gitee.com/KingPrime/ZKBotHtml.git")
                        .setDirectory(file)
                        .call();
                return true;
            } catch (GitAPIException e) {
                log.error("下载Html文件失败：{}",e.getMessage());
                return false;
            }

        }
        return file.exists();
    }
    private static boolean initWinRedis() {
        String x = "cmd /c start "+System.getProperty("user.dir")+"\\Redis\\redis-server.exe "+System.getProperty("user.dir")+"\\Redis\\redis.windows.conf";
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
                    Process exec = Runtime.getRuntime().exec(x);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    if (bufferedReader.readLine() == null){
                        return true;
                    }
                }
                return flg;
            }
            if (file.exists()) {
                if(isRunRedis("redis-server")){
                     Runtime.getRuntime().exec(x);
                }
            }
            return false;
        } catch (GitAPIException e) {
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isRunRedis(String name){
        Runtime run = Runtime.getRuntime();
        try {
             Process exec = run.exec("cmd /c Tasklist");
             BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
             String g;
             while ((g = in.readLine())!=null){
                 g = g.toLowerCase(Locale.ROOT);
                 if (g.contains(name)){
                     return false;
                 }
             }
             return true;
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }


}
