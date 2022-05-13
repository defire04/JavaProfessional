package com.company;


public class Engine {

    private String type;
    private double power;

    public String getType() {
        return type;
    }
    public double getPower() {
        return power;
    }

    protected void setType(String type) {
        this.type = type;
    }
    protected void setPower(double power) {
        this.power = power;
    }

    Engine(){}

    Engine(String type, double power){
        this.type = type;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Type = " + this.type + '\n' +
               "Power = " + this.power + '\n';
    }
}
