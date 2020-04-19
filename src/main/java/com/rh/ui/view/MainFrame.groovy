package com.rh.ui.view

import com.rh.ui.factory.BaseFrameFactory
import com.rh.ui.factory.SnakerPanelFactory
import com.rh.ui.model.bound.BoundFactory
import groovy.swing.SwingBuilder

import javax.swing.*

class MainFrame {

    void init() {
        def swingBuilder = new SwingBuilder()
        swingBuilder.registerFactory('frame', new BaseFrameFactory())
        swingBuilder.registerFactory('snakerPanel', new SnakerPanelFactory())

        def frame = swingBuilder.frame(title: '贪吃蛇',
                bounds: BoundFactory.getFrameBound(),
                resizable: false, // 窗口大小不可变
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
        ) {
            snakerPanel()
        }

        frame.visible = true;
    }

}
