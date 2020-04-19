package com.rh.ui.view;

import com.rh.ui.model.Food;
import com.rh.ui.model.Snaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.rh.ui.model.Direction.DOWN;
import static com.rh.ui.model.Direction.LEFT;
import static com.rh.ui.model.Direction.RIGHT;
import static com.rh.ui.model.Direction.UP;
import static com.rh.ui.model.bound.BoundFactory.getPaintH;
import static com.rh.ui.model.bound.BoundFactory.getPaintW;
import static com.rh.ui.model.bound.BoundFactory.getPaintX;
import static com.rh.ui.model.bound.BoundFactory.getPaintY;

/**
 * 绘制贪吃蛇
 */
public class SnakerPanel extends JPanel implements KeyListener, ActionListener {

    private Snaker snaker = new Snaker();
    private Food food = new Food();

    {
        snaker.init();
        food.init();
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
        g.fillRect(getPaintX(), getPaintY(), getPaintW(), getPaintH());

        food.paint(this, g);
        snaker.paint(this, g);

        if (!snaker.getGameState()) {
            g.setColor(Color.red);
            g.setFont(new Font("Ubuntu Regular", Font.BOLD, 40));
            g.drawString("暂停", 200, 200);
            g.setColor(Color.black); // 还原为黑色
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
            snaker.setNextDirection(UP);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            snaker.setNextDirection(DOWN);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            snaker.setNextDirection(LEFT);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            snaker.setNextDirection(RIGHT);
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
        if (snaker.getGameState()) {
            snaker.changeDirection();
            snaker.moveForward();
        }

        // 蛇是否吃到食物了
        boolean isEatFood = snaker.checkIsEatFood(food);
        food.randomGeneration(snaker.getGameState(), isEatFood);
        snaker.increase(isEatFood);

        this.repaint();
    }
}
