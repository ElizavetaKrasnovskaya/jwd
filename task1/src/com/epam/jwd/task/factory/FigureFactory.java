package com.epam.jwd.task.factory;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Point;

import java.util.ArrayList;

public interface FigureFactory {

    Figure createFigure(FigureType type, ArrayList<Point> figureConstituents) throws FigureException;

}
