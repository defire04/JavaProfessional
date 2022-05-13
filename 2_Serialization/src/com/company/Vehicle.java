package com.company;

public class Vehicle implements Comparable<Vehicle> {

    private double speed;
    private int yearOfProduction;
    transient private Engine engine;

    public double getSpeed() {
        return speed;
    }
    public int getYearOfProduction() {
        return yearOfProduction;
    }
    public Engine getEngine() {
        return engine;
    }

    protected void setSpeed(double speed) {
        this.speed = speed;
    }
    protected void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
    protected void setEngine(Engine engine) {
        this.engine = engine;
    }


    Vehicle(){}

    Vehicle(double speed, int yearOfProduction, Engine engine) {
        this.speed = speed;
        this.yearOfProduction = yearOfProduction;
        this.engine = engine;
    }


    @Override
    public String toString() {
        return  "\nSpeed = " + this.speed + "\n" +
                "Year of production = " + this.yearOfProduction + "\n" +
                "Engine : " + '\n'+ this.engine ;
    }


    @Override
    public int compareTo(Vehicle o) {
        return this.yearOfProduction - o.yearOfProduction;
    }
}
