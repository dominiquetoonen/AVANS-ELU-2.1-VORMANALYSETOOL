package nl.avans.vatCalculator;

import javax.swing.*;
import nl.avans.vatCalculator.view.VatCalculatorFrame;

public class Controller {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new VatCalculatorFrame(new Controller()));
    }
}