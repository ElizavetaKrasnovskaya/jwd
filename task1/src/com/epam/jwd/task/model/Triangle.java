package com.epam.jwd.task.model;

import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.strategy.PropertyStrategy;
import com.epam.jwd.task.strategy.impl.TrianglePropertyStrategy;

import java.util.ArrayList;
import java.util.Objects;

public class Triangle extends Figure{

    private static final int NUMBER_OF_FIGURE_POINTS = 3;
    private static long numberOfTriangles = 0;

    private final long index = ++numberOfTriangles;
    private PropertyStrategy figurePropertiesStrategy = TrianglePropertyStrategy.getInstance();

    {
        figureType = FigureType.TRIANGLE;
    }

    public Triangle(ArrayList<Point> points) {
        this.points = new ArrayList<>(NUMBER_OF_FIGURE_POINTS);
        for (int i = 0; i < NUMBER_OF_FIGURE_POINTS && i < points.size(); i++) {
            this.points.set(i, points.get(i));
        }
    }

    @Override
    public long getIndex() {
        return index;
    }

    @Override
    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    @Override
    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    @Override
    public double fetchPerimeter() {
        return figurePropertiesStrategy.calculatePerimeter(points);
    }

    @Override
    public double fetchArea() {
        return figurePropertiesStrategy.calculateArea(points);
    }

    @Override
    public ArrayList<Point> getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return "Triangle" +
                " index = " + index +
                ", figurePropertiesStrategy = " + figurePropertiesStrategy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getIndex() == triangle.getIndex() &&
                Objects.equals(getFigurePropertiesStrategy(), triangle.getFigurePropertiesStrategy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex(), getFigurePropertiesStrategy());
    }
}
