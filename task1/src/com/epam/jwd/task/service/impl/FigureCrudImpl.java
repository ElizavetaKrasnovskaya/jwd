package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.builder.FigureCriteria;
import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.factory.FigureFactory;
import com.epam.jwd.task.model.ApplicationContext;
import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.model.impl.SimpleApplicationContext;
import com.epam.jwd.task.service.FigureCrud;
import com.epam.jwd.task.service.FigureStorageService;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FigureCrudImpl implements FigureCrud {

    private static final ApplicationContext APPLICATION_CONTEXT = SimpleApplicationContext.getInstance();
    private static final FigureFactory FIGURE_FACTORY = APPLICATION_CONTEXT.createFigureFactory();
    private static final FigureStorageService FIGURE_STORAGE_SERVICE = FigureCacheStorageService.getInstance();


    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> points) throws FigureException {
        return FIGURE_FACTORY.createFigure(type, points);
    }

    @Override
    public List<Figure> multiCreateFigure(Map<FigureType, List<ArrayList<Point>>> figureCreateInfo) throws FigureException {
        List<Figure> figures = new ArrayList<>();

        for (FigureType figureType : figureCreateInfo.keySet()) {
            for (ArrayList<Point> points : figureCreateInfo.get(figureType)) {
                figures.add(FIGURE_FACTORY.createFigure(figureType, points));
            }
        }

        return figures;
    }

    @Override
    public void deleteFigure(Figure figure) throws FigureException {
        FigureCacheStorageService figureCacheStorageService = FigureCacheStorageService.getInstance();
        figureCacheStorageService.removeFigureFromStorage(figure);
    }

    @Override
    public Figure findFigure(Figure figure) throws FigureException {
        return FIGURE_STORAGE_SERVICE.fetchFigureFromStorage(figure);
    }

    @Override
    public void updateFigure(Figure oldFigure, Figure newFigure) throws FigureException {
        FIGURE_STORAGE_SERVICE.removeFigureFromStorage(oldFigure);
        FIGURE_STORAGE_SERVICE.addFigureToStorage(newFigure);
    }

    @Override
    public Figure findFigureByID(long id) throws FigureException {
        Figure figure = null;
        Set<FigureType> figureTypes = EnumSet.allOf(FigureType.class);
        Iterator<FigureType> iterator = figureTypes.iterator();

        while (iterator.hasNext() && figure == null) {
            figure = FIGURE_STORAGE_SERVICE.fetchFigureByIDFromStorage(iterator.next(), id);
        }

        return figure;
    }

    @Override
    public List<Figure> findFiguresByCriteria(FigureCriteria figureCriteria) {
        //TODO search figure by criteria
        return null;
    }

}
