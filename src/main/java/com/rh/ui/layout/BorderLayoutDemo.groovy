package com.rh.ui.layout

import groovy.swing.SwingBuilder
import groovy.swing.factory.SwingBorderFactory

import javax.swing.JFrame
import java.awt.BorderLayout
import java.awt.Button
import java.awt.Frame

/**
 * 盒子布局<br>
 * 东南西北中布局
 */
class BorderLayoutDemo {

    static void main(String[] args) {
        groovy()
//        java()
    }

    static void groovy() {
        def swingBuilder = new SwingBuilder()

        def button1 = {
            swingBuilder.button(label: 'center')
        }

        def button2 = {
            swingBuilder.button(label: 'each')
        }

        def layout = {
            swingBuilder.borderLayout(center: button1(),
                    east: button2()
            )
        }

        def panel = {
            swingBuilder.panel(){
                layout()
            }
        }

        def frame = swingBuilder.frame(title: 'test',
                bounds: [0, 0, 500, 500]
        ) {
            panel()
        }

        frame.visible = true;
    }

    private static void java() {
        def east = new Button('east')
        def west = new Button('west')
        def south = new Button('south')
        def north = new Button('north')
        def center = new Button('center')

        def frame = new Frame(title: 'BorderLayoutDemo',
                size: [500, 500]
        )

        frame.add(east, BorderLayout.EAST)
        frame.add(west, BorderLayout.WEST)
        frame.add(south, BorderLayout.SOUTH)
        frame.add(north, BorderLayout.NORTH)
        frame.add(center, BorderLayout.CENTER)

        frame.setVisible(true)
    }
}
