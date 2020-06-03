package com.rh.ui.layout.border

import groovy.swing.factory.LayoutFactory

import javax.swing.JComponent
import java.awt.BorderLayout

class BorderLayoutFactory extends LayoutFactory {
    BorderLayoutFactory() {
        super(BorderLayout.class)
    }

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        if (!(parent instanceof BorderLayout)) {
            return
        }

        def node = BorderLayoutDemo.swingBuilder.parentNode
        if (!(node instanceof JComponent)) {
            return
        }

        builder.
        node.add(child, BorderLayout.EAST)
    }
}
