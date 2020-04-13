package com.rh.ui.view;

import com.rh.ui.model.Food;
import com.rh.ui.model.Snaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.rh.ui.model.SnakerBody.Direction.DOWN;
import static com.rh.ui.model.SnakerBody.Direction.LEFT;
import static com.rh.ui.model.SnakerBody.Direction.RIGHT;
import static com.rh.ui.model.SnakerBody.Direction.UP;

/**
 * 绘制贪吃蛇
 */
public class SnakerPanel extends JPanel implements KeyListener, ActionListener {

    private Snaker snaker = new Snaker();
    private Food food = new Food();

    {
        snaker.init();
        food.randomGeneration();
        setFocusable(true); // 获取焦点事件
        addKeyListener(this); // 键盘监听, 开启键盘监听必须设置 setFocusable(true)
    }

    /**
     * 定时器
     */
    private Timer timer = new Timer(200, this);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 清屏

        // 绘制静态面板
        g.fillRect(10, 50, 900, 410);

        snaker.paint(this, g);
        food.paint(this, g);

        if (!snaker.getGameState()) {
            g.setColor(Color.red);
            g.setFont(new Font("Ubuntu Regular", Font.BOLD, 40));
            g.drawString("暂停", 200, 200);
        }

        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            snaker.changeGameState();
            this.refreshSnaker();
        }
        if (keyCode == KeyEvent.VK_UP) {
            snaker.changeDirection(UP.getValue());
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            snaker.changeDirection(DOWN.getValue());
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            snaker.changeDirection(LEFT.getValue());
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            snaker.changeDirection(RIGHT.getValue());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        refreshSnaker();
    }

    private void refreshSnaker() {
        if (!snaker.getGameState()) {
            return;
        }

        snaker.moveForward();
        this.repaint();
    }
}
