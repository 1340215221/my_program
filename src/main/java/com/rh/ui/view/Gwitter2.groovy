package com.rh.ui.view

import groovy.swing.SwingBuilder

import javax.swing.JFrame

class Gwitter2 {

    static void main(String[] args){
        def gwitter = new Gwitter2()
        gwitter.show()
    }

    void show(){
        def swingBuilder = new SwingBuilder()

        def customMenuBar = {
            swingBuilder.menuBar{
                menu(text: "File", mnemonic: 'F') {
                    menuItem(text: "Exit", mnemonic: 'X', actionPerformed: { dispose() })
                }
            }
        }

        swingBuilder.frame(title:"Gwitter",
                defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                size:[400,500],
                show:true) {
            customMenuBar()
        }
    }

}
