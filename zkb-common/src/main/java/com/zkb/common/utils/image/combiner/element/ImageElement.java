package com.zkb.common.utils.image.combiner.element;


import com.zkb.common.utils.image.combiner.enums.ZoomMode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImageElement extends CombineElement<ImageElement> {
    private BufferedImage image;
    private String imgUrl;
    private Integer width;
    private Integer height;
    private Integer roundCorner;
    private ZoomMode zoomMode;
    private Integer rotate;
    private Integer blur;

    public ImageElement(String imgUrl, int x, int y) throws Exception {
        this.imgUrl = imgUrl;
        this.width = this.getImage().getWidth();
        this.height = this.getImage().getHeight();
        this.zoomMode = ZoomMode.Origin;
        super.setX(x);
        super.setY(y);
    }

    public ImageElement(BufferedImage image, int x, int y) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.zoomMode = ZoomMode.Origin;
        super.setX(x);
        super.setY(y);
    }

    public ImageElement(String imgUrl, int x, int y, int width, int height, ZoomMode zoomMode) {
        this.imgUrl = imgUrl;
        this.width = width;
        this.height = height;
        this.zoomMode = zoomMode;
        super.setX(x);
        super.setY(y);
    }

    public ImageElement(BufferedImage image, int x, int y, int width, int height, ZoomMode zoomMode) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.zoomMode = zoomMode;
        super.setX(x);
        super.setY(y);
    }

    public BufferedImage getImage() throws Exception {
        if (this.image == null) {
            try {
                this.image = ImageIO.read(new URL(this.imgUrl));
            } catch (Exception var2) {
                throw var2;
            }
        }

        return this.image;
    }

    public ImageElement setImage(BufferedImage image) {
        this.image = image;
        return this;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public ImageElement setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Integer getWidth() {
        return this.width;
    }

    public ImageElement setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public ImageElement setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getRoundCorner() {
        return this.roundCorner;
    }

    public ImageElement setRoundCorner(Integer roundCorner) {
        this.roundCorner = roundCorner;
        return this;
    }

    public ZoomMode getZoomMode() {
        return this.zoomMode;
    }

    public ImageElement setZoomMode(ZoomMode zoomMode) {
        this.zoomMode = zoomMode;
        return this;
    }

    public Integer getRotate() {
        return this.rotate;
    }

    public ImageElement setRotate(Integer rotate) {
        this.rotate = rotate;
        return this;
    }

    public Integer getBlur() {
        return this.blur;
    }

    public void setBlur(Integer blur) {
        this.blur = blur;
    }
}

