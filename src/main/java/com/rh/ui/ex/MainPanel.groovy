package com.rh.ui.ex

import java.awt.Color

import static com.rh.ui.ex.MainFactory.swingBuilder

class MainPanel {

    void init() {
        swingBuilder.panel(background: Color.yellow) {
            new MyButton().init()
        }
    }

}
