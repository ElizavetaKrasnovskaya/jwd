package com.epam.jwd.task1.strategy;

import com.epam.jwd.task1.model.Point;

public enum MultiAngleStrategyImpl implements FigureStrategy {
    INSTANCE;

    @Override
    public double calculatePerimeter(Point[] points) {

        double side = Math.sqrt(Math.pow(Math.abs(points[0].getX() - points[1].getX()), 2) +
                Math.pow(Math.abs(points[0].getY() - points[1].getY()), 2));

        return side * 4;
    }

    @Override
    public double calculateArea(Point[] points) {

        double side = Math.sqrt(Math.pow(Math.abs(points[0].getX() - points[1].getX()), 2) +
                Math.pow(Math.abs(points[0].getY() - points[1].getY()), 2));

        double area;
        area = (4 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 8));
        return area;
    }
}
