package com.company;

import java.io.Serializable;

class Point implements GeometricComponents, Serializable, Comparable<Point> {
    private int x;
    private int y;
    private String name;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getName() {
        return name;
    }

    protected void setX(int x) {
        this.x = x;
    }
    protected void setY(int y) {
        this.y = y;
    }
    protected void setName(String name) {
        this.name = name;
    }

    Point() {
    }

    Point(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return this.x == point.x && this.y == point.y;
    }


    @Override
    public int hashCode() {
        return 17 * this.x + 13 * this.y;
    }


    @Override
    public String toString() {
        return "Point:" + this.name +"(" + this.x + "," + this.y + ")";
    }


    @Override
    public int compareTo(Point o) {
        int result = this.x - o.x;
        if (result == 0) {
            result = this.y - o.y;
            if (result == 0) {
                result = this.name.compareTo(o.name);
            }
        }
        return result;
    }


    protected boolean isLinesThroughPoint(Line line) {
        return this.y == (line.getK() * this.x + line.getB());
    }
}


