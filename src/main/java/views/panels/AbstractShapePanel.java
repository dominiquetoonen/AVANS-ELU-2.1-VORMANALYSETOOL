package views.panels;

import mappers.Shapes;
import models.Cube;
import views.components.DefaultButton;
import views.components.DefaultPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

abstract public class AbstractShapePanel extends JPanel {
    private Cube cube;
    private JFrame frame;
    private JTextField lengthTextField;
    private JTextField widthTextField;
    private JTextField heightTextField;

    public AbstractShapePanel(JFrame frame) {
        cube = new Cube();
        cube.setType(Cube.name);

        this.frame = frame;
        lengthTextField = new JTextField();
        widthTextField = new JTextField();
        heightTextField = new JTextField();

        setLayout(new GridLayout(3, 2));

        setListeners();

        add(leftTop());
        add(rightTop());
        add(leftCenter());
        add(rightCenter());
        add(leftBottom());
        add(rightBottom());
    }

    private void setListeners() {
        lengthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!lengthTextField.getText().equals("")) {
                    cube.setLength(Double.parseDouble(lengthTextField.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        widthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!widthTextField.getText().equals("")) {
                    cube.setWidth(Double.parseDouble(widthTextField.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        heightTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!heightTextField.getText().equals("")) {
                    cube.setHeight(Double.parseDouble(heightTextField.getText()));
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

        panel.add(new JLabel("Lengte"));
        panel.add(lengthTextField);

        return panel;
    }

    private JPanel rightTop() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        panel.add(new JLabel("Breedte"));
        panel.add(widthTextField);

        return panel;
    }

    private JPanel leftCenter() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        panel.add(new JLabel("Hoogte"));
        panel.add(heightTextField);

        return panel;
    }

    private JPanel rightCenter() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        return panel;
    }

    private JPanel leftBottom() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton button = new DefaultButton("OK");
        button.addActionListener(e -> {
            if (new Shapes().saveCube(cube)) {
                frame.dispose();
                MainPanel.refreshList();
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