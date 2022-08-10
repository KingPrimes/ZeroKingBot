package com.twg.bot.warframe.utils.forums;


import com.twg.bot.warframe.domain.WarframeRivenTrend;
import com.twg.common.utils.Fonts;
import com.twg.common.utils.Seat;
import com.twg.common.utils.image.ImageUtils;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.twg.common.utils.ColorEnum.*;

@Component
public class RivenDispositionUpdatesImage {

    public static void getImage(List<WarframeRivenTrend> rt) throws Exception {
        List<Seat> seatList = new ArrayList<>();
        BufferedImage image = ImageUtils.getImage("/images/riven-news.png");
        String text = "---本次紫卡倾向更新如下---";
        seatList.add(ImageUtils.getSeat(text, 575, 120, COLOR_MINOR, Fonts.FONT_SOURCE_CN_MEDIUM_BOLD));
        seatList.add(ImageUtils.getSeat(rt.get(0).getIsDate(), 1240, 1530, COLOR_RIVEN_MOD, Fonts.FONT_SOURCE_CN_MEDIUM_BOLD));
        int x = 90, y = 160;
        //遍历WfRivenTrend集合
        for (WarframeRivenTrend trend : rt) {
            text = trend.getTraCh() + ":" + trend.getRivenTrendOldNum() + " -> " + trend.getRivenTrendNewNum();
            if (Double.parseDouble(trend.getRivenTrendNewNum()) > Double.parseDouble(trend.getRivenTrendOldNum())) {
                seatList.add(
                        ImageUtils.getSeat(
                                text,
                                x,
                                y,
                                COLOR_RIVEN_UP,
                                Fonts.FONT_SOURCE_CN_MEDIUM_BOLD));
            } else {
                seatList.add(
                        ImageUtils.getSeat(
                                text,
                                x,
                                y,
                                COLOR_RIVEN_DOW,
                                Fonts.FONT_SOURCE_CN_MEDIUM_BOLD));
            }
            y += Fonts.FONT_SOURCE_CN_MEDIUM_BOLD.getSize() * 2;
            if (y > 1400) {
                x += 420;
                y = 160;
            }
        }
        assert image != null;
        ImageIO.write(ImageUtils.getBufferedImage(image, seatList), "jpg", new File("./renew-riven-disposition.jpg"));
        //return URLDecoder.decode(RivenDispositionUpdatesImage.class.getProtectionDomain().getCodeSource().getLocation().getPath(),"UTF-8") +"renew-riven-disposition.jpg";
    }


}
