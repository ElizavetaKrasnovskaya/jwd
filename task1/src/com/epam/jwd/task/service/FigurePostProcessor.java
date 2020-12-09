package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.impl.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
