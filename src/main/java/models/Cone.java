package models;

public class Cone extends Shape {
    public Cone() {
        setType(Companion.CONE.toString());
    }

    @Override
    public String getName() {
        return Companion.CONE.getPrettyName();
    }

    @Override
    public String getTitle() {
        return getName() + " " + getRadius() + " " + getHeight() + "\n";
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * (getRadius() * getRadius()) * getHeight();
    }
}
