package com.epam.jwd.task.model.impl;

import java.util.Objects;

public class Square extends Figure {

    private final Point pointFirst;
    private final Point pointSecond;
    private final Point pointThird;
    private final Point pointFourth;

    public Square(Point pointFirst, Point pointSecond, Point pointThird, Point pointFourth) {
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
        this.pointThird = pointThird;
        this.pointFourth = pointFourth;
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

    public Point getPointFourth() {
        return pointFourth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return getPointFirst().equals(square.getPointFirst()) &&
                getPointSecond().equals(square.getPointSecond()) &&
                getPointThird().equals(square.getPointThird()) &&
                getPointFourth().equals(square.getPointFourth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPointFirst(), getPointSecond(), getPointThird(), getPointFourth());
    }

    @Override
    public String toString() {
        return "Square" +
                " pointFirst = " + pointFirst +
                ", pointSecond = " + pointSecond +
                ", pointThird = " + pointThird +
                ", pointFourth = " + pointFourth;
    }

    @Override
    public boolean validate() {

        double firstSide = Math.sqrt(Math.pow(Math.abs(getPointFirst().getX() - getPointSecond().getX()), 2) +
                Math.pow(Math.abs(getPointFirst().getY() - getPointSecond().getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(getPointSecond().getX() - getPointThird().getX()), 2) +
                Math.pow(Math.abs(getPointSecond().getY() - getPointThird().getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(getPointThird().getX() - getPointFourth().getX()), 2) +
                Math.pow(Math.abs(getPointThird().getY() - getPointFourth().getY()), 2));

        double fourthSide = Math.sqrt(Math.pow(Math.abs(getPointFourth().getX() - getPointFirst().getX()), 2) +
                Math.pow(Math.abs(getPointFourth().getY() - getPointFirst().getY()), 2));

        if (getPointFirst().equals(getPointSecond()) ||
                getPointFirst().equals(getPointThird()) ||
                getPointFirst().equals(getPointFourth()) ||
                getPointSecond().equals(getPointThird()) ||
                getPointSecond().equals(getPointFourth()) ||
                getPointThird().equals(getPointFourth())) {
            return false;
        } else if (firstSide != secondSide || firstSide != thirdSide || firstSide != fourthSide ||
                secondSide != thirdSide || secondSide != fourthSide || thirdSide != fourthSide) {
            return false;
        } else {
            return true;
        }
    }
}
