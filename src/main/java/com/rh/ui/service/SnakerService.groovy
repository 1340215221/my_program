package com.rh.ui.service

import com.rh.ui.factory.BaseFrameFactory
import com.rh.ui.factory.SnakerPanelFactory
import com.rh.ui.model.bound.BoundFactory
import groovy.swing.SwingBuilder

import javax.swing.*

class SnakerService {

    private JFrame frame;
    private JPanel panel;

    /**
     * 启动
     */
    void startApp() {
        def swingBuilder = new SwingBuilder()
        swingBuilder.registerFactory('frame', new BaseFrameFactory())
        swingBuilder.registerFactory('snakerPanel', new SnakerPanelFactory())

        frame = swingBuilder.frame(title: '贪吃蛇',
                bounds: BoundFactory.getFrameBound(),
                resizable: false, // 窗口大小不可变
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
        ) {
            panel = snakerPanel()
        }

        frame.visible = true;
    }

    /**
     * 方向键移动贪吃蛇
     */
    void moveSnaker() {
    }
}
