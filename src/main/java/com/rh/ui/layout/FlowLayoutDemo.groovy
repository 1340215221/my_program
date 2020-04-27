package com.rh.ui.layout

import com.rh.ui.controls.JIcon
import groovy.swing.SwingBuilder

import javax.swing.WindowConstants
import java.awt.Button
import java.awt.FlowLayout
import java.awt.Frame

/**
 * 流式布局, 左右中
 */
class FlowLayoutDemo {

    static void main(String[] args) {
        groovy()
//        java()
    }

    static void groovy() {
        def builder = new SwingBuilder()

        def botten1 = {
            builder.button(label: '注册')
        }

//        def layout = new FlowLayout(FlowLayout.RIGHT)

        def layout = {
            builder.flowLayout(newAlign: FlowLayout.RIGHT)
        }

        def panel = {
            builder.panel(){
                layout()
                botten1()
            }
        }

        def frame = builder.frame(title: 'test',
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
                bounds: [0, 0, 500, 500],
        ){
            panel()
        }

        frame.visible = true
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
