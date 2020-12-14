package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.impl.Line;
import com.epam.jwd.task.model.impl.Point;

import java.util.ArrayList;

public class LineLogic {

    public static ArrayList<Line> initLines() {
        ArrayList<Point> points = PointLogic.initPoints();
        ArrayList<Line> lines = new ArrayList<>(2);
        lines.add(new Line(points.get(1), points.get(1)));
        lines.add(new Line(points.get(3), points.get(3)));
        return lines;
    }

}
