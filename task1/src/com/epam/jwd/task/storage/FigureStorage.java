package com.epam.jwd.task.storage;

import com.epam.jwd.task.model.impl.Line;
import com.epam.jwd.task.model.impl.MultiAngle;
import com.epam.jwd.task.model.impl.Square;
import com.epam.jwd.task.model.impl.Triangle;

import java.util.ArrayList;
import java.util.List;

public class FigureStorage {

    private static FigureStorage instance;

    private static final List<Line> ALL_CREATED_LINES = new ArrayList<>();
    private static final List<Triangle> ALL_CREATED_TRIANGLES = new ArrayList<>();
    private static final List<Square> ALL_CREATED_SQUARES = new ArrayList<>();
    private static final List<MultiAngle> ALL_CREATED_MULTI_ANGLE = new ArrayList<>();

    private FigureStorage() {
    }

    public static FigureStorage getInstance() {
        if (instance == null) {
            instance = new FigureStorage();
        }

        return instance;
    }

    public void addLineToStorage(Line line) {
        ALL_CREATED_LINES.add(line);
    }

    public void removeLineFromStorage(Line line) {
        ALL_CREATED_LINES.remove(line);
    }

    public Line fetchLineFromStorage(Line line) {
        return ALL_CREATED_LINES.stream().
                filter(lineFromStorage -> lineFromStorage.equals(line)).findAny().orElse(null);
    }

    public void addTriangleToStorage(Triangle triangle) {
        ALL_CREATED_TRIANGLES.add(triangle);
    }

    public void removeTriangleFromStorage(Triangle triangle) {
        ALL_CREATED_TRIANGLES.remove(triangle);
    }

    public Triangle fetchTriangleFromStorage(Triangle triangle) {
        return ALL_CREATED_TRIANGLES.stream().
                filter(triangleFromStorage -> triangleFromStorage.equals(triangle)).findAny().orElse(null);
    }

    public Triangle fetchTriangleFromStorageByID(long id) {
        return ALL_CREATED_TRIANGLES.stream().
                filter(triangleFromStorage -> triangleFromStorage.getID() == id).findAny().orElse(null);
    }

    public void addSquareToStorage(Square square) {
        ALL_CREATED_SQUARES.add(square);
    }

    public void removeSquareFromStorage(Square square) {
        ALL_CREATED_SQUARES.remove(square);
    }

    public Square fetchSquareFromStorage(Square square) {
        return ALL_CREATED_SQUARES.stream().
                filter(squareFromStorage -> squareFromStorage.equals(square)).findAny().orElse(null);
    }

    public Square fetchSquareFromStorageByID(long id) {
        return ALL_CREATED_SQUARES.stream().
                filter(squareFromStorage -> squareFromStorage.getID() == id).findAny().orElse(null);
    }

    public void addMultiAngleFigureToStorage(MultiAngle multiAngle) {
        ALL_CREATED_MULTI_ANGLE.add(multiAngle);
    }

    public void removeMultiAngleFigureFromStorage(MultiAngle multiAngle) {
        ALL_CREATED_MULTI_ANGLE.remove(multiAngle);
    }

    public MultiAngle fetchMultiAngleFigureFromStorage(MultiAngle multiAngle) {
        return ALL_CREATED_MULTI_ANGLE.stream().
                filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage.equals(multiAngle)).
                findAny().orElse(null);
    }

    public MultiAngle fetchMultiAngleFigureFromStorageByID(long id) {
        return ALL_CREATED_MULTI_ANGLE.stream().
                filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage.getID() == id).
                findAny().orElse(null);
    }

}
