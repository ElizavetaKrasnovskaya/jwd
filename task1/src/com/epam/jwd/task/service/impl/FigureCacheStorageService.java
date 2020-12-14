package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.MultiAngle;
import com.epam.jwd.task.model.impl.Square;
import com.epam.jwd.task.model.impl.Triangle;
import com.epam.jwd.task.service.FigureStorageService;
import com.epam.jwd.task.storage.FigureStorage;

public class FigureCacheStorageService implements FigureStorageService {
    private static FigureCacheStorageService instance;
    private static final FigureStorage FIGURE_STORAGE = FigureStorage.getInstance();

    private FigureCacheStorageService() {
    }

    public static FigureCacheStorageService getInstance() {
        if (instance == null) {
            instance = new FigureCacheStorageService();
        }

        return instance;
    }

    @Override
    public Figure fetchFigureFromStorage(Figure figure) throws FigureException {
        switch (figure.getFIGURE_TYPE()) {
            case TRIANGLE:
                figure = FIGURE_STORAGE.fetchTriangleFromStorage((Triangle) figure);
                break;
            case SQUARE:
                figure = FIGURE_STORAGE.fetchSquareFromStorage((Square) figure);
                break;
            case MULTI_ANGLE:
                figure = FIGURE_STORAGE.fetchMultiAngleFigureFromStorage((MultiAngle) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    @Override
    public void addFigureToStorage(Figure figure) throws FigureException {
        switch (figure.getFIGURE_TYPE()) {
            case TRIANGLE:
                FIGURE_STORAGE.addTriangleToStorage((Triangle) figure);
                break;
            case SQUARE:
                FIGURE_STORAGE.addSquareToStorage((Square) figure);
                break;
            case MULTI_ANGLE:
                FIGURE_STORAGE.addMultiAngleFigureToStorage((MultiAngle) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }

    @Override
    public void removeFigureFromStorage(Figure figure) throws FigureException {
        switch (figure.getFIGURE_TYPE()) {
            case TRIANGLE:
                FIGURE_STORAGE.removeTriangleFromStorage((Triangle) figure);
                break;
            case SQUARE:
                FIGURE_STORAGE.removeSquareFromStorage((Square) figure);
                break;
            case MULTI_ANGLE:
                FIGURE_STORAGE.removeMultiAngleFigureFromStorage((MultiAngle) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }

    @Override
    public Figure fetchFigureByIDFromStorage(FigureType type, long id) throws FigureException {
        Figure figure;

        switch (type) {
            case TRIANGLE:
                figure = FIGURE_STORAGE.fetchTriangleFromStorageByID(id);
                break;
            case SQUARE:
                figure = FIGURE_STORAGE.fetchSquareFromStorageByID(id);
                break;
            case MULTI_ANGLE:
                figure = FIGURE_STORAGE.fetchMultiAngleFigureFromStorageByID(id);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }
}
