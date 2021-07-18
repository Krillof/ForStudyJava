package my.spring_proj.model.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sportsman implements Entity {
    private int id;
    private String name;
    private int rank;
    private int year_of_birth;
    private int personal_record;
    private String country;

    public Sportsman(){

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public int getPersonal_record() {
        return personal_record;
    }

    public void setPersonal_record(int personal_record) {
        this.personal_record = personal_record;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Sportsman(int id, String name, int rank, int year_of_birth, int personal_record, String country) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.year_of_birth = year_of_birth;
        this.personal_record = personal_record;
        this.country = country;
    }

    @Override
    public String show() {
        return
                "<td>" + this.getId() + "</td>" +
                "<td>" + this.getName() + "</td>" +
                "<td>" + this.getRank() + "</td>" +
                "<td>" + this.getYear_of_birth() + "</td>" +
                "<td>" + this.getPersonal_record() + "</td>" +
                "<td>" + this.getCountry() + "</td>";
    }

    @Override
    public String getHeader() {
        return "<tr>"+
                "<th> id </th>" +
                "<th> name </th>" +
                "<th> rank </th>" +
                "<th> year_of_birth </th>" +
                "<th> personal_record </th>" +
                "<th> country </th>" +
                "</tr>";
    }

    @Override
    public void queryPackUp(ResultSet res) throws SQLException {
        setId(res.getInt(1));
        setName(res.getString(2));
        setRank(res.getInt(3));
        setYear_of_birth(res.getInt(4));
        setPersonal_record(res.getInt(5));
        setCountry(res.getString(6));
    }

}
