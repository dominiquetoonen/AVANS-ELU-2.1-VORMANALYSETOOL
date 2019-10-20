package controller;

import model.Cube;
import model.Sphere;
import javax.swing.*;
import model.Cylinder;
import view.AddCubePanel;
import view.AddShapeFrame;
import view.AddSpherePanel;
import view.AddCylinderPanel;

import java.awt.*;

public class AddShape {
    public AddShape(JComboBox jComboBox) {
        if (jComboBox.getSelectedItem() == Cube.name) {
            AddShapeFrame frame = new AddShapeFrame(Cube.name);
            frame.setSize(new Dimension(600, 300));
            frame.setContentPane(new AddCubePanel(frame));

            SwingUtilities.invokeLater(frame);

        } else if (jComboBox.getSelectedItem() == Cylinder.name) {
            AddShapeFrame frame = new AddShapeFrame(Cylinder.name);
            frame.setSize(new Dimension(600, 200));
            frame.setContentPane(new AddCylinderPanel(frame));

            SwingUtilities.invokeLater(frame);

        } else if (jComboBox.getSelectedItem() == Sphere.name) {
            AddShapeFrame frame = new AddShapeFrame(Sphere.name);
            frame.setSize(new Dimension(600, 200));
            frame.setContentPane(new AddSpherePanel(frame));

            SwingUtilities.invokeLater(frame);
        }
    }
}
