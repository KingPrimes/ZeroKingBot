package com.twg.common.utils.image.combiner.element;


import com.twg.common.utils.image.combiner.enums.LineAlign;
import sun.font.FontDesignMetrics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TextElement extends CombineElement<TextElement> {
    private FontDesignMetrics metrics;
    private String text;
    private Font font;
    private boolean strikeThrough;
    private Color color = new Color(0, 0, 0);
    private Integer rotate;
    private Integer lineHeight;
    private Integer width;
    private Integer height;
    private Integer drawY;
    private boolean autoBreakLine = false;
    private int maxLineWidth = 600;
    private int maxLineCount = 2;
    private LineAlign lineAlign;
    private List<TextElement> breakLineElements;

    public TextElement(String text, Font font, int x, int y) {
        this.lineAlign = LineAlign.Left;
        this.text = text;
        this.font = font;
        super.setX(x);
        super.setY(y);
    }

    public TextElement(String text, int fontSize, int x, int y) {
        this.lineAlign = LineAlign.Left;
        this.text = text;
        this.font = new Font("阿里巴巴普惠体", 0, fontSize);
        super.setX(x);
        super.setY(y);
    }

    public TextElement(String text, String fontName, int fontSize, int x, int y) {
        this.lineAlign = LineAlign.Left;
        this.text = text;
        this.font = new Font(fontName, 0, fontSize);
        super.setX(x);
        super.setY(y);
    }

    public Integer getWidth() {
        if (this.width == null) {
            this.width = this.getMetrics().stringWidth(this.text);
        }

        return this.width;
    }

    public Integer getHeight() {
        if (this.height == null) {
            if (this.autoBreakLine) {
                this.height = this.getLineHeight() * this.getBreakLineElements().size();
            } else {
                this.height = this.getLineHeight();
            }
        }

        return this.height;
    }

    public Integer getDrawY() {
        if (this.drawY == null) {
            this.drawY = this.getY() + (this.getLineHeight() - this.getMetrics().getHeight()) / 2 + this.getMetrics().getAscent();
        }

        return this.drawY;
    }

    public List<TextElement> getBreakLineElements() {
        if (this.breakLineElements == null) {
            this.breakLineElements = this.computeBreakLineElements();
        }

        return this.breakLineElements;
    }

    public String getText() {
        return this.text;
    }

    public TextElement setText(String text) {
        this.text = text;
        this.resetProperties();
        return this;
    }

    public Font getFont() {
        return this.font;
    }

    public TextElement setFont(Font font) {
        this.font = font;
        this.resetProperties();
        return this;
    }

    public Integer getRotate() {
        return this.rotate;
    }

    public TextElement setRotate(Integer rotate) {
        this.rotate = rotate;
        return this;
    }

    public Color getColor() {
        return this.color;
    }

    public TextElement setColor(Color color) {
        this.color = color;
        return this;
    }

    public TextElement setColor(int r, int g, int b) {
        return this.setColor(new Color(r, g, b));
    }

    public Integer getLineHeight() {
        if (this.lineHeight == null) {
            this.lineHeight = this.getMetrics().getHeight();
        }

        return this.lineHeight;
    }

    public TextElement setLineHeight(Integer lineHeight) {
        this.lineHeight = lineHeight;
        this.resetProperties();
        return this;
    }

    public boolean isStrikeThrough() {
        return this.strikeThrough;
    }

    public TextElement setStrikeThrough(boolean strikeThrough) {
        this.strikeThrough = strikeThrough;
        return this;
    }

    public boolean isAutoBreakLine() {
        return this.autoBreakLine;
    }

    public TextElement setAutoBreakLine(int maxLineWidth, int maxLineCount, int lineHeight) {
        this.autoBreakLine = true;
        this.maxLineWidth = maxLineWidth;
        this.maxLineCount = maxLineCount;
        this.lineHeight = lineHeight;
        return this;
    }

    public TextElement setAutoBreakLine(int maxLineWidth, int maxLineCount) {
        this.autoBreakLine = true;
        this.maxLineWidth = maxLineWidth;
        this.maxLineCount = maxLineCount;
        return this;
    }

    public TextElement setAutoBreakLine(int maxLineWidth, int maxLineCount, int lineHeight, LineAlign lineAlign) {
        this.autoBreakLine = true;
        this.maxLineWidth = maxLineWidth;
        this.maxLineCount = maxLineCount;
        this.lineHeight = lineHeight;
        this.lineAlign = lineAlign;
        return this;
    }

    public TextElement setAutoBreakLine(int maxLineWidth, int maxLineCount, LineAlign lineAlign) {
        this.autoBreakLine = true;
        this.maxLineWidth = maxLineWidth;
        this.maxLineCount = maxLineCount;
        this.lineAlign = lineAlign;
        return this;
    }

    public LineAlign getLineAlign() {
        return this.lineAlign;
    }

    private void resetProperties() {
        this.width = null;
        this.height = null;
        this.drawY = null;
        this.breakLineElements = null;
    }

    private FontDesignMetrics getMetrics() {
        if (this.metrics == null) {
            this.metrics = FontDesignMetrics.getMetrics(this.font);
        }

        return this.metrics;
    }

    private List<TextElement> computeBreakLineElements() {
        List<TextElement> breakLineElements = new ArrayList();
        List<String> breakLineTexts = this.computeLines(this.text);
        int currentY = this.getY();

        for (int i = 0; i < breakLineTexts.size() && i < this.maxLineCount; ++i) {
            String text = breakLineTexts.get(i);
            if (i == this.maxLineCount - 1 && i < breakLineTexts.size() - 1) {
                text = text.substring(0, text.length() - 1) + "...";
            }

            TextElement textLineElement = new TextElement(text, this.font, this.getX(), currentY);
            textLineElement.setColor(this.color);
            textLineElement.setStrikeThrough(this.strikeThrough);
            textLineElement.setCenter(this.isCenter());
            textLineElement.setAlpha(this.getAlpha());
            textLineElement.setRotate(this.rotate);
            textLineElement.setLineHeight(this.getLineHeight());
            textLineElement.setDirection(this.getDirection());
            breakLineElements.add(textLineElement);
            currentY += this.getLineHeight();
        }

        return breakLineElements;
    }

    private List<String> computeLines(String text) {
        List<String> computedLines = new ArrayList();
        String strToComputer = "";
        String word = "";
        boolean hasWord = false;
        char[] chars = text.toCharArray();
        int count = 0;

        for (int i = 0; i < chars.length && count++ <= 2000; ++i) {
            char c = chars[i];
            if (!this.isChineseChar(c) && c != ' ' && i != chars.length - 1) {
                word = word + c;
            } else {
                word = word + c;
                hasWord = true;
            }

            if (hasWord) {
                int originWidth = this.getMetrics().stringWidth(strToComputer);
                int wordWidth = this.getMetrics().stringWidth(word);
                strToComputer = strToComputer + word;
                int newWidth = originWidth + wordWidth;
                if (wordWidth > this.maxLineWidth) {
                    int fetch = (int) ((float) (this.maxLineWidth - originWidth) / (float) wordWidth * (float) word.length());
                    strToComputer = strToComputer.substring(0, strToComputer.length() - word.length() + fetch);
                    computedLines.add(strToComputer);
                    strToComputer = "";
                    i -= word.length() - fetch;
                } else if (newWidth > this.maxLineWidth) {
                    strToComputer = strToComputer.substring(0, strToComputer.length() - word.length());
                    computedLines.add(strToComputer);
                    strToComputer = "";
                    i -= word.length();
                }

                word = "";
                hasWord = false;
            }
        }

        if (strToComputer != "") {
            computedLines.add(strToComputer);
        }

        return computedLines;
    }

    private boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[一-龥]");
    }
}
