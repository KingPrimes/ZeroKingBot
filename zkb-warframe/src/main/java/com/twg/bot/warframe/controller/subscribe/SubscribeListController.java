package com.twg.bot.warframe.controller.subscribe;


import com.twg.bot.warframe.utils.HtmlToImage;
import com.twg.common.utils.spring.SpringUtils;
import com.twg.framework.interceptor.IgnoreAuth;
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