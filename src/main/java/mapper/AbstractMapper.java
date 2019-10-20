package mapper;

import controller.DBConnect;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;

abstract public class AbstractMapper {
    private DBConnect dbConnect;
    private ArrayList<String> columns;

    AbstractMapper() {
        dbConnect = new DBConnect("root", "");
        columns = new ArrayList<>();

        try {
            dbConnect.connect();

            ResultSet resultSet = dbConnect.getStatement().executeQuery("SELECT * FROM " + getTableName());

            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                columns.add(resultSet.getMetaData().getColumnName(i));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HashMap> all() {
        ArrayList<HashMap> results = new ArrayList<>();

        try {
            dbConnect.connect();

            ResultSet resultSet = dbConnect.getStatement().executeQuery("SELECT * FROM " + getTableName());

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
            dbConnect.connect();

            int deletedRows = dbConnect.getStatement().executeUpdate("DELETE FROM " + getTableName() + " WHERE SHAPE_ID = " + id);

            return deletedRows > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    abstract String getTableName();
}
