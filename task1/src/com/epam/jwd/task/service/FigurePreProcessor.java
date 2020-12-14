package com.epam.jwd.task.service;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.model.impl.Point;

import java.util.ArrayList;

public interface FigurePreProcessor {
    void preProcess(ArrayList<Point> points) throws FigureException;
}
