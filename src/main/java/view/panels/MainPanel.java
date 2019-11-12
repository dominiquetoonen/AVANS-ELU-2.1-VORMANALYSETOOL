package view.panels;

import java.awt.*;
import model.Cube;
import model.Shape;
import model.Sphere;
import javax.swing.*;
import mapper.Shapes;
import model.Cylinder;
import java.util.ArrayList;
import controller.AddShape;
import view.components.DefaultPanel;
import view.components.DefaultButton;

public class MainPanel extends JPanel {
    private JPanel leftPanel;
    private JPanel rightPanel;
    private static JList jList;
    private static DefaultListModel<String> model;

    public MainPanel() {
        model = new DefaultListModel<>();

        jList = new JList<>(model);
        jList.setFont(new Font(getFont().getFontName(), getFont().getStyle(), getFont().getSize() + 2));
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setLeftPanel();
        setRightPanel();

        setLayout(new GridLayout(1, 2));

        add(leftPanel);
        add(rightPanel);
    }

    public static void refreshList() {
        model.clear();

        for (String s : getTextList()) {
            model.addElement(s);
        }
    }

    private void setLeftPanel() {
        leftPanel = new DefaultPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        String[] shapes = {Cylinder.name, Sphere.name, Cube.name};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapes);

        JTextField volumeTextField = new JTextField();
        volumeTextField.setEnabled(false);

        JTextField totalVolumeTextField = new JTextField();
        totalVolumeTextField.setEnabled(false);

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

        refreshList();
        JScrollPane jScrollPane = new JScrollPane(jList);


        JButton calculateContentButton = new DefaultButton("Totale inhoud");
        calculateContentButton.addActionListener(e -> calculateContent());

        JButton loadButton = new DefaultButton("Verwijder vorm");
        loadButton.addActionListener(e -> deleteItems());

        rightPanel.add(jScrollPane, BorderLayout.CENTER);
        rightPanel.add(calculateContentButton);
        rightPanel.add(loadButton);
    }

    private static void deleteItems() {
        for (Object s : jList.getSelectedValuesList()) {
            int shapeId = Integer.parseInt(s.toString().split(" - ")[0]);
            new Shapes().delete(shapeId);
        }

        refreshList();
    }

    private static void calculateContent() {
        System.out.println(jList.getSelectedValue().getClass().getName());
        System.out.println(jList.getSelectedValuesList().getClass().getName());
    }

    private static ArrayList<String> getTextList() {
        ArrayList<model.Shape> shapes = new Shapes().all();
        ArrayList<String> textList = new ArrayList<>();

        for (Shape shape : shapes) {
            textList.add(shape.getId() + " - " + shape.getTitle());
        }

        return textList;
    }
}