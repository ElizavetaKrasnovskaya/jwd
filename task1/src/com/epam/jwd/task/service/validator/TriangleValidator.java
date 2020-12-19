package com.epam.jwd.task.service.validator;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public class TriangleValidator {

    public static boolean isFigureValid(Figure figure) {
        return (isEnoughPoints(figure) && isTriangleExist(figure)) && !isNull(figure.getPoints());
    }

    private static boolean isEnoughPoints(Figure figure) {
        final int NUMBER_OF_FIGURE_POINTS = 3;
        return figure.getPoints().size() == NUMBER_OF_FIGURE_POINTS;
    }

    private static boolean isNull(ArrayList<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) == null) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTriangleExist(Figure triangle) {
        ArrayList<Point> points = triangle.getPoints();
        int x1 = points.get(0).getX();
        int y1 = points.get(0).getY();
        int x2 = points.get(1).getX();
        int y2 = points.get(1).getY();
        int x3 = points.get(2).getX();
        int y3 = points.get(2).getY();
        return ((x1 - x3) * (y2 - y3) != (x2 - x3) * (y1 - y3));
    }

}
