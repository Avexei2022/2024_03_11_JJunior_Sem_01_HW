package ru.gb.student.persons;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.gb.student.departments.Department;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private double salary;
    private Department department;
}
