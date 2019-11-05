package view.components;

import java.awt.*;
import model.Shape;
import javax.swing.*;
import mapper.Shapes;
import java.util.ArrayList;

public class RightPanel extends JPanel {
    private JList jList;

    public JPanel getView() {
        JPanel rightPanel = new DefaultPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        jList = new JList<>(getTextList().toArray());
        jList.setFont(new Font(getFont().getFontName(), getFont().getStyle(), getFont().getSize() + 2));
        rightPanel.add(new JScrollPane(jList), BorderLayout.CENTER);

        JButton saveButton = new DefaultButton("Totale inhoud");
        saveButton.addActionListener(e -> System.out.println("Totale inhoud"));
        rightPanel.add(saveButton);

        JButton loadButton = new DefaultButton("Verwijder vorm");

        loadButton.addActionListener(e -> {
            for (Object s : jList.getSelectedValuesList()) {
                int shapeId = Integer.parseInt(s.toString().split(" - ")[0]);
                new Shapes().delete(shapeId);

                new RightPanel().refreshList();
            }
        });

        rightPanel.add(loadButton);
        return rightPanel;
    }

    public void refreshList() {
//        ((DefaultListModel) jList.getModel()).clear();
    }

    private ArrayList<String> getTextList() {
        ArrayList<model.Shape> shapes = new Shapes().all();
        ArrayList<String> textList = new ArrayList<>();

        for (Shape shape : shapes) {
            textList.add(shape.getId() + " - " + shape.getTitle());
        }

        return textList;
    }
}