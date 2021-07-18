package my.spring_proj.model.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Entity {
    String show();


    String getHeader();
    void queryPackUp(ResultSet res) throws SQLException;
}
