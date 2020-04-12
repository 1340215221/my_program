package com.rh.ui.layout

import java.awt.Button
import java.awt.Frame
import java.awt.GridLayout

/**
 * 表格布局
 */
class GridLayoutDemo {

    static void main(String[] args) {
        def frame = new Frame(title: 'GridLayoutDemo',
                layout: new GridLayout(3, 2)
        )

        def button1 = new Button('button1')
        def button2 = new Button('button2')
        def button3 = new Button('button3')
        def button4 = new Button('button4')
        def button5 = new Button('button5')
        def button6 = new Button('button6')

        frame.add(button1)
        frame.add(button2)
        frame.add(button3)
        frame.add(button4)
        frame.add(button5)
        frame.add(button6)

        // 自动填充 (Button大小会随着窗口大小而变化)
        frame.pack()
        frame.setVisible(true)
    }

}
