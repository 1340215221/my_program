package com.rh.ui.view;

import javax.swing.*;

public class BaseFrame extends JFrame {

    private static int tabBarHeight = 30;

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height + tabBarHeight);
    }
}
