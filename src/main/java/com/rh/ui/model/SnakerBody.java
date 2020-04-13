package com.rh.ui.model;

import com.rh.ui.constant.ImageResources;
import com.rh.ui.exception.SnakerException;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.*;

/**
 * 蛇的身体
 */
@Data
@NoArgsConstructor
public class SnakerBody {

    public static final String DEF_DIRECTION = Direction.RIGHT.getValue();
    public static final Integer SNAKER_BODY_W = 30;
    public static final Integer SNAKER_BODY_H = 30;

    /**
     * 大小
     */
    /**
     * 位置
     */
    private Integer x;
    private Integer y;
    /**
     * 前一个
     */
    private SnakerBody nextBody;
    /**
     * 后一个
     */
    /**
     * 显示样子
     */
    private ImageIcon imageIcon = ImageResources.headIcon;

    /**
     * 获得方向
     */
    public String getDirection() {
        SnakerBody nextBody = this.getNextBody();
        if (nextBody == null) {
            return DEF_DIRECTION;
        }

        if (nextBody.getX() - getX() > 0) {
            return Direction.RIGHT.getValue();
        }

        if (nextBody.getX() - getX() < 0) {
            return Direction.LEFT.getValue();
        }

        if (nextBody.getY() - getY() > 0) {
            return Direction.DOWN.getValue();
        }

        if (nextBody.getY() - getY() < 0) {
            return Direction.UP.getValue();
        }

        throw new SnakerException(String.format("方向错误, nextBody.x=%s, nextBody.y=%s, x=%s, y=%s",
                nextBody.getX(), nextBody.getY(), getX(), getY()));
    }

    /**
     * 向前移动
     */
    public void moveForward() {
        if (nextBody == null) {
            throw new SnakerException("移动失败, 没有找到前一个节点");
        }
        setX(nextBody.getX());
        setY(nextBody.getY());
    }

    /**
     * 向前移动
     * 通过方向
     */
    public void moveForwardByDirection() {
        String direction = getDirection();
        if (Direction.DOWN.equals(direction)) {
            y = y + SNAKER_BODY_H;
            return;
        }
        if (Direction.UP.equals(direction)) {
            y = y - SNAKER_BODY_H;
            return;
        }
        if (Direction.LEFT.equals(direction)) {
            x = x - SNAKER_BODY_H;
            return;
        }
        if (Direction.RIGHT.equals(direction)) {
            x = x + SNAKER_BODY_H;
            return;
        }

        throw new SnakerException("通过方向移动失败, 没有匹配的方向");
    }

    /**
     * 方向
     */
    @Getter
    public enum Direction {
        DOWN("down"),
        UP("up"),
        LEFT("left"),
        RIGHT("right"),
        ;

        String value;

        Direction(String value) {
            this.value = value;
        }
        public boolean equals(String value) {
            return this.value.equals(value);
        }
    }

}
