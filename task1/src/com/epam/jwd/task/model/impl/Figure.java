package com.epam.jwd.task.model.impl;

import com.epam.jwd.task.model.FigureType;
import com.epam.jwd.task.strategy.FigureStrategy;

public abstract class Figure {

    private FigureStrategy figureStrategy;
    private FigureType FIGURE_TYPE;
    private long ID = 0;
    private static long nextID = 1;

    public Figure(){}

    public Figure(FigureStrategy figureStrategy, FigureType FIGURE_TYPE) {
        this.figureStrategy = figureStrategy;
        this.FIGURE_TYPE = FIGURE_TYPE;
        ID = nextID++;
    }

    public long getID() {
        return ID;
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
