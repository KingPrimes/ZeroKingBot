package com.zkb.web.bot.black;

import com.zkb.bot.domain.BotBlack;
import com.zkb.bot.server.IBotBlackServer;
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
@RequestMapping("/bot/black")
public class BlackController extends BaseController {


    private final String PREFIX = "bot/black/";
    @Autowired
    private IBotBlackServer blackServer;

    @GetMapping()
    public String info() {
        return PREFIX + "black";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BotBlack black) {
        startPage();
        List<BotBlack> list = blackServer.selectBotBlackList(black);
        return getDataTable(list);
    }

    @Log(title = "黑名单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(BotBlack black) {
        return toAjax(blackServer.insertBotBlack(black));
    }

    @GetMapping("/add")
    public String add(ModelMap mmap) {
        return PREFIX + "/add";
    }

    @Log(title = "黑名单", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable Long id) {
        return toAjax(blackServer.deleteBotBlackById(id));
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        BotBlack botBlack = blackServer.selectBotBlackById(id);
        mmap.put("black", botBlack);
        return PREFIX + "/edit";
    }

    @Log(title = "黑名单", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(BotBlack black) {
        return toAjax(blackServer.updateBotBlack(black));
    }

}
