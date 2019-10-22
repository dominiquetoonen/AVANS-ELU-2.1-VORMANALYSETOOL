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
    protected Statement stmt;
    private ResultSet resultSet;
    private Connection connection;
    private ArrayList<String> columns = new ArrayList<>();;

    AbstractMapper() {
        username = "root";
        password = "";

        try {
            connect();
            resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());

            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                columns.add(resultSet.getMetaData().getColumnName(i));
            }

            closeConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_PATH, username, password);
        stmt = connection.createStatement();
    }

    protected void closeConnection() throws SQLException {
        stmt.close();
        connection.close();
    }

    // TODO: Fix possibility of SQL injection
    public boolean delete(int id) {
        try {
            connect();

            int deletedRows = stmt.executeUpdate("DELETE FROM " + getTableName() + " WHERE SHAPE_ID = " + id);

            return (deletedRows > 0);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    abstract String getTableName();
}
