package models;

public class Cylinder extends Shape {
    public static final String name = "Cilinder";

    private double radius;
    private double height;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String getTitle() {
        return getType() + " " + getRadius() + " " + getHeight() + "\n";
    }

    @Override
    public double calculateVolume() {
        return Math.PI * (getRadius() * getRadius()) * getHeight();
    }
}
