package com.epam.jwd.task.decorator;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.service.FigurePreProcessor;
import com.epam.jwd.task.service.impl.FigureExistencePreProcessor;

public class FigurePreProcessingDecorator implements FigureFactory{
    private final FigureFactory figureFactory;
    private static final FigurePreProcessor FIGURE_PRE_PROCESSORS = new FigureExistencePreProcessor();

    public FigurePreProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {

            FIGURE_PRE_PROCESSORS.process(figureConstituents);

        return figureFactory.createFigure(type, figureConstituents);
    }
}
