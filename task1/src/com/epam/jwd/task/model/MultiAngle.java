package com.epam.jwd.task.model;

import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.strategy.PropertyStrategy;
import com.epam.jwd.task.strategy.impl.MultiFigurePropertyStrategy;

import java.util.ArrayList;

public class MultiAngle extends Figure{

    private PropertyStrategy figurePropertyStrategy = MultiFigurePropertyStrategy.INSTANCE;
    private static long numberOfMultiAngleFigure = 0;

    private final long index = ++numberOfMultiAngleFigure;

    {
        figureType = FigureType.MULTI_ANGLE;
    }

    public MultiAngle(ArrayList<Point> points){
        this.points = points;
    }


    @Override
    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertyStrategy;
    }

    @Override
    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        super.setFigurePropertiesStrategy(figurePropertiesStrategy);
    }

    @Override
    public double fetchPerimeter() {
        return figurePropertyStrategy.calculatePerimeter(points);
    }

    @Override
    public double fetchArea() {
        return figurePropertyStrategy.calculateArea(points);
    }

    @Override
    public ArrayList<Point> getPoints() {
        return super.getPoints();
    }

    @Override
    public long getIndex() {
        return 0;
    }

}
