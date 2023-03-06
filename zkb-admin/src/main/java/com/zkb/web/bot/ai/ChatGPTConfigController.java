package com.zkb.web.bot.ai;

import com.zkb.bot.aiml.domain.ChatGPTConfig;
import com.zkb.bot.aiml.service.IChatGPTService;
import com.zkb.common.core.controller.BaseController;
import com.zkb.common.core.domain.AjaxResult;
import com.zkb.common.core.redis.RedisCache;
import com.zkb.common.vo.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bot/ai/chat/config")
public class ChatGPTConfigController extends BaseController {

    @Autowired
    IChatGPTService service;
    @Autowired
    RedisCache redis;

    private final String PREFIX = "bot/ai/chat/";

    @GetMapping()
    public String info(ModelMap map) {
        ChatGPTConfig config = redis.getCacheObject("chat-config");
        if(config == null){
            config = new ChatGPTConfig();
            config.setKey("");
            config.setMsg("");
            config.setProxy(new Proxy());
        }
        map.put("config",config);
        return PREFIX + "config";
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(ChatGPTConfig config){
        return toAjax(service.setChatGPTConfig(config));
    }


}
