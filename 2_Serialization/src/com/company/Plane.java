package com.company;

import java.io.*;
import java.util.ArrayList;

public class Plane extends Vehicle implements Serializable {

    private String model;
    private int flightRange;
    transient private Chassis chassis;

    public String getModel() {
        return model;
    }
    public int getFlightRange() {
        return flightRange;
    }
    public Chassis getChassis() {
        return chassis;
    }

    protected void setModel(String model) {
        this.model = model;
    }
    protected void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }
    protected void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    Plane() {
    }


    Plane(double speed, int yearOfProduction, Engine engine, String model, int flightRange, Chassis chassis) {
        super(speed, yearOfProduction, engine);
        this.model = model;
        this.flightRange = flightRange;
        this.chassis = chassis;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Model = " + this.model + '\n' +
                "Flight range = " + this.flightRange + '\n' +
                "Chassis: " + '\n' + this.chassis + '\n';
    }


    @Serial
    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            os.writeDouble(getSpeed());
            os.writeInt(getYearOfProduction());
            os.writeObject(getEngine().getType());
            os.writeDouble(getEngine().getPower());
            os.writeInt(chassis.getWheel().getPower());
            os.writeDouble(chassis.getWheel().getDiameter());
            os.writeInt(chassis.getNumberOfWheels());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream is) {
        try {
            is.defaultReadObject();
            setSpeed(is.readDouble());
            setYearOfProduction(is.readInt());
            setEngine(new Engine((String) is.readObject(), is.readDouble()));

            this.chassis = new Chassis(new Wheel(is.readInt(), is.readDouble()), is.readInt());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e + " ");
        }
    }

    public static ArrayList<Plane> factoryPlanes(int number) {
        ArrayList<Plane> planeArrayList = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            planeArrayList.add(new Plane(Controller.randomSpeed(), Controller.randomYear(), new Engine("gasolines", Controller.randomPower()),
                    Controller.randomAircraftModel(), Controller.randomFlightRange(), new Chassis(new Wheel(200, 70), 20)));
        }
        return planeArrayList;
    }
}
