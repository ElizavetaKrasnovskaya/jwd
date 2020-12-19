package com.epam.jwd.task.strategy;

import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public interface PropertyStrategy {

    double calculatePerimeter(ArrayList<Point> points);

    double calculateArea(ArrayList<Point> points);

}
