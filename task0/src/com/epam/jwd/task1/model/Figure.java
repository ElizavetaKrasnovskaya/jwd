package com.epam.jwd.task1.model;

import com.epam.jwd.task1.strategy.FigureStrategy;

public abstract class Figure {

    private FigureStrategy figureStrategy;

    public Figure() {
    }

    public Figure(FigureStrategy figureStrategy) {
        this.figureStrategy = figureStrategy;
    }

    public abstract boolean validate();

    public double calculatePerimeter(Point[] points) {
        return figureStrategy.calculatePerimeter(points);
    }

    public double calculateArea(Point[] points) {
        return figureStrategy.calculateArea(points);
    }
}
