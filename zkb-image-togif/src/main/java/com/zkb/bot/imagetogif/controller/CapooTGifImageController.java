package com.zkb.bot.imagetogif.controller;


import com.zkb.bot.utils.PrivateAddApi;
import com.zkb.common.jhlabs.image.PerspectiveFilter;
import com.zkb.common.utils.image.ImageToGif;
import com.zkb.common.utils.image.ImageUtils;
import com.zkb.common.utils.image.combiner.ImageCombiner;
import com.zkb.common.utils.image.combiner.enums.OutputFormat;
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
@RequestMapping("/Gif/Capoo/Chuo")
public class CapooTGifImageController {

    @GetMapping(value = "/{uuid}/getImage/{id}/{ms}")
    public void getImage(@PathVariable("id") long id, @PathVariable("ms") int ms, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "image/gif");
        //Gif图像组
        List<BufferedImage> ims = new ArrayList<>();
        //获取用户头像
        BufferedImage prk = ImageIO.read(new URL(PrivateAddApi.getPrivateHeadImage(id)));
        for (int i = 1; i <= 8; i++) {
            //素材地址
            String path = "/images-gif/capoo/t/" + i + ".png";
            //加载素材到内存
            BufferedImage s = ImageUtils.getImage(path);
            //加载素材到内存
            assert s != null;
            ImageCombiner combiner = new ImageCombiner(new BufferedImage(s.getWidth(), s.getHeight(), BufferedImage.TYPE_INT_ARGB), OutputFormat.PNG);
            //透视变换 实体类
            PerspectiveFilter filter = new PerspectiveFilter();
            if (i == 1) {
                filter.setCorners(
                        137,
                        242,
                        269,
                        242,
                        269,
                        285,
                        137,
                        285
                );
                combiner.addImageElement(filter.filter(prk), 137, 242);
            }
            if (i == 2) {
                filter.setCorners(
                        137,
                        245,
                        269,
                        245,
                        269,
                        285,
                        137,
                        285
                );
                combiner.addImageElement(filter.filter(prk), 137, 245);
            }
            if (i == 3 || i == 4 || i == 5) {
                filter.setCorners(
                        151,
                        191,
                        253,
                        191,
                        253,
                        283,
                        151,
                        283
                );
                combiner.addImageElement(filter.filter(prk), 151, 191);
            }
            if (i == 6) {
                filter.setCorners(
                        147,
                        198,
                        254,
                        198,
                        254,
                        283,
                        147,
                        283
                );
                combiner.addImageElement(filter.filter(prk), 147, 198);
            }
            if (i == 7 || i == 8) {
                filter.setCorners(
                        147,
                        225,
                        254,
                        225,
                        254,
                        283,
                        147,
                        283
                );
                combiner.addImageElement(filter.filter(prk), 147, 225);
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
