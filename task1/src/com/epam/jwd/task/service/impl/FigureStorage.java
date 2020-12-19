package com.epam.jwd.task.service.impl;

import com.epam.jwd.task.model.Figure;

import java.util.ArrayList;

public enum FigureStorage {

    INSTANCE;

    private ArrayList<Figure> triangles = new ArrayList<>();
    private ArrayList<Figure> squares= new ArrayList<>();
    private ArrayList<Figure> multiAngles = new ArrayList<>();

    public ArrayList<Figure> getTriangles() {
        return triangles;
    }

    public ArrayList<Figure> getSquares() {
        return squares;
    }

    public ArrayList<Figure> getMultiAngles() {
        return multiAngles;
    }

}
