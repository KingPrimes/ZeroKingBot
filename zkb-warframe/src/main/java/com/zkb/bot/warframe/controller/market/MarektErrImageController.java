package com.zkb.bot.warframe.controller.market;


import com.alibaba.fastjson.JSONArray;
import com.zkb.bot.warframe.dao.ErrorWM;
import com.zkb.bot.warframe.utils.HtmlToImage;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.framework.interceptor.IgnoreAuth;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/warframe/market")
public class MarektErrImageController {

    @IgnoreAuth
    @GetMapping(value = "/{uuid}/getMarektErrImage/{er}", produces = MediaType.IMAGE_PNG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable String er) throws IOException {
        response.setHeader("Content-Type", "image/png");
        List<ErrorWM> erWms = JSONArray.parseArray(URLDecoder.decode(er, "UTF-8"), ErrorWM.class);
        ByteArrayOutputStream out = SpringUtils.getBean(HtmlToImage.class).marketErrImage(erWms);
        response.getOutputStream().write(out.toByteArray());
    }
}
