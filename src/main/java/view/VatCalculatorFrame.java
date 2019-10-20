package view;

import controller.Shapes;

import javax.swing.*;
import java.awt.*;

public class VatCalculatorFrame extends JFrame implements Runnable {
    public VatCalculatorFrame() {
        super("Vorm Applicatie");

        setSize(new Dimension(600, 500));
        setContentPane(new VatCalculatorPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run() {

    }
}
