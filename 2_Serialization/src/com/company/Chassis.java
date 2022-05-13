package com.company;


public class Chassis {
    transient private Wheel wheel;
    private int numberOfWheels;

    public Wheel getWheel() {
        return wheel;
    }
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    protected void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
    protected void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }


    Chassis() {
    }

    Chassis(Wheel wheel, int numberOfWheels){
        this.wheel = wheel;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "Wheel:" + '\n' + this.wheel + '\n' +
                "Number of wheels = " + this.numberOfWheels + '\n';
    }
}
