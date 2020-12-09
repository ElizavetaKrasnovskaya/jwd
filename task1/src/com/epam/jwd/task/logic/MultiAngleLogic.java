package com.epam.jwd.task.logic;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.ApplicationContext;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.MultiAngle;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.model.impl.SimpleApplicationContext;

public class MultiAngleLogic {
    public static MultiAngle[] initMultiAngels() {
        Point[] points = PointLogic.initPoints();
        MultiAngle[] multiAngles = new MultiAngle[1];

        try {
            final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
            final FigureFactory figureFactory = applicationContext.createFigureFactory();

            multiAngles[0] = (MultiAngle) figureFactory.createFigure(FigureType.MULTI_ANGLE, points);
        } catch (FigureException ex) {
            ex.printStackTrace();
        }
        return multiAngles;
    }
}
