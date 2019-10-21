package mapper;

import model.Shape;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

abstract public class AbstractMapper {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_PATH = "jdbc:mysql://localhost:3306/vat_calculator";

    private String username;
    private String password;
    private Statement statement;
    private Connection connection;
    private ArrayList<String> columns = new ArrayList<>();;

    AbstractMapper() {
        username = "root";
        password = "";

        try {
            connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + getTableName());

            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                columns.add(resultSet.getMetaData().getColumnName(i));
            }

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_PATH, username, password);
        statement = connection.createStatement();
    }

    private void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public ArrayList<HashMap> all() {
        ArrayList<HashMap> results = new ArrayList<>();

        try {
            connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + getTableName());

            while (resultSet.next()) {
                HashMap<String, String> row = new HashMap<>();

                for (String column : columns) {
                    row.put(column, resultSet.getString(column));
                }

                results.add(row);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    // TODO: Fix possibility of SQL injection
    public boolean delete(int id) {
        try {
            connect();

            int deletedRows = statement.executeUpdate("DELETE FROM " + getTableName() + " WHERE SHAPE_ID = " + id);

            return (deletedRows > 0);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    abstract String getTableName();
    abstract ArrayList<Shape> getModels();
}
