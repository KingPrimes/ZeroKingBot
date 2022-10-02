package com.zkb.common.utils.htmltoimage;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.simple.Graphics2DRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderToImage {

    /**
     * 高清Html转Image
     * @param url url
     * @param width 宽度
     * @param bufferedImageType bufferedImageType
     * @return BufferedImage
     */
    public static BufferedImage renderToImageAutoSize(String url, int width, int bufferedImageType) {
        Graphics2DRenderer g2r = new Graphics2DRenderer();
        g2r.setDocument(url);
        SharedContext sharedContext = g2r.getSharedContext();
        //设置图片清晰度
        sharedContext.setDPI(523);
        sharedContext.setDotsPerPixel(3);
        Dimension dim = new Dimension(width, 1000);
        BufferedImage buff = new BufferedImage((int)dim.getWidth(), (int)dim.getHeight(), bufferedImageType);
        Graphics2D g = (Graphics2D)buff.getGraphics();
        g2r.layout(g, new Dimension(width, 1000));
        g.dispose();
        Rectangle rect = g2r.getMinimumSize();
        buff = new BufferedImage((int)rect.getWidth(), (int)rect.getHeight(), bufferedImageType);
        g = (Graphics2D)buff.getGraphics();
        g2r.render(g);
        g.dispose();
        return buff;
    }
}
