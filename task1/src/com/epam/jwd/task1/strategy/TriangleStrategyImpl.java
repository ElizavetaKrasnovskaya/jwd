package com.epam.jwd.task1.strategy;

import com.epam.jwd.task1.model.Point;

public class TriangleStrategyImpl implements FigureStrategy {

    private TriangleStrategyImpl() {
    }

    private static class TriangleStrategyHolder {
        private final static TriangleStrategyImpl instance = new TriangleStrategyImpl();
    }

    public static TriangleStrategyImpl getInstance() {
        return TriangleStrategyHolder.instance;
    }

    @Override
    public double calculatePerimeter(Point[] points) {
        double firstSide = Math.sqrt(Math.pow(Math.abs(points[0].getX() - points[1].getX()), 2) +
                Math.pow(Math.abs(points[0].getY() - points[1].getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(points[1].getX() - points[2].getX()), 2) +
                Math.pow(Math.abs(points[1].getY() - points[2].getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(points[2].getX() - points[0].getX()), 2) +
                Math.pow(Math.abs(points[2].getY() - points[0].getY()), 2));

        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double calculateArea(Point[] points) {

        double firstSide = Math.sqrt(Math.pow(Math.abs(points[0].getX() - points[1].getX()), 2) +
                Math.pow(Math.abs(points[0].getY() - points[1].getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(points[1].getX() - points[2].getX()), 2) +
                Math.pow(Math.abs(points[1].getY() - points[2].getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(points[2].getX() - points[0].getX()), 2) +
                Math.pow(Math.abs(points[2].getY() - points[0].getY()), 2));

        return Math.sqrt((calculatePerimeter(points) / 2) *
                ((calculatePerimeter(points) / 2) - firstSide) *
                ((calculatePerimeter(points) / 2) - secondSide) *
                ((calculatePerimeter(points) / 2) - thirdSide));
    }

}
