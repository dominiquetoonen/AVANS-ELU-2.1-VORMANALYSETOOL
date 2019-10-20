package mapper;

import controller.DBConnect;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;

abstract public class AbstractMapper {
    public ArrayList<HashMap> all() {
        ArrayList<HashMap> results = new ArrayList<>();
        ArrayList<String> columns = new ArrayList<>();


        DBConnect db = new DBConnect("root", "");
        try {
            db.connect();

            ResultSet resultSet = db.getStatement().executeQuery("SELECT * FROM " + getTableName());

            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                columns.add(resultSet.getMetaData().getColumnName(i));
            }

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

    abstract String getTableName();
}
