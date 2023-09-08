package com.zkb.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.zkb.common.core.domain.GitContents;
import com.zkb.common.utils.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


public class GitFiles {

    private static final Logger log = LoggerFactory.getLogger(GitFiles.class);
    static String url = "https://api.github.com/repos/KingPrimes/DataSource/contents/emoji_file";

    public static boolean git(String path) {
        String s = HttpUtils.sendGetOkHttp(url);
        url = "https://api.github.com/repos/KingPrimes/DataSource/contents";
        if (s.isEmpty() || s.equals("timeout")) {
            return false;
        }

        List<GitContents> contents = JSONArray.parseArray(s, GitContents.class);
        File file = new File(path);
        //如果目录不存在则创建目录
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            for (GitContents content : contents) {
                log.debug("一级目录：{}", content.getName());
                file = new File(content.getPath());
                //如果目录不存在则创建目录
                if (!file.exists()) {
                    file.mkdirs();
                }
                log.debug("url:{}",url + "/" + content.getPath());
                //向下级目录便利
                s = HttpUtils.sendGetOkHttp(url + "/" + content.getPath());
                if (s.isEmpty() || s.equals("timeout")) {
                    return false;
                }
                List<GitContents> parsed = JSONArray.parseArray(s, GitContents.class);
                for (GitContents gitContents : parsed) {
                    if (!gitContents.getName().contains(".")) {
                        log.debug("二级目录：{}", gitContents.getName());
                        file = new File(gitContents.getPath());
                        //如果目录不存在则创建目录
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    }

                    //判断下载路径是否是空,不为空则是文件，为空则是目录
                    if (gitContents.getDownloadUrl() != null && !gitContents.getDownloadUrl().isEmpty()) {
                        file = new File(gitContents.getPath());
                        log.debug("文件名称：{} -- 文件是否存在:{}", gitContents.getName(),file.exists());
                        if(!file.exists()){
                            byte[] bytes = HttpUtils.sendGetForFile(gitContents.getDownloadUrl().replaceAll("githubusercontent","gitmirror"));
                            if (bytes != null) {
                                FileOutputStream out = new FileOutputStream(file);
                                out.write(bytes);
                            }
                        }
                    } else {
                        if (!gitContents.getName().contains(".")) {
                            file = new File(gitContents.getPath());
                            //如果目录不存在则创建目录
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                        }
                        //向下级目录便利
                        s = HttpUtils.sendGetOkHttp(url + "/" + gitContents.getPath());
                        if (s.isEmpty() || s.equals("timeout")) {
                            return false;
                        }
                        List<GitContents> p = JSONArray.parseArray(s, GitContents.class);
                        for (GitContents g : p) {
                            if (!g.getName().contains(".")) {
                                log.debug("三级目录：{}", g.getName());
                                file = new File(g.getPath());
                                //如果目录不存在则创建目录
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                            }
                            //判断下载路径是否是空,不为空则是文件，为空则是目录
                            if (g.getDownloadUrl() != null && !g.getDownloadUrl().isEmpty()) {
                                file = new File(g.getPath());
                                log.debug("文件名称：{} -- 文件是否存在:{}", g.getName(),file.exists());
                                if(!file.exists()){
                                    byte[] bytes = HttpUtils.sendGetForFile(g.getDownloadUrl().replaceAll("githubusercontent","gitmirror"));
                                    if (bytes != null) {
                                        FileOutputStream out = new FileOutputStream(g.getPath());
                                        out.write(bytes);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            log.error("下载表情文件出错，错误信息：{}", e.getMessage());
        }
        return false;
    }

}
