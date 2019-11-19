package models;

public class Cube extends Shape {
    public Cube() {
        setType(Companion.CUBE.toString());
    }

    @Override
    public String getName() {
        return Companion.CUBE.getName();
    }

    @Override
    public String getTitle() {
        return getName() + " " + getLength() + " " + getWidth() + " " + getHeight() + "\n";
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }
}
