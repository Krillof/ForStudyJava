package my.spring_proj.model.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Competition implements Entity {
    private int id;
    private String name;
    private int world_record;
    private LocalDate set_date;

    public Competition(){

    }


    public Competition(int id, String name, int world_record, LocalDate set_date) {
        this.id = id;
        this.name = name;
        this.world_record = world_record;
        this.set_date = set_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorld_record() {
        return world_record;
    }

    public void setWorld_record(int world_record) {
        this.world_record = world_record;
    }

    public LocalDate getSet_date() {
        return set_date;
    }

    public void setSet_date(LocalDate set_date) {
        this.set_date = set_date;
    }

    @Override
    public String show() {
        return
                "<td>" + this.getId() + "</td>" +
                "<td>" + this.getName() + "</td>" +
                "<td>" + this.getWorld_record() + "</td>" +
                "<td>" + this.getSet_date() + "</td>";
    }

    @Override
    public String getHeader() {
        return "<tr>"+
                "<th> id </th>" +
                "<th> name </th>" +
                "<th> world_record </th>" +
                "<th> set_date </th>" +
                "</tr>";
    }

    @Override
    public void queryPackUp(ResultSet res) throws SQLException {
        setId(res.getInt(1));
        setName(res.getString(2));
        setWorld_record(res.getInt(3));
        setSet_date(res.getDate(4).toLocalDate());
    }
}
