package com.rh.ui.model;

import com.rh.ui.view.SnakerPanel;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * 食物
 */
@Data
public class Food {

    private Integer x;
    private Integer y;

    /**
     * 随机生成一个位置
     */
    public void randomGeneration() {
        // todo
        x = 160;
        y = 310;
    }

    public void paint(SnakerPanel snakerPanel, Graphics g) {
//        imageIcon.(snakerPanel, g, x, y);
        g.setColor(Color.orange);
        g.fillOval(this.getX(), this.getY(), 30, 30);
        // 还原为黑色
        g.setColor(Color.black);
    }

    /**
     * 过滤蛇的位置
     * 不与蛇的身体重合
     */

    /**
     * 圆心x
     */
    public int getCenterOfCircleX() {
        return x + 15;
    }

    /**
     * 圆心x
     */
    public int getCenterOfCircleY() {
        return y + 15;
    }
}
