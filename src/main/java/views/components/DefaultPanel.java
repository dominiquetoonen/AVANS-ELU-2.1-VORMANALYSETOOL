package views.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DefaultPanel extends JPanel {
    public DefaultPanel() {
        setBackground(new Color(96, 95, 64));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(20, 20, 10, 20));
    }

    public JPanel getWidthPanel(JTextField widthTextField) {
        add(new JLabel("Breedte (cm)"));
        add(widthTextField);

        return this;
    }

    public JPanel getLengthPanel(JTextField lengthTextField) {
        add(new JLabel("Lengte (cm)"));
        add(lengthTextField);

        return this;
    }

    public JPanel getHeightPanel(JTextField heightTextField) {
        add(new JLabel("Hoogte (cm)"));
        add(heightTextField);

        return this;
    }

    public JPanel getRadiusPanel(JTextField radiusTextField) {
        add(new JLabel("Straal (cm)"));
        add(radiusTextField);

        return this;
    }
}
