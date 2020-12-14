package com.epam.jwd.task.logic;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.ApplicationContext;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.model.impl.SimpleApplicationContext;
import com.epam.jwd.task.model.impl.Triangle;

import java.util.ArrayList;

public class TriangleLogic {

    public static ArrayList<Triangle> initTriangles() {
        ArrayList<Point> points = PointLogic.initPoints();
        ArrayList<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < triangles.size(); i++) {
            try {
                final ApplicationContext applicationContext = SimpleApplicationContext.getInstance();
                final FigureFactory figureFactory = applicationContext.createFigureFactory();
                triangles.set(i, (Triangle) figureFactory.createFigure(FigureType.TRIANGLE, points));
            } catch (FigureException ex) {
                ex.printStackTrace();
            }

        }
        return triangles;
    }
}
