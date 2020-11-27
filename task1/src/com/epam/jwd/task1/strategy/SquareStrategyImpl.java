package com.epam.jwd.task1.strategy;

import com.epam.jwd.task1.model.Point;

public class SquareStrategyImpl implements FigureStrategy {

    private static SquareStrategyImpl instance;

    private SquareStrategyImpl() {
    }

    public static SquareStrategyImpl getInstance() {
        if (instance == null) {
            instance = new SquareStrategyImpl();
        }
        return instance;
    }

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
        return Math.pow(side, 2);
    }
}
