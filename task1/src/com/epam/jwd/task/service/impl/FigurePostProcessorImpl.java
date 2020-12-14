package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.service.FigurePostProcessor;

public class FigurePostProcessorImpl implements FigurePostProcessor {

    private static FigurePostProcessorImpl instance;

    private FigurePostProcessorImpl(){}

    public static FigurePostProcessor getInstance() {
        if (instance == null) {
            instance = new FigurePostProcessorImpl();
        }
        return instance;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {

        if (!validate(figure)) {
            throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    private boolean validate(Figure figure) {

        return figure.validate();
    }

}
