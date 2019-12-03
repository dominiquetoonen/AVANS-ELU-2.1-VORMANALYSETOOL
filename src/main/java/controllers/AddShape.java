package controllers;

import java.awt.*;
import models.Shape;
import javax.swing.*;
import java.util.Objects;
import views.AddShapeFrame;
import views.panels.*;

public class AddShape {
    public AddShape(JComboBox jComboBox) {
        String selectedShape = Objects.requireNonNull(jComboBox.getSelectedItem()).toString();
        AddShapeFrame frame = new AddShapeFrame(selectedShape);

        if (selectedShape.equals(Shape.Companion.CUBE.getPrettyName())) {
            frame.setSize(new Dimension(600, 300));
            frame.setContentPane(new AddCubePanel(frame));

        } else if (selectedShape.equals(Shape.Companion.CYLINDER.getPrettyName())) {
            frame.setSize(new Dimension(600, 200));
            frame.setContentPane(new AddCylinderPanel(frame));

        } else if (selectedShape.equals(Shape.Companion.SPHERE.getPrettyName())) {
            frame.setSize(new Dimension(600, 200));
            frame.setContentPane(new AddSpherePanel(frame));

        } else if (selectedShape.equals(Shape.Companion.CONE.getPrettyName())) {
            frame.setSize(new Dimension(600, 200));
            frame.setContentPane(new AddConePanel(frame));

        } else if (selectedShape.equals(Shape.Companion.PYRAMID.getPrettyName())) {
            frame.setSize(new Dimension(600, 300));
            frame.setContentPane(new AddPyramidPanel(frame));
        }
    }
}
