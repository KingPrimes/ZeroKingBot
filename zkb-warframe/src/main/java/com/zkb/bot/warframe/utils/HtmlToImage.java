package com.zkb.bot.warframe.utils;


import com.zkb.bot.enums.WarframeEnum;
import com.zkb.bot.enums.WarframeSubscribeEnums;
import com.zkb.bot.warframe.dao.*;
import com.zkb.bot.warframe.domain.WarframeRelics;
import com.zkb.bot.warframe.domain.WarframeTranslation;
import com.zkb.bot.warframe.service.*;
import com.zkb.common.utils.DateUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.file.FileUtils;
import com.zkb.common.utils.htmltoimage.RenderToImage;
import com.zkb.common.utils.spring.SpringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class HtmlToImage {

    private static final Logger log = LoggerFactory.getLogger(HtmlToImage.class);

    private static final String HTML_PATH = "./ZKBotHtml/";
    @Autowired
    IWarframeTranslationService trans;

    @Autowired
    IWarframeMarketRivenTionService rts;

    @Autowired
    IWarframeRelicsService relics;

    /**
     * 获取宽度
     *
     * @param html html文档
     * @return 宽度
     */
    private static int getWidth(String html) {
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
    private static String outH(String html) {
        html = html.replaceAll("<!--", "<xx>").replaceAll("-->", "</xx>");
        Document doc = Jsoup.parse(html);
        if (!doc.getElementsByTag("xx").isEmpty()) {
            int i = doc.getElementsByTag("xx").size();
            for (; i > 0; i--) {
                html = new StringBuilder(html).replace(html.indexOf("<xx>"), html.indexOf("</xx>") + 5, "").toString().trim();
            }
        }
        if (!doc.getElementsByTag("w").isEmpty()) {
            html = new StringBuilder(html).replace(html.indexOf("<w>"), html.indexOf("</w>") + 4, "").toString().trim();
        }
        StringBuilder str = new StringBuilder(html);
        str.insert(str.indexOf("</body>"), "<div style=\"text-align: center; background-color: #fffefa;\">\n" +
                "\tPosted by:KingPrimes<br/>\n" +
                "\t" +
                HintList.getHint() +
                "\n</div>\n");
        return str.toString();
    }

    /**
     * html 文档转成 字节流
     *
     * @param htmlFilePath html文件路径
     * @param width        生成图片的宽度
     * @return 字节流
     */
    public static ByteArrayOutputStream convertHtmlToImage(String htmlFilePath, int width) {
        try {
            File htmlFile = new File(htmlFilePath);
            String url = htmlFile.toURI().toURL().toExternalForm();
            BufferedImage image = RenderToImage.renderToImageAutoSize(url, width, BufferedImage.TYPE_INT_ARGB_PRE);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            return os;
        } catch (IOException e) {
            log.error("html渲染字节流出错，文件路径：{}\n\t\t错误信息：{}", htmlFilePath, e.getMessage());
        }
        return null;
    }

    /**
     * 平原图片
     *
     * @return 字节流
     */
    public ByteArrayOutputStream allCycleImage(GlobalStates g) {

        //地球
        GlobalStates.EarthCycle earth = g.getEarthCycle();

        //夜灵平野
        GlobalStates.CetusCycle cetus = g.getCetusCycle();

        //福尔图娜
        GlobalStates.VallisCycle vallis = g.getVallisCycle();

        //魔胎之境
        GlobalStates.CambionCycle cambion = g.getCambionCycle();

        //扎里曼
        GlobalStates.ZarimanCycle zariman = g.getZarimanCycle();

        //Html 文件
        String html = FileUtils.getFileString(HTML_PATH + "html/allCycle.html");

        int width = getWidth(html);
        html = outH(html);

        if (html.contains("#table")) {
            String str = "<h3>---地球---</h3>" +
                    "<table>" +
                    "<tr>" +
                    "<td>" +
                    "状态" +
                    "</td>" +
                    "<td>" +
                    trans.enToZh(earth.getState()) +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "时间" +
                    "</td>" +
                    "<td>" +
                    DateUtils.getDate((earth.getExpiry()), new Date()) +
                    "</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>" +
                    "<h3>---夜灵平野---</h3>" +
                    "<table>" +
                    "<tr>" +
                    "<td>" +
                    "状态" +
                    "</td>" +
                    "<td>" +
                    trans.enToZh(cetus.getState()) +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "时间" +
                    "</td>" +
                    "<td>" +
                    DateUtils.getDate((cetus.getExpiry()), new Date()) +
                    "</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>" +
                    "<h3>---福尔图娜---</h3>" +
                    "<table>" +
                    "<tr>" +
                    "<td>" +
                    "状态" +
                    "</td>" +
                    "<td>" +
                    trans.enToZh(vallis.getState()) +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "时间" +
                    "</td>" +
                    "<td>" +
                    DateUtils.getDate((vallis.getExpiry()), new Date()) +
                    "</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>" +
                    "<h3>---魔胎之境---</h3>" +
                    "<table>" +
                    "<tr>" +
                    "<td>" +
                    "状态" +
                    "</td>" +
                    "<td>" +
                    cambion.getActive().toUpperCase(Locale.ROOT) +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "时间" +
                    "</td>" +
                    "<td>" +
                    DateUtils.getDate((cambion.getExpiry()), new Date()) +
                    "</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br/>" +
                    "<h3>---扎里曼---</h3>" +
                    "<table>" +
                    "<tr>" +
                    "<td>" +
                    "状态" +
                    "</td>" +
                    "<td>" +
                    zariman.getState().toUpperCase(Locale.ROOT) +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "时间" +
                    "</td>" +
                    "<td>" +
                    DateUtils.getDate((zariman.getExpiry()), new Date()) +
                    "</td>" +
                    "</tr>" +
                    "</table>";

            html = html.replaceAll("#table", str);
        }
        //地球
        {
            if (html.contains("#earthType")) {
                html = html.replaceAll("#earthType", trans.enToZh(earth.getState()));
            }
            if (html.contains("#earthEnd")) {
                html = html.replaceAll("#earthEnd", DateUtils.getDate((earth.getExpiry()), new Date()));
            }
        }
        //夜灵平野
        {
            if (html.contains("#cetusType")) {
                html = html.replaceAll("#cetusType", trans.enToZh(cetus.getState()));
            }
            if (html.contains("#cetusEnd")) {
                html = html.replaceAll("#cetusEnd", DateUtils.getDate((cetus.getExpiry()), new Date()));
            }
        }
        //福尔图娜
        {
            if (html.contains("#vallisType")) {
                html = html.replaceAll("#vallisType", trans.enToZh(vallis.getState()));
            }
            if (html.contains("#vallisEnd")) {
                html = html.replaceAll("#vallisEnd", DateUtils.getDate((vallis.getExpiry()), new Date()));
            }
        }
        //魔胎之境
        {
            if (html.contains("#cambionType")) {
                html = html.replaceAll("#cambionType", cambion.getActive().toUpperCase(Locale.ROOT));
            }
            if (html.contains("#cambionEnd")) {
                html = html.replaceAll("#cambionEnd", DateUtils.getDate((cambion.getExpiry()), new Date()));
            }
        }
        //扎里曼
        {
            if (html.contains("#zarimanType")) {
                html = html.replaceAll("#zarimanType", zariman.getState().toUpperCase(Locale.ROOT));
            }
            if (html.contains("#zarimanEnd")) {
                html = html.replaceAll("#zarimanEnd", DateUtils.getDate((zariman.getExpiry()), new Date()));
            }
        }

        return tmpHtmlToImageByteArray("allCycle", html, width);

    }

    /**
     * 仲裁 Html 转 图片
     *
     * @param arbitration 数据
     * @return 字节流
     */
    public ByteArrayOutputStream arbitrationImage(GlobalStates.Arbitration arbitration) {
        String html = FileUtils.getFileString(HTML_PATH + "html/arbitration.html");
        int width = getWidth(html);
        html = outH(html);
        String node = arbitration.getNode().
                replace(
                        StringUtils.quStr(arbitration.getNode()),
                        trans.enToZh(StringUtils.quStr(arbitration.getNode())
                        )
                );
        if (html.contains("#table")) {

            String str = "<table>" +
                    "<tr>" +
                    "<td>" +
                    "任务地点" +
                    "</td>" +
                    "<td>" +
                    node +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "派系" +
                    "</td>" +
                    "<td>" +
                    arbitration.getEnemy() +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "任务类型" +
                    "</td>" +
                    "<td>" +
                    trans.enToZh(arbitration.getType()) +
                    "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +
                    "距离结束" +
                    "</td>" +
                    "<td>" +
                    DateUtils.getDate((arbitration.getExpiry()), new Date()) +
                    "</td>" +
                    "</tr>" +
                    "</table>";
            html = html.replaceAll("#table", str);
        }
        if (html.contains("#Node")) {
            html = html.replaceAll("#Node", node);
        }
        if (html.contains("#Ene")) {
            html = html.replaceAll("#Ene", arbitration.getEnemy());
        }
        if (html.contains("#Type")) {
            html = html.replaceAll("#Type", trans.enToZh(arbitration.getType()));
        }
        if (html.contains("#End")) {
            html = html.replaceAll("#End", DateUtils.getDate((arbitration.getExpiry()), new Date()));
        }

        return tmpHtmlToImageByteArray("arbitration", html, width);
    }

    /**
     * 突击图片
     *
     * @param sortie 数据
     * @return 图片 字节流
     */
    public ByteArrayOutputStream assaultImage(GlobalStates.Sortie sortie) {
        String html = FileUtils.getFileString(HTML_PATH + "html/assault.html");
        int width = getWidth(html);
        html = outH(html);

        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str

                    .append("<h3>今天是由：[")
                    .append(sortie.getBoss())
                    .append("]主导的突击任务</h3>")
                    .append("<h3>派系：[")
                    .append(sortie.getFaction())
                    .append("]</h3>")
                    .append("<h3>任务结束：")
                    .append(DateUtils.getDate((sortie.getExpiry()), new Date()))
                    .append("</h3>")
                    .append("<h3>---任务详情---</h3>")
                    .append("<div class=\"assault\">")

            ;
            for (GlobalStates.Sortie.Variants variant : sortie.getVariants()) {
                str.append("<table>")
                        .append("<tr><td>任务地址：")
                        .append(variant.getNode()
                                .replace(
                                        StringUtils.quStr(
                                                variant.getNode()),
                                        trans.enToZh(StringUtils.quStr(variant.getNode()))))
                        .append("</td></tr>")
                        .append("<tr><td>任务类型：")
                        .append(trans.enToZh(variant.getMissionType()))
                        .append("</td></tr>")
                        .append("<tr><td>状态：")
                        .append(trans.enToZh(variant.getModifier()))
                        .append("</td></tr>")
                        .append("</table>");
            }

            str
                    .append("</div>")
            ;
            html = html.replaceAll("#table", str.toString());
        }

        if (!html.contains("#table")) {
            if (html.contains("#Boss")) {
                html = html.replaceAll("#Boss", sortie.getBoss());
            }

            if (html.contains("#Ene")) {
                html = html.replaceAll("#Ene", sortie.getFaction());
            }
            if (html.contains("#End")) {
                html = html.replaceAll("#End", DateUtils.getDate((sortie.getExpiry()), new Date()));
            }
            if (html.contains("#Deta")) {
                StringBuilder str = new StringBuilder();
                for (GlobalStates.Sortie.Variants variant : sortie.getVariants()) {
                    str.append("<table>")
                            .append("<tr><td>任务地址：")
                            .append(variant.getNode()
                                    .replace(
                                            StringUtils.quStr(
                                                    variant.getNode()),
                                            trans.enToZh(StringUtils.quStr(variant.getNode()))))
                            .append("</td></tr>")
                            .append("<tr><td>任务类型：")
                            .append(trans.enToZh(variant.getMissionType()))
                            .append("</td></tr>")
                            .append("<tr><td>状态：")
                            .append(trans.enToZh(variant.getModifier()))
                            .append("</td></tr>")
                            .append("</table>");
                }
                html = html.replaceAll("#Deta", str.toString());
            } else {
                int i = 1;
                for (GlobalStates.Sortie.Variants variant : sortie.getVariants()) {
                    String node = variant.getNode()
                            .replace(
                                    StringUtils.quStr(
                                            variant.getNode()),
                                    trans.enToZh(StringUtils.quStr(variant.getNode())));

                    if (html.contains("#Node" + i)) {
                        html = html.replaceAll("#Node" + i, node);
                    }

                    if (html.contains("#Type" + i)) {
                        html = html.replaceAll("#Type" + i, trans.enToZh(variant.getMissionType()));
                    }
                    if (html.contains("#State" + i)) {
                        html = html.replaceAll("#State" + i, trans.enToZh(variant.getModifier()));
                    }
                    i++;
                }
            }
        }

        return tmpHtmlToImageByteArray("assault", html, width);
    }

    /**
     * 执政官突击
     *
     * @param archonHunt 数据
     * @return 图片字节流
     */
    public ByteArrayOutputStream archonHuntImage(GlobalStates.ArchonHunt archonHunt) {
        String html = FileUtils.getFileString(HTML_PATH + "html/assault.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str

                    .append("<h3>本次的执政官突击是由：[")
                    .append(archonHunt.getBoss())
                    .append("]主导</h3>")
                    .append("<h3>派系：[")
                    .append(archonHunt.getFaction())
                    .append("]</h3>")
                    .append("<h3>任务结束：")
                    .append(DateUtils.getDate((archonHunt.getExpiry()), new Date()))
                    .append("</h3>")
                    .append("<h3>---任务详情---</h3>")
                    .append("<div class=\"assault\">")

            ;
            for (GlobalStates.ArchonHunt.Mission variant : archonHunt.getMissions()) {
                str.append("<table>")
                        .append("<tr><td>任务地址：")
                        .append(variant.getNode()
                                .replace(
                                        StringUtils.quStr(
                                                variant.getNode()),
                                        trans.enToZh(StringUtils.quStr(variant.getNode()))))
                        .append("</td></tr>")
                        .append("<tr><td>任务类型：")
                        .append(trans.enToZh(variant.getType()))
                        .append("</td></tr>")
                        .append("</table>");
            }

            str
                    .append("</div>")
            ;
            html = html.replaceAll("#table", str.toString());
        }

        if (!html.contains("#table")) {
            if (html.contains("#Boss")) {
                html = html.replaceAll("#Boss", archonHunt.getBoss());
            }

            if (html.contains("#Ene")) {
                html = html.replaceAll("#Ene", archonHunt.getFaction());
            }
            if (html.contains("#End")) {
                html = html.replaceAll("#End", DateUtils.getDate((archonHunt.getExpiry()), new Date()));
            }
            if (html.contains("#Deta")) {
                StringBuilder str = new StringBuilder();
                for (GlobalStates.ArchonHunt.Mission variant : archonHunt.getMissions()) {
                    str.append("<table>")
                            .append("<tr><td>任务地址：")
                            .append(variant.getNode()
                                    .replace(
                                            StringUtils.quStr(
                                                    variant.getNode()),
                                            trans.enToZh(StringUtils.quStr(variant.getNode()))))
                            .append("</td></tr>")
                            .append("<tr><td>任务类型：")
                            .append(trans.enToZh(variant.getType()))
                            .append("</td></tr>")
                            .append("</table>");
                }
                html = html.replaceAll("#Deta", str.toString());
            } else {
                int i = 1;
                for (GlobalStates.ArchonHunt.Mission variant : archonHunt.getMissions()) {
                    String node = variant.getNode()
                            .replace(
                                    StringUtils.quStr(
                                            variant.getNode()),
                                    trans.enToZh(StringUtils.quStr(variant.getNode())));

                    if (html.contains("#Node" + i)) {
                        html = html.replaceAll("#Node" + i, node);
                    }

                    if (html.contains("#Type" + i)) {
                        html = html.replaceAll("#Type" + i, trans.enToZh(variant.getType()));
                    }
                    i++;
                }
            }
        }

        return tmpHtmlToImageByteArray("assault", html, width);
    }

    /**
     * 每日特惠图片
     *
     * @param deals 数据
     * @return 图片字节流
     */
    public ByteArrayOutputStream dailyDealsImage(GlobalStates.DailyDeals deals) {
        String html = FileUtils.getFileString(HTML_PATH + "html/daily.html");
        int width = getWidth(html);
        html = outH(html);
        String item = trans.enToZh(deals.getItem());
        Integer origin = deals.getOriginalPrice();
        Integer sale = deals.getSalePrice();
        String discount = deals.getDiscount() + "%";
        if (deals.getTotal() - deals.getSold() == 0) {
            deals.setSold(deals.getTotal());
        } else if (deals.getTotal() - deals.getSold() == deals.getTotal()) {
            deals.setSold(0);
        } else {
            deals.setSold(deals.getTotal() - deals.getSold());
        }
        Integer total = deals.getTotal();
        Integer sold = deals.getSold();
        String endTime = DateUtils.getDate(deals.getExpiry(), new Date());

        if (html.contains("#table")) {
            String str = "<table><tr><td>物品名称：" +
                    item +
                    "</td></tr>" +
                    "<tr><td>原价/现价：" +
                    origin +
                    "/" +
                    sale +
                    "</td></tr>" +
                    "<tr><td>折扣比：" +
                    discount +
                    "</td></tr>" +
                    "<tr><td>总/余：" +
                    total +
                    "/" +
                    sold +
                    "</td></tr><tr><td>剩余时间：" +
                    endTime +
                    "</td></tr>" +
                    "</table>";
            html = html.replaceAll("#table", str);
        }
        if (!html.contains("#table")) {
            if (html.contains("#Item")) {
                html = html.replaceAll("#Item", item);
            }
            if (html.contains("#Origin")) {
                html = html.replaceAll("#Origin", String.valueOf(origin));
            }
            if (html.contains("#Sale")) {
                html = html.replaceAll("#Sale", String.valueOf(sale));
            }
            if (html.contains("#Discount")) {
                html = html.replaceAll("#Discount", discount);
            }
            if (html.contains("#Total")) {
                html = html.replaceAll("#Total", String.valueOf(total));
            }
            if (html.contains("#Sold")) {
                html = html.replaceAll("#Sold", String.valueOf(sold));
            }
            if (html.contains("#End")) {
                html = html.replaceAll("#End", endTime);
            }
        }
        return tmpHtmlToImageByteArray("daily", html, width);
    }

    /**
     * 裂隙图片
     *
     * @param fiss 数据
     * @return 图片 字节流
     */
    public ByteArrayOutputStream fissuesImage(FissureList fiss) {
        String html = FileUtils.getFileString(HTML_PATH + "html/fissues.html");
        int width = getWidth(html);
        html = outH(html);

        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str
                    .append("<h3>---古纪裂隙---</h3><table class=\"t1\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>")
            ;
            for (GlobalStates.Fissures fissure : fiss.getT1()) {
                str
                        .append("<tr><td>")
                        .append(fissure.getNode())
                        .append("</td><td>")
                        .append(fissure.getMissionType())
                        .append("</td><td>")
                        .append(fissure.getEta())
                        .append("</td></tr>")
                ;

            }
            str.append("</table><h3>---前纪裂隙---</h3><table class=\"t2\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");

            for (GlobalStates.Fissures fissure : fiss.getT2()) {
                str
                        .append("<tr><td>")
                        .append(fissure.getNode())
                        .append("</td><td>")
                        .append(fissure.getMissionType())
                        .append("</td><td>")
                        .append(fissure.getEta())
                        .append("</td></tr>")
                ;

            }
            str.append("</table><h3>---中纪裂隙---</h3><table class=\"t3\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
            for (GlobalStates.Fissures fissure : fiss.getT3()) {
                str
                        .append("<tr><td>")
                        .append(fissure.getNode())
                        .append("</td><td>")
                        .append(fissure.getMissionType())
                        .append("</td><td>")
                        .append(fissure.getEta())
                        .append("</td></tr>")
                ;

            }

            str.append("</table><h3>---后纪裂隙---</h3><table class=\"t4\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
            for (GlobalStates.Fissures fissure : fiss.getT4()) {
                str
                        .append("<tr><td>")
                        .append(fissure.getNode())
                        .append("</td><td>")
                        .append(fissure.getMissionType())
                        .append("</td><td>")
                        .append(fissure.getEta())
                        .append("</td></tr>")
                ;

            }

            str.append("</table><h3>---安魂裂隙---</h3><table class=\"t5\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
            for (GlobalStates.Fissures fissure : fiss.getT5()) {
                str
                        .append("<tr><td>")
                        .append(fissure.getNode())
                        .append("</td><td>")
                        .append(fissure.getMissionType())
                        .append("</td><td>")
                        .append(fissure.getEta())
                        .append("</td></tr>")
                ;

            }
            str.append("</table>");

            html = html.replaceAll("#table", str.toString());
        }

        if (!html.contains("#table")) {
            if (html.contains("#T1")) {
                StringBuilder str = new StringBuilder();
                str.append("<table class=\"t1\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
                for (GlobalStates.Fissures fissure : fiss.getT1()) {
                    str
                            .append("<tr><td>")
                            .append(fissure.getNode())
                            .append("</td><td>")
                            .append(fissure.getMissionType())
                            .append("</td><td>")
                            .append(fissure.getEta())
                            .append("</td></tr>")
                    ;

                }
                str.append("</table>");
                html = html.replaceAll("#T1", str.toString());
            }
            if (html.contains("#T2")) {
                StringBuilder str = new StringBuilder();
                str.append("<table class=\"t2\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
                for (GlobalStates.Fissures fissure : fiss.getT2()) {
                    str
                            .append("<tr><td>")
                            .append(fissure.getNode())
                            .append("</td><td>")
                            .append(fissure.getMissionType())
                            .append("</td><td>")
                            .append(fissure.getEta())
                            .append("</td></tr>")
                    ;

                }
                str.append("</table>");
                html = html.replaceAll("#T2", str.toString());
            }
            if (html.contains("#T3")) {
                StringBuilder str = new StringBuilder();
                str.append("<table class=\"t3\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
                for (GlobalStates.Fissures fissure : fiss.getT3()) {
                    str
                            .append("<tr><td>")
                            .append(fissure.getNode())
                            .append("</td><td>")
                            .append(fissure.getMissionType())
                            .append("</td><td>")
                            .append(fissure.getEta())
                            .append("</td></tr>")
                    ;

                }
                str.append("</table>");
                html = html.replaceAll("#T3", str.toString());
            }
            if (html.contains("#T4")) {
                StringBuilder str = new StringBuilder();
                str.append("<table class=\"t4\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
                for (GlobalStates.Fissures fissure : fiss.getT4()) {
                    str
                            .append("<tr><td>")
                            .append(fissure.getNode())
                            .append("</td><td>")
                            .append(fissure.getMissionType())
                            .append("</td><td>")
                            .append(fissure.getEta())
                            .append("</td></tr>")
                    ;

                }
                str.append("</table>");
                html = html.replaceAll("#T4", str.toString());
            }
            if (html.contains("#T5")) {
                StringBuilder str = new StringBuilder();
                str.append("<table class=\"t5\"><tr><th>任务地点</th><th>任务类型</th><th>距离结束</th></tr>");
                for (GlobalStates.Fissures fissure : fiss.getT5()) {
                    str
                            .append("<tr><td>")
                            .append(fissure.getNode())
                            .append("</td><td>")
                            .append(fissure.getMissionType())
                            .append("</td><td>")
                            .append(fissure.getEta())
                            .append("</td></tr>")
                    ;

                }
                str.append("</table>");
                html = html.replaceAll("#T5", str.toString());
            }
        }

        return tmpHtmlToImageByteArray("fissues", html, width);
    }

    /**
     * 入侵图片
     *
     * @return 图片字节流
     */
    public ByteArrayOutputStream invasionsImage(GlobalStates g) {
        String html = FileUtils.getFileString(HTML_PATH + "html/invasions.html");
        int width = getWidth(html);
        html = outH(html);
        List<GlobalStates.Invasions> invasions = g.getInvasions();

        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str.append("<table class=\"invasions\"><tr><th>任务地点</th><th>攻方奖励</th><th>守方奖励</th><th>攻击进度</th></tr>");
            for (GlobalStates.Invasions invasion : invasions) {
                if (!invasion.getCompleted()) {
                    String att = "无";
                    String def = "无";
                    if (invasion.getAttackerReward().getCountedItems().size() > 0) {
                        att = trans.enToZh(invasion.getAttackerReward().getCountedItems().get(0).getType());
                    }
                    if (invasion.getDefenderReward().getCountedItems().size() > 0) {
                        def = trans.enToZh(invasion.getDefenderReward().getCountedItems().get(0).getType());
                    }
                    str
                            .append("<tr><td>")
                            .append(invasion.getNode().replace(StringUtils.quStr(invasion.getNode()), trans.enToZh(StringUtils.quStr(invasion.getNode()))))
                            .append("</td><td>")
                            .append(att)
                            .append("</td><td>")
                            .append(def)
                            .append("</td><td>")
                            .append(String.format("%.2f", Double.valueOf(invasion.getCompletion())))
                            .append("%</td></tr>")

                    ;
                }
            }
            str.append("</table>");
            html = html.replaceAll("#table", str.toString());
        }

        return tmpHtmlToImageByteArray("invasions", html, width);
    }

    /**
     * 电波图片
     *
     * @param n 数据
     * @return 图片字节流
     */
    public ByteArrayOutputStream nighTwaveImage(Nightwave n) {
        String html = FileUtils.getFileString(HTML_PATH + "html/nighTwave.html");
        int width = getWidth(html);
        html = outH(html);

        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str
                    .append("<h3>---每日挑战---</h3>");
            for (GlobalStates.Nightwave.ActiveChallenges activeChallenges : n.getDaily()) {
                str
                        .append("<p class=\"day\">")
                        .append(activeChallenges.getDesc())
                        .append("(")
                        .append(activeChallenges.getReputation())
                        .append(")</p>");
            }
            str.append("<h3>---每周挑战---</h3>");
            for (GlobalStates.Nightwave.ActiveChallenges activeChallenges : n.getWeek()) {
                str
                        .append("<p class=\"week\">")
                        .append(activeChallenges.getDesc())
                        .append("(")
                        .append(activeChallenges.getReputation())
                        .append(")</p>");
            }
            str.append("<h3>---精英挑战---</h3>");
            for (GlobalStates.Nightwave.ActiveChallenges activeChallenges : n.getElite()) {
                str
                        .append("<p class=\"elite\">")
                        .append(activeChallenges.getDesc())
                        .append("(")
                        .append(activeChallenges.getReputation())
                        .append(")</p>");
            }

            html = html.replaceAll("#table", str.toString());

        }


        return tmpHtmlToImageByteArray("nighTwave", html, width);
    }

    /**
     * 钢铁图片
     *
     * @param state 数据
     * @return 字节流
     */
    public ByteArrayOutputStream steePathImage(GlobalStates.SteelPath state) {
        String html = FileUtils.getFileString(HTML_PATH + "html/steePath.html");
        int width = getWidth(html);
        html = outH(html);

        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            String key = "";
            for (int i = 0; i < state.getRotation().size(); i++) {
                if (state.getCurrentReward().getName().equals(state.getRotation().get(i).getName())) {
                    if (i + 1 < state.getRotation().size()) {
                        key = state.getRotation().get(i + 1).getName();
                    } else {
                        key = state.getRotation().get(0).getName();
                    }
                    break;
                }
            }
            key = trans.enToZh(key);
            str
                    .append("<table><tr><td>本周奖励</td><td>")
                    .append(trans.enToZh(state.getCurrentReward().getName()))
                    .append("</td></tr><tr><td>所需精华</td><td>")
                    .append(state.getCurrentReward().getCost())
                    .append("</td></tr><tr><td>剩余时间</td><td>")
                    .append(DateUtils.getDateWeek(state.getActivation(), new Date(), Calendar.DAY_OF_MONTH, 7))
                    .append("</td></tr><tr><td>下次奖励</td><td>")
                    .append(key)
                    .append("</td></tr></table>");


            html = html.replaceAll("#table", str.toString());


        }

        return tmpHtmlToImageByteArray("steePath", html, width);
    }

    /**
     * 奸商图片
     *
     * @param v 数据
     * @return 图片字节流
     */
    public ByteArrayOutputStream voidImage(GlobalStates.VoidTrader v) {
        String html = FileUtils.getFileString(HTML_PATH + "html/voidTrader.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            String location = v.getLocation().replace(
                    StringUtils.quStr(v.getLocation()),
                    trans.enToZh(StringUtils.quStr(v.getLocation()))
            );
            StringBuilder str = new StringBuilder();

            if (v.getInventory().size() != 0) {
                str.append("<table class=\"voidTrader\">")
                        .append("<thead><tr><th>物品名称</th><th>星币</th><th>杜卡币</th></tr></thead><tbody>");
                for (GlobalStates.VoidTrader.Inventory inventory : v.getInventory()) {
                    str
                            .append("<tr><td>")
                            .append(trans.enToZh(inventory.getItem()).replace("&", "&amp;"))
                            .append("</td><td>")
                            .append(inventory.getCredits() / 1000)
                            .append("k</td><td>")
                            .append(inventory.getDucats())
                            .append("</td></tr>")
                    ;

                }
                str.append("</tbody></table>");
            }
            str.append("<table class=\"voidTraderOut\"><caption align=\"top\">---------------------------------</caption><tr><td>虚空商人所在地：</td><td>")
                    .append(location)
                    .append("</td></tr><tr><td>虚空商人 到来/离去：</td><td>")
                    .append(DateUtils.getDate(v.getExpiry(), new Date()))
                    .append("</td></tr></table>");
            html = html.replaceAll("#table", str.toString());
        }


        return tmpHtmlToImageByteArray("voidTrader", html, width);
    }

    /**
     * 订阅指令列表
     *
     * @return 图片字节流
     */
    public ByteArrayOutputStream subscriberHelp() {
        String html = FileUtils.getFileString(HTML_PATH + "html/subscriberHelp.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str.append("<table class=\"table-css\"><thead><tr><th>名称</th><th>数值</th></tr></thead><tbody>");

            for (WarframeSubscribeEnums enums : WarframeSubscribeEnums.values()) {
                if (enums.ordinal() != 0) {
                    str
                            .append("<tr><td>")
                            .append(enums.getName())
                            .append("</td><td>")
                            .append(enums.ordinal())
                            .append("</td></tr>");
                }
            }
            str.append("</tbody></table>");
            html = html.replaceAll("#table", str.toString());
        }

        return tmpHtmlToImageByteArray("subscriberHelp", html, width);
    }

    /**
     * 翻译 图片
     *
     * @param key 数据
     * @return 图片 字节流
     */
    public ByteArrayOutputStream translationImage(String key) {
        String html = FileUtils.getFileString(HTML_PATH + "html/translation.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            List<WarframeTranslation> translations = trans.enAndZhToList(key);

            StringBuilder str = new StringBuilder();
            str.append("<table class=\"tra\"><thead><tr><th>中文</th><th>英文</th></tr></thead><tbody>");

            for (WarframeTranslation tra : translations) {
                str
                        .append("<tr><td>")
                        .append(tra.getTraCh())
                        .append("</td><td>")
                        .append(tra.getTraEn())
                        .append("</td></tr>");
            }
            str.append("</tbody></table>");
            html = html.replaceAll("#table", str.toString());

        }
        return tmpHtmlToImageByteArray("translation", html, width);
    }

    public ByteArrayOutputStream marketErrImage(List<ErrorWM> erWms) {
        String html = FileUtils.getFileString(HTML_PATH + "html/marketErr.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str.append("<table class=\"table-css\">");
            for (ErrorWM erWm : erWms) {
                str
                        .append("<tr><td>")
                        .append(erWm.getCh())
                        .append("</td></tr>");
            }
            str.append("</table>");

            html = html.replaceAll("#table", str.toString());
        }
        return tmpHtmlToImageByteArray("marketErr", html, width);
    }

    public ByteArrayOutputStream timeOutImage() {
        String html = "<!DOCTYPE html><html><head> <meta charset=\"UTF-8\"/><link rel=\"stylesheet\" href=\"../css/index.css\"/></head><body>" +
                "<div class=\"card\"><div class=\"card-layer\">" +
                "<h1>请求超时请稍后重试！!</h1></div></div>" +
                "</body></html>";
        int width = getWidth(html);
        html = outH(html);
        return tmpHtmlToImageByteArray("timeOut", html, width);
    }

    public ByteArrayOutputStream marketNotImage() {
        String html = "<!DOCTYPE html><html><head> <meta charset=\"UTF-8\"/><link rel=\"stylesheet\" href=\"../css/index.css\"/></head><body>" +
                "<div class=\"card\"><div class=\"card-layer\">" +
                "<h2>您查询的物品当前无在线玩家售卖!<br/>您查询的物品或许是不可交易!<br/>发送 wiki 物品名 查看物品是否可以交易!</h2></div></div>" +
                "</body></html>";
        int width = getWidth(html);
        html = outH(html);
        return tmpHtmlToImageByteArray("marketNot", html, width);
    }

    public ByteArrayOutputStream NotImage() {
        String html = "<!DOCTYPE html><html><head> <meta charset=\"UTF-8\"/><link rel=\"stylesheet\" href=\"../css/index.css\"/></head><body>" +
                "<div class=\"card\"><div class=\"card-layer\">" +
                "<h2>未找到您查询的物品！</h2><h2>请输入的更详细些！</h2></div></div>" +
                "</body></html>";
        int width = getWidth(html);
        html = outH(html);
        return tmpHtmlToImageByteArray("Not", html, width);
    }

    /**
     * 查询 信条/赤毒 武器
     *
     * @param licksOrSister 数据
     * @return 图片字节流
     */
    public ByteArrayOutputStream marketLichAndSisterImage(MarketLichOrSister licksOrSister, WarframeEnum type) {
        String html = FileUtils.getFileString(HTML_PATH + "html/marketLichAndSister.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str
                    .append("<h2>---以下是出售<span style=\"color: rgb(252, 99, 21);\"> [")
                    .append(licksOrSister.getItemName())
                    .append("] </span>的玩家---</h2><table class=\"table-css\"><thead><tr><th>玩家名</th><th>起拍价</th><th>买断价</th><th>一口价</th><th>最高价</th><th>元素</th><th>加成</th><th>幻纹</th><th>上架日期</th></tr></thead><tbody>")

            ;
            for (MarketLichOrSister.Auctions lick : licksOrSister.getPayload().getAuctions()) {
                String ephemera = "无";
                String topBid = "无";
                if (lick.getItem().getHavingEphemera()) {
                    if (WarframeEnum.TYPE_MARKET_CD == type) {
                        ephemera = SpringUtils.getBean(IWarframeMarketLichService.class).selectWarframeMarketLichByElement(lick.getItem().getElement()).getItemName();
                    } else {
                        ephemera = SpringUtils.getBean(IWarframeMarketSisterService.class).selectWarframeMarketSisterByElement(lick.getItem().getElement()).getItemName();
                    }
                }
                if (lick.getTopBid() != null) {
                    topBid = String.valueOf(lick.getTopBid());
                }
                str
                        .append("<tr><td>")
                        .append(lick.getOwner().getIngameName())
                        .append("</td><td>")
                        .append(lick.getStartingPrice())
                        .append("</td><td>")
                        .append(lick.getBuyoutPrice() == null ? "无" : lick.getBuyoutPrice())
                        .append("</td><td>")
                        .append(lick.getBuyoutPrice() == null ? "无" : lick.getBuyoutPrice())
                        .append("</td><td>")
                        .append(topBid)
                        .append("</td><td>")
                        .append(SpringUtils.getBean(IWarframeMarketElementService.class).selectWarframeMarketElementByElementEn(lick.getItem().getElement()).getElementCh())
                        .append("</td><td>")
                        .append(lick.getItem().getDamage())
                        .append("</td><td>")
                        .append(ephemera)
                        .append("</td><td>")
                        .append(DateUtils.getDateSize(new Date(), lick.getUpdated()))
                        .append("</td></tr>")
                ;

            }
            StringBuilder re = new StringBuilder();
            re.append("/w ")
                    .append(licksOrSister.getPayload().getAuctions().get(0).getOwner().getIngameName())
                    .append(" Hi! ");
            if (WarframeEnum.TYPE_MARKET_CD == type) {
                re.append("I want to buy: ")
                        .append(StringUtils.convertToCamelCaseK(licksOrSister.getPayload().getAuctions().get(0).getItem().getWeaponUrlName()))
                        .append("(Kuva Lich),");
            } else {
                re.append("I want to buy: ")
                        .append(StringUtils.convertToCamelCaseK(licksOrSister.getPayload().getAuctions().get(0).getItem().getWeaponUrlName()))
                        .append("(Sisters of Parvos),");
            }
            re.append("what's your offer? (warframe.market)");

            str.append("</tbody></table><div><h2>---快捷回复指令---</h2><p style=\"color: rgb(46, 112, 167);\">")
                    .append(re)
                    .append("</p></div>")
            ;


            html = html.replaceAll("#table", str.toString());

        }


        return tmpHtmlToImageByteArray("marketLichAndSister", html, width);
    }

    /**
     * Warframe Market 查询物品
     *
     * @param market 数据
     * @param seBy   买/卖？
     * @param isMax  满？
     * @return 图片字节流
     */
    public ByteArrayOutputStream marketImage(Market market, Boolean seBy, Boolean isMax) {
        String html = FileUtils.getFileString(HTML_PATH + "html/market.html");
        int width = getWidth(html);
        html = outH(html);

        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str.append("<h2>");
            if (isMax) {
                str.append("满级");
            }
            if (seBy) {
                str.append("买家");
            } else {
                str.append("卖家");
            }

            str
                    .append("</h2>")
                    .append("<h2>---以下是出售")
                    .append("<span style=\"color: rgb(252, 99, 21);\"> [")
                    .append(market.getInclude().getItem().getItems_in_set().get(0).getZhhans().getItem_name())
                    .append("] </span>")
                    .append("的玩家---</h2><table class=\"table-css\">")
                    .append("<thead><tr><th>玩家名</th><th>数量</th><th>白金</th></tr></thead><tbody>")
            ;

            for (Market.Orders order : market.getPayload().getOrders()) {
                str
                        .append("<tr><td>")
                        .append(order.getUser().getIngameName())
                        .append("</td><td>")
                        .append(order.getQuantity())
                        .append("</td><td>")
                        .append(order.getPlatinum())
                        .append("</td></tr>");
            }
            str.append("</tbody></table><div><h2>---物品介绍---</h2><p style=\"color: rgb(152, 101, 36);\">")
                    .append(market.getInclude().getItem().getItems_in_set().get(0).getZhhans().getDescription())
                    .append("</p></div>");
            if (market.getInclude().getItem().getItems_in_set().get(0).getZhhans().getDrop().size() != 0) {
                str.append("<table><cite><h2>---包含 [")
                        .append(market.getInclude().getItem().getItems_in_set().get(0).getZhhans().getItem_name())
                        .append(" ]物品的遗物</h2></cite>");
                for (Market.Drop drop : market.getInclude().getItem().getItems_in_set().get(0).getZhhans().getDrop()) {
                    str.append("<tr><td>")
                            .append(drop.getName())
                            .append("</td></tr>");
                }
                str.append("</table>");

            }
            str.append("<div><h2>---快捷回复指令---</h2><p style=\"color: rgb(46, 112, 167);\"> /w ")
                    .append(market.getPayload().getOrders().get(0).getUser().getIngameName())
                    .append(" Hi I want to buy: ")
                    .append(StringUtils.convertToCamelCaseK(market.getInclude().getItem().getItems_in_set().get(0).getUrlName()))
                    .append(" for ")
                    .append(market.getPayload().getOrders().get(0).getPlatinum())
                    .append(" Platinum(Warframe.market)</p></div>")
            ;

            html = html.replaceAll("#table", str.toString());

        }

        return tmpHtmlToImageByteArray("market", html, width);
    }

    /**
     * Warframe Market 查询物品
     *
     * @param market 数据
     * @param seBy   买/卖？
     * @param isMax  满？
     * @return 图片字节流
     */
    public ByteArrayOutputStream marketImage2(Market market, Boolean seBy, Boolean isMax, String form) {
        String html = FileUtils.getFileString(HTML_PATH + "html/market.html");
        int width = getWidth(html);
        html = outH(html);
        String sell = "<li class=\"nav_li\">卖家</li>",
                buy = "<li class=\"nav_li\">买家</li>",
                typeAll = "<li class=\"nav_li\">全部</li>",
                typeOn = "<li class=\"nav_li\">在线</li>",
                typeSlm = "<li class=\"nav_li\">离线</li>",
                idwAll = "<li class=\"nav_li\">全部</li>",
                idw = "<li class=\"nav_li\">满级</li>";

        //物品名
        if (html.contains("#title")) {
            html = html.replaceAll("#title", market.getInclude().getItem().getItems_in_set().get(0).getZhhans().getItem_name() + " <br/>" + StringUtils.convertToCamelCase(form));
        }
        //头部
        if (html.contains("#rank") || html.contains("#ducats") || html.contains("#credits") || html.contains("#type")) {
            String id = market.getInclude().getItem().getId();
            int ducats = 0, level = 0, tax = 0, modMax = 0;

            String type = "";
            for (Market.ItemsInSet itemsInSet : market.getInclude().getItem().getItems_in_set()) {
                if (itemsInSet.getId().equals(id)) {
                    if (itemsInSet.getDucats() != null) {
                        ducats = itemsInSet.getDucats();
                    }
                    if (itemsInSet.getMasteryLevel() != null) {
                        level = itemsInSet.getMasteryLevel();
                    }
                    if (itemsInSet.getTradingTax() != null) {
                        tax = itemsInSet.getTradingTax();
                    }
                    if (itemsInSet.getRarity() != null) {
                        type = itemsInSet.getRarity();
                    }
                    if (itemsInSet.getModMaxRank() != null) {
                        modMax = itemsInSet.getModMaxRank();
                    }
                    break;
                }
            }
            if (modMax != 0 && type.length() != 0) {
                html = html.replaceAll("#type", type);
            } else {
                html = html.replaceAll("#type", "");
            }

            if (ducats != 0) {
                html = html.replaceAll("#ducats", "<img src=\"../img/Ducats.png\" style=\"width: 15px;\" />" + ducats);
            } else {
                html = html.replaceAll("#ducats", "");
            }

            html = html.replaceAll("#rank", String.valueOf(level)).replaceAll("#credits", "<img src=\"../img/Credits.png\" style=\"width: 15px;\" />" + tax);

        }

        //订单
        if (!seBy) {
            html = html.replaceAll("#sellorbuy", sell.replace("nav_li", "actv_li") + buy);
        } else {
            html = html.replaceAll("#sellorbuy", sell + buy.replace("nav_li", "actv_li"));
        }

        if (isMax) {
            html = html.replaceAll("#idw", idwAll + idw.replaceAll("nav_li", "actv_li"));
        } else {
            html = html.replaceAll("#idw", idwAll.replaceAll("nav_li", "actv_li") + idw);
        }

        //具体数据
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            for (Market.Orders order : market.getPayload().getOrders()) {
                str
                        .append("<tr><td class=\"sell\"><div class=\"sell\">卖</div></td>")
                        .append("<td style=\"text-align: left;\"><div class=\"avatr-image\">")
                        .append("<img class=\"user__avatar--sAYSu\" src=\"../img/market/default-avatar.png\" /></div>")
                        .append("<div class=\"avatr-name\"><span class=\"user__name--xF_ju\">")
                        .append(order.getUser().getIngameName())
                        .append("</span></div>")
                        .append("</td><td >")
                        .append("<span class=\"ingame--OWe2B\">");
                if (order.getUser().getStatus().equals("online")) {
                    str.append("在线");
                }
                if (order.getUser().getStatus().equals("ingame")) {
                    str.append("游戏中");
                }
                //声誉
                str
                        .append("</span></td><td>")
                        .append("<div class=\"order-row__user-reputation--lGJbY\">");
                if (order.getUser().getReputation() >= 5) {
                    str.append("<span style=\"color: #00a96c;\">")
                            .append(order.getUser().getReputation())
                            .append("</span>")
                            .append("<img src=\"../img/market/icon-smile.png\" style=\"width: 15px;\" />");
                } else {
                    str.append("<span style=\"color: #739098;\">")
                            .append(order.getUser().getReputation())
                            .append("</span>")
                            .append("<img src=\"../img/market/icon-meh.png\" style=\"width: 15px;\" />");
                }

                str
                        .append("</div></td><td>")
                        .append("<div class=\"price\">")
                        .append(order.getPlatinum())
                        .append("<img src=\"../img/market/icon-platinum.png\" style=\"width: 15px;\" /></div></td>")
                        .append("<td><div class=\"quantity\">")
                        .append(order.getQuantity())
                        .append("<img src=\"../img/market/icon-cubes.png\" style=\"width: 15px;\" />")
                        .append("</div></td><td>")
                        .append(order.getModRank())
                        .append("</td></tr>");
            }
            html = html.replaceAll("#table", str.toString());
        }


        return tmpHtmlToImageByteArray("market", html, width);
    }

    /**
     * Warframe.Market 紫卡图片
     *
     * @param riven 紫卡数据
     * @param name  武器名称
     * @return 紫卡图片 字节流
     */
    public ByteArrayOutputStream marketRiven(MarketRiven riven, String name) {
        String html = FileUtils.getFileString(HTML_PATH + "html/marketRiven.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str
                    .append("<h1>---<span style=\"color: rgb(252, 99, 21);\"> [")
                    .append(name)
                    .append("] </span> 紫卡查询结果---</h1>")
                    .append("<table class=\"table-css riven\"><thead><tr><th>玩家名称</th><th>白金</th><th>紫卡名称</th><th>加成</th><th>加成</th><th>加成</th><th>负</th><th>段位</th>")
                    .append("<th>槽位</th><th>洗次</th><th>紫卡等级</th></tr></thead><tbody>")
            ;
            int i = 0;
            for (MarketRiven.Auctions auction : riven.getPayload().getAuctions()) {
                str
                        .append("<tr><td>")
                        .append(auction.getOwner().getIngameName())
                        .append("</td><td>")
                        .append(auction.getBuyoutPrice())
                        .append("</td><td>")
                        .append(auction.getItem().getName())
                        .append("</td>")
                ;
                for (MarketRiven.Attributes attribute : auction.getItem().getAttributes()) {
                    str
                            .append("<td>")
                            .append(attribute.getValue())
                            .append("%")
                            .append(rts.selectWarframeMarketRivenTionByUrlName(attribute.getUrlName()).getEffect())
                            .append("</td>")
                    ;
                }
                switch (auction.getItem().getAttributes().size()) {
                    case 2: {
                        str.append("<td>无</td><td>无</td>");
                        break;
                    }
                    case 3: {
                        str.append("<td>无</td>");
                        break;
                    }
                    default: {
                        break;
                    }
                }

                str
                        .append("<td>")
                        .append(auction.getItem().getMasteryLevel())
                        .append("</td><td class=\"")
                        .append(auction.getItem().getPolarity())
                        .append("\"></td><td>")
                        .append(auction.getItem().getReRolls())
                        .append("</td><td>")
                        .append(auction.getItem().getModRank())
                        .append("</td></tr>")
                ;
                i++;
                if (i >= 30) {
                    break;
                }
            }
            str.append("</tbody></table>");


            html = html.replaceAll("#table", str.toString());
        }


        return tmpHtmlToImageByteArray("marketRiven", html, width);
    }

    /**
     * 查询金银垃圾
     *
     * @param dumps 垃圾数据
     * @return 图片字节流
     */
    public ByteArrayOutputStream marketDucat(DucatDumps dumps) {
        String html = FileUtils.getFileString(HTML_PATH + "html/marketDumps.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str
                    .append("<table class=\"table-css\"><caption about=\"top\">金垃圾</caption><thead><tr><th>名称</th><th>杜卡币</th><th>?币/白金</th><th>成交均价</th><th>库存</th></tr></thead><tbody>");
            for (Ducats.Ducat ducat : dumps.getGod()) {
                str
                        .append("<tr><td>")
                        .append(ducat.getItem_name())
                        .append("</td><td>")
                        .append(ducat.getDucats())
                        .append("</td><td>")
                        .append(ducat.getDucatsPerPlatinumWa())
                        .append("</td><td>")
                        .append(ducat.getWaPrice())
                        .append("</td><td>")
                        .append(ducat.getVolume())
                        .append("</td></tr>");

            }
            str.append("</tbody></table><table class=\"table-css\"><caption about=\"top\">银垃圾</caption><thead><tr><th>名称</th><th>杜卡币</th><th>?币/白金</th><th>成交均价</th><th>库存</th></tr></thead><tbody>");
            for (Ducats.Ducat ducat : dumps.getSilver()) {
                str
                        .append("<tr><td>")
                        .append(ducat.getItem_name())
                        .append("</td><td>")
                        .append(ducat.getDucats())
                        .append("</td><td>")
                        .append(ducat.getDucatsPerPlatinumWa())
                        .append("</td><td>")
                        .append(ducat.getWaPrice())
                        .append("</td><td>")
                        .append(ducat.getVolume())
                        .append("</td></tr>");

            }
            str.append("</tbody></table>");
            html = html.replaceAll("#table", str.toString());
        }


        return tmpHtmlToImageByteArray("marketDumps", html, width);
    }

    public ByteArrayOutputStream relicsSelect(List<WarframeRelics> relics) {
        String html = FileUtils.getFileString(HTML_PATH + "html/relics.html");
        int width = getWidth(html);
        html = outH(html);
        if (relics.size() == 0 || relics.size() > 90) return NotImage();
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str.append("<tr><td>");
            int x = 0, j = 0;
            String tempName = "", tempTier = "";
            for (WarframeRelics relic : relics) {
                if (x != 0 && x % 6 == 0) {
                    str.append("</table></td>");
                    j++;
                    if (j % 4 == 0) {
                        str.append("</tr><tr><td>");
                    }
                    if (x < relics.size() && j % 4 != 0) str.append("<td>");
                }

                if (!tempName.equals(relic.getRelicsName()) && !tempTier.equals(relic.getRelicsTier()) || (x != 0 && x % 6 == 0)) {
                    str
                            .append("<table class=\"relics\"><caption about=\"top\" class=\"relics-")
                            .append(relic.getRelicsTier())
                            .append("\"> [")
                            .append(relic.getRelicsTierD())
                            .append(" ")
                            .append(relic.getRelicsName())
                            .append(" 遗物] </caption>")
                    ;
                    tempName = relic.getRelicsName();
                    tempTier = relic.getRelicsTier();
                }
                str.append("<tr><td>")
                        .append(relic.getRelicsItemName())
                        .append("</td></tr>");

                if (x == relics.size() - 1) {
                    str.append("</table></td></tr>");
                }

                x++;

            }
            /* str.append("</table>");*/

            html = html.replaceAll("#table", str.toString());
        }
        return tmpHtmlToImageByteArray("relics", html, width);
    }

    public ByteArrayOutputStream relics(Map<String, List<WarframeRelics>> relics) {
        String html = FileUtils.getFileString(HTML_PATH + "html/relics.html");
        int width = getWidth(html);
        html = outH(html);
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str.append("<tr>");
            int x = 0;
            String tempName = "";
            for (String key : relics.keySet()) {
                if (x % 5 == 0) {
                    str.append("</tr><tr>");
                }
                str.append("<td>");
                for (WarframeRelics r : relics.get(key)) {
                    if (!tempName.equals(r.getRelicsName())) {
                        str
                                .append("<table class=\"relics\"><caption about=\"top\" class=\"relics-")
                                .append(r.getRelicsTier())
                                .append("\"> [")
                                .append(r.getRelicsTierD())
                                .append(" ")
                                .append(r.getRelicsName())
                                .append(" 遗物] </caption>")
                        ;
                        tempName = r.getRelicsName();
                    }

                    str.append("<tr><td class=\"");
                    if (r.getRelicsItemChance().equals("11")) {
                        str.append("relics-y\">");
                    }
                    if (r.getRelicsItemChance().equals("2")) {
                        str.append("relics-j\">");
                    }
                    if (r.getRelicsItemChance().equals("25.33")) {
                        str.append("relics-t\">");
                    }
                    str

                            .append(r.getRelicsItemName().replace("&", "&amp;"))
                            .append("</td></tr>");


                }
                str.append("</table>").append("</td>");
                x++;
            }
            String outStr = str.toString();
            if (!StringUtils.substring(outStr, outStr.length() - 5, outStr.length()).equals("</tr>")) {
                str.append("</tr>");
                outStr = str.toString();
            }

            html = html.replaceAll("#table", outStr);
        }
        return tmpHtmlToImageByteArray("relics", html, width);
    }

    /**
     * 模拟砸核桃
     *
     * @return 图片流
     */
    public ByteArrayOutputStream relicsToy() {
        String html = FileUtils.getFileString(HTML_PATH + "html/relicsToy.html");
        int width = getWidth(html);
        html = outH(html);
        int max = relics.selectWarframeRelicsMaxId().getRelicsKeyId();
        Random r = new Random();
        int p = r.nextInt(3) + 2;
        switch (p) {
            case 2:
                width = 1140;
                break;
            case 3:
                width = 1500;
                break;
            case 4:
                width = 2100;
                break;
        }
        if (html.contains("#table")) {
            StringBuilder str = new StringBuilder();
            str.append("<table><tr>");
            for (int i = 0; i < p; i++) {
                WarframeRelics warframeRelics = relics.selectWarframeRelicsToTraById(r.nextInt(max) + 1);
                str.append("<td><div class=\"relics-toy-");
                switch (warframeRelics.getRelicsItemChance()) {
                    case "11":
                        str.append("y\">");
                        break;
                    case "2":
                        str.append("j\">");
                        break;
                    case "25.33":
                        str.append("t\">");
                        break;
                    default:
                        break;
                }
                str.append("<img src=\"../img/relics/");
                String item = warframeRelics.getRelicsItemName().toLowerCase();

                if (item.contains("forma")) {
                    str.append("Forma");
                } else if (item.contains("chassis")) {
                    str.append("Chassis");
                } else if (item.contains("neuroptics")) {
                    str.append("Neuroptics");
                } else if (item.contains("systems")) {
                    str.append("Systems");
                } else if (item.contains("adapter")) {
                    str.append("Adapter");
                } else {
                    String[] s = warframeRelics.getRelicsItemName().split(" ");
                    str.append(s[s.length - 1]);
                }

                str.append(".png\" width=\"128\" height=\"128\"/>")
                        .append("<p>")
                        .append(warframeRelics.getTraCh().replace("&", "&amp;"))
                        .append("</p></div><p>")
                        .append(StringUtils.getRandomString())
                        .append("</p></td>");
            }
            str.append("</tr></table>");

            html = html.replaceAll("#table", str.toString());
        }


        return tmpHtmlToImageByteArray("relicsToy", html, width);
    }



    public ByteArrayOutputStream tmpHtmlToImageByteArray(String name, String html, int width) {
        String path = HTML_PATH;
        FileUtils.isMkdirs(path + "tmp");
        path = path + "tmp/" + name + ".html";
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


}
