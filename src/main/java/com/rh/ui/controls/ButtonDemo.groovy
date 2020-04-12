package com.rh.ui.controls

import groovy.swing.SwingBuilder
import javafx.scene.control.RadioButton

import javax.swing.*
import java.awt.BorderLayout
import java.awt.Color

class ButtonDemo {

    public static void main(String[] args) {
        def swingBuilder = new SwingBuilder()

        def radioButtion1 = {
            swingBuilder.radioButton('单选1')
        }
        def radioButtion2 = {
            swingBuilder.radioButton('单选2')
        }
        def radioButtion3 = {
            swingBuilder.radioButton('单选3')
        }

        def buttonGroup = {buttion1, buttion2, buttion3->
            swingBuilder.buttonGroup().with {
                add(buttion1)
                add(buttion2)
                add(buttion3)
            }
        }

        def panel = {

            def panel1 = swingBuilder.panel(background: Color.green)

//            panel1.add(new JRadioButton('单选1'))

            panel1.add(swingBuilder.radioButton('单选2'))

//            panel.add(radioButtion1(), BorderLayout.NORTH)
//            panel.add(radioButtion2(), BorderLayout.SOUTH)
//            def buttion1 = radioButtion1() // 这里必须是闭包, 在这里创建才能享有自动添加
//            def buttion2 = radioButtion2()
//            def buttion3 = radioButtion3()
//
//            buttonGroup(buttion1, buttion2, buttion3)

        }

        def frame = swingBuilder.frame(size: [500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ){
            panel()
        }

        frame.visible = true
    }

}
