package com.rh.ui.model;

import com.rh.ui.constant.ImageResources;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 蛇头
 */
@Data
@NoArgsConstructor
public class SnakerHead extends SnakerBody {

    /**
     * 方向
     */
    private String direction = DEF_DIRECTION;

    /**
     * 初始化
     */
    {
        setImageIcon(ImageResources.bodyIcon);
    }

    @Override
    public void moveForward() {
        super.moveForwardByDirection();
        transboundaryReset();
    }

    /**
     * 超过边框范围, 从另一头开始
     */
    private void transboundaryReset() {
        if (getX() < 0) {
            setX(900);
        }
        if (getX() > 900) {
            setX(0);
        }
        if (getY() < 0) {
            setY(600);
        }
        if (getY() > 600) {
            setY(0);
        }
    }

}
