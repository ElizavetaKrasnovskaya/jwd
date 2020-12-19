package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.IllegalFigureTypeException;
import com.epam.jwd.task.factory.FigureType;
import com.epam.jwd.task.service.FigurePostProcessor;
import com.epam.jwd.task.service.FigurePreProcessor;

public class ServiceProvider {

    private ServiceProvider() {
    }

    private static final ServiceProvider INSTANCE = new ServiceProvider();

    private FigurePreProcessor preProcessor = new FigureExistencePreProcessor();
    private FigurePostProcessor trianglePostProcessor = new TriangleExistencePostProcessor();
    private FigurePostProcessor squarePostProcessor = new SquareExistencePostProcessor();
    private FigurePostProcessor multiAnglePostProcessor = new MultiAngleExistencePostProcessor();
    private FigureStorage figureStorage = FigureStorage.INSTANCE;

    public static ServiceProvider getINSTANCE() {
        return INSTANCE;
    }

    public FigurePreProcessor getPreProcessor() {
        return preProcessor;
    }

    public FigureStorage getFigureStorage() {
        return figureStorage;
    }


    public FigurePostProcessor getPostProcessor(FigureType type) throws IllegalFigureTypeException {
        switch (type) {
            case TRIANGLE:
                return trianglePostProcessor;
            case SQUARE:
                return squarePostProcessor;
            case MULTI_ANGLE:
                return multiAnglePostProcessor;
            default:
                throw new IllegalFigureTypeException("Figure type not founded");
        }
    }

}
