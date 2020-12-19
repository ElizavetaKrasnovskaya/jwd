package com.epam.jwd.task.service.validator;

import com.epam.jwd.task.model.Point;

import java.util.ArrayList;

public class FigureValidator {

    public static boolean isFigureValid(ArrayList<Point> points) {

        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = 1 + i; j < points.size(); j++) {
                if (points.get(i).equals(points.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

}
