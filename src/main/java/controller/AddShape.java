package controller;

import model.Cube;
import model.Sphere;
import javax.swing.*;
import model.Cylinder;
import view.components.AddCubePanel;
import view.AddShapeFrame;
import view.components.AddSpherePanel;
import view.components.AddCylinderPanel;

import java.awt.*;
import java.util.Objects;

public class AddShape {
    public AddShape(JComboBox jComboBox) {
        AddShapeFrame frame;

        switch (Objects.requireNonNull(jComboBox.getSelectedItem()).toString()) {
            case Cube.name:
                frame = new AddShapeFrame(Cube.name);
                frame.setSize(new Dimension(600, 300));
                frame.setContentPane(new AddCubePanel(frame));

                SwingUtilities.invokeLater(frame);

                break;
            case Sphere.name:
                frame = new AddShapeFrame(Sphere.name);
                frame.setSize(new Dimension(600, 200));
                frame.setContentPane(new AddSpherePanel(frame));

                SwingUtilities.invokeLater(frame);

                break;
            case Cylinder.name:
                frame = new AddShapeFrame(Cylinder.name);
                frame.setSize(new Dimension(600, 200));
                frame.setContentPane(new AddCylinderPanel(frame));

                SwingUtilities.invokeLater(frame);

                break;
        }
    }
}
