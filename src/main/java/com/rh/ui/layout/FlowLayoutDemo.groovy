package com.rh.ui.layout

import java.awt.Button
import java.awt.FlowLayout
import java.awt.Frame

/**
 * 流式布局, 左右中
 */
class FlowLayoutDemo {

    static void main(String[] args) {
        java()
    }

    private static void java() {
        def button1 = new Button('注册')
        def button2 = new Button('登陆')
        def button3 = new Button('登出')

        def frame = new Frame(size: [500, 500],
                // 流式布局默认为中
//                layout: new FlowLayout(),
                layout: new FlowLayout(FlowLayout.RIGHT),
        )

        frame.add(button1)
        frame.add(button2)
        frame.add(button3)

        frame.setVisible(true)
    }

}
