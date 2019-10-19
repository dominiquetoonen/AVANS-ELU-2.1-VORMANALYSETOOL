package view;

import java.awt.*;
import javax.swing.*;
import controller.Controller;

public class VatCalculatorFrame extends JFrame implements Runnable {

    public VatCalculatorFrame(Controller controller) {
        super("Vorm Applicatie");

        setSize(new Dimension(600, 500));

        setLocationRelativeTo(null);
        setContentPane(new VatCalculatorPanel(controller));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void run() {

    }
}
