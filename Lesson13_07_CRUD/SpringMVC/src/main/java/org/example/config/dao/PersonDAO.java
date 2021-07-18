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

        people.add(new Person(++PEOPLE_COUNT, "A", 20, "abc@abc.abc"));
        people.add(new Person(++PEOPLE_COUNT, "B", 19, "abc@abc.abc"));
        people.add(new Person(++PEOPLE_COUNT, "C", 18, "abcd@abcd.abcd"));
        people.add(new Person(++PEOPLE_COUNT, "D", 17, "abc@abc.abc"));
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

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);

    }
}
