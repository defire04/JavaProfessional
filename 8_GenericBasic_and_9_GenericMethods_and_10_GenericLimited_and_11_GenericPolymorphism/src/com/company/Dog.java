package com.company;

class Dog extends Animal{
    Dog(int weight){
        super(weight);
    }

    @Override
    public String toString() {
        return "Dog with weight: " + this.getWeight();
    }
}

class Poodle extends Dog{

    Poodle(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Poodle with weight: " + this.getWeight();
    }
}