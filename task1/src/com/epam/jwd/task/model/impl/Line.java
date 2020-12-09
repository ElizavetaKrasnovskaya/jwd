package com.epam.jwd.task.model.impl;

import java.util.Objects;

public class Line {

    private final Point pointFirst;
    private final Point pointSecond;

    public Line(Point pointFirst, Point pointSecond) {
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
    }

    public Point getPointFirst() {
        return pointFirst;
    }

    public Point getPointSecond() {
        return pointSecond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return getPointFirst().equals(getPointFirst()) &&
                getPointSecond().equals(getPointSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPointFirst(), getPointSecond());
    }

    @Override
    public String toString() {
        return "Line" +
                " pointFirst = " + pointFirst +
                ", pointSecond = " + pointSecond;
    }

    public boolean validate(){
        if(getPointFirst().equals(getPointSecond())){
            return false;
        }else {
            return true;
        }
    }
}
