package com.zkb.common.utils.image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RotateImage {
    /**
     * 旋转图片
     *
     * @param image  图片
     * @param rotate 旋转的角度
     * @return 处理后的图片
     */
    public static BufferedImage rotateImage(BufferedImage image, double rotate) {
        double width = image.getWidth();
        double height = image.getHeight();
        int type = image.getType();

        BufferedImage result = new BufferedImage((int) width, (int) height, type);
        Graphics2D g2 = result.createGraphics();
        g2.rotate(Math.toRadians(rotate), width / 2, height / 2);
        g2.drawImage(image, null, 0, 0);
        return result;
    }
}
