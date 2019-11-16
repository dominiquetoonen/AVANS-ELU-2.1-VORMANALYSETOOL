package views;

import views.panels.MainPanel;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame implements Runnable {
    public MainFrame() {
        super("Vorm Applicatie");

        setSize(new Dimension(600, 500));
        setContentPane(new MainPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run() {

    }
}
