package mappers;

import java.sql.*;

abstract public class AbstractMapper {

    private Statement stmt;
    private Connection connection;

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_PATH = "jdbc:mysql://localhost:3306/vat_calculator";
    private final String username = "root";
    private final String password = "";

    protected void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_PATH, username, password);
        stmt = connection.createStatement();
    }

    protected void closeConnection() throws SQLException {
        stmt.close();
        connection.close();
    }

    public Statement getStatement() {
        return stmt;
    }

    public boolean delete(int id) {
        try {
            connect();
            int deletedRows = stmt.executeUpdate("DELETE FROM " + getTableName() + " WHERE SHAPE_ID = " + id);

            closeConnection();

            return (deletedRows > 0);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    abstract String getTableName();
}
