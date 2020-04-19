package com.rh.ui.model;

import com.rh.ui.constant.ImageResources;
import com.rh.ui.exception.SnakerException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.swing.*;

/**
 * 蛇的身体
 */
@Data
@NoArgsConstructor
public class SnakerBody {

    public static final Direction DEF_DIRECTION = Direction.RIGHT;
    /**
     * 默认每块的边长
     */
    public static final Integer BODY_LENG = 30;

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
    private SnakerBody prevBody;
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
    public Direction getDirection() {
        SnakerBody prevBody = this.getPrevBody();
        if (prevBody == null) {
            return DEF_DIRECTION;
        }

        if (prevBody.getX() - getX() > 0) {
            return Direction.RIGHT;
        }

        if (prevBody.getX() - getX() < 0) {
            return Direction.LEFT;
        }

        if (prevBody.getY() - getY() > 0) {
            return Direction.DOWN;
        }

        if (prevBody.getY() - getY() < 0) {
            return Direction.UP;
        }

        throw new SnakerException(String.format("方向错误, nextBody.x=%s, nextBody.y=%s, x=%s, y=%s",
                prevBody.getX(), prevBody.getY(), getX(), getY()));
    }

    /**
     * 向前移动
     */
    public void moveForward() {
        if (prevBody == null) {
            throw new SnakerException("移动失败, 没有找到前一个节点");
        }
        setX(prevBody.getX());
        setY(prevBody.getY());
    }

    /**
     * 向前移动
     * 通过方向
     */
    public void moveForwardByDirection() {
        Direction direction = getDirection();
        if (direction == null) {
            throw new SnakerException("通过方向移动失败, 没有匹配的方向");
        }

        direction.moveForward(this);
    }

    /**
     * 设置初始位置<br>
     * 通过前一个设置
     */
    public void setInitPlace() {
        if (prevBody == null) {
            throw new SnakerException("增加尾巴时, 没有找到位置");
        }

        Direction direction = prevBody.getDirection();
        if (direction == null) {
            throw new SnakerException("增加尾巴时, 没有找到位置");
        }

        direction.setNextBodyPlace(this, prevBody);
    }
}
