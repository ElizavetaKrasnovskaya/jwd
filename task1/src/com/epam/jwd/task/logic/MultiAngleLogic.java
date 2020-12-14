package com.epam.jwd.task.logic;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.ApplicationContext;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.MultiAngle;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.model.impl.SimpleApplicationContext;

import java.util.ArrayList;

public class MultiAngleLogic {
    public static ArrayList<MultiAngle> initMultiAngels() {
        ArrayList<Point> points = PointLogic.initPoints();
        ArrayList<MultiAngle> multiAngles = new ArrayList<>(1);

        try {
            final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
            final FigureFactory figureFactory = applicationContext.createFigureFactory();

            multiAngles.set(0, (MultiAngle) figureFactory.createFigure(FigureType.MULTI_ANGLE, points));
        } catch (FigureException ex) {
            ex.printStackTrace();
        }
        return multiAngles;
    }
}
