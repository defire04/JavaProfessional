package com.company;


import java.io.*;
import java.util.List;

public class Controller {
    static  void writeToFile(File fileName, List<? extends Vehicle> whatWriteToFile) throws IOException {
        System.out.println(" ------------------ WriteFile ------------------");
        ObjectOutputStream input = null;
        try {
            input = new ObjectOutputStream(new FileOutputStream(fileName));
            for (Vehicle info : whatWriteToFile) {
                input.writeObject(info);
            }
            System.out.println("Recorded successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            assert input != null;
            input.flush();
            input.close();
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


    static double randomSpeed() {
        double max = 1020;
        double min = 200;
        max -= min;
        return (Math.random() * ++max) + min;
    }

    static int randomYear() {
        double max = 2020;
        double min = 1995;
        max -= min;
        return (int) ((Math.random() * ++max) + min);
    }

    static double randomPower() {
        double max = 3.5;
        double min = 1.8;
        max -= min;
        return (Math.random() * ++max) + min;
    }

    static String randomAircraftModel() {
        double max = 5;
        double min = 0;
        max -= min;

        String[] models = {"1/139 Boeing 707-120", "1/72 DC-8 / 50 Lufthansa", "1/72 DC-8 / 50 UAL", "1/72 DC-8 / 50 DAL", "1/144 Airbus A350-900",
                "1/200 (snap) Aeroflot P.Tchaikovsky Vq-Bfy"};

        return models[(int) ((Math.random() * ++max) + min)];
    }

    static int randomFlightRange() {
        double max = 11000;
        double min = 6000;
        max -= min;
        return (int) ((Math.random() * ++max) + min);
    }
}
