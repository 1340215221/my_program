package com.rh.ui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.rh.ui.view.FrameView;

public class SnakerGame {

    public static void main(String[] args) {
        System.out.println("开始启动");
        FlatDarculaLaf.install();
        System.out.println("完成Darcula主题初始化");
        new FrameView().init();
        System.out.println("完成[贪吃蛇]初始化");
    }

}
