package model;

public class Sphere extends Shape {
    public static final String name = "Bol";

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String getTitle() {
        return getType() + " " + getRadius() + "\n";
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(getRadius(), 3);
    }
}
