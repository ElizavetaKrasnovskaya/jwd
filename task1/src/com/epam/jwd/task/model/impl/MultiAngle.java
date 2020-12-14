package com.epam.jwd.task.model.impl;

import java.util.ArrayList;
import java.util.Objects;

public class MultiAngle extends Figure {

    private final ArrayList<Point> points;

    public MultiAngle(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public boolean validate() {

        double firstSide = Math.sqrt(Math.pow(Math.abs(getPoints().get(0).getX() - getPoints().get(1).getX()), 2) +
                Math.pow(Math.abs(getPoints().get(0).getY() - getPoints().get(1).getY()), 2));

        double secondSide = Math.sqrt(Math.pow(Math.abs(getPoints().get(1).getX() - getPoints().get(2).getX()), 2) +
                Math.pow(Math.abs(getPoints().get(1).getY() - getPoints().get(2).getY()), 2));

        double thirdSide = Math.sqrt(Math.pow(Math.abs(getPoints().get(2).getX() - getPoints().get(3).getX()), 2) +
                Math.pow(Math.abs(getPoints().get(2).getY() - getPoints().get(3).getY()), 2));

        double fourthSide = Math.sqrt(Math.pow(Math.abs(getPoints().get(3).getX() - getPoints().get(0).getX()), 2) +
                Math.pow(Math.abs(getPoints().get(3).getY() - getPoints().get(0).getY()), 2));

        if (getPoints().get(0).equals(getPoints().get(1)) ||
                getPoints().get(0).equals(getPoints().get(2)) ||
                getPoints().get(0).equals(getPoints().get(3)) ||
                getPoints().get(1).equals(getPoints().get(2)) ||
                getPoints().get(1).equals(getPoints().get(3)) ||
                getPoints().get(2).equals(getPoints().get(3))) {

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
        return getPoints().equals(that.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints());
    }

    @Override
    public String toString() {
        return "MultiAngle" +
                "points=" + points;
    }
}
