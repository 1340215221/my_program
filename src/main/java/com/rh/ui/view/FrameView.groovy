package com.rh.ui.view

import com.rh.ui.factory.SnakerPanelFactory
import groovy.swing.SwingBuilder

import javax.swing.*

class FrameView {

    void init() {
        def swingBuilder = new SwingBuilder()
        swingBuilder.registerFactory('snakerPanel', new SnakerPanelFactory())

        def frame = swingBuilder.frame(title: '贪吃蛇',
                bounds: [500, 200, 900, 600],
                resizable: false, // 窗口大小不可变
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
        ) {
            snakerPanel()
        }

        frame.visible = true;
    }

}
