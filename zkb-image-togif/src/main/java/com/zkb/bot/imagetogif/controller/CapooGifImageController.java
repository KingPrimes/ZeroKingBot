package com.zkb.bot.imagetogif.controller;


import com.zkb.bot.utils.PrivateAddApi;
import com.zkb.common.jhlabs.image.PerspectiveFilter;
import com.zkb.common.utils.image.ImageToGif;
import com.zkb.common.utils.image.ImageUtils;
import com.zkb.common.utils.image.combiner.ImageCombiner;
import com.zkb.common.utils.image.combiner.enums.OutputFormat;
import com.zkb.framework.interceptor.IgnoreAuth;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Gif/Capoo/Ding")
public class CapooGifImageController {
    @IgnoreAuth
    @GetMapping(value = "/{uuid}/getImage/{id}/{ms}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE})
    public void getImage(@PathVariable("id") long id, @PathVariable("ms") int ms, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "image/gif");
        //Gif图像组
        List<BufferedImage> ims = new ArrayList<>();
        //获取用户头像
        BufferedImage prk = ImageIO.read(new URL(PrivateAddApi.getPrivateHeadImage(id)));
        //对头像圆角处理
        ImageCombiner pr = new ImageCombiner(prk, OutputFormat.PNG);
        pr.setCanvasRoundCorner(200);
        //头像圆角处理
        BufferedImage privateImage = pr.combine();
        //遍历Png素材
        for (int i = 1; i <= 43; i++) {
            //素材地址
            String path = "/images-gif/capoo/ding/" + i + ".png";
            //加载素材到内存
            BufferedImage s = ImageUtils.getImage(path);
            //加载素材到内存
            assert s != null;
            ImageCombiner combiner = new ImageCombiner(new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_INT_ARGB), OutputFormat.PNG);
            //透视变换 实体类
            PerspectiveFilter filter = new PerspectiveFilter();
            if (i == 1 || i == 13 || i == 25) {
                filter.setCorners(
                        184,
                        63,
                        277,
                        63,
                        277,
                        155,
                        184,
                        155
                );
                combiner.addImageElement(filter.filter(privateImage), 184, 63);
            }
            if (i == 2 || i == 14 || i == 26) {
                filter.setCorners(
                        186,
                        77.7F,
                        277,
                        77.7F,
                        277,
                        169.7F,
                        186,
                        169.7F
                );
                combiner.addImageElement(filter.filter(privateImage), 186, 77);
            }
            if (i == 3 || i == 15 || i == 27) {
                filter.setCorners(
                        185.9F,
                        100,
                        279,
                        100,
                        279,
                        194,
                        185.9F,
                        194
                );
                combiner.addImageElement(filter.filter(privateImage), 185, 100);
            }
            if (i == 4 || i == 16 || i == 28) {
                combiner.addImageElement(
                        Thumbnails.of(prk)
                                .scale(1)
                                .asBufferedImage()
                        , 185
                        , 112);
            }
            if (i == 5 || i == 17 || i == 29) {
                filter.setCorners(
                        159,
                        196,
                        304,
                        196,
                        304,
                        238,
                        159,
                        238);
                combiner.addImageElement(filter.filter(privateImage), 159, 196);
            }
            if (i == 6 || i == 18 || i == 30) {
                filter.setCorners(
                        180,
                        137,
                        296,
                        137,
                        296,
                        202,
                        180,
                        196);
                combiner.addImageElement(filter.filter(prk), 180, 137);
            }
            if (i == 7 || i == 19 || i == 31) {
                filter.setCorners(
                        177,
                        69,
                        294,
                        69,
                        294,
                        147,
                        177,
                        147);
                combiner.addImageElement(filter.filter(prk), 177, 69);
            }
            if (i == 8 || i == 20 || i == 32) {
                filter.setCorners(
                        172,
                        45,
                        296,
                        45,
                        296,
                        135,
                        172,
                        135);
                combiner.addImageElement(filter.filter(prk), 172, 45);
            }
            if (i == 9 || i == 21 || i == 33) {
                filter.setCorners(
                        176,
                        36.5F,
                        291,
                        36.5F,
                        291,
                        126,
                        176,
                        126);
                combiner.addImageElement(filter.filter(prk), 176, 36);
            }
            if (i == 10 || i == 22 || i == 34) {
                filter.setCorners(
                        181,
                        38,
                        286,
                        38,
                        286,
                        124,
                        181,
                        124);
                combiner.addImageElement(filter.filter(prk), 181, 38);
            }
            if (i == 11 || i == 23 || i == 35) {
                filter.setCorners(
                        183,
                        57,
                        280,
                        57,
                        280,
                        143,
                        183,
                        143);
                combiner.addImageElement(filter.filter(prk), 183, 57);
            }
            if (i == 12 || i == 24 || i == 36) {
                filter.setCorners(
                        185,
                        60,
                        277,
                        60,
                        277,
                        147,
                        185,
                        147);
                combiner.addImageElement(filter.filter(prk), 185, 60);
            }
            if (i == 37) {
                filter.setCorners(
                        185,
                        72,
                        271,
                        72,
                        271,
                        164,
                        185,
                        164);
                combiner.addImageElement(filter.filter(prk), 185, 72);
            }
            if (i == 38) {
                filter.setCorners(
                        183,
                        134,
                        268,
                        134,
                        268,
                        289,
                        183,
                        289);
                combiner.addImageElement(filter.filter(prk), 183, 134);
            }
            combiner.addImageElement(s, 0, 0);
            ims.add(combiner.combine());
        }
        if (ms > 0) {
            response.getOutputStream().write(ImageToGif.imagesToGif(ims, ms).toByteArray());
        } else {
            response.getOutputStream().write(ImageToGif.imagesToGif(ims).toByteArray());
        }
    }
}
