package com.rh.ui.controls


import java.awt.*

/**
 * 窗口
 */
class FrameDemo {

    static void main(String[] args) {

        def frame = new Frame(title: '第一个窗口',
                width: 400,
                height: 400,
                resizable: false,
                x: 200,
                y: 200,
                background: new Color(8, 150, 68),
                location: [200, 200],
                visible: true
        )
    }

}
