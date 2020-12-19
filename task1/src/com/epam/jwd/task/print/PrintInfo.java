package com.epam.jwd.task.print;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.factory.impl.ApplicationContext;
import com.epam.jwd.task.logic.Creator;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.impl.FigureSearchCriteria;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PrintInfo {

    private static final Logger LOGGER = LogManager.getLogger(PrintInfo.class);

    public static void print(){
        Creator creator = new Creator();
        ArrayList<Point> points = creator.initPoints();
        ArrayList<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.set(0, points.get(0));
        pointsForTriangle.set(1, points.get(1));
        pointsForTriangle.set(2, points.get(2));
        FigureFactory figureFactory = ApplicationContext.getFigureFactory();
        Figure figure;

        try{
            figure = figureFactory.createFigure(FigureType.TRIANGLE, pointsForTriangle);
            double perimeter = figure.fetchPerimeter();
            double area = figure.fetchArea();
            LOGGER.log(Level.INFO, "Figure {}. Area of the figure: {}. Perimeter of the figure: {}", figure, area, perimeter);
        }catch (FigureException ex) {
            LOGGER.log(Level.ERROR, "Array: {}. Result: {}", pointsForTriangle, ex.getMessage());
        }

        FigureSearchCriteria criteria = FigureSearchCriteria.builder()
                .setFigureType(FigureType.MULTI_ANGLE)
                .setMinArea(2.6)
                .setMaxArea(8.5)
                .build();
        System.out.println(criteria);
    }

}
