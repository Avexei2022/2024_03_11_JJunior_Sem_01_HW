package ru.gb.student.persons;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonsList {
    private final List<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        if(!personList.contains(person)) personList.add(person);
    }
}
