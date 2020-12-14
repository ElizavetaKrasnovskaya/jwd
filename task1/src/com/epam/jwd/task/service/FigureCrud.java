package com.epam.jwd.task.service;

import com.epam.jwd.task.builder.FigureCriteria;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FigureCrud {

    Figure createFigure(FigureType type, ArrayList<Point> points) throws FigureException;

    List<Figure> multiCreateFigure(Map<FigureType, List<ArrayList<Point>>> figureCreateInfo) throws FigureException;

    void deleteFigure(Figure figure) throws FigureException;

    Figure findFigure(Figure figure) throws FigureException;

    void updateFigure(Figure oldFigure, Figure newFigure) throws FigureException;

    Figure findFigureByID(long id) throws FigureException;

    List<Figure> findFiguresByCriteria(FigureCriteria figureCriteria);

}
