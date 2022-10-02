package com.zkb.web.log;


import com.zkb.common.annotation.Log;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.enums.BusinessStatus;
import com.zkb.common.enums.BusinessType;
import com.zkb.system.domain.SysOperLog;
import com.zkb.system.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作日志记录
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/log/operlog")
public class SysOperlogController extends BaseController {
    private String prefix = "log/operlog";

    @Autowired
    private ISysOperLogService operLogService;


    @GetMapping()
    public String operlog(ModelMap map) {
        map.put("businessType", BusinessType.values());
        Map<Object,Object> m = new HashMap<>();
        for(BusinessType key:BusinessType.values()){
            m.put(key.ordinal(),key.getType());
        }
        map.put("businessMap",m);
        map.put("businessStatus", BusinessStatus.values());
        return prefix + "/operlog";
    }


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOperLog operLog) {
        startPage();
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }


    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(operLogService.deleteOperLogByIds(ids));
    }


    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") Long operId, ModelMap mmap) {
        Map<Object,Object> m = new HashMap<>();
        for(BusinessType key:BusinessType.values()){
            m.put(key.ordinal(),key.getType());
        }
        mmap.put("businessType", m);
        mmap.put("operLog", operLogService.selectOperLogById(operId));
        return prefix + "/detail";
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean() {
        operLogService.cleanOperLog();
        return success();
    }

}
