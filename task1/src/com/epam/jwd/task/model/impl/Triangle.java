package com.epam.jwd.task.model.impl;


import java.util.Objects;

public class Triangle extends Figure {

    private final Point pointFirst;
    private final Point pointSecond;
    private final Point pointThird;

    public Triangle(Point pointFirst, Point pointSecond, Point pointThird) {
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
        this.pointThird = pointThird;
    }

    public Point getPointFirst() {
        return pointFirst;
    }

    public Point getPointSecond() {
        return pointSecond;
    }

    public Point getPointThird() {
        return pointThird;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getPointFirst().equals(triangle.getPointFirst()) &&
                getPointSecond().equals(triangle.getPointSecond()) &&
                getPointThird().equals(triangle.getPointThird());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPointFirst(), getPointSecond(), getPointThird());
    }

    @Override
    public String toString() {
        return "Triangle" +
                " pointFirst = " + pointFirst +
                ", pointSecond = " + pointSecond +
                ", pointThird = " + pointThird;
    }

    @Override
    public boolean validate() {

        double firstSide = Math.sqrt(Math.pow(Math.abs(getPointFirst().getX() - getPointSecond().getX()), 2) +
                Math.pow(Math.abs(getPointFirst().getY() - getPointSecond().getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(getPointSecond().getX() - getPointThird().getX()), 2) +
                Math.pow(Math.abs(getPointSecond().getY() - getPointThird().getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(getPointThird().getX() - getPointFirst().getX()), 2) +
                Math.pow(Math.abs(getPointThird().getY() - getPointFirst().getY()), 2));

        if (getPointFirst().equals(getPointSecond()) | getPointFirst().equals(getPointThird()) | getPointSecond().equals(getPointThird())) {
            return false;
        } else if (firstSide + secondSide < thirdSide |
                firstSide + thirdSide < secondSide |
                secondSide + thirdSide < firstSide) {
            return false;
        } else {
            return true;
        }
    }
}
