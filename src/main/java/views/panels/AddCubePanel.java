package views.panels;

import models.Cube;

import java.util.ArrayList;

import views.components.DefaultPanel;

import javax.swing.*;

public class AddCubePanel extends AddShapePanel {
    public AddCubePanel(JFrame jFrame) {
        super(jFrame, new Cube());
    }

    @Override
    public ArrayList<JPanel> getTextFields() {
        ArrayList<JPanel> textFields = new ArrayList<>();

        textFields.add(new DefaultPanel().getLengthPanel(lengthTextField));
        textFields.add(new DefaultPanel().getWidthPanel(widthTextField));
        textFields.add(new DefaultPanel().getHeightPanel(heightTextField));

        return textFields;
    }
}