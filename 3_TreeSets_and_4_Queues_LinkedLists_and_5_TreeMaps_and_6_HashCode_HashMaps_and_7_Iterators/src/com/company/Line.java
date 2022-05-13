package com.company;

import java.util.List;
import java.util.TreeSet;
import java.io.Serializable;
import java.text.DecimalFormat;

class Line implements GeometricComponents, Serializable, Comparable<Line> {
    private double k;
    private double b;
    private String name;

    public double getK() {
        return k;
    }
    public double getB() {
        return b;
    }
    public String getName() {
        return name;
    }

    protected void setK(double k) {
        this.k = k;
    }
    protected void setB(double b) {
        this.b = b;
    }
    protected void setName(String name) {
        this.name = name;
    }


    Line() {
    }


    Line(Point dot1, Point dot2) {
        if (dot1.getX() == dot2.getX()) {
            this.k = 0;
            this.b = dot1.getY();
        } else if (dot1.getY() == dot2.getY()) {
            this.k = 0;
            this.b = dot1.getY();
        } else {
            this.k = -((double) (dot2.getY() - dot1.getY()) / (double) (dot1.getX() - dot2.getX()));
            this.b = -((double) (dot2.getX() * dot1.getY() - dot1.getX() * dot2.getY()) / (double) (dot1.getX() - dot2.getX()));

            if(this.k == 0){
                k = 0;
            }
            if(this.b == 0){
                b = 0;
            }
        }
        this.name = dot1.getName() + dot2.getName();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Double.compare(line.k, this.k) == 0 && Double.compare(line.b, this.b) == 0;
    }


    @Override
    public int hashCode() {
        return (int) (19 * this.k + 17 * this.b);
    }


    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return this.name + " (K=" + decimalFormat.format(this.k) + " B=" + decimalFormat.format(this.b) + ")";
    }


    @Override
    public int compareTo(Line o) {
        int result = Double.compare(this.k, o.k);
        if (result == 0) {
            result = Double.compare(this.b, o.b);
        }
        return result;
    }

    protected boolean isPointOnLine(Point point) {
        return point.getY() == (this.k * point.getX() + this.b);
    }
}
