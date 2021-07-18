package org.example.config.dao;

import org.example.config.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    public List<Person> people;

    public static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "A"));
        people.add(new Person(++PEOPLE_COUNT, "B"));
        people.add(new Person(++PEOPLE_COUNT, "C"));
        people.add(new Person(++PEOPLE_COUNT, "D"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people
                .stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }


    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
