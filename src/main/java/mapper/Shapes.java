package mapper;

import java.util.ArrayList;

public class Shapes extends AbstractMapper {
    private String tableName;

    @Override
    String getTableName() {
        return "shapes";
    }
}
