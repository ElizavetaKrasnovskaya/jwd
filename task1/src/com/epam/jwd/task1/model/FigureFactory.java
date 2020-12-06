package com.epam.jwd.task1.model;

public class FigureFactory {


    private static final FigurePreProcessor figurePreProcessor = new FigureExistencePreProcessor();
    private static final FigurePostProcessor figurePostProcessor = new FigureExistencePostProcessor();

    public Figure createFigure(String type, Point[] points) throws FigureException {

        figurePreProcessor.process(points);
        Figure figure;
        switch (type) {
            case "Triangle":
                figure = new Triangle();
                break;
            case "Square":
                figure = new Square();
                break;
            case "MultiAngle":
                figure = new MultiAngle();
                break;
            default:
                throw new FigureException("This type is not exists");
        }
        figure = figurePostProcessor.process(figure);
        return figure;
    }
}
