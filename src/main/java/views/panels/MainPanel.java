package views.panels;

import java.awt.*;
import models.Cube;
import models.Shape;
import models.Sphere;
import javax.swing.*;
import mappers.Shapes;
import models.Cylinder;
import controllers.AddShape;
import views.components.*;

public class MainPanel extends JPanel {
    private static DefaultListModel<String> model;
    private static String[] shapeList;
    private static JList jList;

    private JComboBox<String> shapeComboBox = new JComboBox<>();
    private JTextField volumeTextField = new DefaultTextField();
    private JTextField totalVolumeTextField = new DefaultTextField();

    private JButton addButton;
    private JButton loadButton;
    private JButton totalVolumeButton;

    private JScrollPane jScrollPane = new JScrollPane();

    public MainPanel() {
        model = new DefaultListModel<>();

        jList = new DefaultList();
        jList.setModel(model);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jList.addListSelectionListener(listSelectionEvent -> {
            if (!listSelectionEvent.getValueIsAdjusting()) {
                double volume = 0.0;
                for (Object s : jList.getSelectedValuesList()) {
                    int shapeId = getIdFromSelection(s);
                    Shape shape = new Shapes().findById(shapeId);
                    volume += shape.calculateVolume();
                }

                volumeTextField.setText(volume + "");
            }
        });

        shapeList = new String[]{
                Shape.Companion.CUBE.toString(),
                Shape.Companion.CYLINDER.toString(),
                Shape.Companion.SPHERE.toString()
        };

        shapeComboBox.setModel(new DefaultComboBoxModel<>(shapeList));

        volumeTextField.setEditable(false);
        totalVolumeTextField.setEditable(false);

        addButton = new DefaultButton("VORM TOEVOEGEN");
        addButton.addActionListener(e -> new AddShape(shapeComboBox));

        loadButton = new DefaultButton("VORM VERWIJDEREN");
        loadButton.addActionListener(e -> deleteSelectedItems());

        totalVolumeButton = new DefaultButton("TOTALE INHOUD");
        totalVolumeButton.addActionListener(e -> {
            double totalVolume = 0.0;
            for (Shape s : new Shapes().all()) {
                totalVolume += s.calculateVolume();
            }

            totalVolumeTextField.setText(totalVolume + "");
        });

        jScrollPane.setViewportView(jList);

        setLayout(new GridLayout(1, 2));

        add(getLeftPanel());
        add(getRightPanel());

        refreshList();
    }

    public static void refreshList() {
        model.clear();
        for (Shape shape : new Shapes().all()) {
            model.addElement(shape.toString());
        }

        model.lastElement();
    }

    private JPanel getLeftPanel() {
        JPanel leftPanel = new DefaultPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(new JLabel("Vorm"));
        leftPanel.add(shapeComboBox);
        leftPanel.add(new JLabel("Inhoud"));
        leftPanel.add(volumeTextField);
        leftPanel.add(new JLabel("Totale inhoud"));
        leftPanel.add(totalVolumeTextField);
        leftPanel.add(addButton);

        return leftPanel;
    }

    private JPanel getRightPanel() {
        JPanel rightPanel = new DefaultPanel();

        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rightPanel.add(jScrollPane, BorderLayout.CENTER);
        rightPanel.add(totalVolumeButton);
        rightPanel.add(loadButton);

        return rightPanel;
    }


    private static int getIdFromSelection(Object s) {
        return Integer.parseInt(s.toString().split(" - ")[0]);
    }

    private static void deleteSelectedItems() {
        for (Object s : jList.getSelectedValuesList()) {
            int shapeId = getIdFromSelection(s);
            new Shapes().delete(shapeId);
        }

        refreshList();
    }
}