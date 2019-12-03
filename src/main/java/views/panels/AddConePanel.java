package views.panels;

import models.Cone;
import models.Shape;
import views.components.DefaultPanel;

import javax.swing.*;
import java.util.ArrayList;

public class AddConePanel extends AddShapePanel {

    public AddConePanel(JFrame jFrame) {
        super(jFrame, new Cone());
    }

    @Override
    public ArrayList<JPanel> getTextFields() {
        ArrayList<JPanel> textFields = new ArrayList<>();

        textFields.add(new DefaultPanel().getHeightPanel(heightTextField));
        textFields.add(new DefaultPanel().getRadiusPanel(radiusTextField));

        return textFields;
    }
}