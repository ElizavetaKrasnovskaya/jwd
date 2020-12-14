package com.epam.jwd.task.decorator;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.service.impl.FigurePostProcessorImpl;

import java.util.ArrayList;

public class FigurePostProcessingDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private static final FigurePostProcessor FIGURE_POST_PROCESSORS = FigurePostProcessorImpl.getInstance();

    public FigurePostProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> figureConstituents) throws FigureException {

        Figure figure;
        figure = figureFactory.createFigure(type, figureConstituents);
        figure = FIGURE_POST_PROCESSORS.process(figure);

        return figure;
    }

}
