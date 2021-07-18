package my.spring_proj.model.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OneColumn implements Entity{

    private String value;

    public OneColumn(String value) {
        this.value = value;
    }

    public OneColumn() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String show() {
        return "<td>" + getValue() + "</td>";
    }

    @Override
    public String getHeader() {
        return "<tr> <th> 1 </th> </tr>";
    }

    @Override
    public void queryPackUp(ResultSet res) throws SQLException {
        setValue(res.getString(1));
    }


}
