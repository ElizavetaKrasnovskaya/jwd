package com.epam.jwd.task1.model;

import com.epam.jwd.task1.strategy.FigureStrategy;
import com.epam.jwd.task1.strategy.SquareStrategyImpl;

import java.util.Objects;

public class Square extends Figure {

    private static FigureStrategy squareStrategy = SquareStrategyImpl.getInstance();

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    private Point[] points;

    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double fourthSide;

    protected Square() {
        super(squareStrategy);
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

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public void setPoints() {
        points = new Point[]{getPoint1(), getPoint2(), getPoint3()};
    }

    public Point[] getPoints() {
        setPoints();
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

    public double getFourthSide() {
        setFourthSide();
        return fourthSide;
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
        thirdSide = Math.sqrt(Math.pow(Math.abs(point3.getX() - point4.getX()), 2) +
                Math.pow(Math.abs(point3.getY() - point4.getY()), 2));
    }

    private void setFourthSide() {
        fourthSide = Math.sqrt(Math.pow(Math.abs(point4.getX() - point1.getX()), 2) +
                Math.pow(Math.abs(point4.getY() - point1.getY()), 2));
    }

    public boolean validate() {
        if (getPoint1().equals(getPoint2()) ||
                getPoint1().equals(getPoint3()) ||
                getPoint1().equals(getPoint4()) ||
                getPoint2().equals(getPoint3()) ||
                getPoint2().equals(getPoint4()) ||
                getPoint3().equals(getPoint4())) {
            return false;
        } else if (firstSide != secondSide || firstSide != thirdSide || firstSide != fourthSide ||
                secondSide != thirdSide || secondSide != fourthSide || thirdSide != fourthSide) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Square " +
                "point 1 = " + point1 +
                ", point 2 = " + point2 +
                ", point 3 = " + point3 +
                ", point 4 = " + point4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return getPoint1().equals(square.getPoint1()) &&
                getPoint2().equals(square.getPoint2()) &&
                getPoint3().equals(square.getPoint3()) &&
                getPoint4().equals(square.getPoint4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint1(), getPoint2(), getPoint3(), getPoint4());
    }
}
