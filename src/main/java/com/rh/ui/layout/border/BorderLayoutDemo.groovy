package com.rh.ui.layout.border

import groovy.swing.SwingBuilder

import javax.swing.JPanel
import javax.swing.WindowConstants
import java.awt.Color

class BorderLayoutDemo {

    static final SwingBuilder swingBuilder = new SwingBuilder()

    public static void main(String[] args) {
//        swingBuilder.registerFactory('borderLayout', new BorderLayoutFactory())

        def panel2 = {
            swingBuilder.panel(id: 'panel2',
                    background: Color.red,
            )
        }

        def panel1 = {
            swingBuilder.panel(id: 'panel1',
                    background: Color.blue,
            )
        }

        def panel = {
            swingBuilder.panel(id: 'panel'){

                def panel11 = panel1()
                def panel21 = panel2()
                swingBuilder.borderLayout(id: 'layout',
                        south: panel11,
                        east: panel21,
                )
            }
        }

        swingBuilder.frame(id: 'frame',
                bounds: [0, 0, 500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
        ){
            panel()
        }

        swingBuilder.frame.visible = true
    }

}
