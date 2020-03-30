package com.rh.ui.view


import groovy.swing.SwingBuilder

import javax.swing.*

class HelloGroovySwing {
    static main(args) {
        def swingBuilder = new SwingBuilder()
        swingBuilder.frame(title: "title: Hello Groovy Swing",
                defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                size: [200, 300],
                show: true) {
            panel() {
                label("label: Hello Groovy Swing")
            }
        }
    }
}
