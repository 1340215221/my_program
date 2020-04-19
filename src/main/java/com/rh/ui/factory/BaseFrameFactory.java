package com.rh.ui.factory;

import com.rh.ui.view.BaseFrame;
import groovy.util.AbstractFactory;
import groovy.util.FactoryBuilderSupport;

import javax.swing.*;
import java.util.Map;

public class BaseFrameFactory extends AbstractFactory {
    @Override
    public Object newInstance(FactoryBuilderSupport factoryBuilderSupport, Object o, Object o1, Map map) throws InstantiationException, IllegalAccessException {
        return new BaseFrame();
    }

    @Override
    public void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        if (!(parent instanceof JFrame)) {
            return;
        }

        JFrame frame = (JFrame) parent;
        if (child instanceof JPanel) {
            frame.add(((JPanel) child));
            return;
        }
    }
}
