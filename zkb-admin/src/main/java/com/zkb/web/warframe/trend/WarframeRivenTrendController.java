package com.zkb.web.warframe.trend;

import com.zkb.bot.enums.WarframeRivenTrendEnum;
import com.zkb.bot.enums.WarframeRivenTrendTypeEnum;
import com.zkb.bot.warframe.domain.WarframeRivenTrend;
import com.zkb.bot.warframe.service.IWarframeRivenTrendService;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.http.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warframe/trend")
public class WarframeRivenTrendController extends BaseController {

    final String PREFIX = "warframe/trend/";
    @Autowired
    IWarframeRivenTrendService trendService;

    @Autowired
    IWarframeTranslationService traService;

    @GetMapping("/riven-trend")
    public String trend() {
        return PREFIX + "riven-trend";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarframeRivenTrend trend) {
        startPage();
        List<WarframeRivenTrend> list = trendService.selectWarframeRivenTrendList(trend);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(ModelMap mmap) {
        Map<Integer, String> keys = new HashMap<>();
        for (WarframeRivenTrendTypeEnum e : WarframeRivenTrendTypeEnum.values()) {
            keys.put(e.ordinal(), e.getDesc());
        }
        mmap.put("keys", keys);
        return PREFIX + "/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult insertToUpdate(WarframeRivenTrend trend) {
        String ch = trend.getTraCh();

        String en = traService.zhToEn(ch);

        if (en.isEmpty() || ch.trim().equals(en.trim())) {
            return toAjax(0);
        }
        trend.setRivenTrendName(en);
        trend.setRivenTrendNewDot(WarframeRivenTrendEnum.getRivenTrendDot(Double.parseDouble(trend.getRivenTrendNewNum())));
        trend.setRivenTrendOldDot(WarframeRivenTrendEnum.getRivenTrendDot(Double.parseDouble(trend.getRivenTrendOldNum())));
        return toAjax(trendService.insertWarframeRivenTrend(trend));
    }

    @GetMapping("/init")
    public AjaxResult init() {
        System.out.println("WarframeRivenTrendController: 开始执行Trend初始化操作");
        String html = HttpUtils.sendGetOkHttp("https://tenno.life/riven/archgun");
        Document document = Jsoup.parse(html);

        Element div_weapon = document.getElementById("div_weapon");

        Elements elementsByClass = div_weapon.getElementsByTag("li");

        for (Element byClass : elementsByClass) {
            if (!byClass.text().isEmpty() && !byClass.text().contains("●")) {
                WarframeRivenTrend trend = new WarframeRivenTrend();

                for (Element span : byClass.getElementsByTag("span")) {
                    if (StringUtils.isNumberAndDouble(span.text())) {
                        trend.setRivenTrendNewNum(span.text());
                    }
                    trend.setRivenTrendName(traService.zhToEn(span.getElementsByClass("chs").text()));
                    trend.setRivenTrendNewDot(WarframeRivenTrendEnum.getRivenTrendDot(Double.parseDouble(trend.getRivenTrendNewNum())));
                    trend.setRivenTrendOldNum("0");
                    trend.setRivenTrendOldDot(WarframeRivenTrendEnum.getRivenTrendDot(0));
                    trend.setRivenTrendType(WarframeRivenTrendTypeEnum.ARCHGUN);

                }
                trendService.insertWarframeRivenTrend(trend);

            }
        }
        return toAjax(1);
    }

    @GetMapping("/edit/{rivenTrendId}")
    public String edit(@PathVariable String rivenTrendId, ModelMap mmap) {
        WarframeRivenTrend trend = trendService.selectWarframeRivenTrendById(Long.valueOf(rivenTrendId));
        mmap.put("trend", trend);
        Map<Integer, String> keys = new HashMap<>();
        for (WarframeRivenTrendTypeEnum e : WarframeRivenTrendTypeEnum.values()) {
            keys.put(e.ordinal(), e.getDesc());
        }
        mmap.put("keys", keys);
        return PREFIX + "/edit";
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(WarframeRivenTrend trend) {
        return toAjax(trendService.updateWarframeRivenTrend(trend));
    }


}
