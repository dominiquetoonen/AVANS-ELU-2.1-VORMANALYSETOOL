package models;

public class Pyramid extends Shape {
    public Pyramid() {
        setType(Companion.PYRAMID.toString());
    }

    @Override
    public String getName() {
        return Companion.PYRAMID.getPrettyName();
    }

    @Override
    public String getTitle() {
        return getName() + " " + getLength() + " " + getWidth() + " " + getHeight() + "\n";
    }

    @Override
    public double calculateVolume() {
        return (getLength() * getWidth() * getHeight()) / 3;
    }
}
