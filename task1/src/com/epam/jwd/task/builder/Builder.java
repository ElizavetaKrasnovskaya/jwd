package com.epam.jwd.task.builder;

import com.epam.jwd.task.model.FigureType;

public interface Builder {
    void reset();

    void setFigureType(FigureType figureType);

    void setAmountOfAngles(int amountOfAngles);
}
