package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnect {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_PATH = "jdbc:mysql://localhost:3306/vat_calculator";

    private String username;
    private String password;

    private Statement statement = null;
    private Connection connection = null;

    public DBConnect(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_PATH, username, password);
        statement = connection.createStatement();
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
