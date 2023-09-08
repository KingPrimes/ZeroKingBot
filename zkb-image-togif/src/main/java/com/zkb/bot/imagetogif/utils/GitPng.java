package com.zkb.bot.imagetogif.utils;

import java.io.File;

public class GitPng {

    public static final String PATH = System.getProperty("user.dir") + "\\emoji_file\\";

    /**
     * 获取GitCode图片仓库
     *
     * @return 是否下载完毕
     */
    public static boolean getInitPng() {
        File file = new File("./emoji_file");
        return !file.exists();
    }
}
