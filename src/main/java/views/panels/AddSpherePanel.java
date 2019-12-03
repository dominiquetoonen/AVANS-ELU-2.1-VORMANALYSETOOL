package views.panels;

import models.Sphere;

import java.util.ArrayList;

import views.components.DefaultPanel;

import javax.swing.*;

public class AddSpherePanel extends AddShapePanel {
    public AddSpherePanel(JFrame jFrame) {
        super(jFrame, new Sphere());
    }

    @Override
    public ArrayList<JPanel> getTextFields() {
        ArrayList<JPanel> textFields = new ArrayList<>();

        textFields.add(new DefaultPanel().getRadiusPanel(radiusTextField));

        return textFields;
    }
}