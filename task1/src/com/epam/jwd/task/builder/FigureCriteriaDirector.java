package com.epam.jwd.task.builder;

import com.epam.jwd.task.model.FigureType;

public class FigureCriteriaDirector {
    private Builder builder;

    private FigureCriteriaDirector(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void constructPentagon() {
        builder.reset();
        builder.setFigureType(FigureType.MULTI_ANGLE);
        builder.setAmountOfAngles(5);
    }

    public void constructHexagon() {
        builder.reset();
        builder.setFigureType(FigureType.MULTI_ANGLE);
        builder.setAmountOfAngles(6);
    }
}
