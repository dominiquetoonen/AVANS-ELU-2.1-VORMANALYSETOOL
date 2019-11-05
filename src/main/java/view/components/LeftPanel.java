package view.components;

import mapper.Shapes;
import model.Cube;
import model.Shape;
import model.Sphere;
import javax.swing.*;
import view.MainPanel;
import model.Cylinder;
import controller.AddShape;

import java.util.ArrayList;

public class LeftPanel extends JPanel {
    public JPanel getView() {
        JPanel leftPanel = new DefaultPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        String[] shapes = {Cylinder.name, Sphere.name, Cube.name};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapes);

        leftPanel.add(new JLabel("Vorm"));
        leftPanel.add(shapeComboBox);

        leftPanel.add(new JLabel("Inhoud"));
        JTextField volumeTextField = new JTextField();
        volumeTextField.setEnabled(false);
        leftPanel.add(volumeTextField);

        leftPanel.add(new JLabel("Totale inhoud"));
        JTextField totalVolumeTextField = new JTextField();
        totalVolumeTextField.setEnabled(false);
        leftPanel.add(totalVolumeTextField);

        JButton saveButton = new DefaultButton("Opslaan");
        saveButton.addActionListener(e -> new AddShape(shapeComboBox));
        leftPanel.add(saveButton);

        JButton loadButton = new DefaultButton("Laad");
        loadButton.addActionListener(e -> System.out.println("Laad"));
        leftPanel.add(loadButton);

        return leftPanel;
    }
}
