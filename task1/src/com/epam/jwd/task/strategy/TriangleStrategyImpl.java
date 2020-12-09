package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Triangle;

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
    public double calculatePerimeter(Figure figure) {
        Triangle triangle = (Triangle) figure;
        double firstSide = Math.sqrt(Math.pow(Math.abs(triangle.getPointFirst().getX() - triangle.getPointSecond().getX()), 2) +
                Math.pow(Math.abs(triangle.getPointFirst().getY() - triangle.getPointSecond().getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(triangle.getPointSecond().getX() - triangle.getPointThird().getX()), 2) +
                Math.pow(Math.abs(triangle.getPointSecond().getY() - triangle.getPointThird().getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(triangle.getPointThird().getX() - triangle.getPointFirst().getX()), 2) +
                Math.pow(Math.abs(triangle.getPointThird().getY() - triangle.getPointFirst().getY()), 2));

        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double calculateArea(Figure figure) {

        Triangle triangle = (Triangle) figure;
        double firstSide = Math.sqrt(Math.pow(Math.abs(triangle.getPointFirst().getX() - triangle.getPointSecond().getX()), 2) +
                Math.pow(Math.abs(triangle.getPointFirst().getY() - triangle.getPointSecond().getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(triangle.getPointSecond().getX() - triangle.getPointThird().getX()), 2) +
                Math.pow(Math.abs(triangle.getPointSecond().getY() - triangle.getPointThird().getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(triangle.getPointThird().getX() - triangle.getPointFirst().getX()), 2) +
                Math.pow(Math.abs(triangle.getPointThird().getY() - triangle.getPointFirst().getY()), 2));

        return Math.sqrt((calculatePerimeter(figure) / 2) *
                ((calculatePerimeter(figure) / 2) - firstSide) *
                ((calculatePerimeter(figure) / 2) - secondSide) *
                ((calculatePerimeter(figure) / 2) - thirdSide));
    }

}
