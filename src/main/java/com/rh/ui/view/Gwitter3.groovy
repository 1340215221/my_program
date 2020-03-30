package com.rh.ui.view

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.BorderLayout

class Gwitter3 {

    def searchField

    static void main(String[] args){
        def gwitter = new Gwitter3()
        gwitter.show()
    }

    void show() {
        def swingBuilder = new SwingBuilder()

        def customMenuBar = {
            swingBuilder.menuBar{
                menu(text: "File", mnemonic: 'F') {
                    menuItem(text: "Exit", mnemonic: 'X', actionPerformed: {dispose() })
                }
            }
        }

        def searchPanel = {
            swingBuilder.panel(constraints: BorderLayout.NORTH){
                searchField = textField(columns:15)
                button(text:"Search", actionPerformed:{ /* TODO */ } )
            }
        }

        swingBuilder.frame(title:"Gwitter",
                defaultCloseOperation:JFrame.EXIT_ON_CLOSE,
                size:[400,500],
                show:true) {
            customMenuBar()
            searchPanel()
        }
    }
}
