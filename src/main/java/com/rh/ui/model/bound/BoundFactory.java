package com.rh.ui.model.bound;

import com.rh.ui.util.IInit;

import java.util.List;

/**
 * 初始化范围<br>
 * 聚合各个范围的关联关系的地方
 */
public class BoundFactory implements IInit {

    public static BoundFactory boundFactory = new BoundFactory();

    static {
        boundFactory.init();
    }

    private ScreenBound screenBound = new ScreenBound();
    private FrameBound frameBound = new FrameBound();
    private GameDesktopBound gameDesktopBound = new GameDesktopBound();
    private SnakerBodyBound snakerBodyBound = new SnakerBodyBound();

    public void init() {
        gameDesktopBound.init(snakerBodyBound);
        frameBound.init(screenBound, gameDesktopBound);
    }

    /**
     * 得到窗口的范围
     */
    public static List<Integer> getFrameBound() {
        return boundFactory.frameBound.getBound();
    }

    /**
     * 得到画布的x
     */
    public static int getPaintX() {
        return boundFactory.gameDesktopBound.getX();
    }

    /**
     * 得到画布的y
     */
    public static int getPaintY() {
        return boundFactory.gameDesktopBound.getY();
    }

    /**
     * 得到画布的w
     */
    public static int getPaintW() {
        return boundFactory.gameDesktopBound.getPaintW();
    }

    /**
     * 得到画布的h
     */
    public static int getPaintH() {
        return boundFactory.gameDesktopBound.getPaintH();
    }

    /**
     * 判断是否超出x坐标<br>
     * 超出则取反
     */
    public static int checkSnakerMoveBoundX(int snakerHeadX) {
        return boundFactory.gameDesktopBound.checkSnakerMoveBoundX(snakerHeadX);
    }

    /**
     * 判断是否超出y坐标<br>
     * 超出则取反
     */
    public static int checkSnakerMoveBoundY(int snakerHeadY) {
        return boundFactory.gameDesktopBound.checkSnakerMoveBoundY(snakerHeadY);
    }
}
