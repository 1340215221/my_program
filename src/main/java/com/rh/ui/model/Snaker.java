package com.rh.ui.model;

import com.rh.ui.exception.SnakerException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

@Data
public class Snaker {

    /**
     * 初始化长度
     */
    public static final Integer SNAKER_BODY_INIT_LENG = 3;
    /**
     * 初始化位置
     */
    public static final Integer SNAKER_BODY_INIT_PLACE_X = 100;
    public static final Integer SNAKER_BODY_INIT_PLACE_Y = 100;

    /**
     * 贪吃蛇身体
     */
    private final SnakerBodyList bodyList = new SnakerBodyList();
    /**
     * 游戏状态
     */
    private Boolean gameState = true;

    /**
     * 初始化蛇头和两格身体
     */
    public void init() {
        bodyList.add(new SnakerHead());
        bodyList.add(new SnakerBody());
        bodyList.add(new SnakerBody());
    }

    /**
     * 画蛇
     */
    public void paint(JPanel panel, Graphics g) {
        bodyList.forEach(body -> body.getImageIcon().paintIcon(panel, g, body.getX(), body.getY()));
    }

    /**
     * 变更游戏状态
     */
    public void changeGameState() {
        gameState = !gameState;
    }

    /**
     * 向前移动
     */
    public void moveForward() {
        SnakerBody endBody = bodyList.getEndBody();
        if (endBody == null) {
            throw new SnakerException("移动失败, 没有找到[蛇的尾巴]");
        }

        SnakerBody forwardBody = endBody;
        while (forwardBody != null) {
            forwardBody = moveForwardFunction.apply(forwardBody);
        }
    }

    Function<SnakerBody, SnakerBody> moveForwardFunction = body -> {
        if (body == null) {
            return null;
        }

        body.moveForward();
        return body.getNextBody();
    };

    /**
     * 改变方向
     */
    public void changeDirection(String direction) {
        bodyList.changeDirection(direction);
    }

}
