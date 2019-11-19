package mappers;

import models.Cube;
import models.Shape;
import models.Sphere;
import models.Cylinder;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import static models.Shape.Companion.CUBE;

public class Shapes extends AbstractMapper {
    @Override
    String getTableName() {
        return "shapes";
    }

    public Shape findById(int id) {
        for (Shape s : all()) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public ArrayList<Shape> all() {
        ArrayList<Shape> results = new ArrayList<>();

        try {
            connect();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());

            while (resultSet.next()) {
                int shapeId = resultSet.getInt("SHAPE_ID");
                String shapeType = resultSet.getString("SHAPE_TYPE");
                double shapeLength = resultSet.getDouble("SHAPE_LENGTH");
                double shapeWidth = resultSet.getDouble("SHAPE_WIDTH");
                double shapeHeight = resultSet.getDouble("SHAPE_HEIGHT");
                double shapeRadius = resultSet.getDouble("SHAPE_RADIUS");

                switch (Shape.Companion.valueOf(shapeType)) {
                    case CUBE:
                        Cube cube = new Cube();
                        cube.setId(shapeId);
                        cube.setType(shapeType);
                        cube.setLength(shapeLength);
                        cube.setWidth(shapeWidth);
                        cube.setHeight(shapeHeight);

                        results.add(cube);
                        break;

                    case SPHERE:
                        Sphere sphere = new Sphere();
                        sphere.setId(shapeId);
                        sphere.setType(shapeType);
                        sphere.setRadius(shapeRadius);

                        results.add(sphere);
                        break;

                    case CYLINDER:
                        Cylinder cylinder = new Cylinder();
                        cylinder.setId(shapeId);
                        cylinder.setType(shapeType);
                        cylinder.setRadius(shapeRadius);
                        cylinder.setHeight(shapeHeight);

                        results.add(cylinder);
                        break;
                }
            }

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public boolean save(Shape shape) {
        try {
            connect();
            int createdRows = stmt.executeUpdate("INSERT INTO " + getTableName() + " (SHAPE_TYPE, SHAPE_LENGTH, SHAPE_WIDTH, SHAPE_HEIGHT, SHAPE_RADIUS)" + " VALUES ('" + shape.getType() + "', " + shape.getLength() + ", " + shape.getWidth() + ", " + shape.getHeight() + ", " + shape.getRadius() + ")");

            closeConnection();

            return createdRows > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
