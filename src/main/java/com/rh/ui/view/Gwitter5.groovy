package com.rh.ui.view


import com.rh.ui.entiry.Tweet
import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.*

class Gwitter5 {

    def searchField
    def resultsList

    static void main(String[] args){
        def gwitter = new Gwitter5()
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
                    // edt 同步调用, doLater 异步调用, doOutside 创建新线程调用
                    doOutside{
                        resultsList.listData = new Tweet(author: 'rh', content: 'hello world')
//                        resultsList.listData = Search.byKeyword(searchField.text)
                    }
                } )
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
