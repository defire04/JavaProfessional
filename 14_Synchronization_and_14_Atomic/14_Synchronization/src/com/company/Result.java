package com.company;

class Result {
    double result;

    synchronized void add(double d) {
        result += d;
    }

    @Override
    public String toString() {
        return "Result = " + this.result;
    }
}