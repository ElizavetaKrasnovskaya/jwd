package com.epam.jwd.task.factory;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Point;

public interface FigureFactory {

    Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException;

}
