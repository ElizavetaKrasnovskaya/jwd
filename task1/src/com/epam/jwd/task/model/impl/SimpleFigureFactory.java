package com.epam.jwd.task.model.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.FigureType;

public class SimpleFigureFactory implements FigureFactory {

    public static SimpleFigureFactory instance;

    private SimpleFigureFactory() {
    }

    public static SimpleFigureFactory getInstance() {
        if (instance == null) {
            instance = new SimpleFigureFactory();
        }

        return instance;
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        Figure figure;

        switch (type) {
            case TRIANGLE:
                figure = new Triangle(figureConstituents[0], figureConstituents[1], figureConstituents[2]);
                break;
            case SQUARE:
                figure = new Square(figureConstituents[0], figureConstituents[1], figureConstituents[2], figureConstituents[3]);
                break;
            case MULTI_ANGLE:
                figure = new MultiAngle(figureConstituents);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }


}
