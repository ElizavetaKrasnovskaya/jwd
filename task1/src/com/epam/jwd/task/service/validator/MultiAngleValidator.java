package com.epam.jwd.task.service.validator;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public class MultiAngleValidator {

    public static boolean isFigureValid(Figure figure) {

        return isEnoughPoints(figure) && !isNull(figure.getPoints());
    }

    private static boolean isNull(ArrayList<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) == null) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEnoughPoints(Figure figure) {
        final int MIN_NUMBER_OF_FIGURE_POINTS = 4;
        return figure.getPoints().size() >= MIN_NUMBER_OF_FIGURE_POINTS;
    }

}
