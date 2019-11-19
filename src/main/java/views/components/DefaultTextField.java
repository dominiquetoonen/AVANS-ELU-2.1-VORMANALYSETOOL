package views.components;

import javax.swing.*;
import java.awt.*;

public class DefaultTextField extends JTextField {
    public DefaultTextField() {
        setFont(new Font("Default", Font.PLAIN, 14));
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
    }
}
