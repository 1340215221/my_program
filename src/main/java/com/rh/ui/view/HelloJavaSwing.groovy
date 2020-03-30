package com.rh.ui.view

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class HelloJavaSwing {
    static main(args) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Label");

        JFrame frame = new JFrame("Frame");
        panel.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,300);
        frame.setVisible(true);
    }
}
