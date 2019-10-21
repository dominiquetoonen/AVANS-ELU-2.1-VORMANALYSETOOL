package controller;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Shape;
import view.VatCalculatorFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new VatCalculatorFrame());
    }
}