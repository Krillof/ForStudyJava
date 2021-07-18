package my.spring_proj.model.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TwoColumn implements Entity {
    private String value1;
    private String value2;



    public TwoColumn(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public TwoColumn() {
    }


    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }


    @Override
    public String show() {
        return "<td>" + getValue1() + "</td>" +
                "<td>" + getValue2() + "</td>";
    }

    @Override
    public String getHeader() {
        return "<tr> <th> 1 </th> <th> 2 </th> </tr>";
    }

    @Override
    public void queryPackUp(ResultSet res) throws SQLException {
        setValue1(res.getString(1));
        setValue2(res.getString(2));
    }

}
