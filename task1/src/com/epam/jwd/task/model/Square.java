package com.epam.jwd.task.model;

import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.strategy.PropertyStrategy;
import com.epam.jwd.task.strategy.impl.SquarePropertyStrategy;

import java.util.ArrayList;

public class Square extends Figure {

    private static final int NUMBER_OF_FIGURE_POINTS = 4;
    private static long numberOfSquare = 0;

    private final long index = ++numberOfSquare;
    private PropertyStrategy figurePropertyStrategy = SquarePropertyStrategy.INSTANCE;

    {
        figureType = FigureType.SQUARE;
    }

    public Square(ArrayList<Point> points) {
        this.points = new ArrayList<>(NUMBER_OF_FIGURE_POINTS);
        for (int i = 0; i < NUMBER_OF_FIGURE_POINTS && i < points.size(); i++) {
            this.points.set(i, points.get(i));
        }
    }

    @Override
    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertyStrategy;
    }

    @Override
    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        this.figurePropertyStrategy = figurePropertiesStrategy;
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
        return points;
    }

    @Override
    public long getIndex() {
        return 0;
    }

}
