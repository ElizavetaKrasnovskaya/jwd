package com.epam.jwd.task.factory.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.IllegalFigureTypeException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.MultiAngle;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.model.Square;
import com.epam.jwd.task.model.Triangle;

import java.util.ArrayList;


public enum SimpleFigureFactory implements FigureFactory {

    INSTANCE;

    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> figureConstituents) throws FigureException {
        Figure figure;

        switch (type) {
            case TRIANGLE:
                figure = new Triangle(figureConstituents);
                break;
            case SQUARE:
                figure = new Square(figureConstituents);
                break;
            case MULTI_ANGLE:
                figure = new MultiAngle(figureConstituents);
                break;
            default:
                throw new IllegalFigureTypeException("Figure type not founded");
        }

        return figure;
    }
}
