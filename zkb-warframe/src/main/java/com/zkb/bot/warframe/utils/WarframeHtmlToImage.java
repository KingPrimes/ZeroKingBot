package com.zkb.bot.warframe.utils;

import com.zkb.bot.warframe.dao.HintList;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.htmltoimage.RenderToImage;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.uuid.UUID;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class WarframeHtmlToImage {

    private static final Logger log = LoggerFactory.getLogger(WarframeHtmlToImage.class);

    private static final String HTML_PATH = "./ZKBotHtml/";


    /**
     * 获取宽度
     *
     * @param html html文档
     * @return 宽度
     */
    public static int getWidth(String html) {
        Document doc = Jsoup.parse(html);
        int width = 500;
        //判断是否添加宽度标签
        if (!doc.getElementsByTag("w").isEmpty()) {
            String num = doc.getElementsByTag("w").text();
            if (StringUtils.isNumber(num)) width = Integer.parseInt(num);

        }
        return width;
    }

    /**
     * 删除不相干的字段
     *
     * @param html html 文档
     * @return 格式化之后的 html文档
     */
    public static String outH(String html) {
        html = html.replaceAll("<!--", "<xx>").replaceAll("-->", "</xx>");
        Document doc = Jsoup.parse(html);
        if (!doc.getElementsByTag("xx").isEmpty()) {
            int i = doc.getElementsByTag("xx").size();
            System.out.println(i);
            for (; i > 0; i--) {
                html = new StringBuilder(html).replace(html.indexOf("<xx>"), html.indexOf("</xx>") + 5, "").toString().trim();
            }
        }
        if (!doc.getElementsByTag("w").isEmpty()) {
            html = new StringBuilder(html).replace(html.indexOf("<w>"), html.indexOf("</w>") + 4, "").toString().trim();
        }
        html = html.replaceAll("/css/{0,}", "./css/")
                .replaceAll("/img/{0,}", "./img/");
        StringBuilder str = new StringBuilder(html);
        ;
        str.insert(str.indexOf("</body>"), "<div class=\"foot-by\">\n" +
                "\tPosted by:KingPrimes<br/>\n" +
                "\t" +
                HintList.getHint() +
                "\n</div>\n");
        return str.toString();
    }

    /***
     * 根据Html文本生成图片字节流
     * @param name html文件名称
     * @param html html文本
     * @param width 图片宽度
     * @return 字节流
     */
    public static ByteArrayOutputStream tmpHtmlToImageByteArray(String name, String html, int width) {
        String path = HTML_PATH;
        path = path + "/" + name + ".html";
        try {
            FileOutputStream fo = new FileOutputStream(path);
            OutputStreamWriter os = new OutputStreamWriter(fo, StandardCharsets.UTF_8);
            os.write(html);
            os.flush();
            os.close();
        } catch (Exception e) {
            log.error("生成临时文件出错\n\t\t文件名称：{}\n\t\t错误信息：{}", name, e.getMessage());
        }
        return convertHtmlToImage(path, width);
    }

    /***
     * 根据Html文本生成图片字节流
     * @param html html文本
     * @param width 图片宽度
     * @return 字节流
     */
    public static ByteArrayOutputStream tmpHtmlToImageByteArray(String html, int width) {
        String path = HTML_PATH;
        path = path + "/" + UUID.fastUUID() + ".html";
        try {
            FileOutputStream fo = new FileOutputStream(path);
            OutputStreamWriter os = new OutputStreamWriter(fo, StandardCharsets.UTF_8);
            os.write(html);
            os.flush();
            os.close();
        } catch (Exception e) {
            log.error("生成临时文件出错\n\t\t地址：{}\n\t\t错误信息：{}", path, e.getMessage());
        }
        return convertHtmlToImage(path, width);
    }

    /**
     * html 文档转成 字节流
     *
     * @param htmlFilePath html文件路径
     * @param width        生成图片的宽度
     * @return 字节流
     */
    private static ByteArrayOutputStream convertHtmlToImage(String htmlFilePath, int width) {
        try {
            File htmlFile = new File(htmlFilePath);
            String url = htmlFile.toURI().toURL().toExternalForm();
            BufferedImage image = RenderToImage.renderToImageAutoSize(url, width, BufferedImage.TYPE_INT_ARGB_PRE);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            htmlFile.delete();
            return os;
        } catch (IOException e) {
            log.error("html渲染字节流出错，文件路径：{}\n\t\t错误信息：{}", htmlFilePath, e.getMessage());
        }
        return null;
    }

    /**
     * @param url Html Url地址
     * @return
     */
    public static ByteArrayOutputStream conver(String url) {
        String html = HttpUtils.sendGetOkHttp(url);
        System.out.println(html);
        int width = getWidth(html);
        html = outH(html);
        return tmpHtmlToImageByteArray(html, width);
    }

}
