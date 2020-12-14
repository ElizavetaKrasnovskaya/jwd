package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;

public interface FigureStorageService {
    Figure fetchFigureFromStorage(Figure figure) throws FigureException;

    void addFigureToStorage(Figure figure) throws FigureException;

    void removeFigureFromStorage(Figure figure) throws FigureException;

    Figure fetchFigureByIDFromStorage(FigureType type, long id) throws FigureException;
}
