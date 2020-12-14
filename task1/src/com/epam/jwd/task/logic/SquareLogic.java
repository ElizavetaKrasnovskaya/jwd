package com.epam.jwd.task.logic;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.ApplicationContext;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.model.impl.SimpleApplicationContext;
import com.epam.jwd.task.model.impl.Square;

import java.util.ArrayList;

public class SquareLogic {
    public static ArrayList<Square> initSquare() {
        ArrayList<Point> points = PointLogic.initPoints();
        ArrayList<Square> squares = new ArrayList<>(1);
        try {
            final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
            final FigureFactory figureFactory = applicationContext.createFigureFactory();
            squares.add((Square) figureFactory.createFigure(FigureType.SQUARE, points));
        } catch (FigureException ex) {
            ex.printStackTrace();
        }
        return squares;
    }
}
