package views.panels;

import models.Shape;
import views.components.DefaultPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class AddCylinderPanel extends AddShapePanel {
    private Shape shape;

    public AddCylinderPanel(JFrame jFrame, Shape shape) {
        super(jFrame, shape);
        this.shape = shape;
    }

    @Override
    public void setListeners() {
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

    @Override
    public ArrayList<JPanel> getTextFields() {
        ArrayList<JPanel> textFields = new ArrayList<>();

        JPanel heightPanel = new DefaultPanel();
        JPanel radiusPanel = new DefaultPanel();

        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.Y_AXIS));
        heightPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        heightPanel.add(new JLabel("Hoogte"));
        heightPanel.add(heightTextField);

        radiusPanel.setLayout(new BoxLayout(radiusPanel, BoxLayout.Y_AXIS));
        radiusPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        radiusPanel.add(new JLabel("Straal"));
        radiusPanel.add(radiusTextField);

        textFields.add(heightPanel);
        textFields.add(radiusPanel);

        return textFields;
    }
}