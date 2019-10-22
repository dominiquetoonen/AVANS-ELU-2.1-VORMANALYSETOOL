package view;

import controller.AddShape;
import mapper.Shapes;
import model.AbstractModel;
import model.Cube;
import model.Cylinder;
import model.Shape;
import model.Sphere;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

class MainPanel extends JPanel {
    MainPanel() {
        setLayout(new GridLayout(1, 2));

        add(leftPanel());
        add(rightPanel());
    }

    private JPanel leftPanel() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] shapes = {Cylinder.name, Sphere.name, Cube.name};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapes);

        panel.add(new JLabel("Vorm"));
        panel.add(shapeComboBox);

        panel.add(new JLabel("Inhoud"));
        JTextField volumeTextField = new JTextField();
        volumeTextField.setEnabled(false);
        panel.add(volumeTextField);

        panel.add(new JLabel("Totale inhoud"));
        JTextField totalVolumeTextField = new JTextField();
        totalVolumeTextField.setEnabled(false);
        panel.add(totalVolumeTextField);

        JButton saveButton = new DefaultButton("Opslaan");
        saveButton.addActionListener(e -> new AddShape(shapeComboBox));
        panel.add(saveButton);

        JButton loadButton = new DefaultButton("Laad");
        loadButton.addActionListener(e -> System.out.println("Laad"));
        panel.add(loadButton);

        return panel;
    }

    private JPanel rightPanel() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JList jList = new JList<>(getTextList().toArray());
        jList.setFont(new Font(getFont().getFontName(), getFont().getStyle(), getFont().getSize() + 2));
        panel.add(new JScrollPane(jList), BorderLayout.CENTER);

        JButton saveButton = new DefaultButton("Totale inhoud");
        saveButton.addActionListener(e -> System.out.println("Totale inhoud"));
        panel.add(saveButton);

        int shapeId = 3;

        JButton loadButton = new DefaultButton("Verwijder vorm");
        loadButton.addActionListener(e -> new Shapes().delete(shapeId));
        panel.add(loadButton);

        return panel;
    }

    private ArrayList<String> getTextList() {
        ArrayList<Shape> shapes = new Shapes().all();
        ArrayList<String> textList = new ArrayList<>();

        for (Shape shape : shapes) {
            textList.add(shape.getTitle());
        }

        return textList;
    }
}