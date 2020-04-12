package com.rh.ui.listener

import java.awt.*
import java.awt.event.ActionListener

class TextListenerDemo {

    static void main(String[] args) {
        def frame = new Frame(size: [500, 500])

        ActionListener actionListener = {event ->
            TextField field = event.getSource()
            println field.text
            field.text = ''
        } as ActionListener

        def field = new TextField()
        field.addActionListener(actionListener)
        // 用户输入的在屏幕上的回显
        field.setEchoChar("*" as char)

        frame.add(field)
        frame.setVisible(true)
    }

}
