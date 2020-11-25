package com.epam.jwd.task1.view;

import com.epam.jwd.task1.controller.FigureService;
import com.epam.jwd.task1.model.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final Logger logger = LogManager.getLogger(Menu.class);

    private FigureService figureService = new FigureService();
    private Scanner scanner;

    public void printMenu() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("Enter 1, 2, 3, 4 or 5");
            System.out.println("1 - information about points");
            System.out.println("2 - information about lines");
            System.out.println("3 - information about triangles");
            System.out.println("4 - information about squares");
            System.out.println("5 - exit");
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switchCase(choice);
            } catch (InputMismatchException ex) {
                System.out.println("Enter only numbers!!!");
            }
        }
    }

    public void switchCase(int choice) {
        switch (choice) {
            case 1:
                printPoints();
                break;
            case 2:
                printLines();
                break;
            case 3:
                printTriangles();
                break;
            case 4:
                printSquare();
                break;
        }
    }

    public void printPoints() {
        int flag = 0;
        do {
            figureService.initPoints();
            System.out.println(figureService.getPoints()[flag]);
            logger.info(figureService.getPoints()[flag]);
            flag++;
        } while (flag < figureService.getPoints().length);
    }

    public void printLines() {
        figureService.initPoints();
        figureService.initLines();
        for (int i = 0; i < figureService.getLines().length; i++) {
            if (validateLine(figureService.getLines()[i])) {
                System.out.println(figureService.getLines()[i]);
                logger.info(figureService.getLines()[i]);
            } else {
                System.out.println("Line " + figureService.getLines()[i] + " isn't figure");
                logger.error("Line " + figureService.getLines()[i] + " isn't figure");
            }
        }
    }

    public void printTriangles(){
        figureService.initPoints();
        figureService.initTriangles();
        for (int i = 0; i < figureService.getTriangles().length; i++) {
            if (figureService.getTriangles()[i].getPoint1() == figureService.getTriangles()[i].getPoint2() |
                    figureService.getTriangles()[i].getPoint1() == figureService.getTriangles()[i].getPoint3() |
                    figureService.getTriangles()[i].getPoint2() == figureService.getTriangles()[i].getPoint3()) {
                System.out.println("Triangle " + figureService.getTriangles()[i] + " isn't figure");
                logger.error("Triangle " + figureService.getTriangles()[i] + " isn't figure");
            } else if (figureService.getTriangles()[i].getPoint1().getX() + figureService.getTriangles()[i].getPoint2().getX() < figureService.getTriangles()[i].getPoint3().getX() |
                    (figureService.getTriangles()[i].getPoint1().getY() + figureService.getTriangles()[i].getPoint2().getY()) < figureService.getTriangles()[i].getPoint3().getY() |
                    (figureService.getTriangles()[i].getPoint1().getX() + figureService.getTriangles()[i].getPoint3().getX()) < figureService.getTriangles()[i].getPoint2().getX() |
                    (figureService.getTriangles()[i].getPoint1().getY() + figureService.getTriangles()[i].getPoint3().getY()) < figureService.getTriangles()[i].getPoint2().getY() |
                    (figureService.getTriangles()[i].getPoint2().getX() + figureService.getTriangles()[i].getPoint3().getX()) < figureService.getTriangles()[i].getPoint1().getX() |
                    (figureService.getTriangles()[i].getPoint2().getY() + figureService.getTriangles()[i].getPoint3().getY()) < figureService.getTriangles()[i].getPoint1().getY()) {
                System.out.println("Triangle " + figureService.getTriangles()[i] + " isn't figure");
                logger.error("Triangle " + figureService.getTriangles()[i] + " isn't figure");
            } else {
                System.out.println(figureService.getTriangles()[i]);
                logger.info(figureService.getTriangles()[i]);
            }
        }
    }

    public void printSquare(){
        figureService.initPoints();
        figureService.initSquare();
        for(int i = 0; i < figureService.getSquares().length; i++){
            if (figureService.getSquares()[i].getPoint1() == figureService.getSquares()[i].getPoint2() |
                    figureService.getSquares()[i].getPoint1() == figureService.getSquares()[i].getPoint3() |
                    figureService.getSquares()[i].getPoint1() == figureService.getSquares()[i].getPoint4() |
                    figureService.getSquares()[i].getPoint1() == figureService.getSquares()[i].getPoint2() |
                    figureService.getSquares()[i].getPoint2() == figureService.getSquares()[i].getPoint3() |
                    figureService.getSquares()[i].getPoint2() == figureService.getSquares()[i].getPoint4() |
                    figureService.getSquares()[i].getPoint3() == figureService.getSquares()[i].getPoint4()) {
                System.out.println("Square " + figureService.getTriangles()[i] + " isn't figure");
            }else{
                System.out.println(figureService.getSquares()[i]);
            }
        }
    }
    public boolean validateLine(Line line) {
        if (line.getPoint1() == line.getPoint2()) {
            return false;
        }
        return true;
    }
}
