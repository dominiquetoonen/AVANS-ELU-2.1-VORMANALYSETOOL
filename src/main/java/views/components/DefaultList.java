package views.components;

import java.awt.*;
import javax.swing.*;

public class DefaultList extends JList {
    public DefaultList() {
        setFont(new Font("Default", Font.PLAIN, 14));
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
    }
}
