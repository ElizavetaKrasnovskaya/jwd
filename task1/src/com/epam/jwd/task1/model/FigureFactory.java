package com.epam.jwd.task1.model;

public class FigureFactory {

    public Figure createFigure(String type) {
        Figure figure = null;
        switch (type) {
            case "Triangle":
                figure = new Triangle();
                break;
            case "Square":
                figure = new Square();
                break;
            case "MultiAngle":
                figure = new MultiAngle();
        }
        return figure;
    }

}
