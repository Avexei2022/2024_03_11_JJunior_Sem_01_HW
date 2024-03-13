package ru.gb.student.persons;

import lombok.AllArgsConstructor;
import ru.gb.student.departments.DepartmentsList;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class PersonsGenerator {
    DepartmentsList departmentsList;
    int amount;

    public PersonsList createPersonsList() {
        PersonsList personsList = new PersonsList();
        for (int i = 0; i < amount; i++) {
            personsList.addPerson(createPerson(i));

        }
        return personsList;
    }

    private Person createPerson(int i) {
        RandomName randomName = new RandomName(7);
        return new Person(
            randomName.getNameRusByStringShort() + (i + 1),
                ThreadLocalRandom.current().nextInt(20, 66),
                ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                departmentsList.getDepartmentList().
                        get(ThreadLocalRandom.current()
                                .nextInt(departmentsList.getDepartmentList().size()))
        );
    }
}
