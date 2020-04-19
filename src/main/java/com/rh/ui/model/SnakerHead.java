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
    private Direction direction = DEF_DIRECTION;
    /**
     * 下一个移动方向
     */
    private Direction nextDirection;

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
        // todo 蛇头如果碰到了原本的身体会将其截断
    }

    /**
     * 超过边框范围, 从另一头开始
     */
    private void transboundaryReset() {
        setX(BoundFactory.checkSnakerMoveBoundX(getX()));
        setY(BoundFactory.checkSnakerMoveBoundY(getY()));
    }

    /**
     * 判断是否为反向移动
     */
    public boolean checkIsReverseMove() {
        if (this.getNextDirection() == null) {
            return true;
        }

        return this.getDirection().checkIsOpposite(this.getNextDirection());
    }

    /**
     * 设置初始位置
     */
    @Override
    public void setInitPlace() {
        this.setX(Snaker.SNAKER_BODY_INIT_PLACE_X);
        this.setY(Snaker.SNAKER_BODY_INIT_PLACE_Y);
    }

    /**
     * 改变方向
     */
    public void changeDirection() {
        if (this.getNextDirection() == null) {
            return;
        }

        direction = this.getNextDirection();
    }
}
