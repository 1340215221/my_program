package com.rh.ui.controls

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingConstants
import javax.swing.WindowConstants
import java.awt.*

/**
 * JFrame与Frame的区别
 */
class JFrameDemo {

    static void main(String[] args) {
        groovy()
//        java()
    }

    static void java() {
        def label = new JLabel('欢迎使用swingBuilder')
        label.setHorizontalAlignment(SwingConstants.CENTER)

        def frame = new JFrame()
        frame.setSize(500, 500)
        frame.getContentPane().setBackground(Color.green)
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

        frame.add(label)

        frame.setVisible(true)
    }

    private static void groovy() {
        def builder = new SwingBuilder()

        def label = {
            builder.label(text: '欢迎使用swingBuilder',
                    horizontalAlignment: SwingConstants.CENTER // 设置水平居中, 默认为左对齐
            )
        }

        def panel = {
            builder.panel(background: Color.green){
                label()
            }
        }

        def frame = builder.frame(size: [500, 500],
//                background: Color.red,  // 这个颜色设置并不会生效, 因为在JFrame上会默认创建一个 panel 覆盖
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
        ){
            panel()
        }

        frame.visible = true
    }
}
