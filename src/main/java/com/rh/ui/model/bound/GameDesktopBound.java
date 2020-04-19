package com.rh.ui.model.bound;

import com.rh.ui.util.IInit;
import lombok.Setter;

/**
 * 游戏桌面范围
 */
public class GameDesktopBound implements IInit {

    /**
     * 上边距
     */
    @Setter
    private int topMargin = 10;
    /**
     * 下边距
     */
    @Setter
    private int downMargin = 10;
    /**
     * 左边距
     */
    @Setter
    private int leftMargin = 10;
    /**
     * 右边距
     */
    @Setter
    private int rightMargin = 10;
    /**
     * 一列几个贪吃蛇身体
     */
    @Setter
    private int severalPerColumn = 20;
    /**
     * 一行几个贪吃蛇身体
     */
    @Setter
    private int severalPerRow = 30;

    private SnakerBodyBound snakerBodyBound;

    public int getX() {
        return topMargin;
    }

    public int getY() {
        return leftMargin;
    }

    /**
     * 得到画布宽
     */
    public int getPaintW() {
        return severalPerRow * snakerBodyBound.getLeng();
    }

    /**
     * 得到画布高
     */
    public int getPaintH() {
        return severalPerColumn * snakerBodyBound.getLeng();
    }

    public void init(SnakerBodyBound snakerBodyBound) {
        this.snakerBodyBound = snakerBodyBound;
    }

    /**
     * 得到全宽<br>
     * 边框 + 游戏区域
     */
    public int getFullW() {
        return leftMargin + rightMargin + getPaintW();
    }

    /**
     * 得到全高<br>
     * 边框 + 游戏区域
     */
    public int getFullH() {
        return topMargin + downMargin + getPaintH();
    }

    /**
     * 获得画板x轴最大值
     */
    private int getMaxX() {
        return leftMargin + getPaintW() - snakerBodyBound.getLeng();
    }

    /**
     * 获得画板y轴最大值
     */
    private int getMaxY() {
        return topMargin + getPaintH() - snakerBodyBound.getLeng();
    }

    /**
     * 判断是否超出x坐标<br>
     * 超出则取反
     */
    public int checkSnakerMoveBoundX(int snakerHeadX) {
        if (snakerHeadX < getX()) {
            return getMaxX();
        }
        if (snakerHeadX > getMaxX()) {
            return getX();
        }

        return snakerHeadX;
    }

    /**
     * 判断是否超出y坐标<br>
     * 超出则取反
     */
    public int checkSnakerMoveBoundY(int snakerHeadY) {
        if (snakerHeadY < getY()) {
            return getMaxY();
        }
        if (snakerHeadY > getMaxY()) {
            return getY();
        }

        return snakerHeadY;
    }
}
