package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.strategy.PropertyStrategy;

import java.util.ArrayList;

public enum MultiFigurePropertyStrategy implements PropertyStrategy {
    INSTANCE;

    @Override
    public double calculatePerimeter(ArrayList<Point> points) {

        double perimeter = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            perimeter += calculateLengthBetweenTwoPoint(points.get(i), points.get(i+1));
        }
        perimeter += calculateLengthBetweenTwoPoint(points.get(0), points.get(points.size() - 1));

        return perimeter;
    }

    @Override
    public double calculateArea(ArrayList<Point> points) {
        double area = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            area += points.get(i).getX() * points.get(i + 1).getY() - points.get(i).getY() * points.get(i + 1).getX();
        }
        area += points.get(points.size() - 1).getX() * points.get(0).getY() - points.get(points.size() - 1).getY() * points.get(0).getX();
        return Math.abs(area / 2);
    }

    private static double calculateLengthBetweenTwoPoint(Point p1, Point p2) {

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

    }
}
