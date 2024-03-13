package ru.gb.student;

import ru.gb.student.departments.DepartmentsGenerator;
import ru.gb.student.departments.DepartmentsList;
import ru.gb.student.persons.PersonsGenerator;
import ru.gb.student.persons.PersonsList;

public class TasksToRun {
    private final Homework homework;
    private final PersonsList personsList;

    public TasksToRun(int depAmount, int persAmount) {
        homework = new Homework();
        DepartmentsList departmentsList = new DepartmentsGenerator().createDepartments(depAmount);
        personsList = new PersonsGenerator(departmentsList, persAmount).createPersonsList();
    }

    public void run() {
        Task_01();
        Task_02_vol_01();
        Task_02_vol_02();
        Task_03();
        Task_04();
    }

    private void Task_01(){
        System.out.println("\n Задача 1: Вывести на консоль отсортированные (по алфавиту) имена персонов.\n");
        homework.printNamesOrdered(personsList);
    }

    private void Task_02_vol_01() {
        System.out.println("\n Задача 2 Вариант 01: В каждом департаменте найти самого взрослого сотрудника.\n");
        long start = System.nanoTime();
        homework.printDepartmentOldestPerson01(personsList).forEach((k, v) -> System.out.println(k.getName()
                + ", Имя самого возрастного сотрудника: " + v.getName() + ", Возраст: " + v.getAge()));
        long end = System.nanoTime();
        System.out.println("Время поиска: " + (end - start));
    }

    private void Task_02_vol_02() {
        System.out.println("\n Задача 2 Вариант 02: В каждом департаменте найти самого взрослого сотрудника.\n");
        long start = System.nanoTime();
        homework.printDepartmentOldestPerson02(personsList).forEach((k, v) -> System.out.println(k.getName()
                + ", Имя самого возрастного сотрудника: " + v.getName() + ", Возраст: " + v.getAge()));
        long end = System.nanoTime();
        System.out.println("Время поиска: " + (end - start));
    }

    private void Task_03() {
        System.out.println("\n Задача 3: Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000.\n");
        homework.findFirstPersons(personsList).forEach(System.out::println);
    }

    private void Task_04() {
        System.out.println("\n Задача 4: Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна.\n");
        System.out.println(homework.findTopDepartment(personsList).toString());
    }
}
