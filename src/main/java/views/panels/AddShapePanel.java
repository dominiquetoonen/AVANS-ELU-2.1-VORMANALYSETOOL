package views.panels;

import models.Shape;
import mappers.Shapes;
import views.components.DefaultPanel;
import views.components.DefaultButton;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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

    public Shape getShape() {
        return this.shape;
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

    public final void setListeners() {
        lengthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!lengthTextField.getText().equals("")) {
                    shape.setLength(Double.parseDouble(lengthTextField.getText()));
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
                    shape.setWidth(Double.parseDouble(widthTextField.getText()));
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
                    shape.setHeight(Double.parseDouble(heightTextField.getText()));
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
                    shape.setRadius(Double.parseDouble(radiusTextField.getText()));
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

    abstract public ArrayList<JPanel> getTextFields();
}
