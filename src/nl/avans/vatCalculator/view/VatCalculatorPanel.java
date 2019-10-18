package nl.avans.vatCalculator.view;

import java.awt.*;
import javax.swing.*;
import nl.avans.vatCalculator.Controller;

class VatCalculatorPanel extends JPanel {

    VatCalculatorPanel(Controller controller) {
        setLayout(new GridLayout(1, 2));

        add(new LeftPanel(controller));
        add(new RightPanel(controller));
    }
}
