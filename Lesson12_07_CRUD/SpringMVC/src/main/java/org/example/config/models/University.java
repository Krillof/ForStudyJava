package org.example.config.models;

public class University {
    private int number;
    private int average_exams_score;
    private String name;
    private String city;

    public University() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAverage_exams_score() {
        return average_exams_score;
    }

    public void setAverage_exams_score(int average_exams_score) {
        this.average_exams_score = average_exams_score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University(int number, int average_exams_score, String name, String city) {
        this.number = number;
        this.average_exams_score = average_exams_score;
        this.name = name;
        this.city = city;
    }
}
