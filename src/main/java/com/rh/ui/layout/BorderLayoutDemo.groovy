package com.rh.ui.layout

import java.awt.BorderLayout
import java.awt.Button
import java.awt.Frame

/**
 * 盒子布局<br>
 * 东南西北中布局
 */
class BorderLayoutDemo {

    public static void main(String[] args) {
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
