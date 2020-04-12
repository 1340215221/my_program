package com.rh.ui.practice


import groovy.swing.SwingBuilder
import org.apache.commons.collections4.MapUtils

import javax.swing.*
import java.awt.*
import java.awt.event.MouseEvent
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

/**
 * 使用鼠标画画<br>
 * 向swingbuilder中注册自定义的拓展控件
 */
class PaintPractice {

    private static Map<Integer, Integer> poinMap = [:]

    static main(args) {
//        FlatDarculaLaf.install()
        def builder = new SwingBuilder()
        builder.registerFactory('myFrame', new MyFrameFactory())

        MyFrame frame = builder.myFrame(title: '画图',
                size: [500, 500],
                mousePressed: {MouseEvent e ->
                    poinMap.put(e.x, e.y)
                    def source = e.source as MyFrame
                    source.repaint()
                },
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
                windowActivated: {WindowEvent e ->
                    def frame = e.source as MyFrame
                    frame.title = '画图'
                }
        )

        frame.addWindowFocusListener(new MyWindowForceListener())
        frame.visible = true
    };

    static class MyFrame extends JFrame {

        @Override
        void paint(Graphics g) {
            g.color = Color.red
            g.fillOval(100, 100, 100, 100) // 画一个实心圆, 设置相对于窗口的位置

            g.color = Color.green
            g.fillRect(150, 200, 200, 200) // 画个矩形

            if (MapUtils.isNotEmpty(poinMap)) {
                g.color = Color.blue
                poinMap.forEach { x, y ->
                    g.fillOval(x, y, 10, 10)
                }
            }

            // 画笔用完要还原为最初的颜色, 方便下次直接画
            g.color = Color.black
        }

    }

    static class MyWindowForceListener extends WindowAdapter{
        @Override
        void windowLostFocus(WindowEvent e) {
            def frame = e.source as MyFrame
            frame.title = '人去哪了? 快回来'
        }
    }

    static class MyFrameFactory extends AbstractFactory {
        @Override
        Object newInstance(FactoryBuilderSupport factoryBuilderSupport, Object o, Object o1, Map map) throws InstantiationException, IllegalAccessException {
            new MyFrame()
        }
    }
}
