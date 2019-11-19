package controllers;

import java.awt.*;
import models.Cube;
import models.Shape;
import models.Sphere;
import javax.swing.*;
import models.Cylinder;
import java.util.Objects;
import views.AddShapeFrame;
import views.panels.AddCubePanel;
import views.panels.AddSpherePanel;
import views.panels.AddCylinderPanel;

public class AddShape {
    public AddShape(JComboBox jComboBox) {
        AddShapeFrame frame;

        switch (Shape.Companion.valueOf(Objects.requireNonNull(jComboBox.getSelectedItem()).toString())) {
            case CUBE:
                frame = new AddShapeFrame(Shape.Companion.CUBE.getName());
                frame.setSize(new Dimension(600, 300));
                frame.setContentPane(new AddCubePanel(frame, new Cube()));

                SwingUtilities.invokeLater(frame);
                break;
            case CYLINDER:
                frame = new AddShapeFrame(Shape.Companion.SPHERE.getName());
                frame.setSize(new Dimension(600, 200));
                frame.setContentPane(new AddSpherePanel(frame, new Sphere()));

                SwingUtilities.invokeLater(frame);
                break;
            case SPHERE:
                frame = new AddShapeFrame(Shape.Companion.CYLINDER.getName());
                frame.setSize(new Dimension(600, 200));
                frame.setContentPane(new AddCylinderPanel(frame, new Cylinder()));

                SwingUtilities.invokeLater(frame);
                break;
        }
    }
}
