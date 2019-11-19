package views.panels;

import models.Shape;
import views.components.DefaultPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class AddSpherePanel extends AddShapePanel {
    private models.Shape shape;

    public AddSpherePanel(JFrame jFrame, Shape shape) {
        super(jFrame, shape);
        this.shape = shape;
    }

    @Override
    public void setListeners() {
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

        JPanel radiusPanel = new DefaultPanel();

        radiusPanel.setLayout(new BoxLayout(radiusPanel, BoxLayout.Y_AXIS));
        radiusPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        radiusPanel.add(new JLabel("Straal"));
        radiusPanel.add(radiusTextField);

        textFields.add(radiusPanel);

        return textFields;
    }
}