package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistsException;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.FigurePreProcessor;
import com.epam.jwd.task.service.validator.FigureValidator;

import java.util.ArrayList;

public class FigureExistencePreProcessor implements FigurePreProcessor {
    FigureExistencePreProcessor(){}

    @Override
    public void process(ArrayList<Point> points) throws FigureException {
        if (!FigureValidator.isFigureValid(points)) {

            throw new FigureNotExistsException("Such figure can't exist");
        }
    }
}
