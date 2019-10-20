package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddCylinderPanel extends JPanel {
    private JFrame frame;

    public AddCylinderPanel(JFrame frame) {
        this.frame = frame;
        setLayout(new GridLayout(2, 2));

        add(leftTop());
        add(rightTop());
        add(leftBottom());
        add(rightBottom());
    }

    private JPanel leftTop() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        panel.add(new JLabel("Straal"));
        panel.add(new JTextField());

        return panel;
    }

    private JPanel rightTop() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        panel.add(new JLabel("Hoogte"));
        panel.add(new JTextField());

        return panel;
    }

    private JPanel leftBottom() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton button = new DefaultButton("OK");

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