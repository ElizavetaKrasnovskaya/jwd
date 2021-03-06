package com.epam.jwd.task.decorator.impl;

import com.epam.jwd.task.decorator.FigureFactoryDecorator;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.impl.ServiceProvider;

import java.util.ArrayList;


public class PostProcessingFactoryDecorator extends FigureFactoryDecorator {
    private FigureFactory figureFactory;
    private ServiceProvider serviceProvider = ServiceProvider.getINSTANCE();

    public PostProcessingFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> figureConstituents) throws FigureException {
        Figure figure = figureFactory.createFigure(type, figureConstituents);
        figure = serviceProvider.getPostProcessor(type).process(figure);
        return figure;
    }
}
