package com.zkb.web.warframe.config;


import com.zkb.bot.warframe.domain.WarframeTypeEnum;
import com.zkb.bot.warframe.service.IWarframeTypeEnumService;
import com.zkb.common.annotation.Log;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("config/warframe")
public class WarframeConfigController extends BaseController {

    private final String PREFIX = "config/warframe/";
    @Autowired
    IWarframeTypeEnumService typeEnumService;

    @GetMapping("/warframe-config")
    public String config() {
        return PREFIX + "warframe-config";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarframeTypeEnum type) {
        startPage();
        List<WarframeTypeEnum> list = typeEnumService.selectWarframeTypeEnumList(type);
        return getDataTable(list);
    }

    @GetMapping("/edit/{k}")
    public String edit(@PathVariable String k, ModelMap mmap) {
        List<WarframeTypeEnum> te = typeEnumService.selectWarframeTypeEnumList(new WarframeTypeEnum(k));
        mmap.put("ir", te.get(0));
        return PREFIX + "edit";
    }

    @Log(title = "Warframe指令", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(WarframeTypeEnum t) {
        return toAjax(typeEnumService.updateWarframeTypeEnum(t));
    }

}
