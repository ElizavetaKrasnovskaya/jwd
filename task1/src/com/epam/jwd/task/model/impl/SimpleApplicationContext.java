package com.epam.jwd.task.model.impl;

import com.epam.jwd.task.decorator.FigurePostProcessingDecorator;
import com.epam.jwd.task.decorator.FigurePreProcessingDecorator;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.ApplicationContext;

public class SimpleApplicationContext implements ApplicationContext {

    private static FigureFactory figureFactory;
    private static SimpleApplicationContext instance;

    private SimpleApplicationContext() {
    }

    public static SimpleApplicationContext getInstance() {
        if (instance == null) {
            instance = new SimpleApplicationContext();
        }

        return instance;
    }

    @Override
    public FigureFactory createFigureFactory() {
        if (figureFactory == null) {
            figureFactory = new FigurePostProcessingDecorator(new FigurePreProcessingDecorator(SimpleFigureFactory.getInstance()));
        }
        return figureFactory;
    }

}
