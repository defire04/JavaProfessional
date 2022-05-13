package com.company;

class Cat extends Animal {
    Cat(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Cat with weight: " + this.getWeight();
    }
}
