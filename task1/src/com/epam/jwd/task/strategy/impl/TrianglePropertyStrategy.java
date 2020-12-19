package com.epam.jwd.task.strategy.impl;

import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.strategy.PropertyStrategy;

import java.util.ArrayList;

public final class TrianglePropertyStrategy implements PropertyStrategy {

    private static TrianglePropertyStrategy instance;

    private TrianglePropertyStrategy(){}

    public static TrianglePropertyStrategy getInstance() {
        if (instance == null) {
            instance = new TrianglePropertyStrategy();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter(ArrayList<Point> points) {

        double perimeter = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            perimeter += calculateLengthBetweenTwoPoint(points.get(i), points.get(i+1));
        }

        perimeter += calculateLengthBetweenTwoPoint(points.get(0), points.get(points.size()-1));

        return perimeter;
    }

    @Override
    public double calculateArea(ArrayList<Point> points) {

        double sideOne = calculateLengthBetweenTwoPoint(points.get(0), points.get(1));
        double sideTwo = calculateLengthBetweenTwoPoint(points.get(1), points.get(2));
        double sideThree = calculateLengthBetweenTwoPoint(points.get(0), points.get(2));
        double perimeterHalf = (sideOne + sideTwo + sideThree) / 2;

        return Math.sqrt(perimeterHalf * (perimeterHalf - sideOne) * (perimeterHalf - sideTwo)
                * (perimeterHalf - sideThree));
    }

    private static double calculateLengthBetweenTwoPoint(Point p1, Point p2) {

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

    }
}
