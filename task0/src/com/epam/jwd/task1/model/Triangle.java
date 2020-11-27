package com.epam.jwd.task1.model;

import com.epam.jwd.task1.strategy.FigureStrategy;
import com.epam.jwd.task1.strategy.TriangleStrategyImpl;

import java.util.Objects;

public class Triangle extends Figure {

    private static FigureStrategy triangleStrategy = TriangleStrategyImpl.getInstance();

    private Point point1;
    private Point point2;
    private Point point3;

    private Point[] points;

    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(Point point1, Point point2, Point point3) {
        super(triangleStrategy);
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        points = new Point[]{point1, point2, point3};
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point[] getPoints() {
        return points;
    }

    public double getFirstSide() {
        setFirstSide();
        return firstSide;
    }

    public double getSecondSide() {
        setSecondSide();
        return secondSide;
    }

    public double getThirdSide() {
        setThirdSide();
        return thirdSide;
    }

    private void setFirstSide() {
        firstSide = Math.sqrt(Math.pow(Math.abs(point1.getX() - point2.getX()), 2) +
                Math.pow(Math.abs(point1.getY() - point2.getY()), 2));
    }

    private void setSecondSide() {
        secondSide = Math.sqrt(Math.pow(Math.abs(point2.getX() - point3.getX()), 2) +
                Math.pow(Math.abs(point2.getY() - point3.getY()), 2));
    }

    private void setThirdSide() {
        thirdSide = Math.sqrt(Math.pow(Math.abs(point3.getX() - point1.getX()), 2) +
                Math.pow(Math.abs(point3.getY() - point1.getY()), 2));
    }

    public boolean validate() {
        if (point1.equals(point2) | point1.equals(point3) | point2.equals(point3)) {
            return false;
        } else if (firstSide + secondSide < thirdSide |
                firstSide + thirdSide < secondSide |
                secondSide + thirdSide < firstSide) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Triangle" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getPoint1().equals(triangle.getPoint1()) &&
                getPoint2().equals(triangle.getPoint2()) &&
                getPoint3().equals(triangle.getPoint3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint1(), getPoint2(), getPoint3());
    }
}
