package com.rh.ui.factory;

import com.rh.ui.view.SnakerPanel;
import groovy.util.AbstractFactory;
import groovy.util.FactoryBuilderSupport;

import java.util.Map;

public class SnakerPanelFactory extends AbstractFactory {
    @Override
    public Object newInstance(FactoryBuilderSupport factoryBuilderSupport, Object o, Object o1, Map map) throws InstantiationException, IllegalAccessException {
        return new SnakerPanel();
    }
}
