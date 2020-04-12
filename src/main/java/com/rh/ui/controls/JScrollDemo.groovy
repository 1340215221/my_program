package com.rh.ui.controls

import com.formdev.flatlaf.FlatDarculaLaf
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.WindowConstants


/**
 * 滚动面板
 */
class JScrollDemo {

    public static void main(String[] args) {
        FlatDarculaLaf.install()
        scroll()
//        simple()
    }

    /**
     * 文本域加了滚动
     */
    private static void scroll() {
        def builder = new SwingBuilder()

        def textArea = {
            builder.textArea(rows: 20,
                    columns: 50,
                    text: '请输入内容'
            )
        }

        def scrollPane = {
            builder.scrollPane() {
                textArea()
            }
        }

        def frame = builder.frame(size: [500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ) {
            scrollPane()
        }

        frame.visible = true
    }

    /**
     * 文本域没有加滚动
     */
    static void simple() {
        def builder = new SwingBuilder()

        def textArea = {
            builder.textArea(rows: 20,
                    columns: 50,
                    text: '请输入内容'
            )
        }

        def frame = builder.frame(size: [500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ) {
            textArea()
        }

        frame.visible = true
    }
}
