package com.rh.ui.view


import com.rh.ui.entiry.Tweet
import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.*

class Gwitter4 {

    def searchField
    def resultsList

    static void main(String[] args){
        def gwitter = new Gwitter4()
        gwitter.show()
    }

    void show(){
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
                button(text:"Search", actionPerformed:{
                    resultsList.listData = new Tweet(author: 'rh', content: 'hello world') } )
//                    resultsList.listData = Search.byKeyword(searchField.text) } )
            }
        }

        def resultsPanel = {
            swingBuilder.scrollPane(constraints: BorderLayout.CENTER){
                resultsList = list()
            }
        }

        swingBuilder.frame(title:"Gwitter",
                defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                size:[400,500],
                show:true) {
            customMenuBar()
            searchPanel()
            resultsPanel()
        }
    }

}
