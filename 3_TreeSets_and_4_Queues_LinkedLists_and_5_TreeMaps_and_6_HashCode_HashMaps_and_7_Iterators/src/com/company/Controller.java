package com.company;

import java.io.*;
import java.util.*;


class Controller {
    static void createGraph(List<Point> pointsList) { // Рисует точки в консоле
        System.out.println("------------------ Graph ------------------");
        int maxHeight = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (Point point : pointsList) {
            maxHeight = Math.max(point.getY(), maxHeight);
            maxLength = Math.max(point.getX(), maxLength);
        }

        String[][] graph = new String[maxHeight][maxLength];
        for (Point tempPoint : pointsList) {
            graph[tempPoint.getY() - 1][tempPoint.getX() - 1] = tempPoint.getName();
        }

        for (int i = graph.length - 1; i >= 0; i--) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print((graph[i][j] != null ? graph[i][j] + " " : "*" + " "));
            }
            System.out.println();
        }
        for (int i = 0; i <= graph[1].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    static TreeSet<Line> createLines(List<Point> pointList){
        TreeSet<Line> allLines = new TreeSet<>();
        pointList.forEach(point -> {
            pointList.forEach(point2 -> {
                if(!point.equals(point2)){
                    allLines.add(new Line(point, point2));
                }
            });
        });
        return allLines;
    }

    static void numberOfLinesThroughPoint(List<Point> pointList,HashMap<Point, Integer> resultHashMapForPoints ) {
        System.out.println("------------------ Points ------------------");

        TreeSet<Line> allLines = createLines(pointList);

        pointList.forEach(point -> {
//            AtomicInteger count = new AtomicInteger();
            allLines.forEach(line -> {
                if (point.isLinesThroughPoint(line)) {
//                    resultHashMapForPoints.put(point, Integer.toString(count.incrementAndGet())); // Если HashMap value = String
                    resultHashMapForPoints.compute(point, (key, numberOfLines)-> numberOfLines == null ? 1 : ++numberOfLines);
                }
            });
            System.out.println(point.getName() + "(" + point.getX() + "," + point.getY() + ")" +
                    " The number of line that cross : " + resultHashMapForPoints.get(point));
        });
    }


    static void numberOfPointsOnLine(List<Point> pointList, HashMap<Line, Integer> resultHashMapForLines) {
        System.out.println("------------------ Lines ------------------");

        TreeSet<Line> allLines = createLines(pointList);

        allLines.forEach(line -> {
            TreeSet<String> namesPoint = new TreeSet<>();
            pointList.forEach(point -> {
                if (line.isPointOnLine(point)) {
                    namesPoint.add(point.getName());

                }
            });
            resultHashMapForLines.put(line, namesPoint.size());
            System.out.println("Points on line " + line + ": " + namesPoint +
                    "\nCount of points that cross line : " + resultHashMapForLines.get(line) + "\n" +
                    "            - - - - - - - - ");
        });
    }


    static void writeToFile(File fileName, List<HashMap<? extends GeometricComponents, ?>> whatWriteToFile) {
        System.out.println(" ------------------ WriteFile ------------------");

        try (ObjectOutputStream input = new ObjectOutputStream(new FileOutputStream(fileName))){
            try {
                for (HashMap<?, ?> info : whatWriteToFile) {
                    input.writeObject(info);
                }
                System.out.println("Recorded successfully!");
            } finally {
                input.flush();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }


    static void readFile(File fileName) {
        System.out.println(" ------------------ ReadFile ------------------");
        try (ObjectInputStream output = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    System.out.println(output.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Read successfully!");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Second solution
    static void linesForPointAndNumberOfPointsOnLine(List<Point> listOfPoints, HashMap<Point, String> mapForPoints, HashMap<Line, String> mapForNumberOfPointsThatCrossLine) {

        createGraph(listOfPoints);

        System.out.println("------------------ Points ------------------");
        HashMap<Line, TreeSet<String>> mapForPointNamesThatCrossLine = new HashMap<>();
        TreeSet<Line> lineTreeSet;

        for (Point tempPoint1 : listOfPoints) {
            lineTreeSet = new TreeSet<>();
            for (Point tempPoint2 : listOfPoints) {
                if (tempPoint1.equals(tempPoint2)) {
                    continue;
                }
                Line tempLine = new Line(tempPoint1, tempPoint2);
                lineTreeSet.add(tempLine);
                mapForPointNamesThatCrossLine.put(tempLine, new TreeSet<>());
                mapForNumberOfPointsThatCrossLine.put(tempLine, "");
            }
            mapForPoints.put(tempPoint1, Integer.toString(lineTreeSet.size()));

            System.out.println(tempPoint1.getName() + "(" + tempPoint1.getX() + "," + tempPoint1.getY() + ")" +
                    " The number of line that cross : " + lineTreeSet.size());
        }

        System.out.println("------------------ Lines ------------------");
        for (Point tempPoint1 : listOfPoints) {
            for (Point tempPoint2 : listOfPoints) {
                if (tempPoint1.equals(tempPoint2)) {
                    continue;
                }
                Line tempLine = new Line(tempPoint1, tempPoint2);
                mapForPointNamesThatCrossLine.get(tempLine).add(tempPoint1.getName());
                mapForNumberOfPointsThatCrossLine.put(tempLine, Integer.toString(mapForPointNamesThatCrossLine.get(tempLine).size()));
            }
        }
        for (Line tempLine : mapForPointNamesThatCrossLine.keySet()) {
            System.out.println("Points on line " + tempLine + ": " + mapForPointNamesThatCrossLine.get(tempLine) +
                    "\nCount of points that cross line : " + mapForNumberOfPointsThatCrossLine.get(tempLine) + "\n" +
                    "            - - - - - - - - ");
        }
    }
}