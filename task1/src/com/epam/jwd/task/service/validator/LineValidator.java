package com.epam.jwd.task.service.validator;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public class LineValidator {

    public static boolean isFigureValid(Figure figure) {

        return isEnoughPoints(figure.getPoints()) && !isNull(figure.getPoints());
    }

    private static boolean isEnoughPoints(ArrayList<Point> points) {
        final int NUMBER_OF_FIGURE_POINTS = 2;
        return points.size() == NUMBER_OF_FIGURE_POINTS;
    }

    private static boolean isNull(ArrayList<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) == null) {
                return true;
            }
        }
        return false;
    }

}
