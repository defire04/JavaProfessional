package com.company;

import java.io.*;

public class Ship extends Vehicle implements Externalizable {

    private double displacement;
    private double length;
    transient private Boat boat;

    public double getDisplacement() {
        return displacement;
    }
    public double getLength() {
        return length;
    }
    public Boat getBoat() {
        return boat;
    }

    protected void setDisplacement(double displacement) {
        this.displacement = displacement;
    }
    protected void setLength(double length) {
        this.length = length;
    }
    protected void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Ship(){}

    Ship(double speed, int yearOfProduction, Engine engine, double displacement, double length, Boat boat){
        super(speed, yearOfProduction, engine);
        this.displacement = displacement;
        this.length = length;
        this.boat = boat;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Displacement = " + this.displacement + '\n' +
                "Length = " + this.length + '\n' +
                "Boat: " + '\n' + this.boat + '\n' ;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.getSpeed());
        out.writeInt(this.getYearOfProduction());
        out.writeObject(this.getEngine().getType());
        out.writeDouble(this.getEngine().getPower());

        out.writeDouble(this.displacement);
        out.writeDouble(this.length);
        out.writeInt(this.boat.getNumberOfPeople());
        out.writeObject(this.boat.getMaterial());

    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        setSpeed(in.readDouble());
        setYearOfProduction(in.readInt());
        setEngine(new Engine((String) in.readObject(), in.readDouble()));

        this.displacement = in.readDouble();
        this.length = in.readDouble();
        this.boat = new Boat(in.readInt(),(String)in.readObject());
    }
}
