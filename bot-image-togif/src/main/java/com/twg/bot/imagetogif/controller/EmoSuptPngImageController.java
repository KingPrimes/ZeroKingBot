package com.twg.bot.imagetogif.controller;

import com.twg.bot.utils.PrivateAddApi;
import com.twg.common.jhlabs.image.RotateFilter;
import com.twg.common.utils.image.ImageUtils;
import com.twg.common.utils.image.combiner.ImageCombiner;
import com.twg.common.utils.image.combiner.enums.OutputFormat;
import com.twg.framework.interceptor.IgnoreAuth;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Objects;

@RestController
@RequestMapping("/Png/Emo/Supt")
public class EmoSuptPngImageController {
    @IgnoreAuth
    @GetMapping(value = "/{uuid}/getImage/{id}/{ms}")
    public void getImage(@PathVariable("id") long id, @PathVariable("ms") int ms, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", MediaType.IMAGE_PNG_VALUE);
        //获取用户头像
        BufferedImage prk = new ImageCombiner(ImageIO.read(new URL(PrivateAddApi.getPrivateHeadHDImage(id))), OutputFormat.PNG).combine();
        RotateFilter filter = new RotateFilter();
        filter.setAngle(0.40F);
        ImageCombiner combiner = new ImageCombiner(Objects.requireNonNull(ImageUtils.getImage("/images-gif/emo-supt/emo.png")), OutputFormat.PNG);
        combiner.addImageElement(
                Thumbnails.of(filter.filter(prk)).size(1600, 1600).keepAspectRatio(false).asBufferedImage(),
                -145,
                -5
        );
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Thumbnails.of(combiner.combine()).scale(1).outputFormat("png").toOutputStream(out);
        response.getOutputStream().write(out.toByteArray());

    }
}
