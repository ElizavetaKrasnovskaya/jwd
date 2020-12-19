package com.epam.jwd.task.service.validator;

import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public class SquareValidator {

    public static boolean isFigureValid(Figure figure) {
        return (isEnoughPoints(figure) && !isNull(figure.getPoints()) && isSquareExist(figure));
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
        final int NUMBER_OF_FIGURE_POINTS = 4;
        return figure.getPoints().size() == NUMBER_OF_FIGURE_POINTS;
    }

    private static boolean isSquareExist(Figure square) {
        ArrayList<Point> points = square.getPoints();
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);
        Point point4 = points.get(3);

        if (calculateSquareLength(point1, point3) == calculateSquareLength(point2, point4)) {
            if (calculateSquareLength(point1, point2) == calculateSquareLength(point4, point3)) {
                return true;
            }
        }
        if (calculateSquareLength(point1, point2) == calculateSquareLength(point3, point4)) {
            if (calculateSquareLength(point1, point3) == calculateSquareLength(point4, point2)) {
                return true;
            }
        }
        return false;
    }

    private static int calculateSquareLength(Point point1, Point point2) {
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();

        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

}
