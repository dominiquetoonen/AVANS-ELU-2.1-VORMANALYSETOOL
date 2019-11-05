package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import mapper.Shapes;
import model.Shape;
import view.components.LeftPanel;
import view.components.RightPanel;

public class MainPanel extends JPanel {

    public MainPanel() {
        setLayout(new GridLayout(1, 2));

        add(new LeftPanel().getView());
        add(new RightPanel().getView());
    }
}