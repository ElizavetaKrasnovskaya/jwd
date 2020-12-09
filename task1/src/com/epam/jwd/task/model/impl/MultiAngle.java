package com.epam.jwd.task.model.impl;

import java.util.Arrays;

public class MultiAngle extends Figure {

    private final Point[] points;

    public MultiAngle(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public boolean validate() {

        double firstSide = Math.sqrt(Math.pow(Math.abs(getPoints()[0].getX() - getPoints()[1].getX()), 2) +
                Math.pow(Math.abs(getPoints()[0].getY() - getPoints()[1].getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(getPoints()[1].getX() - getPoints()[2].getX()), 2) +
                Math.pow(Math.abs(getPoints()[1].getY() - getPoints()[2].getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(getPoints()[2].getX() - getPoints()[3].getX()), 2) +
                Math.pow(Math.abs(getPoints()[2].getY() - getPoints()[3].getY()), 2));

        double fourthSide = Math.sqrt(Math.pow(Math.abs(getPoints()[3].getX() - getPoints()[0].getX()), 2) +
                Math.pow(Math.abs(getPoints()[3].getY() - getPoints()[0].getY()), 2));

        if (getPoints()[0].equals(getPoints()[1]) ||
                getPoints()[0].equals(getPoints()[2]) ||
                getPoints()[0].equals(getPoints()[3]) ||
                getPoints()[1].equals(getPoints()[2]) ||
                getPoints()[1].equals(getPoints()[3]) ||
                getPoints()[2].equals(getPoints()[3])) {

            return false;

        } else if (firstSide != secondSide || firstSide != thirdSide || firstSide != fourthSide ||
                secondSide != thirdSide || secondSide != fourthSide || thirdSide != fourthSide) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultiAngle)) return false;
        MultiAngle that = (MultiAngle) o;
        return Arrays.equals(getPoints(), that.getPoints());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getPoints());
    }

    @Override
    public String toString() {
        return "MultiAngle " +
                "points = " + Arrays.toString(points);
    }
}
