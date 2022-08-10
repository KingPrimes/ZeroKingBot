package com.twg.common.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 文字的 x y位置 与文本 字体 颜色
 */
public class Seat {
    private int x;
    private int y;
    private String msg;
    private Font font;
    private ColorEnum color;
    private String imagePaeh;
    private BufferedImage image;

    public Seat(Font font) {
        this.font = font;
    }

    public Seat(Font font, ColorEnum color) {
        this.font = font;
        this.color = color;
    }

    public Seat(BufferedImage image, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public Seat(String imagePaeh, int x, int y) {
        this.imagePaeh = imagePaeh;
        this.x = x;
        this.y = y;
    }

    public Seat(Font font, ColorEnum color, int x, int y, String msg) {
        this.font = font;
        this.color = color;
        this.x = x;
        this.y = y;
        this.msg = msg;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getImagePaeh() {
        return imagePaeh;
    }

    public void setImagePaeh(String imagePaeh) {
        this.imagePaeh = imagePaeh;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }
}
