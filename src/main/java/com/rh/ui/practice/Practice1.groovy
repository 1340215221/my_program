package com.rh.ui.practice

import java.awt.*

class Practice1 {

    static main(args) {
//        grid()
        border()
    }

    private static border() {
        def frame = new Frame(title: 'Practice1',
                size: [500, 500],
                layout: new GridLayout(2, 1)
        )

        def panel1 = new Panel(layout: new BorderLayout())
        def panel2 = new Panel(layout: new GridLayout(2, 1))
        def panel3 = new Panel(layout: new BorderLayout())
        def panel4 = new Panel(layout: new GridLayout(2, 2))

        panel1.add(panel2, BorderLayout.CENTER)
        panel3.add(panel4, BorderLayout.CENTER)

        frame.add(panel1)
        frame.add(panel3)

        panel1.add(new Button('button'), BorderLayout.WEST)
        panel1.add(new Button('button'), BorderLayout.EAST)

        panel2.add(new Button('button'))
        panel2.add(new Button('button'))

        panel3.add(new Button('button'), BorderLayout.WEST)
        panel3.add(new Button('button'), BorderLayout.EAST)

        4.times { panel4.add(new Button('button')) }

//        frame.pack()
        frame.setVisible(true)
    }

    private static grid() {
        def frame = new Frame(layout: new GridLayout(2, 3),
                size: [500, 500]
        )

        def panel = new Panel(layout: new GridLayout(2, 1))
        2.times { panel.add(new Button('button')) }

        def panel1 = new Panel(layout: new GridLayout(2, 2))
        4.times { panel.add(new Button('button')) }

        frame.add(new Button('button'))
        frame.add(panel)
        frame.add(new Button('button'))
        frame.add(new Button('button'))
        frame.add(panel1)
        frame.add(new Button('button'))

        frame.setVisible(true)
    }

}
