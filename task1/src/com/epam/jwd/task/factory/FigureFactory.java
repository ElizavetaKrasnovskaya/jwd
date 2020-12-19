package com.epam.jwd.task.factory;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public interface FigureFactory {
    Figure createFigure(FigureType type, ArrayList<Point> figureConstituents) throws FigureException;
}
