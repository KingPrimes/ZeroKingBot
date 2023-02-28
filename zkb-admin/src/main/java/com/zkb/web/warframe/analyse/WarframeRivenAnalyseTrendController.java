package com.zkb.web.warframe.analyse;

import com.zkb.bot.warframe.domain.WarframeRivenAnalyseTrend;
import com.zkb.bot.warframe.service.IWarframeRivenAnalyseTrendService;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/warframe/analyse")
public class WarframeRivenAnalyseTrendController extends BaseController {

    final String PREFIX = "warframe/analyse/";
    @Autowired
    IWarframeRivenAnalyseTrendService trendService;

    @GetMapping("/riven-analyse")
    public String analyse() {
        return PREFIX + "riven-analyse";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarframeRivenAnalyseTrend trend) {
        startPage();
        List<WarframeRivenAnalyseTrend> list = trendService.selectWarframeRivenAnalyseTrendList(trend);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add() {
        return PREFIX + "/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult insertToUpdate(WarframeRivenAnalyseTrend trend) {
        return toAjax(trendService.insertWarframeRivenAnalyseTrend(trend));
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, ModelMap mmap) {
        WarframeRivenAnalyseTrend trend = trendService.selectWarframeRivenAnalyseTrendById(id);
        mmap.put("trend", trend);
        return PREFIX + "/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult update(WarframeRivenAnalyseTrend trend) {
        return toAjax(trendService.updateWarframeRivenAnalyseTrend(trend));
    }


}
