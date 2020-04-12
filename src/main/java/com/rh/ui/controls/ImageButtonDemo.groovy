package com.rh.ui.controls

import groovy.swing.SwingBuilder

import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.WindowConstants
import java.awt.Image

class ImageButtonDemo {

    public static void main(String[] args) {
        def swingBuilder = new SwingBuilder()

        def imageIcon = {
            def url = ImageButtonDemo.class.getResource('../../../../icon/duoduo.png')
            new ImageIcon(url)
        }

        def button = {
            swingBuilder.button(icon: imageIcon(),
                    toolTipText: '图片按钮'
            )
        }

        def frame = swingBuilder.frame(size: [500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ){
            panel(){
                button()
            }
        }

        frame.visible = true
    }

}
