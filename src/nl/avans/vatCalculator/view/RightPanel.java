package nl.avans.vatCalculator.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import nl.avans.vatCalculator.Controller;

class RightPanel extends JPanel {

    RightPanel(Controller controller) {
        setBackground(new Color(96, 95, 64));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        JTextArea jTextArea = new JTextArea();
        jTextArea.setEnabled(false);
        Font f = getFont();
        Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize() + 30);
        jTextArea.setFont(f2);
        add(jTextArea);

        JButton saveButton = new JButton("Totale inhoud");
        saveButton.setBackground(new Color(160, 160, 64));
        saveButton.addActionListener(e -> System.out.println("Totale inhoud"));
        add(saveButton);

        JButton loadButton = new JButton("Verwijder Vorm");
        loadButton.setBackground(new Color(160, 160, 64));
        loadButton.addActionListener(e -> System.out.println("Verwijder Vorm"));
        add(loadButton);
    }
}
