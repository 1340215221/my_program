package com.rh.ui.frame

import java.awt.Color
import java.awt.Frame

class FrameDemo {

    static void main(String[] args) {
//        def frame = new Frame('第一个窗口')
//        frame.setVisible(true)
//        frame.setSize(400, 400)
//         设置背景颜色, 在java文件中有插件可以调
//        frame.setBackground(new Color(8, 150, 68))
//        frame.setLocation(200, 200)
//         设置大小固定
//        frame.setResizable(false)

        def frame1 = new Frame(width: 400,
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
