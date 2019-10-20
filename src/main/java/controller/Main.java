package controller;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.VatCalculatorFrame;

public class Main {
    public static void main(String[] args) {
//        Shapes shapes = new Shapes();
        SwingUtilities.invokeLater(new VatCalculatorFrame());
    }
}