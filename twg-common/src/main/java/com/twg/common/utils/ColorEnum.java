package com.twg.common.utils;

import java.awt.*;

public enum ColorEnum {
    COLOR_BACKGROUND(new Color(226, 187, 131, 145)),
    COLOR_FORM(new Color(251, 238, 226)),
    COLOR_MINOR(new Color(46, 112, 167)),
    COLOR_CHIEF(new Color(14, 176, 201)),
    COLOR_BACK(new Color(163, 92, 143)),
    COLOR_G(new Color(152, 101, 36)),
    COLOR_NODE(new Color(252, 99, 21)),
    COLOR_DUCATS(new Color(169, 151, 110)),
    COLOR_TENGLUOZI(new Color(128, 118, 163)),
    COLOR_MEIDIELV(new Color(18, 170, 156)),
    COLOR_RIVEN_TION(new Color(152, 135, 171)),
    COLOR_RIVEN_MOD(new Color(0, 245, 255)),
    COLOR_GOLD(new Color(250, 192, 0)),
    COLOR_TAN(new Color(171, 105, 0)),
    COLOR_RIVEN_UP(new Color(39, 174, 96)),
    COLOR_RIVEN_DOW(new Color(192, 57, 43)),
    COLOR_TIME_BACKGROUND(new Color(144, 123, 58)),
    COLOR_TIME_FONT(new Color(227, 209, 89)),
    COLOR_PRICE_BACKGROUND(new Color(91, 57, 133)),
    COLOR_PRICE_FONT(new Color(225, 110, 232)),
    MAGENTA(new Color(255, 0, 255)),
    COLOR_TEST(new Color(186, 208, 255)),
    ;
    private final Color color;

    ColorEnum(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
