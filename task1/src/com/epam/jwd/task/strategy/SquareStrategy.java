package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Square;

public class SquareStrategy implements FigureStrategy {

    private static SquareStrategy instance;

    private SquareStrategy() {
    }

    public static SquareStrategy getInstance() {
        if (instance == null) {
            instance = new SquareStrategy();
        }
        return instance;
    }

    @Override
    public double calculateArea(Figure figure) {

        Square square = (Square) figure;
        double side = Math.sqrt(Math.pow(Math.abs(square.getPointFirst().getX() - square.getPointSecond().getX()), 2) +
                Math.pow(Math.abs(square.getPointFirst().getY() - square.getPointSecond().getY()), 2));

        return 4 * side;
    }

    @Override
    public double calculatePerimeter(Figure figure) {

        Square square = (Square) figure;
        double side = Math.sqrt(Math.pow(Math.abs(square.getPointFirst().getX() - square.getPointSecond().getX()), 2) +
                Math.pow(Math.abs(square.getPointFirst().getY() - square.getPointSecond().getY()), 2));

        return Math.pow(side, 2);
    }
}
