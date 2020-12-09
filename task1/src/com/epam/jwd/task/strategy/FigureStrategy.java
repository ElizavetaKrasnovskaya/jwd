package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.impl.Figure;

public interface FigureStrategy {

    double calculatePerimeter(Figure figure);

    double calculateArea(Figure figure);
}
