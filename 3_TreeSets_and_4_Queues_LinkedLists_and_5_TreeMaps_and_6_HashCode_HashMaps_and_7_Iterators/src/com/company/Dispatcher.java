package com.company;

import java.io.*;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Dispatcher {
    public static void main(String[] args) {

        HashMap<Point, Integer> mapForPoints = new HashMap<>();
        HashMap<Line, Integer> mapForLines = new HashMap<>();
        File file = new File("LINES");

        List<Point> listOfPoints = new ArrayList<>();
        listOfPoints.add(new Point(1, 3, "A"));
        listOfPoints.add(new Point(3, 3, "B"));
        listOfPoints.add(new Point(4, 1, "C"));
        listOfPoints.add(new Point(4, 2, "D"));
        listOfPoints.add(new Point(6, 3, "E"));


        Controller.createGraph(listOfPoints);
        Controller.numberOfLinesThroughPoint(listOfPoints, mapForPoints);
        Controller.numberOfPointsOnLine(listOfPoints, mapForLines);


        // Write to file
//        List<HashMap<? extends GeometricComponents, ?>> whatWriteToFile = new ArrayList<>();
//        whatWriteToFile.add(mapForPoints);
//        whatWriteToFile.add(mapForLines);
//
//        Controller.writeToFile(file, whatWriteToFile);
//
//        // Read from file
//        Controller.readFile(file);
    }
}
