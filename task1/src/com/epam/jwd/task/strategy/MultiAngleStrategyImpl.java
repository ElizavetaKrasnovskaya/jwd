package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.MultiAngle;

public enum MultiAngleStrategyImpl implements FigureStrategy {
    INSTANCE;

    @Override
    public double calculatePerimeter(Figure figure) {

        MultiAngle multiAngle = (MultiAngle) figure;

        double side = Math.sqrt(Math.pow(Math.abs(multiAngle.getPoints()[0].getX() - multiAngle.getPoints()[1].getX()), 2) +
                Math.pow(Math.abs(multiAngle.getPoints()[0].getY() - multiAngle.getPoints()[1].getY()), 2));

        return side * 4;
    }

    @Override
    public double calculateArea(Figure figure) {

        MultiAngle multiAngle = (MultiAngle) figure;

        double side = Math.sqrt(Math.pow(Math.abs(multiAngle.getPoints()[0].getX() - multiAngle.getPoints()[1].getX()), 2) +
                Math.pow(Math.abs(multiAngle.getPoints()[0].getY() - multiAngle.getPoints()[1].getY()), 2));

        double area;
        area = (4 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 8));
        return area;
    }
}
