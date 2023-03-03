package com.zkb.bot.warframe.controller.riven;

import com.zkb.bot.warframe.utils.WarframeHtmlToImage;
import com.zkb.common.utils.ip.GetServerPort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/warframe/riven/anaiyse")
public class RivenAnaiyseTrendImageController {

    @GetMapping(value = "/{uuid}/getRivenAnaiyseImage")
    public void getImage(HttpServletResponse response, @PathVariable("uuid") String uuid, @RequestParam("trend") String trend) throws Exception {
        response.setHeader("Content-Type", "image/png");
        ByteArrayOutputStream out = WarframeHtmlToImage.conver("http://localhost:" + GetServerPort.getPort() + "/warframe/riven/anaiyse/" + uuid + "/getRivenAnaiyseHtml?trend="+ URLEncoder.encode(trend,"UTF-8"));
        response.getOutputStream().write(out.toByteArray());
    }

    @GetMapping(value = "/errorImage")
    public void errorImage(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "image/png");
        ByteArrayOutputStream out = WarframeHtmlToImage.conver("http://localhost:" + GetServerPort.getPort() + "/warframe/riven/anaiyse/rivenErrorHtml");
        response.getOutputStream().write(out.toByteArray());
    }

}
