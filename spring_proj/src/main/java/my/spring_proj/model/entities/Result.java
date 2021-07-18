package my.spring_proj.model.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Result implements Entity{
    public int getCompetition_id() {
        return competition_id;
    }

    public Result(){

    }

    public void setCompetition_id(int competition_id) {
        this.competition_id = competition_id;
    }

    public int getSportsman_id() {
        return sportsman_id;
    }

    public void setSportsman_id(int sportsman_id) {
        this.sportsman_id = sportsman_id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getHold_date() {
        return hold_date;
    }

    public void setHold_date(LocalDate hold_date) {
        this.hold_date = hold_date;
    }

    public Result(int competition_id, int sportsman_id, int result, String city, LocalDate hold_date) {
        this.competition_id = competition_id;
        this.sportsman_id = sportsman_id;
        this.result = result;
        this.city = city;
        this.hold_date = hold_date;
    }

    private int competition_id;
    private int sportsman_id;
    private int result;
    private String city;
    private LocalDate hold_date;


    @Override
    public String show() {
        return
                "<td>" + this.getCompetition_id() + "</td>" +
                "<td>" + this.getSportsman_id() + "</td>" +
                "<td>" + this.getResult() + "</td>" +
                "<td>" + this.getCity() + "</td>" +
                "<td>" + this.getHold_date() + "</td>";
    }

    @Override
    public String getHeader() {
        return "<tr>"+
                "<th> competition_id </th>" +
                "<th> sportsman_id </th>" +
                "<th> result </th>" +
                "<th> city </th>" +
                "<th> hold_date </th>" +
                "</tr>";
    }

    @Override
    public void queryPackUp(ResultSet res) throws SQLException {
        setCompetition_id(res.getInt(1));
        setSportsman_id(res.getInt(2));
        setResult(res.getInt(3));
        setCity(res.getString(4));
        setHold_date(res.getDate(5).toLocalDate());
    }


}
