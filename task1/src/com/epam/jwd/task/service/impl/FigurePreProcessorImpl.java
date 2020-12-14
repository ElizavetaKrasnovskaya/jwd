package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.exception.FigureException;
import com.epam.jwd.task.exception.FigureNotExistException;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.service.FigurePreProcessor;

import java.util.ArrayList;

public class FigurePreProcessorImpl implements FigurePreProcessor {

    private static FigurePreProcessorImpl instance;

    private FigurePreProcessorImpl(){}

    public static FigurePreProcessor getInstance(){
        if(instance == null){
            instance = new FigurePreProcessorImpl();
        }
        return instance;
    }

    @Override
    public void preProcess(ArrayList<Point> points) throws FigureException {
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (points.get(i).equals(points.get(j))) {
                    throw new FigureNotExistException("Can't create a figure from the same points");
                }
            }
        }
    }

}
