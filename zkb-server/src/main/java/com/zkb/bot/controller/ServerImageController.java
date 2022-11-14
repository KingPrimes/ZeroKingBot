package com.zkb.bot.controller;

import com.zkb.common.utils.JarManifest;
import com.zkb.common.utils.JarUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.file.FileUtils;
import com.zkb.common.utils.htmltoimage.RenderToImage;
import com.zkb.framework.web.domain.Server;
import com.zkb.framework.web.domain.server.Cpu;
import com.zkb.framework.web.domain.server.Jvm;
import com.zkb.framework.web.domain.server.Mem;
import com.zkb.framework.web.domain.server.Sys;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.jar.Manifest;

@RestController
@RequestMapping("/server")
public class ServerImageController {

    private static final Logger log = LoggerFactory.getLogger(ServerImageController.class);

    Manifest manifestFromClasspath = JarManifest.getManifestFromClasspath(ServerImageController.class);

    @GetMapping
    public void getServerInfoImage(HttpServletResponse response) {
        response.setHeader("Content-Type", "image/gif");
        try {
            Server server = new Server();
            server.copyTo();
            response.getOutputStream().write(infoServer(server));
        } catch (Exception e) {
            log.error("获取Server信息出错：{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private byte[] infoServer(Server server) throws IOException {
        Cpu cpu = server.getCpu();
        Jvm jvm = server.getJvm();
        Mem mem = server.getMem();
        Sys sys = server.getSys();
        String version = "";
        if(JarUtils.isStartupFromJarEx(ServerImageController.class)){
            version = manifestFromClasspath.getMainAttributes().getValue("ZeroKingBot-Version");
        }
        String path = "./ZKBotHtml/tmp";
        FileUtils.isMkdirs(path);
        path = path + "/server.html";
        String html = FileUtils.getFileString("./ZKBotHtml/html/server.html");
        html = html.replace("#CpuNum", String.valueOf(cpu.getCpuNum()))
                .replace("#CpuUsed", String.valueOf(cpu.getUsed()))
                .replace("#CpuSys", String.valueOf(cpu.getSys()))
                .replace("#CpuFree", String.valueOf(cpu.getFree()))

                .replace("#MemTotal", String.valueOf(mem.getTotal()))
                .replace("#JvmTotal", String.valueOf(jvm.getTotal()))

                .replace("#MemUsed", String.valueOf(mem.getUsed()))
                .replace("#JvmUsed", String.valueOf(jvm.getUsed()))

                .replace("#MemFree", String.valueOf(mem.getFree()))
                .replace("#JvmFree", String.valueOf(jvm.getFree()))

                .replace("#MemUsage", String.valueOf(mem.getUsage()))
                .replace("#JvmUsage", String.valueOf(jvm.getUsage()))

                .replace("#ServerName", sys.getComputerName())
                .replace("#OsName", sys.getOsName())

                .replace("#Version", version)
                .replace("#OsArch", sys.getOsArch())

                .replace("#JavaName", jvm.getName())
                .replace("#JavaVersion", jvm.getVersion())

                .replace("#StarTime", jvm.getStartTime())
                .replace("#RunTime", jvm.getRunTime())

        ;
        int width = getWidth(html);
        Document doc = Jsoup.parse(html);
        if (!doc.getElementsByTag("w").isEmpty()) {
            html = new StringBuilder(html).replace(html.indexOf("<w>"), html.indexOf("</w>") + 4, "").toString().trim();
        }
        FileOutputStream fo = new FileOutputStream(path);
        OutputStreamWriter wos = new OutputStreamWriter(fo, StandardCharsets.UTF_8);
        wos.write(html);
        wos.flush();
        wos.close();
        File htmlFile = new File(path);
        String url = htmlFile.toURI().toURL().toExternalForm();
        BufferedImage image = RenderToImage.renderToImageAutoSize(url, width, BufferedImage.TYPE_INT_ARGB_PRE);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        return os.toByteArray();
    }

    private int getWidth(String html) {
        Document doc = Jsoup.parse(html);
        int width = 500;
        //判断是否添加宽度标签
        if (!doc.getElementsByTag("w").isEmpty()) {
            String num = doc.getElementsByTag("w").text();
            if (StringUtils.isNumber(num)) width = Integer.parseInt(num);

        }

        return width;
    }

}
