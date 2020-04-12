package com.rh.ui.controls

import groovy.swing.SwingBuilder

import java.awt.Color
import java.awt.Frame
import java.awt.Panel
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

/**
 * 面板
 */
class PanelDemo {

    static void main(String[] args) {
        java()
//        groovy()
    }

    private static void java() {
        def panel = new Panel(bounds: [50, 50, 400, 400],
                background: new Color(139, 15, 60)
        )

        def frame = new Frame(layout: null,
                bounds: [300, 300, 500, 500],
                background: new Color(40, 161, 35),
                visible: true,
        )
        frame.add(panel)

        frame.addWindowListener(new WindowAdapter() {
            @Override
            void windowClosing(WindowEvent e) {
                System.exit(0)
            }
        })
    }

    // todo
    private static void groovy() {
        def swingBuilder = new SwingBuilder()

        def panel = {
            swingBuilder.panel(bounds: [50, 50, 400, 400],
                    background: new Color(139, 15, 60),
            )
        }

        swingBuilder.frame(layout: null,
                bounds: [300, 300, 500, 500],
                background: new Color(40, 161, 35),
                visible: true){
            panel()
        }
    }

}
