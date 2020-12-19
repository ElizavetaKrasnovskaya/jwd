package com.epam.jwd.task.model;

import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.strategy.PropertyStrategy;
import com.epam.jwd.task.strategy.impl.MultiFigurePropertyStrategy;

import java.util.ArrayList;

public abstract class Figure {

    protected ArrayList<Point> points;
    protected FigureType figureType;
    private PropertyStrategy figurePropertiesStrategy = MultiFigurePropertyStrategy.INSTANCE;

    public Figure(ArrayList<Point> points){
        this.points = points;
    }

    protected Figure() {
    }


    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public double fetchPerimeter() {
        return figurePropertiesStrategy.calculatePerimeter(points);
    }

    public double fetchArea() {
        return figurePropertiesStrategy.calculateArea(points);
    }

    public abstract long getIndex();

    public FigureType getFigureType() {
        return figureType;
    }
}
