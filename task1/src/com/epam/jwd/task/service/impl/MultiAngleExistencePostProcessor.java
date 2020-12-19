package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistsException;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.service.validator.MultiAngleValidator;

import java.util.ArrayList;

public class MultiAngleExistencePostProcessor implements FigurePostProcessor {

    private ArrayList<Figure> multiAngleList = FigureStorage.INSTANCE.getMultiAngles();

    MultiAngleExistencePostProcessor() {}

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (MultiAngleValidator.isFigureValid(figure)) {
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
        multiAngleList.add(figure);
    }

    private Figure fetchFigure(Figure newFigure) {
        for (Figure savedFigure : multiAngleList) {
            if (savedFigure.equals(newFigure)) {
                return savedFigure;
            }
        }
        return null;
    }

}
