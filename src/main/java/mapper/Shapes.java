package mapper;

import model.Cube;
import model.Cylinder;
import model.Shape;
import model.Sphere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Shapes extends AbstractMapper {

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

                switch (shapeType) {
                    case Cube.name:
                        Cube cube = new Cube();
                        cube.setId(shapeId);
                        cube.setType(shapeType);
                        cube.setLength(shapeLength);
                        cube.setWidth(shapeWidth);
                        cube.setHeight(shapeHeight);

                        results.add(cube);
                        break;
                    case Sphere.name:
                        Sphere sphere = new Sphere();
                        sphere.setId(shapeId);
                        sphere.setType(shapeType);
                        sphere.setRadius(shapeRadius);

                        results.add(sphere);
                        break;
                    case Cylinder.name:
                        Cylinder cylinder = new Cylinder();
                        cylinder.setId(shapeId);
                        cylinder.setType(shapeType);
                        cylinder.setRadius(shapeRadius);
                        cylinder.setHeight(shapeHeight);

                        results.add(cylinder);
                        break;
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public boolean saveCube(Cube cube) {
        try {
            connect();
            int createdRows = stmt.executeUpdate(
                    "INSERT INTO " + getTableName() + " (SHAPE_TYPE, SHAPE_LENGTH, SHAPE_WIDTH, SHAPE_HEIGHT)" + " VALUES ('" + cube.getType() + "', " + cube.getLength() + ", " + cube.getWidth() + ", " + cube.getHeight() + ")"
            );

            return createdRows > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveSphere(Sphere sphere) {
        try {
            connect();
            int createdRows = stmt.executeUpdate(
                    "INSERT INTO " + getTableName() + " (SHAPE_TYPE, SHAPE_RADIUS)" + "VALUES ('" + sphere.getType() + "', " + sphere.getRadius() + ")"
            );

            return createdRows > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveCylinder(Cylinder cylinder) {
        try {
            connect();
            int createdRows = stmt.executeUpdate(
                    "INSERT INTO " + getTableName() + " (SHAPE_TYPE, SHAPE_HEIGHT, SHAPE_RADIUS)" + "VALUES ('" + cylinder.getType() + "', " + cylinder.getHeight() + ", " + cylinder.getRadius() + ")"
            );

            return createdRows > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    String getTableName() {
        return "shapes";
    }
}
