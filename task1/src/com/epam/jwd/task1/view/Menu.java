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
        while (choice != 12) {
            System.out.println("Enter: ");
            System.out.println("1 - information about points");
            System.out.println("2 - information about lines");
            System.out.println("3 - information about triangles");
            System.out.println("4 - information about squares");
            System.out.println("5 - information about multi angle");
            System.out.println("6 - find perimeter of triangle");
            System.out.println("7 - find area of triangle");
            System.out.println("8 - find perimeter of square");
            System.out.println("9 - find area of square");
            System.out.println("10 - find perimeter of multi angle");
            System.out.println("11 - find area of multi angle");
            System.out.println("12 - exit");
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
            case 5:
                printMultiAngle();
                break;
            case 6:
                printPerimeterOfTriangle();
                break;
            case 7:
                printAreaOfTriangle();
                break;
            case 8:
                printPerimeterOfSquare();
                break;
            case 9:
                printAreaOfSquare();
                break;
            case 10:
                printPerimeterOfMultiAngle();
                break;
            case 11:
                printAreaOfMultiAngle();
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
        for (int i = 0; i < figureService.getLines().length; i++) {
            if (figureService.getLines()[i].validateLine()) {
                System.out.println(figureService.getLines()[i]);
                logger.info(figureService.getLines()[i]);
            } else {
                System.out.println("Line " + figureService.getLines()[i] + " isn't figure");
                logger.error("Line " + figureService.getLines()[i] + " isn't figure");
            }
        }
    }

    public void printTriangles(){
        for (int i = 0; i < figureService.getTriangles().length; i++) {
            if (figureService.getTriangles()[i].validate()) {
                System.out.println(figureService.getTriangles()[i]);
                logger.info(figureService.getTriangles()[i]);

            } else{
                System.out.println("Triangle " + figureService.getTriangles()[i] + " isn't figure");
                logger.error("Triangle " + figureService.getTriangles()[i] + " isn't figure");
            }
        }
    }

    public void printSquare(){
        for(int i = 0; i < figureService.getSquares().length; i++){
            if (figureService.getSquares()[i].validate()) {
                System.out.println(figureService.getSquares()[i]);
                logger.info(figureService.getSquares()[i]);
            }else{
                System.out.println("Square " + figureService.getSquares()[i] + " isn't figure");
                logger.error("Square " + figureService.getSquares()[i] + " isn't figure");
            }
        }
    }

    public void printMultiAngle(){
        for(int i=0; i<figureService.getMultiAngles().length; i++){
            if(figureService.getMultiAngles()[i].validate()){
                System.out.println(figureService.getMultiAngles()[i]);
                logger.info(figureService.getMultiAngles());
            }else{
                System.out.println("Multi angel " + figureService.getMultiAngles()[i] + " isn't figure");
                logger.error("Multi angel " + figureService.getMultiAngles()[i] + " isn't figure");
            }
        }
    }

    public void printPerimeterOfTriangle() {
        for (int i = 0; i < figureService.getTriangles().length; i++) {
            if (figureService.getTriangles()[i].validate()) {
                System.out.println(figureService.getTriangles()[i].calculatePerimeter());
                logger.info(figureService.getTriangles()[i].calculatePerimeter());
            }else{
                System.out.println("Sorry it isn't triangle(((");
                logger.error("Sorry it isn't triangle(((");
            }
        }
    }

    public void printAreaOfTriangle() {
        for (int i = 0; i < figureService.getTriangles().length; i++) {
            if (figureService.getTriangles()[i].validate()) {
                System.out.println(figureService.getTriangles()[i].calculateArea());
                logger.info(figureService.getTriangles()[i].calculateArea());
            }else{
                System.out.println("Sorry it isn't triangle(((");
                logger.error("Sorry it isn't triangle(((");
            }
        }
    }

    public void printPerimeterOfSquare(){
        for(int i=0; i<figureService.getSquares().length; i++){
            if(figureService.getSquares()[i].validate()){
                System.out.println(figureService.getSquares()[i].calculateArea());
                logger.info(figureService.getSquares()[i].calculateArea());
            }else{
                System.out.println("Sorry it isn't square");
                logger.error("Sorry it isn't square");
            }
        }
    }

    public void printAreaOfSquare(){
        for(int i = 0; i<figureService.getSquares().length; i++){
            if(figureService.getSquares()[i].validate()){
                System.out.println(figureService.getSquares()[i].calculateArea());
                logger.info(figureService.getSquares()[i].calculateArea());
            }else{
                System.out.println("Sorry it isn't square");
                logger.error("Sorry it isn't square");
            }
        }
    }

    public void printPerimeterOfMultiAngle(){
        for(int i=0; i<figureService.getMultiAngles().length; i++){
            if(figureService.getMultiAngles()[i].validate()){
                System.out.println(figureService.getMultiAngles()[i].calculatePerimeter());
                logger.info(figureService.getMultiAngles()[i].calculatePerimeter());
            }else{
                System.out.println("Sorry it isn't multi angle");
                logger.error("Sorry it isn't multi angle");
            }
        }
    }

    public void printAreaOfMultiAngle(){
        for(int i=0; i<figureService.getMultiAngles().length; i++){
            if(figureService.getMultiAngles()[i].validate()){
                System.out.println(figureService.getMultiAngles()[i].calculateArea());
                logger.info(figureService.getMultiAngles()[i].calculateArea());
            }else{
                System.out.println("Sorry it isn't multi angle");
                logger.error("Sorry it isn't multi angle");
            }
        }
    }
}
