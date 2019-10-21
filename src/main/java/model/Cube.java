package model;

public class Cube extends Shape {
    public static final String name = "Blok";

    private double length;
    private double width;
    private double height;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String getTitle() {
        return getType() + " " + getLength() + " " + getWidth() + " " + getHeight() + "\n";
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }
}
