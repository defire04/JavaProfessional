package com.company;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Dispatcher {
    public static void main(String[] args) throws IOException {

        System.out.println("--------------------=== Planes ===--------------------");

        File f1 = new File("PLANES");
        List<Plane> planesList = Plane.factoryPlanes(3);
        Collections.sort(planesList);

        Controller.writeToFile(f1, planesList);
        Controller.readFile(f1);

        System.out.println("--------------------=== SHIPS ===--------------------");

        File f2 = new File("SHIPS");
        List<Ship> shipsList = new ArrayList<>();
        shipsList.add(new Ship(400.0, 2022,
                new Engine("Big", 3), 300.0, 2000.0, new Boat(23, "Wood")));
        shipsList.add(new Ship(500.0, 2009,
                new Engine("Small", 1), 400.0, 3000.0, new Boat(50, "Metal")));
        shipsList.add(new Ship(600.0, 2014,
                new Engine("Medium", 2), 500.0, 5000.0, new Boat(40, "Paper")));
        Collections.sort(shipsList);

        Controller.writeToFile(f2, shipsList);
        Controller.readFile(f2);


        System.out.println(Controller.randomYear());
    }
}
