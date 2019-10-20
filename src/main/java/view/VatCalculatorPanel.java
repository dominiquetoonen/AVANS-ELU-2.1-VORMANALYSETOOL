package view;

import controller.AddShape;
import model.Cube;
import model.Cylinder;
import model.Sphere;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

class VatCalculatorPanel extends JPanel {
    VatCalculatorPanel() {
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

        JTextArea jTextArea = new JTextArea();
        jTextArea.setEnabled(false);
        jTextArea.setFont(new Font(getFont().getFontName(), getFont().getStyle(), getFont().getSize() + 20));


        jTextArea.setText("");
        panel.add(jTextArea);

        JButton saveButton = new DefaultButton("Totale inhoud");
        saveButton.addActionListener(e -> System.out.println("Totale inhoud"));
        panel.add(saveButton);

        JButton loadButton = new DefaultButton("Verwijder Vorm");
        loadButton.addActionListener(e -> System.out.println("Verwijder Vorm"));
        panel.add(loadButton);

        return panel;
    }
}