package com.zkb.web.warframe.config;


import com.zkb.bot.domain.BotAdmins;
import com.zkb.bot.enums.BotAdminPrivilegeEnum;
import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.warframe.domain.TypeEnum;
import com.zkb.bot.warframe.service.IWarframeTypeEnumService;
import com.zkb.common.annotation.Log;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.enums.BusinessType;
import com.zkb.common.enums.OperatorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/config/warframe")
public class WarframeConfigController extends BaseController {

    @Autowired
    IWarframeTypeEnumService typeEnumService;

    private final String PREFIX = "config/warframe/";

    @GetMapping("/warframe-config")
    public String config(){
        return PREFIX+"warframe-config";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TypeEnum type)
    {
        startPage();
        List<TypeEnum> list = typeEnumService.selectWarframeTypeEnumList(type);
        return getDataTable(list);
    }

    @GetMapping("/edit/{k}")
    public String edit(@PathVariable String k, ModelMap mmap)
    {
        List<TypeEnum> te = typeEnumService.selectWarframeTypeEnumList(new TypeEnum(k));
        mmap.put("ir", te.get(0));
        return PREFIX + "edit";
    }

    @Log(title = "Warframe指令", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(TypeEnum t){
        return toAjax(typeEnumService.updateWarframeTypeEnum(t));
    }

   /* @Log(title = "WarframeConfig",businessType = BusinessType.UPDATE,operatorType = OperatorType.MANAGE)
    @PostMapping("/warframe-config")
    public AjaxResult putConfig(Model mmap,@RequestBody Map<String,String> map){
        if(map.isEmpty()){
            return toAjax(false);
        }
        Set<String> keys = map.keySet();
        for(WarframeTypeEnum keyEnum: WarframeTypeEnum.values()){
            for(String key:keys){
                if(keyEnum.name().equals(key)){
                    keyEnum.setType(map.get(key));
                    typeEnumService.updateWarframeTypeEnum(new TypeEnum(key,map.get(key)));
                    break;
                }
            }
        }
        mmap.addAttribute("WarframeKey", getType());
        return toAjax(true);
    }*/

    /*private Map<String,String> getType(){
        Map<String,String> type = new HashMap<>();
        for(WarframeTypeEnum key:WarframeTypeEnum.values()){
            if(WarframeTypeEnum.valueOf(key.name()).getType()!=null && WarframeTypeEnum.valueOf(key.name()).getType().trim().length()!=0 && !key.name().equals("REDIS_MISSION_KEY")){
                type.put(key.name(),WarframeTypeEnum.valueOf(key.name()).getType());
            }

        }
        return type;
    }*/

}
