package com.rh.ui.controls

import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.Color

class JDialogDemo {

    public static void main(String[] args) {
        groovy()
    }

    static void groovy() {
        def swingBuilder = new SwingBuilder()

        def label = {
            swingBuilder.label(text: 'hello world')
        }

        def dPanel = {
            swingBuilder.panel() { // todo 加上 layout: null 后, label的内容没有显示出来
                label()
            }
        }

        def dialog = {
            def widget = swingBuilder.dialog(bounds: [100, 100, 500, 500]) {
                dPanel()
            }

            widget.visible = true
        }

        def button = {
            def button = swingBuilder.button(text: '点击弹出一个对话框',
                    bounds: [30, 30, 200, 50]
            ) {
                action() {
                    dialog()
                }
            }
        }

        def panel = {
            swingBuilder.panel(layout: null) { // 绝对布局
                button()
            }
        }

        def frame = swingBuilder.frame(size: [700, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
        ) {
            panel() // frame上不能直接放置控件, 需要创建一个面板用来放控件, contentPane 就是一个默认创建的 panel
        }

        frame.visible = true
    }
}
