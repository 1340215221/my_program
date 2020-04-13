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
    private final ImageIcon imageIcon = null; // todo

    /**
     * 随机生成一个位置
     */
    public void randomGeneration() {
        // todo
    }

    public void paint(SnakerPanel snakerPanel, Graphics g) {
        imageIcon.paintIcon(snakerPanel, g, x, y);
    }

    /**
     * 过滤蛇的位置
     * 不与蛇的身体重合
     */
}
