package com.epam.jwd.task1.model;

import java.util.Objects;

public class Line {

    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
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

    public boolean validateLine() {
        if (point1 == point2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Line " +
                "point1 = " + point1 +
                ", point2 = " + point2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return getPoint1().equals(line.getPoint1()) &&
                getPoint2().equals(line.getPoint2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint1(), getPoint2());
    }
}
