package com.twg.imagetest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.twg.common.utils.StringUtils;
import com.twg.common.utils.file.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.simple.Graphics2DRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlToImageUtils {
    private static final int WIDTH = 1024;
    private static final String IMAGE_FORMAT = "png";
    private static final String HTML_PATH = "./twg-html/";

    private void convertHtmlToImage(String htmlFilePath, String imageFilePath, int width) {
        try {
            File htmlFile = new File(htmlFilePath);
            String url = htmlFile.toURI().toURL().toExternalForm();
            BufferedImage image = Graphics2DRenderer.renderToImageAutoSize(url, width, BufferedImage.TYPE_INT_ARGB);
            ImageIO.write(image, IMAGE_FORMAT, new File(imageFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertHtmlToImage() {
        //String html = HttpUtils.sendGetOkHttp("https://overframe.gg/items/arsenal/5874/%E6%B8%85%E5%88%9A/");
        convertHtmlToImage("./test.html", "./test.png", 4096);
        //tmpHtmlToImageByteArray("test",image,html,800);

    }

    private void tmpHtmlToImageByteArray(String name, String image, String html, int width) {
        String path = HTML_PATH;
        FileUtils.isMkdirs(path + "tmp");
        path = path + "tmp/" + name + ".html";
        try {
            FileOutputStream fo = new FileOutputStream("./" + name + ".html");
            OutputStreamWriter os = new OutputStreamWriter(fo, StandardCharsets.UTF_8);
            os.write(html);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        convertHtmlToImage(path, image, width);
    }

    public void updateHtml(String imageFilePath) throws IOException {
        String json = "{ \"activation\": 1659305100000,\n" +
                "                \"archwing\": false,\n" +
                "                \"enemy\": \"Corpus\",\n" +
                "                \"expiry\": 1659308640000,\n" +
                "                \"node\": \"Valefor (Europa)\",\n" +
                "                \"sharkwing\": false,\n" +
                "                \"type\": \"Excavation\"}";
        JSONObject object = JSON.parseObject(json);
        String html = FileUtils.getFileString(HTML_PATH + "arbitration.html");
        Document doc = Jsoup.parse(html);
        int width = 500;
        //判断是否添加宽度标签
        if (!doc.getElementsByTag("w").isEmpty()) {
            String num = doc.getElementsByTag("w").text();
            if (StringUtils.isNumber(num)) width = Integer.parseInt(num);
            html = new StringBuilder(html).replace(html.indexOf("<w>"), html.indexOf("</w>") + 4, "").toString();
        }
        html = html.replaceAll("<!--", "<xx>").replaceAll("-->", "</xx>");
        doc = Jsoup.parse(html);
        if (!doc.getElementsByTag("xx").isEmpty()) {
            int i = doc.getElementsByTag("xx").size();
            for (; i > 0; i--) {
                html = new StringBuilder(html).replace(html.indexOf("<xx>"), html.indexOf("</xx>") + 5, "").toString();
            }
        }


        if (html.contains("#table")) {
            String str = "<table>" +
                    "<tr>" +
                    "<td>" +
                    "任务地点" +
                    "</td>" +
                    "<td>" +
                    object.getString("node") +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "派系" +
                    "</td>" +
                    "<td>" +
                    object.getString("enemy") +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "任务类型" +
                    "</td>" +
                    "<td>" +
                    object.getString("type") +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "距离结束" +
                    "</td>" +
                    "<td>" +
                    object.getString("expiry") +
                    "</td>" +
                    "</tr>" +
                    "</table>";
            html = html.replace("#table", str);
        }
        if (html.contains("#Date")) {
            String str = "<tr>" +
                    "<td>" +
                    "任务地点" +
                    "</td>" +
                    "<td>" +
                    object.getString("node") +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "派系" +
                    "</td>" +
                    "<td>" +
                    object.getString("enemy") +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "任务类型" +
                    "</td>" +
                    "<td>" +
                    object.getString("type") +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "距离结束" +
                    "</td>" +
                    "<td>" +
                    object.getString("expiry") +
                    "</td>" +
                    "</tr>";
            html = html.replace("#Date", str);
        }
        if (html.contains("#Node")) {
            html = html.replace("#Node", object.getString("node"));
        }
        if (html.contains("#Ene")) {
            html = html.replace("#Ene", object.getString("enemy"));
        }
        if (html.contains("#Type")) {
            html = html.replace("#Type", object.getString("type"));
        }
        if (html.contains("#End")) {
            html = html.replace("#End", object.getString("expiry"));
        }
        String path = HTML_PATH;
        if (!isOk(path + "tem")) {
            return;
        }
        path = path + "tem/arbitration.html";

        PrintStream print = new PrintStream(Files.newOutputStream(Paths.get(path)));
        print.println(html.trim());
        print.close();

        convertHtmlToImage(path, imageFilePath, width);
    }

    private boolean isOk(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

}
