package com.epam.jwd.task.builder;

import com.epam.jwd.task.model.FigureType;

public class FigureCriteria {
    private FigureType figureType;
    private int amountOfAngles;

    public FigureCriteria() {
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public int getAmountOfAngles() {
        return amountOfAngles;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public void setAmountOfAngles(int amountOfAngles) {
        this.amountOfAngles = amountOfAngles;
    }
}
