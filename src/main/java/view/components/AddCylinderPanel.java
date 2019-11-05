package view.components;

import mapper.Shapes;
import model.Cylinder;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AddCylinderPanel extends JPanel {
    private JFrame frame;
    private Cylinder cylinder;
    private JTextField heightTextField;
    private JTextField radiusTextField;

    public AddCylinderPanel(JFrame frame) {
        this.frame = frame;
        cylinder = new Cylinder();
        cylinder.setType(Cylinder.name);
        heightTextField = new JTextField();
        radiusTextField = new JTextField();

        setLayout(new GridLayout(2, 2));

        setListeners();

        add(leftTop());
        add(rightTop());
        add(leftBottom());
        add(rightBottom());
    }

    private void setListeners() {
        heightTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!heightTextField.getText().equals("")) {
                    cylinder.setHeight(Double.parseDouble(heightTextField.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        radiusTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!radiusTextField.getText().equals("")) {
                    cylinder.setRadius(Double.parseDouble(radiusTextField.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    private JPanel leftTop() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        panel.add(new JLabel("Straal"));
        panel.add(radiusTextField);

        return panel;
    }

    private JPanel rightTop() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        panel.add(new JLabel("Hoogte"));
        panel.add(heightTextField);

        return panel;
    }

    private JPanel leftBottom() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton button = new DefaultButton("OK");
        button.addActionListener(e -> {
            if (new Shapes().saveCylinder(cylinder)) {
                frame.dispose();
            }
        });
        panel.add(button);

        return panel;
    }

    private JPanel rightBottom() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton button = new DefaultButton("Annuleer");
        button.addActionListener(e -> frame.dispose());

        panel.add(button);

        return panel;
    }
}