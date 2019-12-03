package views.panels;

import models.Pyramid;
import views.components.DefaultPanel;

import javax.swing.*;
import java.util.ArrayList;

public class AddPyramidPanel extends AddShapePanel {
    public AddPyramidPanel(JFrame jFrame) {
        super(jFrame, new Pyramid());
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