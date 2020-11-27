package com.epam.jwd.task1.strategy;

import com.epam.jwd.task1.model.Point;

public interface FigureStrategy {

    double calculatePerimeter(Point[] points);

    double calculateArea(Point[] points);
}
