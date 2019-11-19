package views.panels;

import models.Shape;
import views.components.DefaultPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class AddCubePanel extends AddShapePanel {
    private Shape shape;

    public AddCubePanel(JFrame jFrame, Shape shape) {
        super(jFrame, shape);
        this.shape = shape;
    }

    @Override
    public void setListeners() {
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
    }

    @Override
    public ArrayList<JPanel> getTextFields() {
        ArrayList<JPanel> textFields = new ArrayList<>();

        JPanel lengthPanel = new DefaultPanel();
        JPanel widthPanel = new DefaultPanel();
        JPanel heightPanel = new DefaultPanel();

        lengthPanel.setLayout(new BoxLayout(lengthPanel, BoxLayout.Y_AXIS));
        lengthPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        lengthPanel.add(new JLabel("Lengte"));
        lengthPanel.add(lengthTextField);

        widthPanel.setLayout(new BoxLayout(widthPanel, BoxLayout.Y_AXIS));
        widthPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        widthPanel.add(new JLabel("Breedte"));
        widthPanel.add(widthTextField);

        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.Y_AXIS));
        heightPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
        heightPanel.add(new JLabel("Hoogte"));
        heightPanel.add(heightTextField);

        textFields.add(lengthPanel);
        textFields.add(widthPanel);
        textFields.add(heightPanel);

        return textFields;
    }
}