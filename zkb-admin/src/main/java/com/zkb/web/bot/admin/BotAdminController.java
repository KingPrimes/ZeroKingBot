package com.zkb.web.bot.admin;

import com.zkb.bot.domain.BotAdmins;
import com.zkb.bot.enums.BotAdminPrivilegeEnum;
import com.zkb.bot.server.IBotAdminsServer;
import com.zkb.common.annotation.Log;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.page.TableDataInfo;
import com.zkb.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bot/admin")
public class BotAdminController extends BaseController {
    private final String PREFIX = "bot/admin";
    @Autowired
    private IBotAdminsServer adminsServer;

    @GetMapping()
    public String info(ModelMap mmp) {
        Map<Integer, String> keys = new HashMap<>();
        for (BotAdminPrivilegeEnum e : BotAdminPrivilegeEnum.values()) {
            keys.put(e.ordinal(), e.desc());
        }
        mmp.put("keys", keys);
        return PREFIX + "/admin";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BotAdmins botAdmins) {
        startPage();
        List<BotAdmins> list = adminsServer.selectBotAdminsList(botAdmins);
        return getDataTable(list);
    }

    @Log(title = "管理员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(BotAdmins botAdmins) {
        return toAjax(adminsServer.insertBotAdmin(botAdmins));
    }

    @GetMapping("/add")
    public String add(ModelMap mmap) {
        Map<Integer, String> keys = new HashMap<>();
        for (BotAdminPrivilegeEnum e : BotAdminPrivilegeEnum.values()) {
            keys.put(e.ordinal(), e.desc());
        }
        mmap.put("keys", keys);
        return PREFIX + "/add";
    }

    @Log(title = "管理员", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{uid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable Long uid) {
        return toAjax(adminsServer.deleteBotAdmins(uid));
    }

    @GetMapping("/edit/{uid}")
    public String edit(@PathVariable String uid, ModelMap mmap) {
        BotAdmins botAdmins = adminsServer.selectBotAdminsToUid(Long.valueOf(uid));
        mmap.put("ir", botAdmins);
        Map<Integer, String> keys = new HashMap<>();
        for (BotAdminPrivilegeEnum e : BotAdminPrivilegeEnum.values()) {
            keys.put(e.ordinal(), e.desc());
        }
        mmap.put("keys", keys);
        return PREFIX + "/edit";
    }

    @Log(title = "管理员", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(BotAdmins botAdmins) {
        return toAjax(adminsServer.updateBotAdmins(botAdmins));
    }
}
