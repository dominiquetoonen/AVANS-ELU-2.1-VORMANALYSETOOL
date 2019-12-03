package models;

import java.util.ArrayList;

abstract public class Shape {
    public enum Companion {
        CUBE("Blok"),
        CYLINDER("Cylinder"),
        SPHERE("Bol"),
        CONE("Kegel"),
        PYRAMID("Pyramide");

        private final String prettyName;

        Companion(String prettyName) {
            this.prettyName = prettyName;
        }

        public String getPrettyName() {
            return prettyName;
        }

        public static ArrayList<String> getPrettyNames() {
            ArrayList<String> names = new ArrayList<>();
            for (Companion value : Companion.values()) {
                names.add(value.getPrettyName());
            }

            return names;
        }
    }

    private int id;
    private String type;
    private double length;
    private double width;
    private double height;
    private double radius;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return getId() + " - " + getTitle();
    }

    abstract public String getName();
    abstract public String getTitle();
    abstract public double calculateVolume();
}
