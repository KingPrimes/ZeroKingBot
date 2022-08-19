package com.zkb.common.load;

import com.zkb.common.utils.StringUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.util.FS;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadConfig {

    private static final String HTML_PATH = "./ZKBotHtml";
    public static Properties prop = new Properties();

    public static void initConfig() {
        try {
            prop.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/config.ini")));
        } catch (Exception ignored) {
        }
    }

    public static long getAdmin() {
        initConfig();
        String admin = prop.getProperty("admin");
        if (StringUtils.isNumber(admin)) return Long.parseLong(admin);
        return 0;
    }

    //判断配置文件是否存在不存在则新建一个配置文件
    public static boolean WriteConfigFile() {
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

    public static boolean WriteSqlite() {
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
                return false;
            }

        }
        return file.isFile();
    }

    public static boolean initHtml() {
        File file = new File(HTML_PATH);
        if (!file.exists()) {
            try {
                Git.cloneRepository()
                        .setURI("https://gitee.com/KingPrime/ZKBotHtml.git")
                        .setDirectory(file)
                        .call();
                return true;
            } catch (GitAPIException e) {
                return false;
            }

        }
        return file.exists();
    }

    //https://gitcode.net/KingPrimes/win-redis.git
    public static boolean initRedis() {
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
                    Process exec = Runtime.getRuntime().exec("./Redis/setup.bat");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    if (bufferedReader.readLine() == null){
                        return false;
                    }
                    Runtime.getRuntime().exec("net start redis");
                }
                return flg;

            }
            if (file.exists()) {
                Process exec = Runtime.getRuntime().exec("net start redis");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                if(bufferedReader.readLine()==null){
                    Runtime.getRuntime().exec("./Redis/setup.bat");
                    Runtime.getRuntime().exec("net start redis");
                }
            }
            return file.exists();
        } catch (GitAPIException e) {
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
