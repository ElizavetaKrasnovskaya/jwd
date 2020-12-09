package com.epam.jwd.task.logic;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.ApplicationContext;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.model.impl.SimpleApplicationContext;
import com.epam.jwd.task.model.impl.Triangle;

public class TriangleLogic {

    public static Triangle[] initTriangles() {
        Point[] points = PointLogic.initPoints();
        Triangle[] triangles = new Triangle[2];

        for (int i = 0; i < triangles.length; i++) {
            try {
                final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
                final FigureFactory figureFactory = applicationContext.createFigureFactory();

                triangles[i] = (Triangle) figureFactory.createFigure(FigureType.TRIANGLE, points);
            } catch (FigureException ex) {
                ex.printStackTrace();
            }

        }
        return triangles;
    }
}
