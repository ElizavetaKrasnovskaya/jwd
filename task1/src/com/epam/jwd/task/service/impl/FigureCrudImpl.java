package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.IllegalFigureTypeException;
import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.factory.impl.ApplicationContext;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigureCrud;

import java.util.ArrayList;
import java.util.Optional;

public class FigureCrudImpl implements FigureCrud {
    @Override
    public Figure create(FigureType type, ArrayList<Point> figureConstituents) throws FigureException {
        return ApplicationContext.getFigureFactory().createFigure(type, figureConstituents);
    }

    @Override
    public boolean delete(Figure figure) throws FigureException {
        return false;
    }

    @Override
    public boolean update(Figure figure) throws IllegalFigureTypeException {
        return false;
    }

    @Override
    public Optional<Figure> findByIndex(FigureType figureType, int index) throws IllegalFigureTypeException {
        return Optional.empty();
    }
}
