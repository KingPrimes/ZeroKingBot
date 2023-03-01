package com.zkb.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtils {

    static Logger log = LoggerFactory.getLogger(DownLoadUtils.class);


    /**
     * 功能  文件下载
     *
     * @param filePath 文件将要保存的目录
     * @param method   请求方法，包括POST和GET
     * @param url      请求的路径
     * @param fileName 文件名称
     * @param suffix   后缀名称
     */
    public static boolean saveUrlAs(String url, String filePath, String fileName, HttpMethod method, String suffix) {
        FileOutputStream fileOut;
        HttpURLConnection conn;
        InputStream inputStream;
        //创建不同的文件夹目录
        File file = new File(filePath);
        file.delete();
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }

        try {
            // 建立链接
            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod(method.name());
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {
                filePath += "/";
            }
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            fileOut = new FileOutputStream(filePath + fileName + "." + suffix);
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] bt = new byte[4096];
            int length = bis.read(bt);
            //保存文件
            while (length != -1) {
                bos.write(bt, 0, length);
                length = bis.read(bt);
            }
            bos.close();
            bis.close();
            conn.disconnect();
            return true;
        } catch (Exception e) {
            log.error("文件下载错误："+e.getMessage());
            return false;
        }
    }


}
