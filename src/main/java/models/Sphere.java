package models;

public class Sphere extends Shape {
    public Sphere() {
        setType(Companion.SPHERE.toString());
    }

    @Override
    public String getName() {
        return Companion.SPHERE.getPrettyName();
    }

    @Override
    public String getTitle() {
        return getName() + " " + getRadius() + "\n";
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(getRadius(), 3);
    }
}
