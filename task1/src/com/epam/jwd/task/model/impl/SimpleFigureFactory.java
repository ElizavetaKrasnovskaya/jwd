package com.epam.jwd.task.model.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.FigureType;

import java.util.ArrayList;

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
    public Figure createFigure(FigureType type, ArrayList<Point> figureConstituents) throws FigureException {
        Figure figure;

        switch (type) {
            case TRIANGLE:
                figure = new Triangle(figureConstituents.get(0), figureConstituents.get(1), figureConstituents.get(2));
                break;
            case SQUARE:
                figure = new Square(figureConstituents.get(0), figureConstituents.get(1), figureConstituents.get(2), figureConstituents.get(3));
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
