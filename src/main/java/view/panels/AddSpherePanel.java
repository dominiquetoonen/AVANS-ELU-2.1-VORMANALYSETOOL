package view.panels;

import mapper.Shapes;
import model.Sphere;
import view.components.DefaultButton;
import view.components.DefaultPanel;
import view.panels.MainPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class AddSpherePanel extends JPanel {
    private JFrame frame;
    private Sphere sphere;
    private JTextField radiusTextField;

    public AddSpherePanel(JFrame frame) {
        this.frame = frame;
        sphere = new Sphere();
        sphere.setType(Sphere.name);
        radiusTextField = new JTextField();

        setLayout(new GridLayout(2, 2));

        setListeners();

        add(leftTop());
        add(rightTop());
        add(leftBottom());
        add(rightBottom());
    }
    
    private void setListeners() {
        radiusTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!radiusTextField.getText().equals("")) {
                    sphere.setRadius(Double.parseDouble(radiusTextField.getText()));
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

        return panel;
    }

    private JPanel leftBottom() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton button = new DefaultButton("OK");
        button.addActionListener(e -> {
            if (new Shapes().saveSphere(sphere)) {
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