package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.MultiAngle;
import com.epam.jwd.task.model.impl.Square;
import com.epam.jwd.task.model.impl.Triangle;
import com.epam.jwd.task.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure instanceof Triangle) {
            FigureExistencePostProcessor.checkTriangleValidation(figure);
        } else if (figure instanceof Square) {
            FigureExistencePostProcessor.checkSquareValidation(figure);
        } else if (figure instanceof MultiAngle) {
            FigureExistencePostProcessor.checkMultiAngleValidation(figure);
        }
        return figure;
    }

    private static void checkTriangleValidation(Figure figure) throws FigureException {
        Triangle triangle = (Triangle) figure;
        if (!triangle.validate()) {
            throw new FigureNotExistException("Triangle doesn't exist");
        }
    }

    private static void checkSquareValidation(Figure figure) throws FigureException {
        Square square = (Square) figure;
        if (!square.validate()) {
            throw new FigureNotExistException("Square doesn't exist");
        }
    }

    private static void checkMultiAngleValidation(Figure figure) throws FigureException {
        MultiAngle multiAngle = (MultiAngle) figure;
        if (!multiAngle.validate()) {
            throw new FigureNotExistException("MultiAngle doesn't exist");
        }
    }

}
