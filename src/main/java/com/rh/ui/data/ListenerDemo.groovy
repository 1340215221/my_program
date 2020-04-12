package com.rh.ui.data

import groovy.swing.SwingBuilder

import javax.swing.JFrame

/**
 * 随便找的参考例子
 */
class ListenerDemo {

    public static void main(String[] args) {
        def data =[
                [nick: 'MrG', full: 'Guillaume Laforge'],
                [nick: 'jez', full: 'Jeremy Rayner'],
                [nick: 'fraz', full: 'Franck Rasolo'],
                [nick: 'sormuras', full: 'Christian Stein'],
                [nick: 'blackdrag', full: 'Jochen Theodorou'],
                [nick: 'Mittie', full:true]
        ]
        def swing = new SwingBuilder();
        def frame = swing.frame(title: 'Table Demo', defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE) {
            vbox {
                scrollPane {
                    tab = table {
                        editing: true;
                        model = tableModel(list: data) {
                            propertyColumn(header: 'Nickname', propertyName: 'nick');
                            propertyColumn(header: 'Full Name', propertyName: 'full',editable:false);
                        }
                    }
                }
                button() {
                    action(name: '打印model的内容') {
                        println(model.rows);
                        //println(tab.cellEditor.getTableCellEditorComponent());
                        //println(tab.editorComponent);
                    }
                }
            }
        }

        frame.pack();
        frame.show();

//model.getRows().add([nick:'李',full:'李某某']);
//    model.rows.add([nick: '李', full: '李某某']);
//    tab.updateUI();
//model.rows.clear();
//tab.updateUI();



/*
tab.getSelectionModel().addListSelectionListener(
    new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
            println event;
        }
    }
);
model.addTableModelListener(
    new TableModelListener() {
        public void tableChanged(TableModelEvent  event) {
            println event;
            println "yes";
        }
    }
)
*/

//监听JTable的鼠标事件
/*
tab.addMouseListener(
    new MouseAdapter() {
        public void mouseClicked(MouseEvent event) {
            //println event;
            //groovy.inspect.swingui.ObjectBrowser.inspect(event);
            //println "yes";
            def tab = event.component;
            tab.setValueAt(!tab.getValueAt(tab.getSelectedRow(), tab.getSelectedColumn()), tab.getSelectedRow(), tab.getSelectedColumn());
            tab.updateUI();
        }
    }
);
*/

/*
//监听JTable的键盘事件
tab.addKeyListener(
    new KeyAdapter() {
        public void keyPressed(KeyEvent event) {
            //groovy.inspect.swingui.ObjectBrowser.inspect(event);
        }
    }
);
*/
    }

}
