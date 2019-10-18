package nl.avans.vatCalculator.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import nl.avans.vatCalculator.Controller;

class LeftPanel extends JPanel {

    LeftPanel(Controller controller) {
        setBackground(new Color(96, 95, 64));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel shapeLabel = new JLabel("Vorm");
        add(shapeLabel);
        String[] shapes = {"cilinder", "bol", "blok"};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapes);
        add(shapeComboBox);

        JLabel volumeLabel = new JLabel("Inhoud");
        add(volumeLabel);
        JTextField volumeTextField = new JTextField();
        add(volumeTextField);

        JLabel totalVolumeLabel = new JLabel("Totale inhoud");
        add(totalVolumeLabel);
        JTextField totalVolumeTextField = new JTextField();
        add(totalVolumeTextField);

        JButton saveButton = new JButton("Opslaan");
        saveButton.setBackground(new Color(160, 160, 64));
        saveButton.addActionListener(e -> System.out.println("Opslaan"));
        add(saveButton);

        JButton loadButton = new JButton("Laad");
        loadButton.setBackground(new Color(160, 160, 64));
        loadButton.addActionListener(e -> System.out.println("Laad"));
        add(loadButton);
    }
}
