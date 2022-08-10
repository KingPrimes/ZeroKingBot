package com.twg.bot.warframe.utils;

import com.twg.bot.enums.WarframeSubscribeEnums;
import com.twg.bot.enums.WarframeTypeEnum;
import com.twg.bot.warframe.dao.*;
import com.twg.bot.warframe.domain.WarframeTranslation;
import com.twg.bot.warframe.service.IWarframeMarketElementService;
import com.twg.bot.warframe.service.IWarframeMarketLichOrSisterService;
import com.twg.bot.warframe.service.IWarframeMarketSisterService;
import com.twg.bot.warframe.service.IWarframeTranslationService;
import com.twg.common.utils.DateUtils;
import com.twg.common.utils.StringUtils;
import com.twg.common.utils.file.FileUtils;
import com.twg.common.utils.spring.SpringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.simple.Graphics2DRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class HtmlToImage {

    private static final String HTML_PATH = "./TWGBot-html/";
    @Autowired
    IWarframeTranslationService trans;

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
            StringBuffer str = new StringBuffer();
            str
                    .append("<h3>---地球---</h3>")
                    .append("<table>")
                    .append("<tr>")
                    .append("<td>")
                    .append("状态")
                    .append("</td>")
                    .append("<td>")
                    .append(trans.enToZh(earth.getState()))
                    .append("</td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td>")
                    .append("时间")
                    .append("</td>")
                    .append("<td>")
                    .append(DateUtils.getDate((earth.getExpiry()), new Date()))
                    .append("</td>")
                    .append("</tr>")
                    .append("</table>")
                    .append("<br/>")

                    .append("<h3>---夜灵平野---</h3>")
                    .append("<table>")
                    .append("<tr>")
                    .append("<td>")
                    .append("状态")
                    .append("</td>")
                    .append("<td>")
                    .append(trans.enToZh(cetus.getState()))
                    .append("</td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td>")
                    .append("时间")
                    .append("</td>")
                    .append("<td>")
                    .append(DateUtils.getDate((cetus.getExpiry()), new Date()))
                    .append("</td>")
                    .append("</tr>")
                    .append("</table>")
                    .append("<br/>")

                    .append("<h3>---福尔图娜---</h3>")
                    .append("<table>")
                    .append("<tr>")
                    .append("<td>")
                    .append("状态")
                    .append("</td>")
                    .append("<td>")
                    .append(trans.enToZh(vallis.getState()))
                    .append("</td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td>")
                    .append("时间")
                    .append("</td>")
                    .append("<td>")
                    .append(DateUtils.getDate((vallis.getExpiry()), new Date()))
                    .append("</td>")
                    .append("</tr>")
                    .append("</table>")
                    .append("<br/>")

                    .append("<h3>---魔胎之境---</h3>")
                    .append("<table>")
                    .append("<tr>")
                    .append("<td>")
                    .append("状态")
                    .append("</td>")
                    .append("<td>")
                    .append(cambion.getActive().toUpperCase(Locale.ROOT))
                    .append("</td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td>")
                    .append("时间")
                    .append("</td>")
                    .append("<td>")
                    .append(DateUtils.getDate((cambion.getExpiry()), new Date()))
                    .append("</td>")
                    .append("</tr>")
                    .append("</table>")
                    .append("<br/>")

                    .append("<h3>---扎里曼---</h3>")
                    .append("<table>")
                    .append("<tr>")
                    .append("<td>")
                    .append("状态")
                    .append("</td>")
                    .append("<td>")
                    .append(zariman.getState().toUpperCase(Locale.ROOT))
                    .append("</td>")
                    .append("</tr>")
                    .append("<tr>")
                    .append("<td>")
                    .append("时间")
                    .append("</td>")
                    .append("<td>")
                    .append(DateUtils.getDate((zariman.getExpiry()), new Date()))
                    .append("</td>")
                    .append("</tr>")
                    .append("</table>")

            ;

            html = html.replaceAll("#table", str.toString());
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
                            .append(trans.enToZh(inventory.getItem()))
                            .append("</td><td>")
                            .append(inventory.getCredits() / 1000)
                            .append("k</td><td>")
                            .append(inventory.getDucats())
                            .append("</td></tr>")
                    ;

                }
                str.append("</tbody></table>");
            }
            str.append("<table class=\"voidTrader\"><caption align=\"top\">---------------------------------</caption><tr><td>虚空商人所在地：</td><td>")
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

    /**
     * 查询 信条/赤毒 武器
     *
     * @param licksOrSister 数据
     * @return 图片字节流
     */
    public ByteArrayOutputStream marketLichAndSisterImage(MarketLichOrSister licksOrSister, WarframeTypeEnum type) {
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
                    if (WarframeTypeEnum.TYPE_MARKET_CD == type) {
                        ephemera = SpringUtils.getBean(IWarframeMarketLichOrSisterService.class).selectWarframeMarketLichByElement(lick.getItem().getElement()).getItemName();
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
            if (WarframeTypeEnum.TYPE_MARKET_CD == type) {
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
                    .append(market.getInclude().getItem().getItems_in_set().get(0).getZhHans().getItem_name())
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
                    .append(market.getInclude().getItem().getItems_in_set().get(0).getZhHans().getDescription())
                    .append("</p></div>");
            if (market.getInclude().getItem().getItems_in_set().get(0).getZhHans().getDrop().size() != 0) {
                str.append("<table><cite><h2>---包含 [")
                        .append(market.getInclude().getItem().getItems_in_set().get(0).getZhHans().getItem_name())
                        .append(" ]物品的遗物</h2></cite>");
                for (Market.Drop drop : market.getInclude().getItem().getItems_in_set().get(0).getZhHans().getDrop()) {
                    str.append("<tr><td>")
                            .append(drop.getName())
                            .append("</td></tr>");
                }
                str.append("</table>");

            }
            str.append("<div><h2>---快捷回复指令---</h2><p style=\"color: rgb(46, 112, 167);\"> /w ")
                    .append(market.getPayload().getOrders().get(0).getUser().getIngameName())
                    .append(" Hi I want to buy: ")
                    .append(StringUtils.convertToCamelCaseK(market.getInclude().getItem().getItems_in_set().get(0).getUrl_name()))
                    .append(" for ")
                    .append(market.getPayload().getOrders().get(0).getPlatinum())
                    .append(" Platinum(Warframe.market)</p></div>")
            ;

            html = html.replaceAll("#table", str.toString());

        }

        return tmpHtmlToImageByteArray("market", html, width);
    }


    /**
     * 获取宽度
     *
     * @param html html文档
     * @return 宽度
     */
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

    /**
     * 删除不相干的字段
     *
     * @param html html 文档
     * @return 格式化之后的 html文档
     */
    private String outH(String html) {
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
    private ByteArrayOutputStream convertHtmlToImage(String htmlFilePath, int width) {
        try {
            File htmlFile = new File(htmlFilePath);
            String url = htmlFile.toURI().toURL().toExternalForm();
            BufferedImage image = Graphics2DRenderer.renderToImageAutoSize(url, width, BufferedImage.TYPE_INT_ARGB);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            return os;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ByteArrayOutputStream tmpHtmlToImageByteArray(String name, String html, int width) {
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
            e.printStackTrace();
        }
        return convertHtmlToImage(path, width);
    }

}
