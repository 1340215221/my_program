package com.rh.ui.ex

import javax.swing.JFrame

import static com.rh.ui.ex.MainFactory.swingBuilder

class MainFrame {

    private MainPanel panel = new MainPanel()
    private JFrame frame;

    void init() {
        frame = swingBuilder.frame(bounds: [0, 0, 500, 400]) {
            panel.init()
        }
    }

    void show() {
        if (frame == null) {
            return
        }

        frame.visible = true
    }
}
