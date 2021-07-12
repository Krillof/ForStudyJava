package org.example.config.dao;

import org.example.config.models.Person;
import org.example.config.models.University;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UniversityDAO {
    public List<University> universities;

    public static int UNIVERSITIES_AMOUNT;

    {
        universities = new ArrayList<>();

        universities.add(new University(++UNIVERSITIES_AMOUNT, 300, "MGU", "Moscow"));
        universities.add(new University(++UNIVERSITIES_AMOUNT, 290, "BAUMANKA", "Moscow"));
        universities.add(new University(++UNIVERSITIES_AMOUNT, 250, "KubGU", "Krasnodar"));
        universities.add(new University(++UNIVERSITIES_AMOUNT, 250, "SpbGU", "Saint-Petersburg"));
        universities.add(new University(++UNIVERSITIES_AMOUNT, 220, "KubGAU", "Krasnodar"));

    }

    public List<University> index(){
        return universities;
    }

    public University show(int id){
        return universities
                .stream()
                .filter(university -> university.getNumber() == id)
                .findAny()
                .orElse(null);
    }


    public void save(University university) {
        university.setNumber(++UNIVERSITIES_AMOUNT);
        universities.add(university);
    }
}
