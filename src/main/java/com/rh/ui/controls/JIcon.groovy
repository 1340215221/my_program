package com.rh.ui.controls

import groovy.swing.SwingBuilder

import javax.swing.*

class JIcon {

    static main(args) {
        def swingBuilder = new SwingBuilder()

        def imageIcon = {
            def url = JIcon.class.getResource('../../../../icon/duoduo.png')
            new ImageIcon(url)
        }

        def label = {
            def label = swingBuilder.label(text: 'ImageIcon')

            label.icon = imageIcon()  // 必须由 SwingBuilder 的控件才享有自动添加, 闭包不需要返回当前构建的控件
        }

        def frame = swingBuilder.frame(size: [500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
                visible: test1() // 优先执行这里再, 添加组件, 在组件加载慢时, 有些效果出不来, 所以 visitable 放在最后较好
        ){
            println 'content'
            label()
        }

//        frame.visible = true;
    }

    static boolean test1() {
        println 'field'
        true
    }


}
