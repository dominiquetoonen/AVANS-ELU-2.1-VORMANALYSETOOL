package views.panels;

import java.awt.*;
import models.Cube;
import models.Shape;
import models.Sphere;
import javax.swing.*;

import mappers.Shapes;
import models.Cylinder;
import controllers.AddShape;
import views.components.DefaultPanel;
import views.components.DefaultButton;

public class MainPanel extends JPanel {
    private JPanel leftPanel;
    private JPanel rightPanel;
    private static JList jList;
    private static DefaultListModel<String> model;

    private JTextField volumeTextField = new JTextField();
    private JTextField totalVolumeTextField = new JTextField();

    public MainPanel() {
        model = new DefaultListModel<>();

        jList = new JList<>(model);
        jList.setFont(new Font(getFont().getFontName(), getFont().getStyle(), getFont().getSize() + 2));
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
//                System.out.println(volume);
            }
        });

        refreshList();

        setLeftPanel();
        setRightPanel();

        setLayout(new GridLayout(1, 2));

        add(leftPanel);
        add(rightPanel);
    }

    public static void refreshList() {
        model.clear();

        for (Shape shape : new Shapes().all()) {
            model.addElement(shape.toString());
        }

        model.lastElement();
    }

    private void setLeftPanel() {
        leftPanel = new DefaultPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        String[] shapes = {Cylinder.name, Sphere.name, Cube.name};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapes);

        volumeTextField.setEnabled(false);
        volumeTextField.setFont(new Font(getFont().getFontName(), getFont().getStyle(), getFont().getSize() + 2));
        volumeTextField.setForeground(Color.black);

        totalVolumeTextField.setEnabled(false);
        totalVolumeTextField.setFont(new Font(getFont().getFontName(), getFont().getStyle(), getFont().getSize() + 2));
        totalVolumeTextField.setForeground(Color.black);

        JButton addButton = new DefaultButton("Vorm toevoegen");
        addButton.addActionListener(e -> new AddShape(shapeComboBox));

        leftPanel.add(new JLabel("Vorm"));
        leftPanel.add(shapeComboBox);
        leftPanel.add(new JLabel("Inhoud"));
        leftPanel.add(volumeTextField);
        leftPanel.add(new JLabel("Totale inhoud"));
        leftPanel.add(totalVolumeTextField);
        leftPanel.add(addButton);
    }

    private void setRightPanel() {
        rightPanel = new DefaultPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JScrollPane jScrollPane = new JScrollPane(jList);

        JButton totalVolumeButton = new DefaultButton("Totale inhoud");
        totalVolumeButton.addActionListener(e -> {
            double totalVolume = 0.0;

            for (Shape s : new Shapes().all()) {
                totalVolume += s.calculateVolume();
            }

            totalVolumeTextField.setText(totalVolume + "");
//            System.out.println(totalVolume);
        });

        JButton loadButton = new DefaultButton("Verwijder vorm");
        loadButton.addActionListener(e -> deleteSelectedItems());

        rightPanel.add(jScrollPane, BorderLayout.CENTER);
        rightPanel.add(totalVolumeButton);
        rightPanel.add(loadButton);
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