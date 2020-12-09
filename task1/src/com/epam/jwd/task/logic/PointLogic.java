package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.impl.Point;

public class PointLogic {

    public static Point[] initPoints() {
        Point[] points = new Point[4];
        points[0] = new Point(2, 3);
        points[1] = new Point(4, 3);
        points[2] = new Point(2, 1);
        points[3] = new Point(4, 1);
        return points;
    }

}
