package views.panels;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import models.Shape;
import javax.swing.*;
import mappers.Shapes;
import controllers.AddShape;
import views.components.*;

public class MainPanel extends JPanel {
    private static JList jList;
    private static DefaultListModel<String> model;
    private static String[] shapeList = Shape.Companion.getPrettyNames().toArray(new String[0]);

    private JComboBox<String> shapeComboBox = new JComboBox<>();
    private static JTextField volumeTextField = new DefaultTextField();
    private static JTextField totalVolumeTextField = new DefaultTextField();

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

                DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
                otherSymbols.setDecimalSeparator('.');
                otherSymbols.setGroupingSeparator(',');
                DecimalFormat df = new DecimalFormat("#.##", otherSymbols);
                volumeTextField.setText(df.format(volume));
            }
        });

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

            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator(',');
            DecimalFormat df = new DecimalFormat("#.##", otherSymbols);

            totalVolumeTextField.setText(df.format(totalVolume));
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

        volumeTextField.setText("");
        totalVolumeTextField.setText("");

//        model.lastElement();
    }

    private JPanel getLeftPanel() {
        JPanel leftPanel = new DefaultPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(new JLabel("Vorm"));
        leftPanel.add(shapeComboBox);
        leftPanel.add(new JLabel("Inhoud (cm)"));
        leftPanel.add(volumeTextField);
        leftPanel.add(new JLabel("Totale inhoud (cm)"));
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