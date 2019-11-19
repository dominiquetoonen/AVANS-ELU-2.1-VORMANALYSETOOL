package views.panels;

import models.Shape;
import mappers.Shapes;
import views.components.DefaultPanel;
import views.components.DefaultButton;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

abstract public class AddShapePanel extends JPanel {
    private Shape shape;
    private JFrame jFrame;

    protected JTextField lengthTextField;
    protected JTextField widthTextField;
    protected JTextField heightTextField;
    protected JTextField radiusTextField;

    public AddShapePanel(JFrame jFrame, Shape shape) {
        this.jFrame = jFrame;
        this.shape = shape;

        this.lengthTextField = new JTextField();
        this.widthTextField = new JTextField();
        this.heightTextField = new JTextField();
        this.radiusTextField = new JTextField();

        ArrayList<JPanel> textFields = getTextFields();

        setLayout(new GridLayout(((int) (Math.ceil((double) textFields.size() / 2)) + 1), 2));

        setListeners();

        for (JPanel jPanel : textFields) {
            add(jPanel);
        }

        if (textFields.size() % 2 != 0) {
            add(emptyPanel());
        }

        add(OKButtonPanel());
        add(cancelButtonPanel());
    }

    private JPanel emptyPanel() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 10, 20));

        return panel;
    }

    private JPanel OKButtonPanel() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton button = new DefaultButton("OK");
        button.addActionListener(e -> {
            if (new Shapes().save(shape)) {
                jFrame.dispose();
                MainPanel.refreshList();
            }
        });
        panel.add(button);

        return panel;
    }

    private JPanel cancelButtonPanel() {
        JPanel panel = new DefaultPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton button = new DefaultButton("Annuleer");
        button.addActionListener(e -> jFrame.dispose());

        panel.add(button);

        return panel;
    }

    abstract public void setListeners();

    abstract public ArrayList<JPanel> getTextFields();
}
