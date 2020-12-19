package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public class Creator {

    public ArrayList<Point> initPoints(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 2));
        points.add(new Point(3, 2));
        points.add(new Point(3, 0));
        points.add(new Point(1, 1));
        return points;
    }

}
