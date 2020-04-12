package com.rh.ui.listener

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

class KeyListenerDemo {

    public static void main(String[] args) {
        def swingBuilder = new SwingBuilder()

        def frame = swingBuilder.frame(size: [500, 500])

        frame.addKeyListener(new MyKeyListener())

        frame.visible = true
    }

    static class MyKeyListener extends KeyAdapter {
        @Override
        void keyPressed(KeyEvent e) {
            def code = e.keyCode
            if (KeyEvent.VK_UP == code) {
                println '你按下了[向上]按键'
            }
        }
    }
}
