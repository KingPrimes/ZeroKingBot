package com.zkb.common.utils;

import org.springframework.http.HttpMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtils {


    //测试
    /*public static void main(String[] args) {
        saveUrlAs("https://ghproxy.com/https://github.com/KingPrimes/ZeroKingBot/releases/download/4.1.9.0/ZeroKingBot.jar","","ZeroKingBot",HttpMethod.GET,"jar");
    }*/


    /**
     * 功能  文件下载
     *
     * @param filePath 文件将要保存的目录
     * @param method   请求方法，包括POST和GET
     * @param url      请求的路径
     * @param fileName 文件名称
     * @param suffix   后缀名称
     */
    public static void saveUrlAs(String url, String filePath, String fileName, HttpMethod method, String suffix) {
        FileOutputStream fileOut;
        HttpURLConnection conn;
        InputStream inputStream;
        //创建不同的文件夹目录
        File file = new File(filePath);
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
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}
