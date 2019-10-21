package mapper;

import model.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Shapes extends AbstractMapper {

    public ArrayList<Shape> getModels() {
        ArrayList<Shape> shapes = new ArrayList<>();

        for (HashMap result : new mapper.Shapes().all()) {
            int shapeId         = Integer.parseInt(result.get("SHAPE_ID").toString());
            String shapeType    = result.get("SHAPE_TYPE").toString();
            float shapeLength   = Float.parseFloat(result.get("SHAPE_LENGTH").toString());
            float shapeWidth    = Float.parseFloat(result.get("SHAPE_WIDTH").toString());
            float shapeHeight   = Float.parseFloat(result.get("SHAPE_HEIGHT").toString());
            float shapeRadius   = Float.parseFloat(result.get("SHAPE_RADIUS").toString());

            switch (shapeType) {
                case Cube.name:
                    Cube cube = new Cube();
                    cube.setId(shapeId);
                    cube.setType(shapeType);
                    cube.setLength(shapeLength);
                    cube.setWidth(shapeWidth);
                    cube.setHeight(shapeHeight);

                    shapes.add(cube);
                    break;
                case Sphere.name:
                    Sphere sphere = new Sphere();
                    sphere.setId(shapeId);
                    sphere.setType(shapeType);
                    sphere.setRadius(shapeRadius);

                    shapes.add(sphere);
                    break;
                case Cylinder.name:
                    Cylinder cylinder = new Cylinder();
                    cylinder.setId(shapeId);
                    cylinder.setType(shapeType);
                    cylinder.setRadius(shapeRadius);
                    cylinder.setHeight(shapeHeight);

                    shapes.add(cylinder);
                    break;
            }
        }

        return shapes;
    }

    @Override
    String getTableName() {
        return "shapes";
    }
}
