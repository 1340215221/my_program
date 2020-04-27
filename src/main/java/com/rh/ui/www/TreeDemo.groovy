package com.rh.ui.www

import com.formdev.flatlaf.FlatDarculaLaf
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.JTree
import javax.swing.WindowConstants
import javax.swing.tree.DefaultMutableTreeNode

class TreeDemo {

    JFrame f;

    TreeDemo() {
        groovy()
//        java();
    }

    private void groovy() {
        FlatDarculaLaf.install();
        SwingBuilder swingBuilder = new SwingBuilder();

        def tree = {
            def node0 = new DefaultMutableTreeNode('一级目录')

            def node1 = new DefaultMutableTreeNode('一级目录')
            def node2 = new DefaultMutableTreeNode('一级目录')

            def node11 = new DefaultMutableTreeNode('二级目录')
            def node21 = new DefaultMutableTreeNode('二级目录')

            def node211 = new DefaultMutableTreeNode('三级目录')

            node0.add(node1)
            node0.add(node2)
            node1.add(node11)
            node1.add(node21)
            node21.add(node211)

            def tree = swingBuilder.tree()
        }

        def panel = {
            swingBuilder.panel(){
                tree()
            }
        }

        def frame = swingBuilder.frame(size: [400, 400],
                locationRelativeTo: null,
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ){
            panel()
        }

        frame.visible = true;
    }

    private void java() {
        f = new JFrame();
        DefaultMutableTreeNode sort= new DefaultMutableTreeNode("食材分类");
        DefaultMutableTreeNode vagetable = new DefaultMutableTreeNode("蔬菜类");
        DefaultMutableTreeNode meat = new DefaultMutableTreeNode("肉类");
        sort.add(vagetable );
        sort.add(meat);
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("百香果");
        DefaultMutableTreeNode jin = new DefaultMutableTreeNode("泰国金桔");
        DefaultMutableTreeNode liulian = new DefaultMutableTreeNode("榴莲");
        DefaultMutableTreeNode ytao = new DefaultMutableTreeNode("樱桃");
        vagetable .add(b);
        vagetable .add(jin);
        vagetable .add(liulian);
        vagetable .add(ytao);

        DefaultMutableTreeNode c = new DefaultMutableTreeNode("牛肉");
        meat.add(c);

        JTree jt = new JTree(sort);
        f.add(jt);
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new TreeDemo();
    }
}
