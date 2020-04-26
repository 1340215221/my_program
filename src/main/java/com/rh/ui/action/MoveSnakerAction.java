package com.rh.ui.action;

import com.rh.ui.service.SnakerService;

/**
 * 移动蛇
 */
public class MoveSnakerAction {

    private SnakerService snakerService = new SnakerService();

    /**
     * 启动
     */
    public void startApp() {
        snakerService.startApp();
    }

    /**
     * 移动
     */
    public void moveSnaker() {
        snakerService.moveSnaker();
    }

}
