package com.epam.jwd.task1.controller;

import com.epam.jwd.task1.model.Line;
import com.epam.jwd.task1.model.MultiAngle;
import com.epam.jwd.task1.model.Point;
import com.epam.jwd.task1.model.Square;
import com.epam.jwd.task1.model.Triangle;

public class FigureService {

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

    public void initPoints(){
        points[0] = new Point(2.0, 3.0);
        points[1] = new Point(4.0, 3.0);
        points[2] = new Point(2.0, 1.0);
        points[3] = new Point(4.0, 1.0);
    }

    public void initLines(){
        lines[0] = new Line(points[1], points[2]);
        lines[1] = new Line(points[3], points[3]);
    }

    public void initTriangles(){
        triangles[0] = new Triangle(points[0], points[1], points[2]);
        triangles[1] = new Triangle(points[1], points[2], points[1]);
    }

    public void initSquare(){
        squares[0] = new Square(points[0], points[1], points[2], points[3]);
    }

    public void initMultiAngle(){
        multiAngles[0] = new MultiAngle(points[0], points[1], points[2], points[3]);
    }

    public Point[] getPoints() {
        initPoints();
        return points;
    }

    public Line[] getLines() {
        initPoints();
        initLines();
        return lines;
    }

    public Triangle[] getTriangles() {
        initPoints();
        initTriangles();
        return triangles;
    }

    public Square[] getSquares() {
        initPoints();
        initSquare();
        return squares;
    }

    public MultiAngle[] getMultiAngles() {
        initPoints();
        initMultiAngle();
        return multiAngles;
    }
}
