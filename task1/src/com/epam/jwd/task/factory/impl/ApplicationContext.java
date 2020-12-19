package com.epam.jwd.task.factory.impl;

import com.epam.jwd.task.decorator.impl.PostProcessingFactoryDecorator;
import com.epam.jwd.task.decorator.impl.PreProcessingFactoryDecorator;
import com.epam.jwd.task.factory.FigureFactory;

public class ApplicationContext {

    private final static ApplicationContext INSTANCE = new ApplicationContext();
    private final static FigureFactory figureFactory = createFigureFactory();

    private ApplicationContext(){}

    public static FigureFactory getFigureFactory() {
        return figureFactory;
    }

    private static FigureFactory createFigureFactory() {

        FigureFactory figureFactory = SimpleFigureFactory.INSTANCE;

        figureFactory = new PreProcessingFactoryDecorator(figureFactory);

        figureFactory = new PostProcessingFactoryDecorator(figureFactory);

        return figureFactory;
    }

}
