package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistsException;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.service.validator.SquareValidator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SquareExistencePostProcessor implements FigurePostProcessor {

    private ArrayList<Figure> squareList = FigureStorage.INSTANCE.getSquares();

    SquareExistencePostProcessor() {}

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (SquareValidator.isFigureValid(figure)) {
            figure = fetchOrSave(figure);
        } else {
            throw new FigureNotExistsException("Figure not exists");
        }
        return figure;
    }

    private Figure fetchOrSave(Figure figure) {
        Figure savedFigure;
        if ((savedFigure = fetchFigure(figure)) != null) {
            return savedFigure;
        } else {
            save(figure);
            return figure;
        }
    }

    private void save(Figure figure) {
        squareList.add(figure);
    }

    private Figure fetchFigure(Figure newFigure) {
        for (Figure savedFigure : squareList) {
            if (savedFigure.equals(newFigure)) {
                return savedFigure;
            }
        }
        return null;
    }

}
