package ru.gb.student;

import ru.gb.student.departments.Department;
import ru.gb.student.persons.Person;
import ru.gb.student.persons.PersonsList;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public void printNamesOrdered(PersonsList persons) {
        persons.getPersonList().stream()
                .map(Person::getName)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public Map<Department, Person> printDepartmentOldestPerson01(PersonsList persons) {
        return persons.getPersonList().stream()
                .map(Person::getDepartment)
                .distinct()
                .collect(Collectors.toMap(department -> department,
                        department -> persons.getPersonList().stream()
                                .filter(person -> person.getDepartment().equals(department))
                                .max(Comparator.comparingInt(Person::getAge)).orElseThrow()));

    }

    public Map<Department, Person> printDepartmentOldestPerson02(PersonsList persons) {
        Map<Department, Person> departmentPersonMap = new HashMap<>();
        persons.getPersonList().stream().sorted(Comparator.comparingInt(Person::getAge))
                .forEach(person -> departmentPersonMap.put(person.getDepartment(), person));
        return departmentPersonMap;
    }

    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public List<Person> findFirstPersons(PersonsList persons) {
        return persons.getPersonList().stream()
                .filter(person -> person.getAge() < 30 && person.getSalary() > 50000)
                .limit(10)
                .toList();
    }

    /**
     * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
     */
    public Optional<Department> findTopDepartment(PersonsList persons) {
        return persons.getPersonList().stream()
                .map(Person::getDepartment)
                .distinct()
                .collect(Collectors.toMap(department -> department,
                        department -> persons.getPersonList().stream()
                                .filter(person -> person.getDepartment().equals(department))
                                .mapToDouble(Person::getSalary)
                                .reduce(0, Double::sum)))
                .entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

}
