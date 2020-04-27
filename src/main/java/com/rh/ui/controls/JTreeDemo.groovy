package com.rh.ui.controls

import com.formdev.flatlaf.FlatDarculaLaf
import groovy.swing.SwingBuilder

import javax.swing.*
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel

class JTreeDemo {

    public static void main(String[] args) {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        FlatDarculaLaf.install();
        groovy()
    }

    static void groovy() {
        def builder = new SwingBuilder()

        builder.registerFactory('model', new MyTreeModelFactory())
        builder.registerFactory('node', new MyTreeNodeFactory())

        def node = {
            builder.node(userObject: '根节点'){
                node(userObject: '一级目录1')
                node(userObject: '一级目录2'){
                    node(userObject: '二级目录21'){
                        node(userObject: '三级目录211')
                    }
                }
            }
        }

        def model = {
            builder.model(root: node())
        }

        def tree = {
            def tree = builder.tree(model: model())
        }

        def panel = {
            builder.panel(){
                tree()
            }
        }

        def frame = builder.frame(title: 'test',
                bounds: [0, 0, 500, 400],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE,
        ) {
            panel()
        }

        frame.visible = true
    }

    static class MyTreeNodeFactory extends AbstractFactory {
        @Override
        Object newInstance(FactoryBuilderSupport factoryBuilderSupport, Object o, Object o1, Map map) throws InstantiationException, IllegalAccessException {
            new DefaultMutableTreeNode()
        }

        @Override
        void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
            if (!(parent instanceof DefaultMutableTreeNode && child in DefaultMutableTreeNode)) {
                return
            }

            parent.add(child)
        }
    }

    static class MyTreeModelFactory extends AbstractFactory {
        @Override
        Object newInstance(FactoryBuilderSupport factoryBuilderSupport, Object o, Object o1, Map map) throws InstantiationException, IllegalAccessException {
            new DefaultTreeModel(new DefaultMutableTreeNode())
        }
    }
}
