package com.company;


public class Wheel  {
    private int power;
    private double diameter;

    public int getPower() {
        return power;
    }
    public double getDiameter() {
        return diameter;
    }

    protected void setPower(int power) {
        this.power = power;
    }
    protected void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    Wheel(){}

    Wheel(int power, double diameter){
        this.power = power;
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Power = " + power + "\n" +
                "Diameter = " + diameter;
    }
}
