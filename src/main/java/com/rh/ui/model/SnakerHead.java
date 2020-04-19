package com.rh.ui.model;

import com.rh.ui.constant.ImageResources;
import com.rh.ui.model.bound.BoundFactory;
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
        setX(BoundFactory.checkSnakerMoveBoundX(getX()));
        setY(BoundFactory.checkSnakerMoveBoundY(getY()));
    }

}
