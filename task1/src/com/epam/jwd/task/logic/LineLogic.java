package com.epam.jwd.task.logic;

import com.epam.jwd.task.model.impl.Line;
import com.epam.jwd.task.model.impl.Point;

public class LineLogic {

    public static Line[] initLines() {
        Point[] points = PointLogic.initPoints();
        Line[] lines = new Line[2];
        lines[0] = new Line(points[1], points[2]);
        lines[1] = new Line(points[3], points[3]);
        return lines;
    }

}
