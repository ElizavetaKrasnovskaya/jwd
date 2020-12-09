package com.epam.jwd.task.model.impl;

import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.strategy.FigureStrategy;

public abstract class Figure {

    private FigureStrategy figureStrategy;
    private FigureType FIGURE_TYPE;

    public Figure(){}

    public Figure(FigureStrategy figureStrategy, FigureType FIGURE_TYPE) {
        this.figureStrategy = figureStrategy;
        this.FIGURE_TYPE = FIGURE_TYPE;
    }

    public FigureType getFIGURE_TYPE() {
        return FIGURE_TYPE;
    }

    public void setStrategy(FigureStrategy figureStrategy) {
        this.figureStrategy = figureStrategy;
    }

    public FigureStrategy executeStrategy() {
        return figureStrategy;
    }

    public abstract boolean validate();
}
