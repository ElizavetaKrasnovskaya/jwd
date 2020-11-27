package com.epam.jwd.task1.controller;

import com.epam.jwd.task1.model.FigureFactory;
import com.epam.jwd.task1.model.Line;
import com.epam.jwd.task1.model.MultiAngle;
import com.epam.jwd.task1.model.Point;
import com.epam.jwd.task1.model.Square;
import com.epam.jwd.task1.model.Triangle;

public class FigureService {

    FigureFactory figureFactory = new FigureFactory();

    private final static int amountOfPoints = 4;
    private final static int amountOfLines = 2;
    private final static int amountOfTriangles = 2;
    private final static int amountOfSquares = 1;
    private final static int amountOfMultiAngles = 1;

    private Point[] points = new Point[amountOfPoints];
    private Line[] lines = new Line[amountOfLines];
    private Triangle[] triangles = new Triangle[amountOfTriangles];
    private Square[] squares = new Square[amountOfSquares];
    private MultiAngle[] multiAngles = new MultiAngle[amountOfMultiAngles];

    public void initPoints() {
        points[0] = new Point(2.0, 3.0);
        points[1] = new Point(4.0, 3.0);
        points[2] = new Point(2.0, 1.0);
        points[3] = new Point(4.0, 1.0);
    }

    public void initLines() {
        initPoints();
        lines[0] = new Line(points[1], points[2]);
        lines[1] = new Line(points[3], points[3]);
    }

    public void initTriangles() {
        initPoints();
        triangles[0] = (Triangle) figureFactory.createFigure("Triangle");
        triangles[0].setPoint1(points[0]);
        triangles[0].setPoint2(points[1]);
        triangles[0].setPoint3(points[2]);

        triangles[1] = (Triangle) figureFactory.createFigure("Triangle");
        triangles[1].setPoint1(points[0]);
        triangles[1].setPoint2(points[1]);
        triangles[1].setPoint3(points[1]);
    }

    public void initSquare() {
        initPoints();
        squares[0] = (Square) figureFactory.createFigure("Square");
        squares[0].setPoint1(points[0]);
        squares[0].setPoint2(points[1]);
        squares[0].setPoint3(points[2]);
        squares[0].setPoint4(points[3]);
    }

    public void initMultiAngle() {
        initPoints();
        multiAngles[0] = (MultiAngle) figureFactory.createFigure("MultiAngle");
        multiAngles[0].setPoint1(points[0]);
        multiAngles[0].setPoint2(points[1]);
        multiAngles[0].setPoint3(points[2]);
        multiAngles[0].setPoint4(points[3]);
    }

    public Point[] getPoints() {
        initPoints();
        return points;
    }

    public Line[] getLines() {
        initLines();
        return lines;
    }

    public Triangle[] getTriangles() {
        initTriangles();
        return triangles;
    }

    public Square[] getSquares() {
        initSquare();
        return squares;
    }

    public MultiAngle[] getMultiAngles() {
        initMultiAngle();
        return multiAngles;
    }
}
