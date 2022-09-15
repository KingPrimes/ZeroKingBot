package com.zkb.bot.imagetogif.utils;

import com.zkb.common.load.LoadConfig;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.util.FS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class GitPng {

    public static final String PATH = System.getProperty("user.dir") + "\\temp-png\\";

    private static final Logger log = LoggerFactory.getLogger(LoadConfig.class);

    /**
     * 获取GitCode图片仓库
     *
     * @return 是否下载完毕
     */
    public static boolean getInitPng() {
        try {
            File file = new File("./temp-png");
            if (!file.exists()) {
                Git.cloneRepository().setURI("https://gitcode.net/KingPrimes/zerokingbot-gif.git").setDirectory(file).call();
            }
            return RepositoryCache.FileKey.isGitRepository(file, FS.DETECTED);
        } catch (Exception e) {
            log.error("获取GIF底图失败：{}", e.getMessage());
            return true;
        }
    }
}
