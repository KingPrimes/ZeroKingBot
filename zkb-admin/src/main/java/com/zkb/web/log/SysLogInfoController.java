package com.zkb.web.log;

import com.zkb.bot.enums.GifEnums;
import com.zkb.bot.enums.ImageEnum;
import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.common.annotation.Log;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.TitleType;
import com.zkb.system.domain.SysLogInfo;
import com.zkb.system.service.ISysLogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/log/info")
public class SysLogInfoController extends BaseController {

    private String prefix = "log/info";

    @Autowired
    private ISysLogInfoService infoService;


    @GetMapping()
    public String infolog(ModelMap map) {
        List<Object> orderType = new ArrayList<>();
        for (WarframeTypeEnum key : WarframeTypeEnum.values()) {
            if (!key.getType().isEmpty() && !key.getType().equals("warframe-data-the-provided-plat")) {
                orderType.add(key.getType().replace("/", ""));
            }
        }
        for (GifEnums key : GifEnums.values()) {
            if (!key.getType().isEmpty()) {
                orderType.add(key.getType().replace("/", ""));
            }
        }
        for (ImageEnum key : ImageEnum.values()) {
            if (!key.getType().isEmpty()) {
                orderType.add(key.getType().replace("/", ""));
            }
        }
        List<Object> title = new ArrayList<>();
        for (TitleType key : TitleType.values()) {
            if (!key.getType().isEmpty()) {
                title.add(key.getType());
            }
        }
        map.put("orderType", orderType);
        map.put("title", title);
        return prefix + "/info";
    }

    @GetMapping("/detail/{logId}")
    public String detail(@PathVariable("logId") Long logId, ModelMap mmap) {
        Map<Object, Object> m = new HashMap<>();
        for (BusinessType key : BusinessType.values()) {
            m.put(key.ordinal(), key.getType());
        }
        mmap.put("businessType", m);
        mmap.put("loginfo", infoService.selectSysLogInfoById(logId));
        return prefix + "/detail";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysLogInfo info) {
        startPage();
        List<SysLogInfo> list = infoService.selectSysLogInfoList(info);
        return getDataTable(list);
    }


    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(infoService.deleteSysLogInfoByIds(ids));
    }


/*    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") Long operId, ModelMap mmap) {
        Map<Object, Object> m = new HashMap<>();
        for (BusinessType key : BusinessType.values()) {
            m.put(key.ordinal(), key.getType());
        }
        mmap.put("businessType", m);
        mmap.put("infoLog", infoService.selectSysLogInfoById(operId));
        return prefix + "/detail";
    }*/

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean() {
        infoService.cleanSysLogInfo();
        return success();
    }
}
