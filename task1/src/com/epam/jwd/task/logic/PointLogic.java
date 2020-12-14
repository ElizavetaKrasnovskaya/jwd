package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.impl.Point;

import java.util.ArrayList;

public class PointLogic {

    public static ArrayList<Point> initPoints() {
        ArrayList<Point> points = new ArrayList<>(4);
        points.add(new Point(2, 3));
        points.add(new Point(4, 3));
        points.add(new Point(2, 1));
        points.add(new Point(4, 1));
        return points;
    }

}
