package com.twg.common.utils.image.combiner.painter;


import com.twg.common.utils.image.combiner.element.CombineElement;
import com.twg.common.utils.image.combiner.element.RectangleElement;
import com.twg.common.utils.image.combiner.enums.Direction;

import java.awt.*;

public class RectanglePainter implements IPainter {
    public RectanglePainter() {
    }

    public void draw(Graphics2D g, CombineElement element, int canvasWidth) {
        RectangleElement rectangleElement = (RectangleElement) element;
        g.setColor(rectangleElement.getColor());
        if (rectangleElement.isCenter()) {
            int centerX = (canvasWidth - rectangleElement.getWidth()) / 2;
            rectangleElement.setX(centerX);
        } else if (rectangleElement.getDirection() == Direction.RightLeft) {
            rectangleElement.setX(rectangleElement.getX() - rectangleElement.getWidth());
        } else if (rectangleElement.getDirection() == Direction.CenterLeftRight) {
            rectangleElement.setX(rectangleElement.getX() - rectangleElement.getWidth() / 2);
        }

        if (rectangleElement.getFromColor() != null) {
            float fromX = 0.0F;
            float fromY = 0.0F;
            float toX = 0.0F;
            float toY = 0.0F;
            switch (rectangleElement.getGradientDirection()) {
                case TopBottom:
                    fromX = (float) (rectangleElement.getX() + rectangleElement.getWidth() / 2);
                    fromY = (float) (rectangleElement.getY() - rectangleElement.getFromExtend());
                    toX = fromX;
                    toY = (float) (rectangleElement.getY() + rectangleElement.getHeight() + rectangleElement.getToExtend());
                    break;
                case LeftRight:
                    fromX = (float) (rectangleElement.getX() - rectangleElement.getFromExtend());
                    fromY = (float) (rectangleElement.getY() + rectangleElement.getHeight() / 2);
                    toX = (float) (rectangleElement.getX() + rectangleElement.getWidth() + rectangleElement.getToExtend());
                    toY = fromY;
                    break;
                case LeftTopRightBottom:
                    fromX = (float) rectangleElement.getX() - (float) Math.sqrt((double) rectangleElement.getFromExtend());
                    fromY = (float) rectangleElement.getY() - (float) Math.sqrt((double) rectangleElement.getFromExtend());
                    toX = (float) (rectangleElement.getX() + rectangleElement.getWidth()) + (float) Math.sqrt((double) rectangleElement.getToExtend());
                    toY = (float) (rectangleElement.getY() + rectangleElement.getHeight()) + (float) Math.sqrt((double) rectangleElement.getToExtend());
                    break;
                case RightTopLeftBottom:
                    fromX = (float) (rectangleElement.getX() + rectangleElement.getWidth()) + (float) Math.sqrt((double) rectangleElement.getFromExtend());
                    fromY = (float) rectangleElement.getY() - (float) Math.sqrt((double) rectangleElement.getFromExtend());
                    toX = (float) rectangleElement.getX() - (float) Math.sqrt((double) rectangleElement.getToExtend());
                    toY = (float) (rectangleElement.getY() + rectangleElement.getHeight()) + (float) Math.sqrt((double) rectangleElement.getToExtend());
            }

            g.setPaint(new GradientPaint(fromX, fromY, rectangleElement.getFromColor(), toX, toY, rectangleElement.getToColor()));
        } else {
            g.setPaint(null);
        }

        g.setComposite(AlphaComposite.getInstance(3, rectangleElement.getAlpha()));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillRoundRect(rectangleElement.getX(), rectangleElement.getY(), rectangleElement.getWidth(), rectangleElement.getHeight(), rectangleElement.getRoundCorner(), rectangleElement.getRoundCorner());
    }
}

