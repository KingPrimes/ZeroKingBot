package com.zkb.bot.warframe.controller.subscribe;


import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.framework.interceptor.IgnoreAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/warframe/subscriber")
public class SubscribeListController {

    @IgnoreAuth
    @GetMapping(value = "/getSubscriberHelp")
    public void getSubscriberHelp(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "image/png");
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).subscriberHelp();
        response.getOutputStream().write(out.toByteArray());
    }

}
