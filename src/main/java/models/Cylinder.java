package models;

public class Cylinder extends Shape {
    public Cylinder() {
        setType(Companion.CYLINDER.toString());
    }

    @Override
    public String getName() {
        return Companion.CYLINDER.getName();
    }

    @Override
    public String getTitle() {
        return getName() + " " + getRadius() + " " + getHeight() + "\n";
    }

    @Override
    public double calculateVolume() {
        return Math.PI * (getRadius() * getRadius()) * getHeight();
    }
}
