package com.zkb.web.monitor;


import com.zkb.common.core.controller.BaseController;
import com.zkb.framework.web.domain.Server;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 服务器监控
 * 
 * @author zkb
 */
@Controller
@RequestMapping("/monitor/server")
public class ServerController extends BaseController
{


    @GetMapping()
    public String server(ModelMap mmap) throws Exception
    {
        Server server = new Server();
        server.copyTo();
        mmap.put("server", server);
        String prefix = "monitor/server";
        return prefix + "/server";
    }
}
