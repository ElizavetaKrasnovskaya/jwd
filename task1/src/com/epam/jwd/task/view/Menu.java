package com.epam.jwd.task.view;

import com.epam.jwd.task.logic.LineLogic;
import com.epam.jwd.task.logic.MultiAngleLogic;
import com.epam.jwd.task.logic.PointLogic;
import com.epam.jwd.task.logic.SquareLogic;
import com.epam.jwd.task.logic.TriangleLogic;
import com.epam.jwd.task.model.impl.Figure;
import com.epam.jwd.task.model.impl.Line;
import com.epam.jwd.task.model.impl.MultiAngle;
import com.epam.jwd.task.model.impl.Point;
import com.epam.jwd.task.model.impl.Square;
import com.epam.jwd.task.model.impl.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final Logger logger = LogManager.getLogger(Menu.class);

    private static Scanner scanner;

    public static void printMenu() {
        int choice = 0;
        while (choice != 6) {
            System.out.println("Enter: ");
            System.out.println("1 - information about points");
            System.out.println("2 - information about lines");
            System.out.println("3 - information about triangles");
            System.out.println("4 - information about squares");
            System.out.println("5 - information about multi angle");
            System.out.println("6 - exit");
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switchCase(choice);
            } catch (InputMismatchException ex) {
                System.out.println("Enter only numbers!!!");
            }
        }
    }

    public static void switchCase(int choice) {
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
            case 5:
                printMultiAngle();
                break;
            default:
                System.out.println("No case");
        }
    }

    public static void printPoints() {
        ArrayList<Point> points = PointLogic.initPoints();
        for (Point point : points) {
            System.out.println(point);
        }
    }

    public static void printLines() {
        ArrayList<Line> lines = LineLogic.initLines();
        for (Line line : lines) {
            System.out.println(line);
        }
    }

    public static void printTriangles() {
        ArrayList<Triangle> triangles = TriangleLogic.initTriangles();
        for (Figure triangle : triangles) {
            System.out.println(triangle);
        }
    }

    public static void printSquare() {
        ArrayList<Square> squares = SquareLogic.initSquare();
        for (Square square : squares) {
            System.out.println(square);
        }
    }

    public static void printMultiAngle() {
        ArrayList<MultiAngle> multiAngles = MultiAngleLogic.initMultiAngels();
        for (MultiAngle multiAngle : multiAngles) {
            System.out.println(multiAngle);
        }
    }

}
