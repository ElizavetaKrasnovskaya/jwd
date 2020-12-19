package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.IllegalFigureTypeException;
import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.model.Figure;
import com.epam.jwd.task.model.Point;
import com.epam.jwd.task.service.impl.FigureSearchCriteria;

import java.util.ArrayList;
import java.util.Optional;

public interface FigureCrud {

    Figure create(FigureType type, Point... figureConstituents) throws FigureException;
    ArrayList<Figure> multiCreate(FigureType figureType, ArrayList<Point[]> figureConstituents) throws FigureException;
    boolean delete(Figure figure) throws FigureException;
    Optional<Figure> find(Figure figure) throws IllegalFigureTypeException;
    boolean update(Figure figure) throws IllegalFigureTypeException;
    Optional<Figure> findByIndex(FigureType figureType, int index) throws IllegalFigureTypeException;
    ArrayList<Figure> findByCriteria(FigureSearchCriteria criteria) throws IllegalFigureTypeException;

}
