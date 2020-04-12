package com.rh.ui.practice

import com.formdev.flatlaf.FlatDarculaLaf
import groovy.swing.SwingBuilder

import javax.swing.*
import javax.swing.text.AttributeSet
import javax.swing.text.BadLocationException
import javax.swing.text.PlainDocument
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

/**
 * 实现一个计算器
 */
class CalcPractice {

    private static JTextField field1;
    private static JTextField field2;
    private static JTextField resultField;

    public static void main(String[] args) {
        FlatDarculaLaf.install()
//        java()
        groovy()
    }

    static void groovy() {
        def swingBuilder = new SwingBuilder()

        def num1 = {
            field1 = swingBuilder.textField(columns: 10,
                    document: new NumberInputFilter()
            )
        }

        def num2 = {
            field2 = swingBuilder.textField(columns: 10,
                    document: new NumberInputFilter()
            )
        }

        def result = {
            resultField = swingBuilder.textField(columns: 20,
                    editable: false, // 文本框禁止用户编辑
            )
        }

        def sum = {
            swingBuilder.label(text: '+')
        }

        def button = {
            swingBuilder.button(label: '=',
                    actionPerformed: {
                        resultField.text = Long.valueOf(field1.text) + Long.valueOf(field2.text) + ''
                        field1.text = '' // 求和后清空输入值
                        field2.text = ''
                    }
            )
        }

        swingBuilder.frame(title: '计算器',
                layout: new FlowLayout(),
                pack: true,
                visible: true
        ){
            num1()
            sum()
            num2()
            button()
            result()
        }
    }

    private static void java() {
        def frame = new Frame(title: '计算器',
                layout: new FlowLayout()
        )

        def num1 = new TextField(10)
        def num2 = new TextField(10)
        def result = new TextField(20)

        // 标签
        def label = new TextField('+')

        def button = new Button('=')
        button.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                result.text = Long.valueOf(num1.text) + Long.valueOf(num2.text) + ''
                num1.text = ''
                num2.text = ''
            }
        })

        frame.add(num1)
        frame.add(label)
        frame.add(num2)
        frame.add(button)
        frame.add(result)

        frame.pack()
        frame.setVisible(true)
    }

    /**
     * 过滤输入的非数字类型
     */
    static class NumberInputFilter extends PlainDocument {

        @Override
        void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            def numStr = str.chars.collect({
                def var = it as int
                var > 47 && var < 58 ? it : ''
            }).join()
            super.insertString(offs, numStr, a)
        }

    }
}
