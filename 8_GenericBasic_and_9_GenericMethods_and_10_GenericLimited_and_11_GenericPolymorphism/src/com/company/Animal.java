package com.company;

abstract class Animal {
    private int weight;

    public int getWeight() {
        return weight;
    }
    protected void setWeight(int weight) {
        this.weight = weight;
    }

    Animal() {
    }

    Animal(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        return weight == ((Animal) o).weight;
    }

    @Override
    public int hashCode() {
        return this.weight * 17;
    }
}
