package com.rh.ui.www;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChoose implements ActionListener {

    JFrame f;
    JMenuBar mb;//定义菜单栏
    JMenu file, edit, help;//定义主菜单
    JMenuItem cut, copy, paste, selectAll;//定义菜单选项
    JTextArea ta;
    JScrollPane js;
    FileChoose() {
        f = new JFrame();
        js=new JScrollPane();
        cut = new JMenuItem("剪切");
        copy = new JMenuItem("复制");
        paste = new JMenuItem("粘贴");
        selectAll = new JMenuItem("全选");
        //添加监听者
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        mb = new JMenuBar();
        file = new JMenu("文件");
        edit = new JMenu("编辑");
        help = new JMenu("帮助");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        ta = new JTextArea();
        ta.setBounds(5, 5, 373, 325);
        js.add(ta);
        f.add(js);
        f.add(mb);
        f.add(ta);
        f.setJMenuBar(mb);
        f.setLayout(null);

        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    public static void main(String[] args) {
        new FileChoose();
    }

}
