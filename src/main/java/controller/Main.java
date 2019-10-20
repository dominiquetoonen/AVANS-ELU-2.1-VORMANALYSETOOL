package controller;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.VatCalculatorFrame;

public class Main {
    public static void main(String[] args) {
//        connectToDatabase();
        SwingUtilities.invokeLater(new VatCalculatorFrame());
    }

    public static void connectToDatabase() {
        DBConnect db = new DBConnect("root", "");
        String sql = "SELECT * FROM shapes";

        try {
            db.connect();
            ResultSet resultSet = db.getStatement().executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("SHAPE_ID"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}