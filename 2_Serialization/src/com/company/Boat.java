package com.company;

public class Boat {
    private int numberOfPeople;
    private String material;

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    public String getMaterial() {
        return material;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
    protected void setMaterial(String material) {
        this.material = material;
    }

    Boat(){}

    Boat(int numberOfPeople, String material){
        this.numberOfPeople = numberOfPeople;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Number of people = " + this.numberOfPeople + '\n' +
                "Material = " + this.material;
    }
}
