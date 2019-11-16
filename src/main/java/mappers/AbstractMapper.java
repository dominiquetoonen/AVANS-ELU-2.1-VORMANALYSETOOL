package mappers;

import java.sql.*;
import java.util.ArrayList;

abstract public class AbstractMapper {

    private ResultSet resultSet;
    private Connection connection;

    protected Statement stmt;
    protected ArrayList<String> columns = new ArrayList<>();

    AbstractMapper() {
        try {
            connect();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());

            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
//                System.out.println(resultSet.getMetaData().getColumnTypeName(i));
//                System.out.println(resultSet.getMetaData().getColumnName(i));
                columns.add(resultSet.getMetaData().getColumnName(i));
            }

            closeConnection();
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
    }

    protected void connect() throws ClassNotFoundException, SQLException {
        String DRIVER = "com.mysql.jdbc.Driver";
        String DB_PATH = "jdbc:mysql://localhost:3306/vat_calculator";
        String username = "root";
        String password = "";

        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_PATH, username, password);
        stmt = connection.createStatement();
    }

    protected void closeConnection() throws SQLException {
        stmt.close();
        connection.close();
    }

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
